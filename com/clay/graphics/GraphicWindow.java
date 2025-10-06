package com.clay.graphics;

import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferStrategy;

public class GraphicWindow extends Canvas {

    private BufferStrategy bufferStrategy;
    private Graphics2D g2d = null;
    private Color strokeColor = Color.WHITE;
    private Color fillColor = Color.WHITE;
    private float strokeWidth = 1.0f;
    private boolean filled = false;

    private String fontName = "Monospaced";
    private int fontStyle = Font.PLAIN;
    private int fontSize = 12;
    private Font fontText = new Font(fontName, fontStyle, fontSize);

    public GraphicWindow(int width, int height) {
        setSize(width, height);
    }

    public void CreateBuffer() {
        createBufferStrategy(3);
        bufferStrategy = getBufferStrategy();
    }

    private Graphics2D getGraphics2D() {
        if (bufferStrategy == null) {
            CreateBuffer();
        }
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.setStroke(new BasicStroke(strokeWidth));
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        return g;
    }

    public void ClearGraphic() {
        g2d = getGraphics2D();
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }

    public void RefreshGraphic() {
        if (bufferStrategy != null) {
            g2d.dispose();
            bufferStrategy.show();
            Toolkit.getDefaultToolkit().sync();
        }
    }

    public void SetAntialias(boolean antialias) {
        if (g2d == null) return;
        if (antialias) {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        } else {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        }
    }

    public void SetStrokeWidth(float size) {
        this.strokeWidth = size;
        g2d.setStroke(new BasicStroke(size));
    }

    public void SetColor(int color) {
        int alpha = ((color >> 24) & 0xFF);
        int red = ((color >> 16) & 0xFF);
        int green = ((color >> 8) & 0xFF);
        int blue = ((color) & 0xFF);
        Color value = new Color(red, green, blue, alpha);
        strokeColor = fillColor = value;
    }

    public void SetStrokeColor(int color) {
        int alpha = ((color >> 24) & 0xFF);
        int red = ((color >> 16) & 0xFF);
        int green = ((color >> 8) & 0xFF);
        int blue = ((color) & 0xFF);
        strokeColor = new Color(red, green, blue, alpha);
    }

    public void SetFillColor(int color) {
        int alpha = ((color >> 24) & 0xFF);
        int red = ((color >> 16) & 0xFF);
        int green = ((color >> 8) & 0xFF);
        int blue = ((color) & 0xFF);
        fillColor = new Color(red, green, blue, alpha);
    }

    public void Pixel(int x, int y) {
        Pixel(x, y, strokeColor.getRGB());
    }

    public void Pixel(int x, int y, int color) {
        g2d.setColor(new Color(color));
        g2d.fill(new Rectangle2D.Float(x, y, 1, 1));
    }

    public void Line(int x1, int y1, int x2, int y2) {
        g2d.setColor(strokeColor);
        g2d.draw(new Line2D.Float(x1, y1, x2, y2));
    }

    public void Rect(int x, int y, int w, int h) {
        Rect(x, y, w, h, false);
    }

    public void Rect(int x, int y, int w, int h, boolean fill) {
        if (fill) {
            g2d.setColor(fillColor);
            g2d.fillRect(x, y, w, h);
        }
        g2d.setColor(strokeColor);
        g2d.drawRect(x, y, w, h);
    }

    public void Circle(int x, int y, int rad) {
        Circle(x, y, rad, false);
    }

    public void Circle(int x, int y, int rad, boolean fill) {
        if (fill) {
            g2d.setColor(fillColor);
            g2d.fill(new Ellipse2D.Float(x, y, rad, rad));
        }
        g2d.setColor(strokeColor);
        g2d.draw(new Ellipse2D.Float(x, y, rad, rad));
    }

    public void Ellipse(int x, int y, int w, int h) {
        Ellipse(x, y, w, h, false);
    }

    public void Ellipse(int x, int y, int w, int h, boolean fill) {
        if (fill) {
            g2d.setColor(fillColor);
            g2d.fill(new Ellipse2D.Float(x, y, w, h));
        }
        g2d.setColor(strokeColor);
        g2d.draw(new Ellipse2D.Float(x, y, w, h));
    }

    public void Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        Triangle(x1, y1, x2, y2, x3, y3, false);
    }

    public void Triangle(int x1, int y1, int x2, int y2, int x3, int y3, boolean fill) {
        int[] xpoints = { x1, x2, x3 };
        int[] ypoints = { y1, y2, y3 };
        if (fill) {
            g2d.setColor(fillColor);
            g2d.fill(new Polygon(xpoints, ypoints, 3));
        }
        g2d.setColor(strokeColor);
        g2d.draw(new Polygon(xpoints, ypoints, 3));
    }

    public void Polygon(int[] xpoints, int[] ypoints) {
        Polygon(xpoints, ypoints, false);
    }

    public void Polygon(int[] xpoints, int[] ypoints, boolean fill) {
        if (xpoints.length != ypoints.length) return;
        int size = xpoints.length;
        if (fill) {
            g2d.setColor(fillColor);
            g2d.fill(new Polygon(xpoints, ypoints, size));
        }
        g2d.setColor(strokeColor);
        g2d.draw(new Polygon(xpoints, ypoints, size));
    }

    public void Arc(int x, int y, int radius, int start, int sweep) {
        Arc(x, y, radius, start, sweep, false);
    }

    public void Arc(int x, int y, int radius, int start, int sweep, boolean fill) {
        if (fill) {
            g2d.setColor(fillColor);
            g2d.fill(new Arc2D.Float(x, y, radius, radius, start, sweep, Arc2D.PIE));
        }
        g2d.setColor(strokeColor);
        g2d.draw(new Arc2D.Float(x, y, radius, radius, start, sweep, Arc2D.PIE));
    }

    public void ArcEllipse(int x, int y, int w, int h, int start, int sweep) {
        ArcEllipse(x, y, w, h, start, sweep, false);
    }

    public void ArcEllipse(int x, int y, int w, int h, int start, int sweep, boolean fill) {
        if (fill) {
            g2d.setColor(fillColor);
            g2d.fill(new Arc2D.Float(x, y, w, h, start, sweep, Arc2D.PIE));
        }
        g2d.setColor(strokeColor);
        g2d.draw(new Arc2D.Float(x, y, w, h, start, sweep, Arc2D.PIE));
    }

    public void Text(String text, int offsetX, int offsetY) {
        g2d.setFont(fontText);
        FontMetrics fm = g2d.getFontMetrics();
        int lineHeight = fm.getHeight();

        String[] lines = text.split("\\n", -1);
        int totalHeight = lines.length * lineHeight;
        int maxWidth = 0;
        for (String ln : lines) maxWidth = Math.max(maxWidth, fm.stringWidth(ln));

        int baseX = 0;
        int baseY = 0;

        g2d.setColor(strokeColor);
        for (int i = 0;i < lines.length;i++) {
            String ln = lines[i];
            int lineWidth = fm.stringWidth(ln);
            int drawX = baseX;
            int drawY = baseY + (i * lineHeight) + fm.getAscent();
            g2d.drawString(ln, drawX + offsetX, drawY + offsetY);
        }
    }

}
