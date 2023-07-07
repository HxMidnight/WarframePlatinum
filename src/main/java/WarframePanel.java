import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * This class represents the panel shown after user clicks on a warframe
 */
public class WarframePanel extends JFrame {
    JPanel warframePan = new JPanel();
    Warframe warframe;
    //BLUEPRINTS
    JLabel blueprintLabel = new JLabel("Blueprints: ");
    JButton addBPButton = new JButton("+");
    JTextField bpTextField = new JTextField(2);
    JButton removeBPButton = new JButton("-");
    JLabel blueprintPrice = new JLabel();
    //NEUROPTICS
    JLabel neuropticLabel = new JLabel("Neuroptics: ");
    JButton addNeuroButton = new JButton("+");
    JTextField neuropticTextField = new JTextField(2);
    JButton removeNeuroButton = new JButton("-");
    JLabel neuroPrice = new JLabel();
    //CHASSIS
    JLabel chassisLabel = new JLabel("Chassis: ");
    JButton addChassisButton = new JButton("+");
    JTextField chassisTextField = new JTextField(2);
    JButton removeChassisButton = new JButton("-");
    JLabel chassisPrice = new JLabel();
    //SYSTEMS
    JLabel systemLabel = new JLabel("Systems: ");
    JButton addSystemButton = new JButton("+");
    JTextField systemTextField = new JTextField(2);
    JButton removeSystemButton = new JButton("-");
    JLabel systemPrice = new JLabel();
    //TOTAL
    JLabel setsLabel = new JLabel("Sets: ");
    JButton addSetsButton = new JButton("+");
    JTextField setsTextField = new JTextField(2);
    JButton removeSetsButton = new JButton("-");
    JLabel setsPrice = new JLabel();

    JButton getPrices = new JButton("Call Prices");

    JButton backButton = new JButton("Back");


    /**
     * This is the constructor that adds all buttons and functions to them
     */
    public WarframePanel(Warframe warframe) {
        super();
        this.warframe = warframe;
        updatePanel();
        warframePan.setBackground(Color.black);
        warframePan.setBounds(10,10,530,530);
        GridLayout grid = new GridLayout();
        grid.setHgap(10);
        grid.setVgap(10);

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

        backButton.addActionListener(e -> backing());


        this.setBackground(Color.BLACK);
        this.setBounds(10,10,565,   565);
        this.add(warframePan);
        warframePan.add(blueprintLabel);
        warframePan.add(addBPButton);
        warframePan.add(bpTextField);
        warframePan.add(removeBPButton);

        warframePan.add(neuropticLabel);
        warframePan.add(addNeuroButton);
        warframePan.add(neuropticTextField);
        warframePan.add(removeNeuroButton);

        warframePan.add(chassisLabel);
        warframePan.add(addChassisButton);
        warframePan.add(chassisTextField);
        warframePan.add(removeChassisButton);

        warframePan.add(systemLabel);
        warframePan.add(addSystemButton);
        warframePan.add(systemTextField);
        warframePan.add(removeSystemButton);

        warframePan.add(setsLabel);
        warframePan.add(addSetsButton);
        warframePan.add(setsTextField);
        warframePan.add(removeSetsButton);
        warframePan.add(setsPrice);
        warframePan.add(backButton);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new JSONHandler().writeToJSON(warframe);
                System.exit(0);
            }
        });
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
        setsPrice.setText(String.valueOf(warframe.getSetMax()));
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
        warframe.setSystems(warframe.getSystem()+1);
        updatePanel();
    }

    private void removeSystem() {
        warframe.setSystems(warframe.getSystem()+1);
        updatePanel();
    }

    /**
     * This function adds +1 to everything
     */
    private void addTotal(int add) {
        warframe.setBlueprint(warframe.getBlueprint()+add);
        warframe.setSystems(warframe.getSystem()+add);
        warframe.setChassis(warframe.getChassis()+add);
        warframe.setNeuroptics(warframe.getNeuroptics()+add);
        updatePanel();
    }

    /**
     * This function subtracts -1 to everything
     */
    private void removeTotal(int subtract) {
        warframe.setBlueprint(warframe.getBlueprint()-subtract);
        warframe.setSystems(warframe.getSystem()-subtract);
        warframe.setChassis(warframe.getChassis()-subtract);
        warframe.setNeuroptics(warframe.getNeuroptics()-subtract);
        updatePanel();
    }

    private void changeBlueprint(JTextField input) {
        warframe.setBlueprint(Integer.parseInt(input.getText()));
        updatePanel();
    }

    private void changeNeuroptic(JTextField input) {
        warframe.setNeuroptics(Integer.parseInt(input.getText()));
        updatePanel();
    }

    private void changeSystem(JTextField input) {
        warframe.setSystems(Integer.parseInt(input.getText()));
        updatePanel();
    }
    private void changeChassis(JTextField input) {
        warframe.setChassis(Integer.parseInt(input.getText()));
        updatePanel();
    }

    private void changeTotal(JTextField input) {
        int oldSets = warframe.getTotal();
        if(oldSets > Integer.parseInt(input.getText())) {
            removeTotal(oldSets-Integer.parseInt(input.getText()));
        } else {
            addTotal(Integer.parseInt(input.getText())-oldSets);
        }
        updatePanel();
    }

    private void backing() {
        new JSONHandler().writeToJSON(warframe);
        new MainFrame("Warframe Plat", Main.warframeArrayList).setVisible(true);
        this.dispose();
    }
}
