package com.clay.graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class CreateWindow {

    private String title = "Untitled";
    private int x = 0;
    private int y = 0;
    private int width = 640;
    private int height = 480;
    private boolean available = false;

    private JFrame frame = null;
    private GraphicWindow graphic = null;
    private EventWindow event = null;

    private Color backgroundColor = Color.BLACK;

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

    public CreateWindow(String title, int x, int y, int w, int h) {
        this.title = title;
        this.x = x;
        this.y = y;
        this.width = w;
        this.height =  h;

        window();
    }

    public String GetTitle() {
        return title;
    }

    public int GetX() {
        return x;
    }

    public int GetY() {
        return y;
    }

    public int GetWidth() {
        return width;
    }

    public int GetHeight() {
        return height;
    }

    public void ShowWindow() {
        available = true;
        frame.setVisible(true);
        graphic.CreateBuffer();
    }

    public void SetBackgroundWindow(Colors color) {
        backgroundColor = color.toAWTColor();
    }

    public boolean IsAvailableWindow() {
        try {
            Thread.sleep(16);
        } catch (InterruptedException e) {}
        return frame.isVisible();
    }

    public EventWindow GetEventWindow() {
        return event;
    }

    public GraphicWindow GetGraphicWindow() {
        return graphic;
    }

    public void CloseWindow() {
        try {
            if (frame != null) {
                frame.setVisible(false);
                frame.dispose();
                System.exit(0);
            }
        } finally {
            frame = null;
            graphic = null;
            event = null;
        }
    }

    private void window() {
        frame = new JFrame(title);
        graphic = new GraphicWindow(width, height);
        event = new EventWindow();

        graphic.setPreferredSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        graphic.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                event.lastchar = e.getKeyChar();
                int code = e.getKeyCode();
                if (code >= 0 && code < event.keyDown.length) {
                    if (!event.keyDown[code]) event.keyPressed.add(code);
                    event.keyDown[code] = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                event.lastchar = '\0';
                int code = e.getKeyCode();
                if (code >= 0 && code < event.keyDown.length) {
                    event.keyDown[code] = false;
                    event.keyRelesed.add(code);
                }
            }
        });

        graphic.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                int b = e.getButton();
                if (b >= 0 && b < event.mouseDown.length) {
                    if (!event.mouseDown[b]) event.mousePressed.add(b);
                    event.mouseDown[b] = true;
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                int b = e.getButton();
                if (b >= 0 && b < event.mouseDown.length) {
                    event.mouseDown[b] = false;
                    event.mouseReleased.add(b);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                event.mousex = e.getX();
                event.mousey = e.getY();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                event.mousex = e.getX();
                event.mousey = e.getY();
            }
        });

        graphic.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                event.mousex = e.getX();
                event.mousey = e.getY();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                event.mousex = e.getX();
                event.mousey = e.getY();
            }
        });

        graphic.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                event.mouseWheelRotation = e.getWheelRotation();
                event.mouseScrollWheelRotation += event.mouseWheelRotation;
            }
        });

        graphic.setFocusable(true);

        frame.add(graphic, BorderLayout.CENTER);
        frame.pack();
        frame.setLocation(x, y);
    }

}
