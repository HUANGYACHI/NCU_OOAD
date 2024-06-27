package Line;

import java.awt.*;
import java.awt.geom.Line2D;

import Object.Port;

public class AssociationLine extends LineBase{

    public AssociationLine(Port p1, Port p2) {
        super(p1, p2);
    }

    @Override
    public void drawArrow(Graphics2D g2D) {
        // Association Line
        // 轉2D 可設線條粗度
//        Graphics2D g2D = (Graphics2D) g;
//        g2D.setStroke(new BasicStroke(strokeWidth));
        // arrow
        double phi = Math.toRadians(40);
        int barb = 20;
        double dy = p2.getY() - p1.getY();
        double dx = p2.getX() - p1.getX();
        double theta = Math.atan2(dy, dx);
        double x, y, rho = theta + phi;

        for(int j = 0; j < 2; j++)
        {
            x = p2.getX() - barb * Math.cos(rho);
            y = p2.getY() - barb * Math.sin(rho);
            g2D.draw(new Line2D.Double(p2.getX(), p2.getY(), x, y));
            rho = theta - phi;
        }
    }

}
