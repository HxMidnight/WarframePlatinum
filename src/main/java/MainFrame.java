import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * This class represents the main view where everything is connected to the user
 */
public class MainFrame extends JFrame {
    ArrayList<JButton> frameButtons = new ArrayList<>();
    JButton btnBack = new RoundedButton("");
    JPanel btnPanel = new JPanel(new GridBagLayout());
    JPanel redPanel = new JPanel();

    /**
     * This is the constructor for the entire application
     * 
     * @param title the name of the window/application
     */
    public MainFrame(String title) {
        int ycoords = 0;
        int xcoords = 0;

        int frameAmount = Main.warframeArrayList.size();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        btnPanel.setBackground(new Color(53, 60, 69));
        btnPanel.setBounds(10, 10, 530, 530);
        this.setBounds(10, 10, 565, 565);

        btnBack.setText("All Prices");
        btnBack.addActionListener(e -> GetPrices());

        for (Warframe warframe : Main.warframeArrayList) {
            JButton btn = new RoundedButton(warframe.getName());
            btn.setFocusable(false);
            btn.setHorizontalAlignment(JButton.LEFT);
            btn.setHorizontalTextPosition(JButton.RIGHT);
            btn.addActionListener(e -> openWindow(warframe));
            gbc.gridx = xcoords;
            gbc.gridy = ycoords;
            frameButtons.add(btn);
            ycoords++;
            if (ycoords > 5) {
                ycoords = 0;
                xcoords++;
            }
        }

        this.setTitle(title);
        this.getContentPane().setBackground(new Color(0x123456));
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(btnPanel);
        this.add(redPanel);
        btnPanel.add(btnBack);
        for (int i = 0; i < frameAmount; i++) {
            btnPanel.add(frameButtons.get(i));
        }
    }

    /**
     * This function allows the opening of the inventory of specified warframe
     * 
     * @param warframe the frame the user wants to look at the components of
     */
    private void openWindow(Warframe warframe) {
        btnPanel.setVisible(false);
        new WarframePanel(warframe).setVisible(true);
        this.dispose();
    }

    /**
     * This function allows the gathering of all prices for all frames
     */
    private void GetPrices() {
        Data data = new Data();
        for (Warframe warframe : Main.warframeArrayList) {
            data.getWarframeSetPrices(warframe);
        }
    }
}
