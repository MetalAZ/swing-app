package com.example.util;

import com.formdev.flatlaf.util.SystemInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class AppUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppUtils.class);


    public static String getAppVersion() {
        var p = AppUtils.class.getPackage();
        return p.getImplementationVersion() == null ? "<DEV>" : p.getImplementationVersion();
    }

    /**
     * Return true if successful.
     *
     * @param url Url to open
     * @return true is successfully opened
     */
    public static boolean openUrlInBrowser(String url) {
        if (SystemInfo.isLinux) return openUrlInBrowserUsingXDGOpen(url);
        if (SystemInfo.isMacOS) return openUrlInBrowserOnMac(url);
        if (Desktop.isDesktopSupported()) return openUrlInBrowserUsingDesktop(url);

        LOGGER.error("Failed to open url");
        return false;
    }

    private static boolean openUrlInBrowserOnMac(String url) {
        Runtime runtime = Runtime.getRuntime();

        try {
            runtime.exec(new String[]{"open " + url});
            return true;
        } catch (IOException e) {
            LOGGER.error("Failed to open url", e);
            return false;
        }
    }

    private static boolean openUrlInBrowserUsingXDGOpen(String url) {
        Runtime runtime = Runtime.getRuntime();

        try {
            runtime.exec(new String[]{"sh", "-c", "xdg-open " + url});
            return true;
        } catch (IOException e) {
            LOGGER.error("Failed to open url", e);
            return false;
        }
    }

    private static boolean openUrlInBrowserUsingDesktop(String url) {
        Desktop desktop = Desktop.getDesktop();

        try {
            desktop.browse(new URI(url));
            return true;
        } catch (IOException | URISyntaxException e) {
            LOGGER.error("Failed to open url", e);
            return false;
        }
    }
}
