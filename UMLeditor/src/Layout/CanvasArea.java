package Layout;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import Line.LineBase;
import Object.*;

public class CanvasArea extends JLayeredPane {

    private List<ObjBase> objs = new ArrayList<ObjBase>();
    private List<LineBase> lines = new ArrayList<LineBase>();
    private Point selectRecP;
    private SelectRect selectRect;

    public CanvasArea() {
        super();
        setLayout(null);
    }

    public void addObj(ObjBase obj) {
        objs.add(obj);
        this.add(obj, Integer.valueOf(objs.size() - 1));
        repaint();
    }

    public void removeObj(ObjBase obj) {
        objs.remove(obj);
        this.remove(obj);
        repaint();
    }

    public void addLine(LineBase line) {
        lines.add(line);
        repaint();
    }

    public List<ObjBase> getObjs() {
        return objs;
    }

    public int getObjCount() {
        return objs.size();
    }

    public ObjBase getObj(Point p) {
        // 最後的obj z最大 取最後一個的後一個來歷遍
        ListIterator li = getObjs().listIterator(getObjs().size());
        while (li.hasPrevious()) {
            ObjBase curObj = (ObjBase) li.previous();
            if (p.getX() >= curObj.getX() && p.getX() <= curObj.getX() + curObj.getWidth() &&
                    p.getY() >= curObj.getY() && p.getY() <= curObj.getY() + curObj.getHeight())
                return curObj;
        }
        return null;
    }

    public void setSelectRecP(Point p) { this.selectRecP = p; }

    public Point getSelectRecP() { return selectRecP; }

    public void setSelectRect(SelectRect rect) { this.selectRect = rect; }

    public SelectRect getselectRect() { return selectRect; }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (ObjBase obj : objs) {
            if (obj.getSelect())
                continue;
            obj.draw(g);
        }
        for (LineBase line : lines)
            line.draw(g);
        for (ObjBase obj : objs) {
            if (obj.getSelect())
                obj.draw(g);
        }
    }

}
