/*
 * Created by JFormDesigner on Sat Aug 06 07:00:57 CDT 2022
 */

package com.example.ui;

import com.example.config.AppConfig;
import com.example.theme.ThemeManager;
import com.formdev.flatlaf.extras.FlatSVGIcon;
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

        setIcons();
        setJMenuBar(appMenu);
        setTitle(AppConfig.APP_NAME);
        setLocationRelativeTo(null); // Centers Window
        setVisible(true);
    }

    private void setIcons() {
        FlatSVGIcon icon = new FlatSVGIcon("icons/check.svg");

        check1.setIcon(icon);
        check1.setText("");

        check2.setIcon(icon);
        check2.setText("");

        check3.setIcon(icon);
        check3.setText("");

        check4.setIcon(icon);
        check4.setText("");
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
        vSpacer2 = new JPanel(null);
        tabbedPane1 = new JTabbedPane();
        scrollPane1 = new JScrollPane();
        panel2 = new JPanel();
        vSpacer3 = new JPanel(null);
        check1 = new JLabel();
        textArea2 = new JTextArea();
        check2 = new JLabel();
        textArea1 = new JTextArea();
        check3 = new JLabel();
        textArea3 = new JTextArea();
        check4 = new JLabel();
        textArea4 = new JTextArea();
        appMenu = new JMenuBar();
        themeMenu = new JMenu();
        lightTheme = new JCheckBoxMenuItem();
        darkTheme = new JCheckBoxMenuItem();
        helpMenu = new JMenu();
        aboutMenu = new JMenuItem();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/icons/form-icon.png")).getImage());
        setMinimumSize(new Dimension(625, 430));
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
                "fillx,hidemode 3",
                // columns
                "[fill]",
                // rows
                "[]" +
                        "[]" +
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
            changeHello.setFocusPainted(false);
            changeHello.addActionListener(e -> changeHelloClicked(e));
            panel1.add(changeHello, "cell 1 2");
        }
        contentPane.add(panel1, "cell 0 0");

        //---- vSpacer2 ----
        vSpacer2.setPreferredSize(new Dimension(10, 15));
        contentPane.add(vSpacer2, "cell 0 1");

        //======== tabbedPane1 ========
        {

            //======== scrollPane1 ========
            {
                scrollPane1.setBorder(BorderFactory.createEmptyBorder());

                //======== panel2 ========
                {
                    panel2.setLayout(new MigLayout(
                            "fillx,hidemode 3,gap 8 8",
                            // columns
                            "[fill]" +
                                    "[fill]",
                            // rows
                            "[]" +
                                    "[]" +
                                    "[]" +
                                    "[]" +
                                    "[]" +
                                    "[]"));
                    panel2.add(vSpacer3, "cell 1 0");

                    //---- check1 ----
                    check1.setText("text");
                    panel2.add(check1, "cell 0 1");

                    //---- textArea2 ----
                    textArea2.setText("Themeing via FlatLaf to provide a more modern look and feel. There are many themes available and a theme designer for making new ones.");
                    textArea2.setWrapStyleWord(true);
                    textArea2.setLineWrap(true);
                    textArea2.setOpaque(false);
                    textArea2.setEditable(false);
                    textArea2.setBorder(null);
                    panel2.add(textArea2, "cell 1 1,pushx,grow,width 10:200");

                    //---- check2 ----
                    check2.setText("text");
                    panel2.add(check2, "cell 0 2");

                    //---- textArea1 ----
                    textArea1.setText("Proguard obfuscation to uglify your code to help deter people from taking it and re-using it without your permission.");
                    textArea1.setLineWrap(true);
                    textArea1.setEditable(false);
                    textArea1.setBorder(null);
                    textArea1.setWrapStyleWord(true);
                    textArea1.setFocusable(false);
                    textArea1.setOpaque(false);
                    panel2.add(textArea1, "cell 1 2,grow,width 10:200");

                    //---- check3 ----
                    check3.setText("text");
                    panel2.add(check3, "cell 0 3");

                    //---- textArea3 ----
                    textArea3.setText("Packaging for installing your application on other computers. This includes everything required to run your application and is optimized for size.");
                    textArea3.setWrapStyleWord(true);
                    textArea3.setLineWrap(true);
                    textArea3.setEditable(false);
                    textArea3.setOpaque(false);
                    textArea3.setBorder(null);
                    panel2.add(textArea3, "cell 1 3,grow,width 10:200");

                    //---- check4 ----
                    check4.setText("text");
                    panel2.add(check4, "cell 0 4");

                    //---- textArea4 ----
                    textArea4.setLineWrap(true);
                    textArea4.setEditable(false);
                    textArea4.setWrapStyleWord(true);
                    textArea4.setOpaque(false);
                    textArea4.setBorder(null);
                    textArea4.setText("No JRE required. You don't need to worry if a computer has the Java Runtime installed. Your installer includes just the parts of the runtime that it needs to run.");
                    panel2.add(textArea4, "cell 1 4,grow,width 10:200");
                }
                scrollPane1.setViewportView(panel2);
            }
            tabbedPane1.addTab("Features", scrollPane1);
        }
        contentPane.add(tabbedPane1, "cell 0 2");
        setSize(625, 430);
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
    private JPanel vSpacer2;
    private JTabbedPane tabbedPane1;
    private JScrollPane scrollPane1;
    private JPanel panel2;
    private JPanel vSpacer3;
    private JLabel check1;
    private JTextArea textArea2;
    private JLabel check2;
    private JTextArea textArea1;
    private JLabel check3;
    private JTextArea textArea3;
    private JLabel check4;
    private JTextArea textArea4;
    private JMenuBar appMenu;
    private JMenu themeMenu;
    private JCheckBoxMenuItem lightTheme;
    private JCheckBoxMenuItem darkTheme;
    private JMenu helpMenu;
    private JMenuItem aboutMenu;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
