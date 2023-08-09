import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * This class represents the panel shown after user clicks on a warframe AKA
 * inventory management
 */

public class WarframePanel extends JFrame {
    JPanel warframePan = new JPanel(new GridBagLayout());
    Warframe warframe;
    // BLUEPRINTS
    JLabel blueprintLabel = new JLabel("Blueprints: ");
    JButton addBPButton = new RoundedButton("+");
    JTextField bpTextField = new JTextField(2);
    JButton removeBPButton = new RoundedButton("-");
    // NEUROPTICS
    JLabel neuropticLabel = new JLabel("Neuroptics: ");
    JButton addNeuroButton = new RoundedButton("+");
    JTextField neuropticTextField = new JTextField(2);
    JButton removeNeuroButton = new RoundedButton("-");
    // CHASSIS
    JLabel chassisLabel = new JLabel("Chassis: ");
    JButton addChassisButton = new RoundedButton("+");
    JTextField chassisTextField = new JTextField(2);
    JButton removeChassisButton = new RoundedButton("-");
    // SYSTEMS
    JLabel systemLabel = new JLabel("Systems: ");
    JButton addSystemButton = new RoundedButton("+");
    JTextField systemTextField = new JTextField(2);
    JButton removeSystemButton = new RoundedButton("-");
    // TOTAL
    JLabel setsLabel = new JLabel("Sets: ");
    JButton addSetsButton = new RoundedButton("+");
    JTextField setsTextField = new JTextField(2);
    JButton removeSetsButton = new RoundedButton("-");
    JLabel setsMaxPrice = new JLabel();
    JLabel setsMinPrice = new JLabel();
    JLabel setsAvgPrice = new JLabel();

    JButton getPrices = new RoundedButton("Call Prices");

    JButton backButton = new RoundedButton("Back");

    /**
     * This is the constructor that adds all buttons and functions to them
     */
    public WarframePanel(Warframe warframe) {
        super();
        this.warframe = warframe;
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        warframePan.setBackground(new Color(53, 60, 69));
        UIManager.put("Button.background", new Color(126, 149, 180));
        warframePan.setBounds(10, 10, 530, 530);

        getPrices.addActionListener(e -> getWarframePrice());

        addBPButton.addActionListener(e -> addBlueprint());
        bpTextField.addActionListener(e -> changeBlueprint(bpTextField));
        removeBPButton.addActionListener(e -> removeBlueprint());

        addNeuroButton.addActionListener(e -> addNeuroptic());
        neuropticTextField.addActionListener(e -> changeNeuroptic(neuropticTextField));
        removeNeuroButton.addActionListener(e -> removeNeuroptic());

        addChassisButton.addActionListener(e -> addChassis());
        chassisTextField.addActionListener(e -> changeChassis(chassisTextField));
        removeChassisButton.addActionListener(e -> removeChassis());

        addSystemButton.addActionListener(e -> addSystem());
        systemTextField.addActionListener(e -> changeSystem(systemTextField));
        removeSystemButton.addActionListener(e -> removeSystem());

        addSetsButton.addActionListener(e -> addTotal(1));
        setsTextField.addActionListener(e -> changeTotal(setsTextField));
        removeSetsButton.addActionListener(e -> removeTotal(1));

        blueprintLabel.setForeground(Color.WHITE);
        neuropticLabel.setForeground(Color.WHITE);
        chassisLabel.setForeground(Color.WHITE);
        systemLabel.setForeground(Color.WHITE);
        setsLabel.setForeground(Color.WHITE);
        setsAvgPrice.setForeground(Color.white);
        setsMinPrice.setForeground(Color.white);
        setsMaxPrice.setForeground(Color.white);

        setsAvgPrice.setText("Avg: " + warframe.getSetAVG());
        setsMaxPrice.setText("Max: " + warframe.getSetMax());
        setsMinPrice.setText("Min: " + warframe.getSetMin());

        backButton.addActionListener(e -> backing());

        this.setBackground(Color.BLACK);
        this.setBounds(10, 10, 565, 565);
        this.add(warframePan);
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 1;
        gbc.gridy = 1;

        gbc.gridx = 5;
        gbc.gridy = 9;
        warframePan.add(getPrices, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        warframePan.add(blueprintLabel, gbc);
        gbc.gridx = 2;
        warframePan.add(removeBPButton, gbc);
        gbc.gridx = 3;
        warframePan.add(bpTextField, gbc);
        gbc.gridx = 4;
        warframePan.add(addBPButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        warframePan.add(neuropticLabel, gbc);
        gbc.gridx = 2;
        warframePan.add(removeNeuroButton, gbc);
        gbc.gridx = 3;
        warframePan.add(neuropticTextField, gbc);
        gbc.gridx = 4;
        warframePan.add(addNeuroButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        warframePan.add(chassisLabel, gbc);
        gbc.gridx = 2;
        warframePan.add(removeChassisButton, gbc);
        gbc.gridx = 3;
        warframePan.add(chassisTextField, gbc);
        gbc.gridx = 4;
        warframePan.add(addChassisButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        warframePan.add(systemLabel, gbc);
        gbc.gridx = 2;
        warframePan.add(removeSystemButton, gbc);
        gbc.gridx = 3;
        warframePan.add(systemTextField, gbc);
        gbc.gridx = 4;
        warframePan.add(addSystemButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        warframePan.add(setsLabel, gbc);
        gbc.gridx = 2;
        warframePan.add(removeSetsButton, gbc);
        gbc.gridx = 3;
        warframePan.add(setsTextField, gbc);
        gbc.gridx = 4;
        warframePan.add(addSetsButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        warframePan.add(setsMaxPrice, gbc);
        gbc.gridy = 7;
        warframePan.add(setsMinPrice, gbc);
        gbc.gridy = 8;
        warframePan.add(setsAvgPrice, gbc);
        gbc.gridx = 0;
        gbc.gridy = 0;
        warframePan.add(backButton, gbc);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new JSONHandler().writeToJSON();
                System.exit(0);
            }
        });
    }

    /**
     * This function collects all the prices for this specified warframe
     */
    private void getWarframePrice() {
        Data data = new Data();
        data.getWarframeSetPrices(warframe);
        setsMaxPrice.setText("Max: " + warframe.getSetMax());
        setsMinPrice.setText("Min: " + warframe.getSetMin());
        setsAvgPrice.setText("Avg: " + warframe.getSetAVG());
    }

    /**
     * This function updates all values seen on screen
     */
    private void updatePanel() {
        neuropticTextField.setText(String.valueOf(warframe.getNeuroptics()));
        chassisTextField.setText(String.valueOf(warframe.getChassis()));
        systemTextField.setText(String.valueOf(warframe.getSystem()));
        setsTextField.setText(String.valueOf(warframe.getTotal()));
        bpTextField.setText(String.valueOf(warframe.getBlueprint()));
    }

    /**
     * This function allows the addition of 1 blueprint
     */
    public void addBlueprint() {
        warframe.setBlueprint(warframe.getBlueprint() + 1);
        updatePanel();
    }

    /**
     * This function allows the removal of 1 blueprint
     */
    private void removeBlueprint() {
        warframe.setBlueprint(warframe.getBlueprint() - 1);
        updatePanel();
    }

    /**
     * This function allows the addition of 1 neuroptic
     */
    private void addNeuroptic() {
        warframe.setNeuroptics(warframe.getNeuroptics() + 1);
        updatePanel();
    }

    /**
     * This function allows the removal of 1 neuroptic
     */
    private void removeNeuroptic() {
        warframe.setNeuroptics(warframe.getNeuroptics() - 1);
        updatePanel();
        updatePanel();
    }

    /**
     * This function allows the addition of 1 chassis
     */
    private void addChassis() {
        warframe.setChassis(warframe.getChassis() + 1);
        updatePanel();
    }

    /**
     * This function allows the removal of 1 chassis
     */
    private void removeChassis() {
        warframe.setChassis(warframe.getChassis() - 1);
        updatePanel();
    }

    /**
     * This function allows the addition of 1 system
     */
    private void addSystem() {
        warframe.setSystems(warframe.getSystem() + 1);
        updatePanel();
    }

    /**
     * This function allows the removal of 1 system
     */
    private void removeSystem() {
        warframe.setSystems(warframe.getSystem() - 1);
        updatePanel();
    }

    /**
     * This function adds +1 to everything
     */
    private void addTotal(int add) {
        warframe.setBlueprint(warframe.getBlueprint() + add);
        warframe.setSystems(warframe.getSystem() + add);
        warframe.setChassis(warframe.getChassis() + add);
        warframe.setNeuroptics(warframe.getNeuroptics() + add);
        updatePanel();
    }

    /**
     * This function subtracts -1 to everything
     */
    private void removeTotal(int subtract) {
        warframe.setBlueprint(warframe.getBlueprint() - subtract);
        warframe.setSystems(warframe.getSystem() - subtract);
        warframe.setChassis(warframe.getChassis() - subtract);
        warframe.setNeuroptics(warframe.getNeuroptics() - subtract);
        updatePanel();
    }

    /**
     * This function allows the change of the entire blueprint amount
     * 
     * @param input the new amount of blueprints
     */
    private void changeBlueprint(JTextField input) {
        warframe.setBlueprint(Integer.parseInt(input.getText()));
        updatePanel();
    }

    /**
     * This function allows the change of the entire neuroptics amount
     * 
     * @param input the new amount of neuroptics
     */
    private void changeNeuroptic(JTextField input) {
        warframe.setNeuroptics(Integer.parseInt(input.getText()));
        updatePanel();
    }

    /**
     * This function allows the change of the entire systems amount
     * 
     * @param input the new amount of systems
     */
    private void changeSystem(JTextField input) {
        warframe.setSystems(Integer.parseInt(input.getText()));
        updatePanel();
    }

    /**
     * This function allows the change of the entire chassis amount
     * 
     * @param input the new amount of chassis
     */
    private void changeChassis(JTextField input) {
        warframe.setChassis(Integer.parseInt(input.getText()));
        updatePanel();
    }

    /**
     * This function allows the change of the entire total amount
     * 
     * @param input the new amount of all components
     */
    private void changeTotal(JTextField input) {
        int oldSets = warframe.getTotal();
        if (oldSets > Integer.parseInt(input.getText())) {
            removeTotal(oldSets - Integer.parseInt(input.getText()));
        } else {
            addTotal(Integer.parseInt(input.getText()) - oldSets);
        }
        updatePanel();
    }

    /**
     * This function allows the user to go back to the warframe selection
     */
    private void backing() {
        new JSONHandler().writeToJSON();
        new MainFrame("Warframe Plat").setVisible(true);
        this.dispose();
    }
}
