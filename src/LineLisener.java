import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LineLisener implements KeyListener {
    private Line line;
    private Ball ball;
    private GamePanel gamePanel;
    private boolean gameStarted;


    public LineLisener(Line line, Ball ball, GamePanel gamePanel) {
        this.line = line;
        this.ball = ball;

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case (KeyEvent.VK_SPACE):
                ball.moveRU();
                gameStarted = true;
                break;
            case (KeyEvent.VK_RIGHT):
                line.moveRigth();
                if (!gameStarted) {
                    ball.setX(line.getX());
                }
                break;
            case (KeyEvent.VK_LEFT):
                line.moveleft();
                if (!gameStarted) {
                    ball.setX(line.getX());
                }
                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public boolean isGameStarted() {
        return gameStarted;
    }

    public void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
    }
}
