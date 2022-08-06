package com.example.theme;

import com.example.config.AppConfig;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.IntelliJTheme;
import com.formdev.flatlaf.intellijthemes.FlatAllIJThemes;
import com.jthemedetecor.OsThemeDetector;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collections;

public class ThemeManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(ThemeManager.class);

    @Getter
    private boolean isDark;

    public ThemeManager() {
        FlatLaf.setGlobalExtraDefaults(Collections.singletonMap("@accentColor", "#00f"));
        final OsThemeDetector detector = OsThemeDetector.getDetector();
        var selectedTheme = detector.isDark() ? AppConfig.DEFAULT_DARK_THEME : AppConfig.DEFAULT_LIGHT_THEME;
        setTheme(selectedTheme);
    }

    public void setTheme(String theme) {
        try {
            var themeInfo = Arrays.stream(FlatAllIJThemes.INFOS)
                    .filter(x -> x.getName().equals(theme))
                    .findFirst()
                    .orElseThrow();

            isDark = themeInfo.isDark();
            
            Class<IntelliJTheme.ThemeLaf> clazz = (Class<IntelliJTheme.ThemeLaf>) Class.forName(themeInfo.getClassName());

            var instance = clazz.getDeclaredConstructor().newInstance();
            FlatLaf.setup(instance);
            FlatLaf.updateUI();
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException |
                 ClassNotFoundException | InstantiationException e) {
            LOGGER.error("Unable to set FlatLaf theme", e);
            setSystemLookAndFeel();
        }
    }

    private void setSystemLookAndFeel() {
        try {
            JFrame.setDefaultLookAndFeelDecorated(false);
            JDialog.setDefaultLookAndFeelDecorated(false);
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException |
                 IllegalAccessException e) {
            LOGGER.error("Unable to set system look and feel", e);
        }
    }
}
