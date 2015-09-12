import java.awt.event.*;

/**
 * Created by compaurum on 11.09.2015.
 */
public class PingPongGameEngine implements MouseListener, MouseMotionListener, GameConstants{

    PingPongGreenTable table;
    public int kidRacketY = KID_RACKET_Y_START;

    public PingPongGameEngine(PingPongGreenTable greenTable){
        this.table = greenTable;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        table.point.x = e.getX();
        table.point.y = e.getY();
        table.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int mouseY = e.getY();

        if (mouseY < kidRacketY && kidRacketY > TABLE_TOP){
            kidRacketY -= RACKET_INCREMENT;
        }else if (kidRacketY < TABLE_BOTTOM){
            kidRacketY += RACKET_INCREMENT;
        }
        table.setKidRacketY(kidRacketY);
        table.repaint();

    }
}
