package views;

import controllers.Controller;
import controllers.StatsViewController;
import controllers.StatusViewController;
import models.Entity.Entity;
import models.StateModel.MainMenuModel;
import models.StateModel.SkillTreeModel;
import models.StateModel.StatsModel;
import views.View;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.PackedColorModel;

public class StatusView {

    // Styling properties
    private Font titleFont;
    private int width;
    private int height;


    private StatusViewController statusViewController;

    public StatusView(Entity entity) {
        statusViewController = new StatusViewController(entity);
    }


    protected void render(int width,int height, Graphics g) {
        this.width = width;
        this.height = (int) (height * .1);
        renderBackground(g);

        titleFont = new Font("Serif", Font.BOLD, (int) (this.height * .4));
        g.setFont(titleFont);
        FontMetrics fm = g.getFontMetrics();

        String statsString = statusViewController.getStatsString();
        Rectangle2D rectangle = fm.getStringBounds(statsString,g);
        int x = this.width / 2 - (int)rectangle.getWidth() / 2;
        int y = (int)rectangle.getHeight();

        g.setColor(Color.BLACK);
        g.drawString(statsString, x, y);

        titleFont = new Font("Serif", Font.BOLD, (int) (this.height * .3));
        g.setFont(titleFont);
        fm = g.getFontMetrics();

        String skillsString = statusViewController.getSkillsString();
        Rectangle2D rectangle2 = fm.getStringBounds(skillsString,g);
        x = this.width / 2 - (int)rectangle2.getWidth() / 2;
        y = (int)rectangle2.getHeight() + (int) (y * .9);

        g.setColor(Color.BLACK);
        g.drawString(skillsString, x, y);
    }

    private void renderBackground(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, width,height);
    }

    public void updateStatsSkill() {
        statusViewController.updateVariables();
    }
}
