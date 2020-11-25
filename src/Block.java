import javax.swing.*;
import java.awt.*;

public class Block extends GameElement {
    private boolean isBroken;

    public Block(int x, int y) {
        super(x, y);
        this.isBroken = false;
        this.imageIcon=new ImageIcon(getClass().getResource("img/block.png"));
        this.iconHeight=imageIcon.getIconHeight();
        this.iconWidth=imageIcon.getIconWidth();
    }

    public boolean isBroken() {
        return isBroken;
    }

    public void setBroken(boolean broken) {
        isBroken = broken;
    }

}
