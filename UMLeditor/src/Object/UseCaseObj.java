package Object;

import java.awt.*;

public class UseCaseObj extends ObjBase {
    public UseCaseObj() {
        super();
    }

    public UseCaseObj(int x, int y, int w, int h, String name) {
        super(x, y, w, h, name);
    }

    @Override
    public void drawObj(Graphics g) {
        // UseCase Obj
        // 轉2D 可設線條粗度
        Graphics2D g2D = (Graphics2D) g;
        // background
        g2D.setColor(Color.lightGray);
        g2D.fillOval(getX(), getY(), getWidth(), getHeight());
        // useCase bound
        g2D.setColor(Color.black);
        g2D.setStroke(new BasicStroke(strokeWidth));
        g2D.drawOval(getX(), getY(), getWidth(), getHeight());
        // name
        g2D.setFont(new Font("Arial", Font.BOLD, 25));
        int wordWidth = g2D.getFontMetrics().stringWidth(getName());
        double empty = (Math.abs(getWidth()) - wordWidth)/2;
        g2D.drawString(getName(), getX() + (int) empty, getY() + getHeight() / 2);
    }
}
