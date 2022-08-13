/*
 * Created by JFormDesigner on Sat Aug 13 09:31:47 CDT 2022
 */

package com.example.ui;

import com.example.util.AppUtils;
import com.formdev.flatlaf.FlatLaf;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.swingx.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.util.Collections;
import java.util.Date;

/**
 * @author unknown
 */
public class ControlPanel extends JPanel {
    private static final Logger LOGGER = LoggerFactory.getLogger(ControlPanel.class);

    public ControlPanel() {
        initComponents();

        xRadioGroup1.add("Option 1");
        xRadioGroup1.add("Option 2");
        xRadioGroup1.setSelectedValue("Option 1");

        xDatePicker1.setDate(new Date());
    }

    private void xHyperlink1(ActionEvent e) {
        AppUtils.openUrlInBrowser(xHyperlink1.getActionCommand());
    }

    private void xColorSelectionButton1PropertyChange(PropertyChangeEvent e) {
        var color = xColorSelectionButton1.getBackground();
        var hex = "#" + Integer.toHexString(color.getRGB()).substring(2);
        updateAccentColor(hex);
    }

    private void updateAccentColor(String color) {
        FlatLaf.setGlobalExtraDefaults(Collections.singletonMap("@accentBaseColor", color));

        Class<? extends LookAndFeel> lafClass = UIManager.getLookAndFeel().getClass();

        try {
            FlatLaf.setup(lafClass.newInstance());
            FlatLaf.updateUILater();
        } catch (InstantiationException | IllegalAccessException ex) {
            LOGGER.error("Failed to change accent color", ex);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        panel1 = new JPanel();
        label1 = new JLabel();
        checkBox1 = new JCheckBox();
        checkBox2 = new JCheckBox();
        xRadioGroup1 = new JXRadioGroup<>();
        spinner1 = new JSpinner();
        comboBox1 = new JComboBox<>();
        xSearchField1 = new JXSearchField();
        progressBar1 = new JProgressBar();
        xDatePicker1 = new JXDatePicker();
        slider1 = new JSlider();
        xColorSelectionButton1 = new JXColorSelectionButton();
        xHyperlink1 = new JXHyperlink();

        //======== this ========
        setLayout(new MigLayout(
                "fillx,hidemode 3",
                // columns
                "[fill]",
                // rows
                "[]"));

        //======== scrollPane1 ========
        {
            scrollPane1.setBorder(BorderFactory.createEmptyBorder());

            //======== panel1 ========
            {
                panel1.setBorder(BorderFactory.createEmptyBorder());
                panel1.setLayout(new MigLayout(
                        "fillx,hidemode 3,gap 10 12",
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

                //---- label1 ----
                label1.setText("Example of what some of the controls look like.");
                panel1.add(label1, "cell 0 0 2 1");

                //---- checkBox1 ----
                checkBox1.setText("Option 1");
                checkBox1.setSelected(true);
                panel1.add(checkBox1, "cell 0 1,alignx left,growx 0");

                //---- checkBox2 ----
                checkBox2.setText("Option 2");
                panel1.add(checkBox2, "cell 0 1");
                panel1.add(xRadioGroup1, "cell 1 1");
                panel1.add(spinner1, "cell 0 2,alignx left,growx 0");

                //---- comboBox1 ----
                comboBox1.setModel(new DefaultComboBoxModel<>(new String[]{
                        "Item 1",
                        "Item 2",
                        "Item 3"
                }));
                panel1.add(comboBox1, "cell 0 2");
                panel1.add(xSearchField1, "cell 1 2");

                //---- progressBar1 ----
                progressBar1.setValue(50);
                panel1.add(progressBar1, "cell 0 3");
                panel1.add(xDatePicker1, "cell 1 3");

                //---- slider1 ----
                slider1.setBorder(BorderFactory.createEmptyBorder());
                panel1.add(slider1, "cell 0 4");

                //---- xColorSelectionButton1 ----
                xColorSelectionButton1.setText("text");
                xColorSelectionButton1.setBackground(new Color(22, 136, 255));
                xColorSelectionButton1.setFocusable(false);
                xColorSelectionButton1.addPropertyChangeListener("background", e -> xColorSelectionButton1PropertyChange(e));
                panel1.add(xColorSelectionButton1, "cell 1 4,alignx left,growx 0");

                //---- xHyperlink1 ----
                xHyperlink1.setText("https://github.com/MetalAZ/swing-app");
                xHyperlink1.setFocusPainted(false);
                xHyperlink1.addActionListener(e -> xHyperlink1(e));
                panel1.add(xHyperlink1, "cell 0 5");
            }
            scrollPane1.setViewportView(panel1);
        }
        add(scrollPane1, "cell 0 0,dock center");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JPanel panel1;
    private JLabel label1;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JXRadioGroup<String> xRadioGroup1;
    private JSpinner spinner1;
    private JComboBox<String> comboBox1;
    private JXSearchField xSearchField1;
    private JProgressBar progressBar1;
    private JXDatePicker xDatePicker1;
    private JSlider slider1;
    private JXColorSelectionButton xColorSelectionButton1;
    private JXHyperlink xHyperlink1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
