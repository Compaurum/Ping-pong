/**
 * Created by compaurum on 11.09.2015.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;

public class PingPongGreenTable extends JPanel implements GameConstants {
    JLabel label;
    public Point point = new Point(0, 0);

    private int ComputerRacketX = 15;
    private int kidRacketY = KID_RACKET_Y_START;

    Dimension preferredSize = new Dimension(TABLE_WIDTH, TABLE_HEIGHT);

    public Dimension getPreferredSize() {
        return preferredSize;
    }

    PingPongGreenTable() {
        PingPongGameEngine gameEngine = new PingPongGameEngine(this);

        addMouseListener(gameEngine);
        addMouseMotionListener(gameEngine);
    }

    void addPaneltoFrame(Container container) {
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.add(this);

        label = new JLabel("Click to see coordinates");
        container.add(label);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.GREEN);

        g.fillRect(0,0,TABLE_WIDTH, TABLE_HEIGHT);

        g.setColor(Color.YELLOW);
        g.fillRect(KID_RACKET_X_START, kidRacketY, 5, 30);

        g.setColor(Color.BLUE);
        g.fillRect(ComputerRacketX, 100, 5, 30);

        g.setColor(Color.RED);
        g.fillOval(25, 110, 10, 10);

        g.setColor(Color.WHITE);
        g.drawRect(10,10,300,200);
        g.drawLine(160, 10, 160, 210);

        if(point != null) {
            label.setText("Coordinates (x,y): " +
                    point.x+", "+ point.y);
            g.fillRect(point.x, point.y, 2, 2);
        }
    }

    //Set the current position of kid's racket
    public void setKidRacketY(int xCoordinate){
        this.kidRacketY = xCoordinate;
    }

    public int getKidRacketY(int xCoordinate){
        return kidRacketY;
    }

    public static void main(String [] args){
        JFrame f = new JFrame("Ping Pong Green Table");

        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        PingPongGreenTable table = new PingPongGreenTable();
        table.addPaneltoFrame(f.getContentPane());

        f.pack();
        f.setVisible(true);
    }

}
