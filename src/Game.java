import javax.swing.*;

public class Game{

    public static void main(String[] args){
        final int N = 30;
        JFrame frame = new JFrame();
        frame.setSize(500,500);
        MainPanel mainPanel = new MainPanel(N);
        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

