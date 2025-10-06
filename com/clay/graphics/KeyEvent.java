package com.clay.graphics;

import static java.awt.event.KeyEvent.*;

public enum KeyEvent {

    // Huruf dan Nombor
    KEY_A(VK_A),
    KEY_B(VK_B),
    KEY_C(VK_C),
    KEY_D(VK_D),
    KEY_E(VK_E),
    KEY_F(VK_F),
    KEY_G(VK_G),
    KEY_H(VK_H),
    KEY_I(VK_I),
    KEY_J(VK_J),
    KEY_K(VK_K),
    KEY_L(VK_L),
    KEY_M(VK_M),
    KEY_N(VK_N),
    KEY_O(VK_O),
    KEY_P(VK_P),
    KEY_Q(VK_Q),
    KEY_R(VK_R),
    KEY_S(VK_S),
    KEY_T(VK_T),
    KEY_U(VK_U),
    KEY_V(VK_V),
    KEY_W(VK_W),
    KEY_X(VK_X),
    KEY_Y(VK_Y),
    KEY_Z(VK_Z),

    KEY_0(VK_0),
    KEY_1(VK_1),
    KEY_2(VK_2),
    KEY_3(VK_3),
    KEY_4(VK_4),
    KEY_5(VK_5),
    KEY_6(VK_6),
    KEY_7(VK_7),
    KEY_8(VK_8),
    KEY_9(VK_9),

    // Fungsi
    KEY_F1(VK_F1),
    KEY_F2(VK_F2),
    KEY_F3(VK_F3),
    KEY_F4(VK_F4),
    KEY_F5(VK_F5),
    KEY_F6(VK_F6),
    KEY_F7(VK_F7),
    KEY_F8(VK_F8),
    KEY_F9(VK_F9),
    KEY_F10(VK_F10),
    KEY_F11(VK_F11),
    KEY_F12(VK_F12),
    KEY_F13(VK_F13),
    KEY_F14(VK_F14),
    KEY_F15(VK_F15),
    KEY_F16(VK_F16),
    KEY_F17(VK_F17),
    KEY_F18(VK_F18),
    KEY_F19(VK_F19),
    KEY_F20(VK_F20),
    KEY_F21(VK_F21),
    KEY_F22(VK_F22),
    KEY_F23(VK_F23),
    KEY_F24(VK_F24),

    // Kawalan
    KEY_ESCAPE(VK_ESCAPE),
    KEY_TAB(VK_TAB),
    KEY_SHIFT(VK_SHIFT),
    KEY_CONTROL(VK_CONTROL),
    KEY_ALT(VK_ALT),
    KEY_SPACE(VK_SPACE),
    KEY_CAPS_LOCK(VK_CAPS_LOCK),
    KEY_ENTER(VK_ENTER),
    KEY_BACK_SPACE(VK_BACK_SPACE),
    KEY_DELETE(VK_DELETE),
    KEY_INSERT(VK_INSERT),
    KEY_PRINTSCREEN(VK_PRINTSCREEN),
    KEY_SCROLL_LOCK(VK_SCROLL_LOCK),
    KEY_PAUSE(VK_PAUSE),
    KEY_NUM_LOCK(VK_NUM_LOCK),

    // Navigasi
    KEY_UP(VK_UP),
    KEY_DOWN(VK_DOWN),
    KEY_LEFT(VK_LEFT),
    KEY_RIGHT(VK_RIGHT),
    KEY_HOME(VK_HOME),
    KEY_END(VK_END),
    KEY_PAGE_UP(VK_PAGE_UP),
    KEY_PAGE_DOWN(VK_PAGE_DOWN),

    // Pad nombor
    KEY_NUMPAD0(VK_NUMPAD0),
    KEY_NUMPAD1(VK_NUMPAD1),
    KEY_NUMPAD2(VK_NUMPAD2),
    KEY_NUMPAD3(VK_NUMPAD3),
    KEY_NUMPAD4(VK_NUMPAD4),
    KEY_NUMPAD5(VK_NUMPAD5),
    KEY_NUMPAD6(VK_NUMPAD6),
    KEY_NUMPAD7(VK_NUMPAD7),
    KEY_NUMPAD8(VK_NUMPAD8),
    KEY_NUMPAD9(VK_NUMPAD9),
    KEY_MULTIPLY(VK_MULTIPLY),
    KEY_ADD(VK_ADD),
    KEY_SUBTRACT(VK_SUBTRACT),
    KEY_DIVIDE(VK_DIVIDE),
    KEY_DECIMAL(VK_DECIMAL),
    KEY_SEPARATOR(VK_SEPARATOR),

    // Istimewa / Simbol
    KEY_SEMICOLON(VK_SEMICOLON),
    KEY_EQUALS(VK_EQUALS),
    KEY_COMMA(VK_COMMA),
    KEY_MINUS(VK_MINUS),
    KEY_PERIOD(VK_PERIOD),
    KEY_SLASH(VK_SLASH),
    KEY_BACK_SLASH(VK_BACK_SLASH),
    KEY_OPEN_BRACKET(VK_OPEN_BRACKET),
    KEY_CLOSE_BRACKET(VK_CLOSE_BRACKET),
    KEY_QUOTE(VK_QUOTE),
    KEY_BACK_QUOTE(VK_BACK_QUOTE),

    ;

    private int code;

    KeyEvent(int code) {
        this.code = code;
    }

    public int getKeyCode() {
        return this.code;
    }

    public KeyEvent[] getAllKeys() {
        return KeyEvent.values();
    }

}
