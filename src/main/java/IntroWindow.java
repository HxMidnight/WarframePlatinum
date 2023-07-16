import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class IntroWindow extends JFrame {
    JPanel introPane = new JPanel();
    JPanel qstPane = new JPanel();
    JButton btnAccept = new JButton("Yes");

    JButton btnDeny = new JButton("No");

    JLabel lblQuestion = new JLabel("Do you want to update warframes?");
    public IntroWindow (String title){
        lblQuestion.setForeground(Color.white);
        qstPane.setBackground(Color.red);
        qstPane.setBounds(10,10,100,1000);

        introPane.setBackground(Color.black);
        introPane.setBounds(10,10,250,250);
        GridLayout grid = new GridLayout(0,1);
        this.setTitle(title);
        this.setBackground(Color.BLACK);
        this.setBounds(10,10,530,530);
        btnAccept.addActionListener(e -> ConnectToAPI());
        btnDeny.addActionListener(e -> ConnectToJSON());

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(grid);
        this.add(qstPane);
        this.add(introPane);
        qstPane.add(lblQuestion);
        introPane.add(btnDeny);
        introPane.add(btnAccept);

    }

    public void ConnectToAPI() {
        Data data = new Data();
        Main.warframeArrayList = data.getWarframeData();
        new MainFrame("Warframe Plat");
        this.dispose();
    }

    public void ConnectToJSON() {
        JSONHandler json = new JSONHandler();
        Main.warframeArrayList = json.readJSON();
        new MainFrame("Warframe Plat");
        this.dispose();
    }
}
