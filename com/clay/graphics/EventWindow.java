package com.clay.graphics;

import java.util.HashSet;
import java.util.Set;

public class EventWindow {

    protected boolean[] keyDown = new boolean[512];
    protected Set<Integer> keyPressed = new HashSet<>();
    protected Set<Integer> keyRelesed = new HashSet<>();
    protected volatile char lastchar = '\0';

    protected volatile int mousex = 0;
    protected volatile int mousey = 0;
    protected boolean[] mouseDown = new boolean[8];
    protected Set<Integer> mousePressed = new HashSet<>();
    protected Set<Integer> mouseReleased = new HashSet<>();
    protected int mouseWheelRotation = 0;
    protected int mouseScrollWheelRotation = 0;

    public EventWindow() {
    }

    public boolean IsKeyEvent(KeyEvent event) {
        int key = event.getKeyCode();
        if (key < 0 || key >= keyDown.length) return false;
        return keyDown[key];
    }

    public boolean IsKB() {
        for (boolean kd : keyDown) if (kd) return true;
        return !keyPressed.isEmpty() || !keyRelesed.isEmpty();
    }

    public char Getch() {
        return lastchar;
    }

    public boolean IsMouseEvent(MouseEvent event) {
        int button = event.getMouseCode();
        return (button >= 0 && button < mouseDown.length) && mouseDown[button];
    }

    public int GetMouseX() {
        return mousex;
    }

    public int GetMouseY() {
        return mousey;
    }

    public int GetMouseScrollWheel() {
        return mouseScrollWheelRotation;
    }

}
