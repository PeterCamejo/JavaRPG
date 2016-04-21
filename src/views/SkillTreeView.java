package views;

import controllers.Controller;
import controllers.StatsViewController;
import models.StateModel.MainMenuModel;
import models.StateModel.SkillTreeModel;
import models.StateModel.StatsModel;
import views.View;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.PackedColorModel;

public class SkillTreeView extends View {

    // Constants
    private final String TITLE = "Your Avatar's Skills!";
    private BufferedImage bg;

    // Styling properties
    private Font titleFont;
    private Font generalFont;
    private int titleButtonMargin;

    private SkillTreeModel model;
    // Data properties
    public SkillTreeView(int width, int height, Canvas canvas, SkillTreeModel model, BufferedImage bg) {
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
        titleFont = new Font("Serif", Font.BOLD, (int) (getScreenHeight() * .06));
        g.setFont(titleFont);

        fm = g.getFontMetrics();
        y += fm.getHeight();
        rectangle = fm.getStringBounds("Curret Skill Points: " + model.getSkillPoints(),g);
        x = getScreenWidth() / 2 - (int)rectangle.getWidth() / 2;
        g.drawString("Curret Skill Points: " + model.getSkillPoints(), x, y);

        y += fm.getHeight();
        rectangle = fm.getStringBounds("Press Enter To Levep Up, Shift to Switch Actives",g);
        x = getScreenWidth() / 2 - (int)rectangle.getWidth() / 2;
        g.drawString("Press Enter To Levep Up, Shift to Switch Actives", x, y);

    }

    private void renderButtons(Graphics g) {
        titleFont = new Font("Serif", Font.BOLD, (int) (getScreenHeight() * .05));
        g.setFont(titleFont);
        FontMetrics fm = g.getFontMetrics();

        int x = (int) (getScreenWidth()*0.3/10);
        int y = getScreenHeight()*4/10;

        Color selectedColor = Color.RED;
        Color regularColor = Color.BLACK;
        g.setColor(regularColor);

        g.drawString("All Skills:", x, y);
        y += fm.getHeight();

        for(int i = 0; i < model.getListSize(); ++i){
            if (model.getCurrentPoint() == i ) {
                g.setColor(selectedColor);
            }
            else {
                g.setColor(regularColor);
            }
            g.drawString(model.getSkillString(i), x, y);
            y += fm.getHeight();
        }

        x = (int) (getScreenWidth()*0.6);
        y = getScreenHeight()*4/10;

        g.setColor(regularColor);
        g.drawString("Active Skills:", x, y);
        y += fm.getHeight();

        for(int i = 0; i < 4; ++i){
            if (model.getCurrentActive() == i ) {
                g.setColor(selectedColor);
            }
            else {
                g.setColor(regularColor);
            }
            g.drawString(model.getActiveSkill(i), x, y);
            y += fm.getHeight();
        }
    }
}
