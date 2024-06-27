package Line;

import java.awt.*;

import Layout.MainWindow;
import Object.Port;

public class GeneralizationLine extends LineBase{

    public GeneralizationLine(Port p1, Port p2) {
        super(p1, p2);
    }

    @Override
    public void drawArrow(Graphics2D g2D) {
        // Generalization Line
        // 轉2D 可設線條粗度
//        Graphics2D g2D = (Graphics2D) g;
//        g2D.setStroke(new BasicStroke(strokeWidth));
        // arrow
        int dx = p2.getX() - p1.getX(), dy = p2.getY() - p1.getY();
        double D = Math.sqrt(dx * dx + dy * dy);
        double xm = D - 20, xn = xm, ym = 15, yn = -15, x;
        double sin = dy / D, cos =  dx / D;

        x = xm*cos - ym*sin + p1.getX();
        ym = xm*sin + ym*cos + p1.getY();
        xm = x;

        x = xn*cos - yn*sin + p1.getX();
        yn = xn*sin + yn*cos + p1.getY();
        xn = x;

        int[] xpoints = {p2.getX(), (int) xm, (int) xn};
        int[] ypoints = {p2.getY(), (int) ym, (int) yn};

        g2D.setColor(MainWindow.getCanvasArea().getBackground());
        g2D.fillPolygon(xpoints, ypoints, 3);
        g2D.setColor(Color.black);
        g2D.drawPolygon(xpoints, ypoints, 3);
    }
}
