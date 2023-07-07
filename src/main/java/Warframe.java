import org.json.simple.JSONObject;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.lang.Math.min;

/**
 * This class represents a warframe, it contains name, amount of blueprint, chassis, neuroptics, system, total sets and codename used in API
 */
public class Warframe {
    private String name;
    private int blueprint;
    private int chassis;
    private int neuroptics;
    private int systems;
    private int total;
    private String codeName;

    //rows are the different components while columns are the prices for the component min/avg/max
    private double[][] prices = new double[3][5];

    /**
     * This is the constructor of a warframe with given name
     * @param name the name of the warframe
     */
    public Warframe(String name) {
        this.name = name;
        blueprint = 0;
        chassis = 0;
        neuroptics = 0;
        systems = 0;
        createCodeName();
        calcTotal();
    }

    public String getName() {
        return name;
    }

    public void setBlueprint(int blueprint) {
        if(blueprint < 0) {
            return;
        }
        this.blueprint = blueprint;
    }

    public int getBlueprint() {
        return blueprint;
    }

    public void setChassis(int chassis) {
        if(chassis < 0) {
            return;
        }
        this.chassis = chassis;
    }

    public int getChassis() {
        return chassis;
    }

    public void setNeuroptics(int neuroptics) {
        if(neuroptics < 0) {
            return;
        }
        this.neuroptics = neuroptics;
    }

    public int getNeuroptics() {
        return neuroptics;
    }

    public void setSystems(int system) {
        if(systems < 0){
            return;
        }
        this.systems = system;
    }

    public int getSystem() {
        return systems;
    }

    /**
     * This function calculates how many sets can be made
     */
    private void calcTotal() {
        total = Math.min(Math.min(blueprint, chassis), Math.min(neuroptics,systems));
    }

    public int getTotal() {
        calcTotal();
        return total;
    }

    /**
     * This function changes the name to the code name version used in warframe.market API
     */
    private void createCodeName() {
        String[] seperatedName = name.split(" ");
        codeName = seperatedName[0].toLowerCase() + "_" + seperatedName[1].toLowerCase() + "_set";
    }

    public String getCodeName() {
        return codeName;
    }

    public void setSetPrices(double max, double avg, double min) {
        prices[0][4] = min;
        prices[1][4] = avg;
        prices[2][4] = max;
    }

    public void setSystemPrices() {

    }

    public void setChassisPrices() {

    }

    public void setNeuropticPrices() {

    }

    public void setBlueprintPrices() {

    }
    public double getSetAVG() {
        return prices[1][4];
    }

    public double getSetMax() {
        return prices[0][4];
    }

    public void copyFrame(Warframe warframe) {
        this.name = warframe.getName();
        this.neuroptics = warframe.getNeuroptics();
        this.systems = warframe.getSystem();
        this.chassis = warframe.getChassis();
        this.blueprint = warframe.getBlueprint();
    }
}
