import javax.swing.*;

public class GameElement {
    protected int x;
    protected int y;
    protected ImageIcon imageIcon;
    protected int iconHeight;
    protected int iconWidth;

    public GameElement(int x, int y) {
        this.x = x;
        this.y = y;
        this.imageIcon = imageIcon;
        this.iconHeight = iconHeight;
        this.iconWidth = iconWidth;
    }

    public int getIconHeight() {
        return iconHeight;
    }

    public void setIconHeight(int iconHeight) {
        this.iconHeight = iconHeight;
    }

    public int getIconWidth() {
        return iconWidth;
    }

    public void setIconWidth(int iconWidth) {
        this.iconWidth = iconWidth;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }
}
