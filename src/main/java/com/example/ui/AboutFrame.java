/*
 * Created by JFormDesigner on Sat Aug 06 07:31:02 CDT 2022
 */

package com.example.ui;

import com.example.config.AppConfig;
import com.example.util.AppUtils;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author unknown
 */
public class AboutFrame extends JDialog {
    private Window owner;

    public AboutFrame(Window owner) {
        super(owner);
        this.owner = owner;

        initComponents();
        initData();
        setVisible(true);
    }

    private void initData() {
        appName.setText(AppConfig.APP_NAME);
        copyright.setText(AppConfig.COPYRIGHT_DETAILS);
        javaRuntime.setText("Java runtime %s".formatted(Runtime.version()));

        appIconBy.setText("<html><a href=''>%s</a></html>".formatted("App icon by Design Circle - Flaticon"));
        appIconBy.setCursor(new Cursor(Cursor.HAND_CURSOR));
        appIconBy.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (AppUtils.openUrlInBrowser("https://www.flaticon.com/authors/design-circle")) {
                    JOptionPane.showMessageDialog(owner, "Unable to open URL in browser.", "Open Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        websiteLink.setText("<html><a href=''>%s</a></html>".formatted(AppConfig.HOME_URL));
        websiteLink.setCursor(new Cursor(Cursor.HAND_CURSOR));
        websiteLink.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (AppUtils.openUrlInBrowser(AppConfig.HOME_URL)) {
                    JOptionPane.showMessageDialog(owner, "Unable to open URL in browser.", "Open Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void okClicked(ActionEvent e) {
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        appIcon = new JLabel();
        hSpacer1 = new JPanel(null);
        panel1 = new JPanel();
        appName = new JLabel();
        versionInfo = new JLabel();
        javaRuntime = new JLabel();
        vSpacer1 = new JPanel(null);
        appIconBy = new JLabel();
        vSpacer2 = new JPanel(null);
        websiteLink = new JLabel();
        copyright = new JLabel();
        buttonBar = new JPanel();
        okButton = new JButton();

        //======== this ========
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        setTitle("About");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setBorder(new EmptyBorder(5, 25, 5, 25));
                contentPanel.setLayout(new MigLayout(
                        "fillx,insets dialog,hidemode 3,gap 8 4",
                        // columns
                        "[fill]" +
                                "[fill]" +
                                "[fill]",
                        // rows
                        "[]" +
                                "[]" +
                                "[]" +
                                "[]" +
                                "[]" +
                                "[]" +
                                "[]" +
                                "[]"));

                //---- appIcon ----
                appIcon.setIcon(new ImageIcon(getClass().getResource("/icons/form-icon.png")));
                contentPanel.add(appIcon, "cell 0 0");
                contentPanel.add(hSpacer1, "cell 1 0");

                //======== panel1 ========
                {
                    panel1.setLayout(new MigLayout(
                            "fillx,insets 0,hidemode 3",
                            // columns
                            "[fill]",
                            // rows
                            "[]" +
                                    "[]" +
                                    "[]"));

                    //---- appName ----
                    appName.setText("App Name");
                    appName.setFont(new Font("Inter", Font.BOLD, 15));
                    panel1.add(appName, "cell 0 0,pushx");

                    //---- versionInfo ----
                    versionInfo.setText("Version 1.0.12345");
                    panel1.add(versionInfo, "cell 0 1");
                }
                contentPanel.add(panel1, "cell 2 0");

                //---- javaRuntime ----
                javaRuntime.setText("Java runtime ...");
                contentPanel.add(javaRuntime, "cell 2 2,pushx");

                //---- vSpacer1 ----
                vSpacer1.setMinimumSize(new Dimension(20, 20));
                contentPanel.add(vSpacer1, "cell 2 3");

                //---- appIconBy ----
                appIconBy.setText("App icon by...");
                contentPanel.add(appIconBy, "cell 2 4");

                //---- vSpacer2 ----
                vSpacer2.setMinimumSize(new Dimension(20, 20));
                contentPanel.add(vSpacer2, "cell 2 5");

                //---- websiteLink ----
                websiteLink.setText("http://...");
                contentPanel.add(websiteLink, "cell 2 6");

                //---- copyright ----
                copyright.setText("Copyright...");
                contentPanel.add(copyright, "cell 2 7");
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setLayout(new MigLayout(
                        "insets dialog,alignx right",
                        // columns
                        "[button,fill]",
                        // rows
                        null));

                //---- okButton ----
                okButton.setText("OK");
                okButton.addActionListener(e -> okClicked(e));
                buttonBar.add(okButton, "cell 0 0");
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        setSize(410, 300);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel appIcon;
    private JPanel hSpacer1;
    private JPanel panel1;
    private JLabel appName;
    private JLabel versionInfo;
    private JLabel javaRuntime;
    private JPanel vSpacer1;
    private JLabel appIconBy;
    private JPanel vSpacer2;
    private JLabel websiteLink;
    private JLabel copyright;
    private JPanel buttonBar;
    private JButton okButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
