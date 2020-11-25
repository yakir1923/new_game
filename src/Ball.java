import javax.swing.*;
import java.awt.*;

public class Ball extends GameElement {
    private boolean isAlive;
    private boolean down;
    private boolean left;
    private int speed;

    public Ball(int x, int y) {
        super(x, y);
        this.isAlive = true;
        this.down = false;
        this.left = false;
         this.imageIcon = new ImageIcon(getClass().getResource("img/new_ball.png"));
        this.iconHeight=imageIcon.getIconHeight();
        this.iconWidth=imageIcon.getIconHeight();
        this.y -= this.iconHeight;
        this.speed = 4;
    }

    public void moveRU() {
        setY(getY() - this.speed);
        setX(getX() + this.speed);
    }

    public void moveRD() {
        setY(getY() + this.speed);
        setX(getX() + this.speed);
    }

    public void moveLD() {
        setY(getY() + this.speed);
        setX(getX() - this.speed);
    }

    public void moveLU() {
        setY(getY() - this.speed);
        setX(getX() - this.speed);
    }


    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }


    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean hitWall() {
        if (this.x == Main.HEIGHT) {
            return true;
        }
        return false;
    }

    public void increaseSpeed () {
        this.speed++;
    }
}
