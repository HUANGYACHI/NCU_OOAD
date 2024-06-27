package Line;

import javax.swing.*;
import java.awt.*;

import Object.Port;

public abstract class LineBase extends JComponent {

    protected Port p1, p2;
    protected int strokeWidth = 5;

    public LineBase() {
        super();
    }

    public LineBase(Port p1, Port p2) {
        super();
        this.p1 = p1;
        this.p2 = p2;
    }

    public void draw(Graphics g) {
        // 轉2D 可設線條粗度
        Graphics2D g2D = (Graphics2D) g;
        g2D.setStroke(new BasicStroke(strokeWidth));
        g.setColor(Color.black);
        g.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
        drawArrow(g2D);
    }

    public abstract void drawArrow(Graphics2D g2D);

}
