package com.clay.graphics;

import java.awt.*;

public class Colors {
    private int value;

    public static final int RED = 0xFFFF0000;
    public static final int GREEN = 0xFF00FF00;
    public static final int BLUE = 0xFF0000FF;
    public static final int BLACK = 0xFF000000;
    public static final int WHITE = 0xFFFFFFFF;
    public static final int TRANSPARENT = 0x00000000;
    public static final int YELLOW = 0xFFFFFF00;
    public static final int CYAN = 0xFF00FFFF;
    public static final int MAGENTA = 0xFFFF00FF;
    public static final int GRAY = 0xFF808080;
    public static final int SILVER = 0xFFC0C0C0;
    public static final int MAROON = 0xFF800000;
    public static final int OLIVE = 0xFF808000;
    public static final int LIME = 0xFF00FF00;
    public static final int TEAL = 0xFF008080;
    public static final int NAVY = 0xFF000080;
    public static final int PURPLE = 0xFF800080;
    public static final int ORANGE = 0xFFFFA500;

    public Colors(int color) {
        int alpha = ((color >> 24) & 0xFF);
        if (alpha == 0) {
            this.value = 0xFF000000 | color;
        } else {
            this.value = color;
        }
    }

    public Colors(int red, int green, int blue) {
        this(255, red, green, blue);
    }

    public Colors(int alpha, int red, int green, int blue) {
        value = ((alpha & 0xFF) << 24) | ((red & 0xFF) << 16) | ((green & 0xFF) << 8) | ((blue & 0xFF));
    }

    public Colors(String color) {
        color = color.trim().toLowerCase();
        if (color.startsWith("#")) {
            color = color.substring(1);
            if (color.length() == 6) {
                // #rrggbb
                value = 0xFF000000 | Integer.parseInt(color, 16);
            } else if (color.length() == 8) {
                // #aarrggbb
                value = (int) Long.parseLong(color, 16);
            }
        } else if (color.startsWith("0x")) {
            color = color.substring(2);
            if (color.length() == 6) {
                // 0xrrggbb
                value = 0xFF000000 | Integer.parseInt(color, 16);
            } else if (color.length() == 8) {
                // 0xaarrggbb
                value = (int) Long.parseLong(color, 16);
            }
        }
        throw new IllegalArgumentException("Invalid color format: " + color);
    }

    public static int argb(int alpha, int red, int green, int blue) {
        return ((alpha & 0xFF) << 24) | ((red & 0xFF) << 16) | ((green & 0xFF) << 8) | ((blue & 0xFF));
    }

    public static int rgb(int red, int green, int blue) {
        return argb(255, red, green, blue);
    }

    public Color toAWTColor() {
        return new Color(getRed(), getGreen(), getBlue(), getAlpha());
    }

    public int getRGB() {
        return value;
    }

    public int getAlpha() {
        return (getRGB() >> 24) & 0xFF;
    }

    public int getRed() {
        return (getRGB() >> 16) & 0xFF;
    }

    public int getGreen() {
        return (getRGB() >> 8) & 0xFF;
    }

    public int getBlue() {
        return (getRGB()) & 0xFF;
    }

    public String toHexString() {
        return String.format("#%08X", value);
    }

}
