package Object;

import javax.swing.*;
import java.awt.*;

public class Port extends JComponent {

    public int wh = 14;
    public Port() {
        super();
    }

    public Port(Point p) {
        super();
        setLocation(p);
    }

    public void draw(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(getX(), getY(), wh, wh);
    }

}
