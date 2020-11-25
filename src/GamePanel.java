import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class GamePanel extends JPanel {
    public final int ALLBLOCKS = 56;
    private ArrayList<Block> blocks;
    private Line line;
    private Ball ball;
    private LineLisener lineLisener;
    private boolean gameOver;
    private boolean winwin;
    private ImageIcon gameOverIcon, winwinIcon;
    private int score =0;
    private JLabel showScore=new JLabel(""+score);
    private long startTime;

    public GamePanel() {
        startTime = System.currentTimeMillis();
        showScore.setFont(new Font("Arial",Font.PLAIN,50));
        showScore.setForeground(Color.white);
        this.add(showScore);
        this.line = new Line(Main.WIDTH / 2, Main.HEIGHT - 200);
        this.ball = new Ball(this.line.getX(), this.line.getY());
        this.blocks = new ArrayList<>();
        this.gameOver=false;
        this.winwin=false;
        int x = 0;
        int y = 0;
        for (int i = 0; i < ALLBLOCKS; i++) {
            this.blocks.add(new Block(x, y));
            if (x > Main.HEIGHT) {
                y += 50;
                x = 0;
            } else {
                x += 150;
            }
        }

        new Thread(() -> {
            try {
                Thread.sleep(100);
                setFocusable(true);
                requestFocus();
                this.addKeyListener(lineLisener = new LineLisener(this.line, this.ball, this));
                while (!gameOver) {
                    if (lineLisener.isGameStarted()) {
                        if (ball.getY() <= 0) {
                            ball.setDown(true);
                        }
                        if (ball.getX() > (Main.WIDTH - this.ball.getIconWidth())) {
                            ball.setLeft(true);
                        }
                        if (createRectangle(ball).intersects(createRectangle(line))) {
                            ball.setDown(false);
                        }
                        if (ball.getY() >= Main.HEIGHT) {
                            System.out.println("faile");
                        }
                        if (ball.getX() <= 0) {
                            ball.setLeft(false);
                        }
                        if (!ball.isDown()) {
                            if (!ball.isLeft()) {
                                ball.moveRU();
                            }
                            if (ball.isLeft() == true) {
                                ball.moveLU();
                            }
                        } else {
                            if (ball.isLeft() == false) {
                                ball.moveRD();
                            } else {
                                ball.moveLD();
                            }
                        }
                    }
                    long countVisibleBlocks=blocks.stream().filter(block -> !block.isBroken()).count();

                    ArrayList<Block> visibleBlocks = new ArrayList<>(blocks.stream().filter(block -> !block.isBroken()).collect(Collectors.toList()));
                    for (Block block : visibleBlocks) {
                        if (!block.isBroken()) {
                            if (createRectangle(ball).intersects(createRectangle(block))) {
                                block.setBroken(true);
                                ball.setDown(!ball.isDown());
                                score++;
                                showScore.setText(""+score);
                            }

                        }

                    }
                    if (countVisibleBlocks==0)
                        winwin=true;


                    if(ball.getY()>Main.HEIGHT)
                    {
                        gameOver=true;
                    }
                    long now  = System.currentTimeMillis();
                    if (now - this.startTime > 30000) {
                        this.startTime = now;
                        this.ball.increaseSpeed();
                    }
                    Thread.sleep(10);
                    repaint();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        ImageIcon background = new ImageIcon(getClass().getResource("img/newBack2.jpg"));
        background.paintIcon(this, g, 0, 0);


        for (Block block : blocks) {
            if ((block.isBroken() == false)) {
                block.imageIcon.paintIcon(this, g, block.getX(), block.getY());
            }
        }
        ball.imageIcon.paintIcon(this, g, ball.getX(), ball.getY());
        line.imageIcon.paintIcon(this, g, line.getX(), line.getY());
        if (gameOver){
            gameOverIcon=new ImageIcon(getClass().getResource("img/youlose2.gif"));
            gameOverIcon.paintIcon(this,g,0,0);
        }
        if(winwin){
            winwinIcon=new ImageIcon(getClass().getResource("img/youwin2.gif"));
            winwinIcon.paintIcon(this,g,0,0);
        }
    }


    public ArrayList<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(ArrayList<Block> blocks) {
        this.blocks = blocks;
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public Rectangle createRectangle(GameElement gameElement) {
        Rectangle rectangle = new Rectangle(gameElement.x, gameElement.y, gameElement.iconWidth, gameElement.iconHeight);
        return rectangle;
    }

}
