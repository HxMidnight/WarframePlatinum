import static java.lang.Math.min;

/**
 * This class represents a warframe, it contains name, amount of blueprint, chassis, neuroptics, system, total sets and codename used in API
 */
public class Warframe {
    private String name;
    private int blueprint;
    private int chassis;
    private int neuroptics;
    private int system;
    private int total;
    private String codeName;

    /**
     * This is the constructor of a warframe with given name
     * @param name the name of the warframe
     */
    public Warframe(String name) {
        this.name = name;
        blueprint = 0;
        chassis = 0;
        neuroptics = 0;
        system = 0;
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

    public void setSystem(int system) {
        if(system < 0){
            return;
        }
        this.system = system;
    }

    public int getSystem() {
        return system;
    }

    /**
     * This function calculates how many sets can be made
     */
    private void calcTotal() {
        total = Math.min(Math.min(blueprint, chassis), Math.min(neuroptics,system));
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
}
