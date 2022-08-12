package com.example.theme;

import com.example.config.AppConfig;
import com.example.theme.custom.Dark;
import com.example.theme.custom.Light;
import com.formdev.flatlaf.FlatLaf;
import com.jthemedetecor.OsThemeDetector;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class ThemeManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(ThemeManager.class);

    @Getter
    private boolean isDark;
    private final Component window;

    public ThemeManager(Component window) {
        this.window = window;

        // Custom themes (in resources folder)
        // https://www.formdev.com/flatlaf/theme-editor/
        Light.installLafInfo();
        Dark.installLafInfo();

        // Install other themes
        // FlatGitHubDarkContrastIJTheme.installLafInfo();

        final OsThemeDetector detector = OsThemeDetector.getDetector();
        var selectedTheme = detector.isDark() ? AppConfig.DEFAULT_DARK_THEME : AppConfig.DEFAULT_LIGHT_THEME;
        setTheme(selectedTheme);
    }

    public void setTheme(String theme) {
        try {
            var themeInfo = Arrays.stream(UIManager.getInstalledLookAndFeels())
                    .filter(x -> x.getName().equals(theme))
                    .findFirst()
                    .orElseThrow();

            var clazz = (Class<FlatLaf>) Class.forName(themeInfo.getClassName());
            var instance = clazz.getDeclaredConstructor().newInstance();

            isDark = instance.isDark();

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
