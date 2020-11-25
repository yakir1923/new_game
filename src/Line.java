import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class Line extends GameElement {
    public Line(int x, int y) {
        super(x, y);

        this.imageIcon=new ImageIcon(getClass().getResource("img/line.jpg"));
        this.iconHeight=imageIcon.getIconHeight();
        this.iconWidth=imageIcon.getIconWidth();
    }

    public void moveleft() {
        if (x > 2)
            setX(getX() - 20);
    }
    public void moveRigth() {
        if (x < Main.WIDTH-iconWidth - 22)
            setX(getX() + 20);
    }

}
