package views;

import models.StateModel.InventoryViewModel;
import models.StateModel.PlayStateModel;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 * Implemented by Peter Camejo
 */
public class InventoryView extends View{
    private final String TITLE = "Inventory";

    private Font titleFont;

    private InventoryViewModel model;

    public InventoryView(int width, int height, Canvas canvas, InventoryViewModel model){
        super(width,height, canvas);
        this.model = model;
    }

    @Override
    protected void render(Graphics g) {
        BufferedImage image = new BufferedImage(getScreenWidth(),getScreenHeight(), BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D g2 = image.createGraphics();

        renderTitle(g2);
        renderSlots(g2);

        g.drawImage(image,(int)(getScreenWidth()*0.2),(int)( getScreenHeight()*0.2),(int)( getScreenWidth()*0.6),(int)( getScreenHeight()*0.6),null);

    }

    private void renderTitle(Graphics g) {
        titleFont = new Font("Serif", Font.BOLD, (int) (getScreenHeight() * .1));
        g.setFont(titleFont);
        FontMetrics fm = g.getFontMetrics();

        Rectangle2D rectangle = fm.getStringBounds(TITLE,g);


        int x = getScreenWidth() / 2 - (int)rectangle.getWidth() / 2;
        int y = (int)rectangle.getHeight();

        g.setColor(Color.WHITE);
        g.drawString(TITLE, x, y);
    }

    private void renderSlots(Graphics g){
        titleFont = new Font("Serif", Font.BOLD, (int) (getScreenHeight() * .05));
        g.setFont(titleFont);
        FontMetrics fm = g.getFontMetrics();

        Color selectedColor = Color.YELLOW;
        Color regularColor = Color.WHITE;
        g.setColor(regularColor);



        int Xinc = (int)(getScreenWidth()*0.16);
        int Yinc = (int)(getScreenHeight()*0.18);

        int blockW = (int)(getScreenWidth()*0.14);
        int blockH = (int)(getScreenHeight()*0.16);

        int size = model.getInventorySize();

        int xStart = (int)(getScreenWidth()*0.1);
        int yStart = (int)(getScreenHeight()*0.2);

        int xpos = xStart;
        int ypos = yStart;

        for(int  i = 0 ; i < size ; i++) {

            if (model.getCurrentIndex() == i) {
                g.setColor(selectedColor);
                g.fillRect(xpos, ypos, blockW, blockH);
            } else {
                g.setColor(regularColor);
                g.fillRect(xpos, ypos, blockW, blockH);
            }

            BufferedImage image = model.getItemImageAt(i);

            if (image != null) {
                g.drawImage(model.getItemImageAt(i), xpos, ypos, blockW, blockH, null);
            }
            xpos += Xinc;
            if(i%5 == 4){
                xpos = xStart;
                ypos += Yinc
                ;
            }
        }
    }

}
