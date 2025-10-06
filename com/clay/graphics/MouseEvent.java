package com.clay.graphics;

import static java.awt.event.MouseEvent.*;

public enum MouseEvent {

    // Butang
    MOUSE_BUTTON_LEFT(BUTTON1),
    MOUSE_BUTTON_MIDDLE(BUTTON2),
    MOUSE_BUTTON_RIGHT(BUTTON3),

    // Jenis
    IS_MOUSE_CLICKED(MOUSE_CLICKED),
    IS_MOUSE_PRESSED(MOUSE_PRESSED),
    IS_MOUSE_RELEASED(MOUSE_RELEASED),
    IS_MOUSE_MOVED(MOUSE_MOVED),
    IS_MOUSE_DRAGGED(MOUSE_DRAGGED),
    IS_MOUSE_ENTERED(MOUSE_ENTERED),
    IS_MOUSE_EXITED(MOUSE_EXITED),
    IS_MOUSE_WHEEL(MOUSE_WHEEL),

    ;

    private int code;

    MouseEvent(int code) {
        this.code = code;
    }

    public int getMouseCode() {
        return this.code;
    }

    public MouseEvent[] getAllMouses() {
        return MouseEvent.values();
    }

}
