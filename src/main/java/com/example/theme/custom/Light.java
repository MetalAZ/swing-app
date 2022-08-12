package com.example.theme.custom;

import com.formdev.flatlaf.FlatLightLaf;

public class Light extends FlatLightLaf {
    public static final String NAME = "Light";

    public static boolean setup() {
        return setup(new Light());
    }

    public static void installLafInfo() {
        installLafInfo(NAME, Light.class);
    }

    @Override
    public String getName() {
        return "Light";
    }

    @Override
    public String getDescription() {
        return "Light Look and Feel";
    }
}