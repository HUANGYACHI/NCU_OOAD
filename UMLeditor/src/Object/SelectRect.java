package Object;

import javax.swing.*;
import java.awt.*;

public class SelectRect extends ObjBase{

    public SelectRect() { super(); }

    public SelectRect(int x, int y, int w, int h) {
        super(x, y, w, h, "SelectRect");
        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    @Override
    public void draw(Graphics g) {
        drawObj(g);
    }

    @Override
    public void drawObj(Graphics g) {
        g.setColor(Color.lightGray);
        g.drawRect(getX(), getY(), getWidth(), getHeight());
    }

}
