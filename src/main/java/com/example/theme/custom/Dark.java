package com.example.theme.custom;

import com.formdev.flatlaf.FlatDarkLaf;

public class Dark extends FlatDarkLaf {
    public static final String NAME = "Dark";

    public static boolean setup() {
        return setup(new Dark());
    }

    public static void installLafInfo() {
        installLafInfo(NAME, Dark.class);
    }

    @Override
    public String getName() {
        return "Dark";
    }

    @Override
    public String getDescription() {
        return "Dark Look and Feel";
    }
}