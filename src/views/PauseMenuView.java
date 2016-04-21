package views;

import models.StateModel.PauseMenuModel;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;


/**
 * Created by Andy on 4/16/2016.
 */
public class PauseMenuView extends View {

    // Constants
    private final String TITLE = "Pause Menu";
    private BufferedImage bg;

    private static final int WIDTH = 700;
    private static final int HEIGHT = 700;

    // Styling properties
    private Font titleFont;
    private Font generalFont;
    private int titleButtonMargin;

    private PauseMenuModel model;

    public PauseMenuView(int width, int height, Canvas canvas, BufferedImage bg, PauseMenuModel model){
        super(width, height, canvas);
        this.bg = bg;
        this.model = model;
    }

    @Override
    public void render(Graphics g) {
        BufferedImage image = new BufferedImage(getScreenWidth(),getScreenHeight(), BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D g2 = image.createGraphics();

        renderBackground(g2);
        renderTitle(g2);
        renderButtons(g2);
        Toolkit.getDefaultToolkit().sync();

        g.drawImage(image,(int)(getScreenWidth()*0.2),(int)( getScreenHeight()*0.2),(int)( getScreenWidth()*0.6),(int)( getScreenHeight()*0.6),null);
    }

    private void renderBackground(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, getScreenWidth(),getScreenHeight());
        //g.drawImage(bg,0,0,getScreenWidth(),getScreenHeight(),null);
    }

    private void renderTitle(Graphics g) {
        titleFont = new Font("Serif", Font.BOLD, (int) (getScreenHeight() * .1));
        g.setFont(titleFont);
        FontMetrics fm = g.getFontMetrics();

        Rectangle2D rectangle = fm.getStringBounds(TITLE,g);


        int x = getScreenWidth() / 2 - (int)rectangle.getWidth() / 2;
        int y = (int)rectangle.getHeight();

        g.setColor(Color.BLACK);
        g.drawString(TITLE, x, y);

    }

    private void renderButtons(Graphics g) {
        titleFont = new Font("Serif", Font.BOLD, (int) (getScreenHeight() * .05));
        g.setFont(titleFont);
        FontMetrics fm = g.getFontMetrics();

        int x = (int) (getScreenWidth()*0.3/10);
        int y = getScreenHeight()*2/10;

        Color selectedColor = Color.BLACK;
        g.setColor(selectedColor);

        g.setFont(titleFont);
        //FontMetrics fm = g.getFontMetrics();

        //int x = WIDTH*6/10;
        //int y = HEIGHT*4/10;

        Color defaultColor = Color.YELLOW;
        //Color selectedColor = Color.RED;

        for(PauseMenuModel.PauseMenuOption option: PauseMenuModel.PauseMenuOption.values()){
            Rectangle2D rectangle = fm.getStringBounds(option.toString(),g);

            if(option.toString().equals(model.getSelected().toString())){
                g.setColor(selectedColor);
                g.drawString(option.toString(), x, y);
            } else {
                g.setColor(defaultColor);
                g.drawString(option.toString(), x, y);
            }

            y += fm.getHeight();
        }

    }

}
