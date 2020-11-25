import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main extends JFrame {
    public static final int HEIGHT = 1000;
    public static final int WIDTH = 1200;
    public static void main(String[] args) {
        File backgroundO= new File("C:\\Users\\USER\\Desktop\\לימודים\\JAVA\\לשלוח\\new_game\\src\\img\\background.jpg");
        File backgroundR=new File("C:\\Users\\USER\\Desktop\\לימודים\\JAVA\\לשלוח\\new_game\\src\\img\\newBack2.jpg");
        resizeImage(backgroundO,backgroundR,WIDTH,HEIGHT,"jpg");

        File ball=new File("C:\\Users\\USER\\Desktop\\לימודים\\JAVA\\לשלוח\\new_game\\src\\img\\white_ball.png");
        File new_ball=new File("C:\\Users\\USER\\Desktop\\לימודים\\JAVA\\לשלוח\\new_game\\src\\img\\new_ball.png");
        resizeImage(ball,new_ball,41,41,"png");

        File youLoseO= new File("C:\\Users\\shani\\Desktop\\שנה ג\\java\\new game\\new_game\\src\\img\\youlose.gif");
        File youLoseR=new File("C:\\Users\\shani\\Desktop\\שנה ג\\java\\new game\\new_game\\src\\img\\youlose2.gif");
        resizeImage(youLoseO,youLoseR,WIDTH,HEIGHT,"gif");

        File youwWinO= new File("C:\\Users\\shani\\Desktop\\שנה ג\\java\\new game\\new_game\\src\\img\\youwin.gif");
        File youWinR=new File("C:\\Users\\shani\\Desktop\\שנה ג\\java\\new game\\new_game\\src\\img\\youwin2.gif");
        resizeImage(youwWinO,youWinR,WIDTH,HEIGHT,"gif");

        new Main();
    }
    public Main(){
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        this.add(new GamePanel());
        this.setVisible(true);

    }
    private static void resizeImage(File originalImage, File resizeImage, int wideth, int height, String format){
        try{
            BufferedImage original= ImageIO.read(originalImage);
            BufferedImage resize= new BufferedImage(wideth,height,original.getType());
            Graphics2D g2= resize.createGraphics();
            g2.drawImage(original,0,0,wideth,height,null);
            g2.dispose();
            ImageIO.write(resize,format,resizeImage);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}