package views;

import controllers.Controller;
import controllers.StatsViewController;
import models.StateModel.ConfigInterfaceModel;
import models.StateModel.MainMenuModel;
import models.StateModel.StatsModel;
import views.View;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.PackedColorModel;

public class ConfigInterfaceView extends View {

    // Constants
    private final String TITLE = "Your Avatar's Stats!";
    private BufferedImage bg;

    // Styling properties
    private Font titleFont;
    private Font generalFont;
    private int titleButtonMargin;

    private ConfigInterfaceModel model;
    // Data properties
    public ConfigInterfaceView(int width, int height, Canvas canvas, ConfigInterfaceModel model, BufferedImage bg) {
        super(width, height, canvas);
        this.model = model;
        this.bg = bg;
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

        Color selectedColor = Color.RED;
        Color regularColor = Color.BLACK;
        g.setColor(regularColor);

        for(int i = 0; i < 5; ++i){
            if (model.getCurrentPoint() == i ) {
                g.setColor(selectedColor);
            }
            else {
                g.setColor(regularColor);
            }

            g.drawString(model.getKey(i), x, y);
            y += fm.getHeight();

            if (i == 10) {
                y = getScreenHeight()*2/10;
                x = (int) (getScreenWidth()*0.6);

            }
        }
    }
}
