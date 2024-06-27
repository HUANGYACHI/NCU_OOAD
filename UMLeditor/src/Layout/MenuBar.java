package Layout;

import javax.swing.*;

import Action.RenameActionListener;
import Action.GroupActionListener;
import Action.UnGroupActionListener;

public class MenuBar extends JMenuBar{

    CanvasArea canvasArea;
    JMenuBar menuBar;
    public MenuBar(CanvasArea canvasArea) {
        this.canvasArea = canvasArea;
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMenuItem group = new JMenuItem("Group");
        JMenuItem unGroup = new JMenuItem("UnGroup");
        JMenuItem changeName = new JMenuItem("Change object name");

        group.addActionListener(new GroupActionListener(canvasArea));
        unGroup.addActionListener(new UnGroupActionListener(canvasArea));
        changeName.addActionListener(new RenameActionListener(canvasArea));

        edit.add(group);
        edit.add(unGroup);
        edit.add(changeName);

        menuBar = new JMenuBar();
        menuBar.add(file);
        menuBar.add(edit);
    }

}
