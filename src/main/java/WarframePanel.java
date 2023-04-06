import javax.swing.*;
import java.awt.*;

/**
 * This class represents the panel shown after user clicks on a warframe
 */
public class WarframePanel extends Panel {
    Warframe warframe = new Warframe("name prime");
    JButton addBP = new JButton();
    JButton removeBP = new JButton();
    JButton addNeuro = new JButton();
    JButton removeNeuro = new JButton();
    JButton addChassis = new JButton();
    JButton removeChassis = new JButton();
    JButton addSystem = new JButton();
    JButton removeSystem = new JButton();
    JButton addTotal = new JButton();
    JButton removeTotal = new JButton();

    /**
     * This is the constructor that adds all buttons and functions to them
     */
    public WarframePanel() {
        super();
        updatePanel();
        addBP.addActionListener(e -> addBlueprint());
        removeBP.addActionListener(e -> removeBlueprint());
        addNeuro.addActionListener(e -> addNeuroptic());
        removeNeuro.addActionListener(e -> removeNeuroptic());
        addChassis.addActionListener(e -> addChassis());
        removeChassis.addActionListener(e -> removeChassis());
        addSystem.addActionListener(e -> addSystem());
        removeSystem.addActionListener(e -> removeSystem());
        addTotal.addActionListener(e -> addTotal());
        removeTotal.addActionListener(e -> removeTotal());

        this.setBackground(Color.BLACK);
        this.setBounds(10,10,530,   530);
        this.add(addBP);
        this.add(removeBP);
        this.add(addNeuro);
        this.add(removeNeuro);
        this.add(addChassis);
        this.add(removeChassis);
        this.add(addSystem);
        this.add(removeSystem);
        this.add(addTotal);
        this.add(removeTotal);
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
        addBP.setText(String.valueOf(warframe.getBlueprint()));
        addNeuro.setText(String.valueOf(warframe.getNeuroptics()));
        addChassis.setText(String.valueOf(warframe.getChassis()));
        addSystem.setText(String.valueOf(warframe.getSystem()));
        addTotal.setText(String.valueOf(warframe.getTotal()));
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
    private void addTotal() {
        warframe.setBlueprint(warframe.getBlueprint()+1);
        warframe.setSystem(warframe.getSystem()+1);
        warframe.setChassis(warframe.getBlueprint()+1);
        warframe.setNeuroptics(warframe.getNeuroptics()+1);
        updatePanel();
    }

    /**
     * This function subtracts -1 to everything
     */
    private void removeTotal() {
        warframe.setBlueprint(warframe.getBlueprint()-1);
        warframe.setSystem(warframe.getSystem()-1);
        warframe.setChassis(warframe.getBlueprint()-1);
        warframe.setNeuroptics(warframe.getNeuroptics()-1);
        updatePanel();
    }
}
