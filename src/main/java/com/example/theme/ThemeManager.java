package com.example.theme;

import com.example.config.AppConfig;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.intellijthemes.FlatAllIJThemes;
import com.jthemedetecor.OsThemeDetector;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.*;

public class ThemeManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(ThemeManager.class);

    @Getter
    private boolean isDark;
    private final Component window;
    private final List<FlatAllIJThemes.FlatIJLookAndFeelInfo> themes = new ArrayList<>();

    public ThemeManager(Component window) {
        this.window = window;

        extendThemeList();

        FlatLaf.setGlobalExtraDefaults(Collections.singletonMap("@accentColor", "#00f"));
        final OsThemeDetector detector = OsThemeDetector.getDetector();
        var selectedTheme = detector.isDark() ? AppConfig.DEFAULT_DARK_THEME : AppConfig.DEFAULT_LIGHT_THEME;
        setTheme(selectedTheme);
    }

    private void extendThemeList() {
        themes.addAll(Arrays.asList(FlatAllIJThemes.INFOS));
        themes.add(new FlatAllIJThemes.FlatIJLookAndFeelInfo("FlatLaf IntelliJ", "com.formdev.flatlaf.FlatIntelliJLaf", false));
    }

    public void setTheme(String theme) {
        try {
            var themeInfo = themes.stream()
                    .filter(x -> x.getName().equals(theme))
                    .findFirst()
                    .orElseThrow();

            isDark = themeInfo.isDark();

            var clazz = (Class<FlatLaf>) Class.forName(themeInfo.getClassName());
            var instance = clazz.getDeclaredConstructor().newInstance();

            FlatLaf.setup(instance);
            FlatLaf.updateUI();
        } catch (NoSuchElementException | NoSuchMethodException | IllegalAccessException | InvocationTargetException |
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
            SwingUtilities.updateComponentTreeUI(window);
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException |
                 IllegalAccessException e) {
            LOGGER.error("Unable to set system look and feel", e);
        }
    }
}
