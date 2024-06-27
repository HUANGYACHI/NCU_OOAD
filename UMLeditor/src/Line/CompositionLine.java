package Line;

import java.awt.*;
import java.awt.geom.Line2D;

import Layout.MainWindow;
import Object.Port;

public class CompositionLine extends LineBase{

    public CompositionLine(Port p1, Port p2) {
        super(p1, p2);
    }

    @Override
    public void drawArrow(Graphics2D g2D) {
        // Composition Line
        // 轉2D 可設線條粗度
//        Graphics2D g2D = (Graphics2D) g;
//        g2D.setStroke(new BasicStroke(strokeWidth));
        // arrow
        double phi = Math.toRadians(40);
        int barb = 20;
        double dy = p2.getY() - p1.getY();
        double dx = p2.getX() - p1.getX();
        double theta = Math.atan2(dy, dx);
        double x, y, x2, y2, x3, y3, rho = theta + phi;

        x = p2.getX() - barb * Math.cos(rho);
        y = p2.getY() - barb * Math.sin(rho);
        rho = theta - phi;

        x2 = x - barb * Math.cos(rho);
        y2 = y - barb * Math.sin(rho);
        rho = theta - phi;

        x3 = p2.getX() - barb * Math.cos(rho);
        y3 = p2.getY() - barb * Math.sin(rho);


        int[] xpoints = {p2.getX(), (int) x, (int) x2, (int) x3};
        int[] ypoints = {p2.getY(), (int) y, (int) y2, (int) y3};

        g2D.setColor(MainWindow.getCanvasArea().getBackground());
        g2D.fillPolygon(xpoints, ypoints, 4);
        g2D.setColor(Color.black);
        g2D.drawPolygon(xpoints, ypoints, 4);
    }

}
