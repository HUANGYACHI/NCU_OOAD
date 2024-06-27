package Factory;

import Line.*;
import Object.*;
import Button.*;

import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class Factory {
    private static int classW = 120, classH = 150;
    private static int useCaseW = 150, useCaseH = 100;
    public static int gridRows = 6;
    public static String buttonType[] = {"select", "associationLine", "generalizationLine", "compositionLine", "class", "useCase"};

    public static GridLayout setGridLayout() {
        return new GridLayout(gridRows, 0, 0, 0);
    }

    public static ButtonBase createButton(String buttonType) {
        switch (buttonType) {
            case "select":
                return new SelectButton("src/IconImg/selectIcon.png");
            case "associationLine":
                return new AssociationLineButton("src/IconImg/associationLineIcon.png");
            case "generalizationLine":
                return new GeneralizationLineButton("src/IconImg/generalizationLineIcon.png");
            case "compositionLine":
                return new CompositionLineButton("src/IconImg/compositionLineIcon.png");
            case "class":
                return new ClassButton("src/IconImg/classIcon.png");
            case "useCase":
                return new UseCaseButton("src/IconImg/useCaseIcon.png");
            default:
                return null;
        }
    }

    public static ObjBase createObj(String objType, MouseEvent e) {
        switch (objType) {
            case "Class":
                return new ClassObj(e.getX(), e.getY(), classW, classH, "Class");
            case "UseCase":
                return new UseCaseObj(e.getX(), e.getY(), useCaseW, useCaseH, "UseCase");
            default:
                return null;
        }
    }

    public static LineBase createLine(String lineType, Port p1, Port p2) {
        switch (lineType) {
            case "Association":
                return new AssociationLine(p1, p2);
            case "Generalization":
                return new GeneralizationLine(p1, p2);
            case "Composition":
                return new CompositionLine(p1, p2);
            default:
                return null;
        }
    }
}
