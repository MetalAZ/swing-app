/*
 * Created by JFormDesigner on Sat Aug 06 07:00:57 CDT 2022
 */

package com.example.ui;

import com.example.config.AppConfig;
import com.example.theme.ThemeManager;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author unknown
 */
public class MainFrame extends JFrame {
    private final MainFrame window;
    private final ThemeManager themeManager;

    public MainFrame() {
        window = this;
        themeManager = new ThemeManager(window);

        initComponents();

        if (themeManager.isDark()) {
            darkTheme.setSelected(true);
        } else {
            lightTheme.setSelected(true);
        }

        setJMenuBar(appMenu);
        setTitle(AppConfig.APP_NAME);
        setLocationRelativeTo(null); // Centers Window
        setVisible(true);
    }

    private void changeHelloClicked(ActionEvent e) {
        updateHello();
    }

    private void nameKeyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) updateHello();
    }

    private void updateHello() {
        helloMessage.setText("Hello, %s!".formatted(name.getText()));
    }

    private void aboutMenuClicked(ActionEvent e) {
        new AboutFrame(window);
    }

    private void lightThemeClicked(ActionEvent e) {
        lightTheme.setSelected(true);
        darkTheme.setSelected(false);
        themeManager.setTheme(AppConfig.DEFAULT_LIGHT_THEME);
    }

    private void darkThemeClicked(ActionEvent e) {
        lightTheme.setSelected(false);
        darkTheme.setSelected(true);
        themeManager.setTheme(AppConfig.DEFAULT_DARK_THEME);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        vSpacer1 = new JPanel(null);
        helloMessage = new JLabel();
        name = new JTextField();
        changeHello = new JButton();
        appMenu = new JMenuBar();
        themeMenu = new JMenu();
        lightTheme = new JCheckBoxMenuItem();
        darkTheme = new JCheckBoxMenuItem();
        helpMenu = new JMenu();
        aboutMenu = new JMenuItem();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/icons/form-icon.png")).getImage());
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
                "fillx,hidemode 3",
                // columns
                "[fill]",
                // rows
                "[]"));

        //======== panel1 ========
        {
            panel1.setLayout(new MigLayout(
                    "fill,hidemode 3",
                    // columns
                    "[fill]" +
                            "[fill]",
                    // rows
                    "[]" +
                            "[]" +
                            "[]"));

            //---- vSpacer1 ----
            vSpacer1.setMinimumSize(new Dimension(12, 20));
            panel1.add(vSpacer1, "cell 0 0");

            //---- helloMessage ----
            helloMessage.setText("Hello...");
            helloMessage.setFont(new Font("Inter", Font.BOLD, 24));
            helloMessage.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(helloMessage, "cell 0 1 2 1");

            //---- name ----
            name.setText("Developer");
            name.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    nameKeyPressed(e);
                }
            });
            panel1.add(name, "cell 0 2,pushx");

            //---- changeHello ----
            changeHello.setText("Hello");
            changeHello.addActionListener(e -> changeHelloClicked(e));
            panel1.add(changeHello, "cell 1 2");
        }
        contentPane.add(panel1, "cell 0 0");
        setSize(595, 425);
        setLocationRelativeTo(getOwner());

        //======== appMenu ========
        {

            //======== themeMenu ========
            {
                themeMenu.setText("Theme");
                themeMenu.setMnemonic('T');

                //---- lightTheme ----
                lightTheme.setText("Light");
                lightTheme.addActionListener(e -> lightThemeClicked(e));
                themeMenu.add(lightTheme);

                //---- darkTheme ----
                darkTheme.setText("Dark");
                darkTheme.addActionListener(e -> darkThemeClicked(e));
                themeMenu.add(darkTheme);
            }
            appMenu.add(themeMenu);

            //======== helpMenu ========
            {
                helpMenu.setText("Help");
                helpMenu.setMnemonic('H');

                //---- aboutMenu ----
                aboutMenu.setText("About");
                aboutMenu.addActionListener(e -> aboutMenuClicked(e));
                helpMenu.add(aboutMenu);
            }
            appMenu.add(helpMenu);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JPanel vSpacer1;
    private JLabel helloMessage;
    private JTextField name;
    private JButton changeHello;
    private JMenuBar appMenu;
    private JMenu themeMenu;
    private JCheckBoxMenuItem lightTheme;
    private JCheckBoxMenuItem darkTheme;
    private JMenu helpMenu;
    private JMenuItem aboutMenu;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
