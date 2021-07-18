import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class MainPanel extends JPanel {
    private final int SIZE =10;

    private ArrayList<Sqr> sqrs = new ArrayList<>();
    private int numSquares;
    private gamePanel gameP = new gamePanel();
    private JButton goBtn;
    private MouseListener mLis = new MouseListener();
    private ButtonListener btLis = new ButtonListener();
    private long startTime;
    private boolean go;


    public MainPanel(int n){
        go = false;
        numSquares = n;
        setLayout(new BorderLayout());
        gameP.addMouseListener(mLis);
        add(gameP);

        goBtn = new JButton("GO");
        goBtn.addActionListener(btLis);
        add(goBtn, BorderLayout.SOUTH);
    }

    private class gamePanel extends JPanel{
        public void paintComponent(Graphics g){
            super.paintComponent(g); //clear the screen);
            g.setColor(Color.BLACK);
            if (go == true && sqrs.size() == 0){
                long milisCount = System.currentTimeMillis() - startTime ;
                JOptionPane.showMessageDialog(null, " You are done in " + milisCount + " milis. Press  GO to play again");
            }
            else{

                for(int i=0 ;  i < sqrs.size() ; i++) {
                    int x = sqrs.get(i).getX();
                    int y = sqrs.get(i).getY();
                    g.fillRect(x, y, SIZE, SIZE);
                    System.out.println("square " + i + "  " + x + "  "+ y);
                }
            }
        }


    }


    private class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e){
            go = true;
            System.out.println("go pressed");
            for(int i=0 ;  i < numSquares ; i++)
                sqrs.add(new Sqr(SIZE));
            startTime = System.currentTimeMillis();
            gameP.repaint();
        }

    }


    private class MouseListener extends MouseAdapter {

        public void mousePressed(MouseEvent e){
            int x = e.getX();
            int y = e.getY();
            if (sqrs.size() == 0)
                repaint();
            else {
                Iterator<Sqr> iter = sqrs.iterator();
                while (iter.hasNext()) {
                    Sqr current = (Sqr) iter.next();
                    if (current.inRange(x, y, SIZE)) {
                        iter.remove();
                        repaint();
                        System.out.println("sqr removed");
                    }
                }
            }

        }
    }
}


