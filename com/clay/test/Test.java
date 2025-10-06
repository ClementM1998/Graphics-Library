package com.clay.test;

import com.clay.graphics.Colors;
import com.clay.graphics.CreateWindow;
import com.clay.graphics.EventWindow;
import com.clay.graphics.GraphicWindow;

public class Test {
    public static void main(String[] args) {

        CreateWindow window = new CreateWindow();
        GraphicWindow graphic = window.GetGraphicWindow();
        EventWindow event = window.GetEventWindow();

        while (window.IsAvailableWindow()) {
            graphic.ClearWindow();

            graphic.RefreshWindow();
        }

        window.CloseWindow();

    }
}
