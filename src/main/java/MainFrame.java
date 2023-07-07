import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * This class represents the main view where everything is connected to the user
 */
public class MainFrame extends JFrame {
    ArrayList<JButton> frameButtons = new ArrayList<>();
    JButton btnBack = new JButton();
    JPanel btnPanel = new JPanel();
    JPanel redPanel = new JPanel();

    /**
     * This is the constructor for the entire application
     * @param title the name of the window/application
     * @param warframeArrayList a list of all warframes available
     */
    public MainFrame(String title, ArrayList<Warframe> warframeArrayList) {
        int frameAmount = warframeArrayList.size();
        btnPanel.setBackground(Color.red);
        btnPanel.setBounds(10,10,530,530);
        GridLayout grid = new GridLayout();
        grid.setHgap(10);
        grid.setVgap(10);
        this.setBounds(10,10,565,   565);

        btnBack.setText("BACK");
        btnBack.addActionListener(e -> closeWindow());

        for (Warframe warframe : warframeArrayList) {
            JButton btn = new JButton();
            btn.setText(warframe.getName());
            btn.setFocusable(false);
            btn.setHorizontalAlignment(JButton.LEFT);
            btn.setHorizontalTextPosition(JButton.RIGHT);
            btn.addActionListener(e -> openWindow(warframe));
            frameButtons.add(btn);
        }

        this.setTitle(title);
        this.getContentPane().setBackground(new Color(0x123456));
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(btnPanel);
        this.add(redPanel);
        redPanel.add(btnBack);
        for(int i=0;i<frameAmount;i++) {
            btnPanel.add(frameButtons.get(i));
        }
    }

    private void openWindow(Warframe warframe) {
        btnPanel.setVisible(false);
        new WarframePanel(warframe).setVisible(true);
        this.dispose();
    }

    private void closeWindow() {
        btnPanel.setVisible(true);
        redPanel.setVisible(false);
    }
}
