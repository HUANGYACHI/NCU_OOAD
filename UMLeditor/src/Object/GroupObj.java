package Object;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GroupObj extends ObjBase{

    private List<ObjBase> objContainer;

    public GroupObj() {
        super();
        objContainer = new ArrayList<ObjBase>();
    }

    @Override
    public void draw(Graphics g) {
        drawObj(g);
        for (ObjBase obj : objContainer)
            obj.draw(g);
    }

    @Override
    public void drawObj(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setStroke(new BasicStroke(2));
        g2D.setColor(new Color(0, 0, 0, .1f));
        g2D.fillRect(getX(), getY(), getWidth(), getHeight());
        g2D.setColor(Color.gray);
        g2D.drawRect(getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void setBounds(int x, int y, int w, int h) {
        super.setBounds(x, y, w, h);
    }

    @Override
    public void setLocation(int x, int y) {
        Point oldLoc = this.getLocation();
        super.setLocation(x, y);

        int diffx = x - oldLoc.x;
        int diffy = y - oldLoc.y;

        for (ObjBase obj : objContainer)
            obj.setLocation(obj.getX() + diffx, obj.getY() + diffy);
    }

    @Override
    public Port getNearestPort(Point p) {
        return null; // 不能畫線
    }

    @Override
    public void setSelect(boolean s) {
        super.select = s;
        for (ObjBase obj : objContainer)
            obj.setSelect(false);
    }

    public List<ObjBase> getObjs() {
        return objContainer;
    }

    @Override
    public void addObj(ObjBase obj) {
        objContainer.add(obj);
        calBounds();
    }

    private void calBounds() {
        int minx = Integer.MAX_VALUE, miny = Integer.MAX_VALUE;
        int maxx = Integer.MIN_VALUE, maxy = Integer.MIN_VALUE;

        for (ObjBase obj : objContainer) {
            minx = obj.getX() < minx ? obj.getX() : minx;
            miny = obj.getY() < miny ? obj.getY() : miny;
            maxx = maxx < obj.getX() + obj.getWidth() ? obj.getX() + obj.getWidth() : maxx;
            maxy = maxy < obj.getY() + obj.getHeight() ? obj.getY() + obj.getHeight() : maxy;
        }

        this.setBounds(minx, miny, maxx - minx, maxy - miny);
    }

    @Override
    public void setName(String name) {
        if (name == null || name.isEmpty())
            name = "";
        super.setName(name);
        if (objContainer == null)
            return;
        for (ObjBase obj : objContainer)
            obj.setName(name);
    }

    @Override
    public int getObjCount() {
        return this.objContainer.size();
    }

}
