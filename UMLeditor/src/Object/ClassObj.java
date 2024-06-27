package Object;

import java.awt.*;

public class ClassObj extends ObjBase{
    public ClassObj() {
        super();
    }

    public ClassObj(int x, int y, int w, int h, String name) {
        super(x, y, w, h, name);
    }

    @Override
    public void drawObj(Graphics g) {
        // Class Obj
        // 轉2D 可設線條粗度
        Graphics2D g2D = (Graphics2D) g;
        // background
        g2D.setColor(Color.lightGray);
        g2D.fillRect(getX(), getY(), getWidth(), getHeight());
        // class bound
        g2D.setColor(Color.black);
        g2D.setStroke(new BasicStroke(strokeWidth));
        g2D.drawRect(getX(), getY(), getWidth(), getHeight());
        g2D.drawLine(getX(), getY() + (getHeight() / 3), getX() + getWidth(), getY() + (getHeight() / 3));
        g2D.drawLine(getX(), getY() + (getHeight() / 3 * 2), getX() + getWidth(), getY() + (getHeight() / 3 * 2));
        // name
        g2D.setFont(new Font("Arial", Font.BOLD, 25));
        int wordWidth = g2D.getFontMetrics().stringWidth(getName());
        double empty = (Math.abs(getWidth()) - wordWidth)/2;
        g2D.drawString(getName(), getX() + (int) empty, getY() + getHeight() / 4);
    }
}
