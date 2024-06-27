package Object;

import javax.swing.*;
import java.awt.*;

public abstract class ObjBase extends JComponent {

    protected boolean select;
    protected Port[] ports;
    protected int strokeWidth = 5;

    public ObjBase() {
        super();
        initPort();
        this.setBounds(0, 0, 0, 0);
        this.setName("");
        select = false;
    }

    public ObjBase(int x, int y, int w, int h, String name) {
        super();
        initPort();
        this.setBounds(x, y, w, h);
        this.setName(name);
        select = false;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.isEmpty())
            name = "";
        super.setName(name);
    }

    public void setSelect(boolean s) {
        select = s;
    }

    public boolean getSelect() {
        return select;
    }

    public void draw(Graphics g) {
        drawObj(g);
        drawPort(g);
    }

    public abstract void drawObj(Graphics g);

    public void drawPort(Graphics g) {
        if (select) {
            for (Port port : ports)
                port.draw(g);
        }
    }

    private void initPort() {
        ports = new Port[4];
        for (int i = 0; i < 4; i++)
            ports[i] = new Port();
    }

    public void relocatePort() {
        ports[0].setLocation(getX() + getWidth()/2 - ports[0].wh/2, getY() - ports[0].wh); // top
        ports[1].setLocation(getX() + getWidth(), getY() + getHeight()/2 - ports[1].wh/2); // right
        ports[2].setLocation(getX() + getWidth()/2 - ports[2].wh/2, getY() + getHeight()); // bottom
        ports[3].setLocation(getX() - ports[3].wh, getY() + getHeight()/2 - ports[3].wh/2); // left
    }

    public Port getNearestPort(Point p) {
        Port nearest = null;
        double shortDistance = Double.MAX_VALUE;

        for (Port port : ports) {
            double distance = getDistance(p, port.getLocation());
            if (distance < shortDistance) {
                nearest = port;
                shortDistance = distance;
            }
        }

        return nearest;
    }

    private double getDistance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    @Override
    public void setBounds(int x, int y, int w, int h) {
        super.setBounds(x, y, w, h);
        relocatePort();
    }

    @Override
    public void setLocation(int x, int y) {
        super.setLocation(x, y);
        relocatePort();
    }

    public void addObj(ObjBase objBase) {}

    public int getObjCount() {
        return 1;
    }

}
