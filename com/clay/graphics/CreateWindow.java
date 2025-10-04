package com.clay.graphics;

import javax.swing.*;

public class CreateWindow {

    private JFrame frame = new JFrame();
    private String title = "Untitled";
    private int x = 0;
    private int y = 0;
    private int width = 680;
    private int height = 480;

    public CreateWindow() {
        window();
    }

    public CreateWindow(String title) {
        this.title = title;

        window();
    }

    public CreateWindow(String title, int x, int y) {
        this.title = title;
        this.x = x;
        this.y = y;

        window();
    }

    public CreateWindow(String title, int x, int y, int width, int height) {
        this.title = title;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        window();
    }

    private void window() {
    }

}
