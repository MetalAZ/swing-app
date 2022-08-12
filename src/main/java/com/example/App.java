package com.example;

import com.example.config.AppConfig;
import com.example.ui.MainFrame;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.util.SystemInfo;

import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        // macOS  (see https://www.formdev.com/flatlaf/macos/)
        if (SystemInfo.isMacOS) {
            // enable screen menu bar
            // (moves menu bar from JFrame window to top of screen)
            System.setProperty("apple.laf.useScreenMenuBar", "true");

            // application name used in screen menu bar
            // (in first menu after the "apple" menu)
            System.setProperty("apple.awt.application.name", AppConfig.APP_NAME);

            // appearance of window title bars
            // possible values:
            //   - "system": use current macOS appearance (light or dark)
            //   - "NSAppearanceNameAqua": use light appearance
            //   - "NSAppearanceNameDarkAqua": use dark appearance
            // (needs to be set on main thread; setting it on AWT thread does not work)
            System.setProperty("apple.awt.application.appearance", "system");
        }

        // Linux
        if (SystemInfo.isLinux) {
            // enable custom window decorations
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
        }

        FlatLaf.registerCustomDefaultsSource("com.example.theme.custom");

        final int rounding = 8;
        final int insets = 2;

        UIManager.put("CheckBox.icon.style", "filled");
        UIManager.put("Component.arrowType", "chevron");

        UIManager.put("Component.focusWidth", 1);
        UIManager.put("Component.innerFocusWidth", 1);

        UIManager.put("Button.arc", rounding);
        UIManager.put("Component.arc", rounding);
        UIManager.put("ProgressBar.arc", rounding);
        UIManager.put("TextComponent.arc", rounding);

        UIManager.put("ScrollBar.thumbArc", rounding);
        UIManager.put("ScrollBar.thumbInsets", new Insets(insets, insets, insets, insets));

        new MainFrame();
    }
}
