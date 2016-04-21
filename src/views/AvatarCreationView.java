package views;

import models.StateModel.AvatarCreationModel;
import models.StateModel.MainMenuModel;
import views.View;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.PackedColorModel;

public class AvatarCreationView extends View {

    private static final String TITLE = "Avatar Creation";

    // Scalable variables.
    private static int WIDTH = 700;
    private static int HEIGHT = 700;

    // Styling properties
    private Font titleFont;
    private Font generalFont;
    private int titleButtonMargin;

    //Model
    private AvatarCreationModel model;


    // Data properties
    public AvatarCreationView(int width, int height, Canvas canvas,AvatarCreationModel model) {
        super(width, height, canvas);
        this.model = model;
    }

    @Override
    public void render(Graphics g) {
        this.WIDTH = getScreenWidth();
        this.HEIGHT = getScreenHeight();

        renderBackground(g);
        renderTitle(g);
        renderButtons(g);
        Toolkit.getDefaultToolkit().sync();
    }

    private void renderBackground(Graphics g) {
        g.setColor(new Color(125,59,191));
        g.fillRect(0, 0, WIDTH, HEIGHT);

    }

    private void renderTitle(Graphics g) {
        g.setFont(titleFont);
        FontMetrics fm = g.getFontMetrics();

        Rectangle2D rectangle = fm.getStringBounds(TITLE,g);


        int x = WIDTH / 2 - (int)rectangle.getWidth() / 2;
        int y = (int)rectangle.getHeight();

        g.setColor(new Color(0,100,255));
        g.drawString(TITLE, x, y);

    }

    private void renderButtons(Graphics g) {

        g.setFont(titleFont);
        FontMetrics fm = g.getFontMetrics();

        int x = WIDTH*6/10;
        int y = HEIGHT*4/10;

        Color defaultColor = Color.YELLOW;
        Color selectedColor = Color.RED;

        for(AvatarCreationModel.AvatarCreationMenu option: AvatarCreationModel.AvatarCreationMenu.values()){
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
