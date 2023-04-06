import javax.swing.*;
import java.awt.*;

/**
 * This class represents the panel shown after user clicks on a warframe
 */
public class WarframePanel extends Panel {
    Warframe warframe = new Warframe("name prime");
    //BLUEPRINTS
    JLabel blueprintLabel = new JLabel("Blueprints: ");
    JButton addBPButton = new JButton("+");
    JTextField bpTextField = new JTextField(2);
    JButton removeBPButton = new JButton("-");
    //NEUROPTICS
    JLabel neuropticLabel = new JLabel("Neuroptics: ");
    JButton addNeuroButton = new JButton("+");
    JTextField neuropticTextField = new JTextField(2);
    JButton removeNeuroButton = new JButton("-");
    //CHASSIS
    JLabel chassisLabel = new JLabel("Chassis: ");
    JButton addChassisButton = new JButton("+");
    JTextField chassisTextField = new JTextField(2);
    JButton removeChassisButton = new JButton("-");
    //SYSTEMS
    JLabel systemLabel = new JLabel("Systems: ");
    JButton addSystemButton = new JButton("+");
    JTextField systemTextField = new JTextField(2);
    JButton removeSystemButton = new JButton("-");
    //TOTAL
    JLabel setsLabel = new JLabel("Sets: ");
    JButton addSetsButton = new JButton("+");
    JTextField setsTextField = new JTextField(2);
    JButton removeSetsButton = new JButton("-");


    /**
     * This is the constructor that adds all buttons and functions to them
     */
    public WarframePanel() {
        super();
        updatePanel();
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


        this.setBackground(Color.BLACK);
        this.setBounds(10,10,530,   530);
        this.add(blueprintLabel);
        this.add(addBPButton);
        this.add(bpTextField);
        this.add(removeBPButton);

        this.add(neuropticLabel);
        this.add(addNeuroButton);
        this.add(neuropticTextField);
        this.add(removeNeuroButton);

        this.add(chassisLabel);
        this.add(addChassisButton);
        this.add(chassisTextField);
        this.add(removeChassisButton);

        this.add(systemLabel);
        this.add(addSystemButton);
        this.add(systemTextField);
        this.add(removeSystemButton);

        this.add(setsLabel);
        this.add(addSetsButton);
        this.add(setsTextField);
        this.add(removeSetsButton);
    }

    public void showPanel(Warframe warframe) {
        this.warframe = warframe;
        System.out.println("new frame");
        updatePanel();
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

    public void addBlueprint() {
        warframe.setBlueprint(warframe.getBlueprint()+1);
        updatePanel();
    }

    private void removeBlueprint() {
        warframe.setBlueprint(warframe.getBlueprint()-1);
        updatePanel();
    }

    private void addNeuroptic() {
        warframe.setNeuroptics(warframe.getNeuroptics()+1);
        updatePanel();
    }

    private void removeNeuroptic() {
        warframe.setNeuroptics(warframe.getNeuroptics()-1);
        updatePanel();updatePanel();
    }

    private void addChassis() {
        warframe.setChassis(warframe.getChassis()+1);
        updatePanel();
    }

    private void removeChassis() {
        warframe.setChassis(warframe.getChassis()-1);
        updatePanel();
    }

    private void addSystem() {
        warframe.setSystem(warframe.getSystem()+1);
        updatePanel();
    }

    private void removeSystem() {
        warframe.setSystem(warframe.getSystem()+1);
        updatePanel();
    }

    /**
     * This function adds +1 to everything
     */
    private void addTotal(int add) {
        warframe.setBlueprint(warframe.getBlueprint()+add);
        warframe.setSystem(warframe.getSystem()+add);
        warframe.setChassis(warframe.getChassis()+add);
        warframe.setNeuroptics(warframe.getNeuroptics()+add);
        updatePanel();
    }

    /**
     * This function subtracts -1 to everything
     */
    private void removeTotal(int subtract) {
        warframe.setBlueprint(warframe.getBlueprint()-subtract);
        warframe.setSystem(warframe.getSystem()-subtract);
        warframe.setChassis(warframe.getChassis()-subtract);
        warframe.setNeuroptics(warframe.getNeuroptics()-subtract);
        updatePanel();
    }

    private void changeBlueprint(JTextField input) {
        warframe.setBlueprint(Integer.valueOf(input.getText()));
        updatePanel();
    }

    private void changeNeuroptic(JTextField input) {
        warframe.setNeuroptics(Integer.valueOf(input.getText()));
        updatePanel();
    }

    private void changeSystem(JTextField input) {
        warframe.setSystem(Integer.valueOf(input.getText()));
        updatePanel();
    }
    private void changeChassis(JTextField input) {
        warframe.setChassis(Integer.valueOf(input.getText()));
        updatePanel();
    }

    private void changeTotal(JTextField input) {
        int oldSets = warframe.getTotal();
        if(oldSets > Integer.valueOf(input.getText())) {
            removeTotal(oldSets-Integer.valueOf(input.getText()));
        } else {
            addTotal(Integer.valueOf(input.getText())-oldSets);
        }
        updatePanel();
    }
}
