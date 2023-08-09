import javax.swing.*;
import java.awt.*;

/**
 * This class represents the first window seen by the user after JSON file has
 * been created
 */
public class IntroWindow extends JFrame {
    JPanel introPane = new JPanel();
    JPanel qstPane = new JPanel();
    JButton btnAccept = new RoundedButton("Yes");

    JButton btnDeny = new RoundedButton("No");

    JLabel lblQuestion = new JLabel("Do you want to update warframes?");

    /**
     * This function constructs and shows the window for the user to choose to
     * connect to API or JSON
     * 
     * @param title the title of the window
     */
    public IntroWindow(String title) {
        lblQuestion.setForeground(Color.white);
        qstPane.setBackground(Color.red);
        qstPane.setBounds(10, 10, 100, 1000);

        introPane.setBackground(Color.black);
        introPane.setBounds(10, 10, 250, 250);
        GridLayout grid = new GridLayout(0, 1);
        this.setTitle(title);
        this.setBackground(Color.BLACK);
        this.setBounds(10, 10, 530, 530);
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

    /**
     * This function allows the connection to the API to update frames
     */
    public void ConnectToAPI() {
        Data data = new Data();
        Main.warframeArrayList = data.getWarframeData();
        new MainFrame("Warframe Plat");
        this.dispose();
    }

    /**
     * This function allows the connection to the JSON file to update frames
     */
    public void ConnectToJSON() {
        JSONHandler json = new JSONHandler();
        Main.warframeArrayList = json.readJSON();
        new MainFrame("Warframe Plat");
        this.dispose();
    }
}
