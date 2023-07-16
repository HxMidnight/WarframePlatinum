
/**
 * This class represents a warframe, it contains name, amount of blueprint, chassis, neuroptics, system, total sets and codename used in API
 */
public class Warframe {
    private final String name;
    private int blueprint;
    private int chassis;
    private int neuroptics;
    private int systems;
    private int total;
    private String codeName;

    private double max;
    private double min;
    private double avg;

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

    /**
     * This is the constructor of a warframe with given name and number of components
     * @param name the name of the warframe
     * @param blueprint how many blueprints there are
     * @param chassis how many chassis there are
     * @param neuroptics how many neuroptics there are
     * @param systems how many systems there are
     */
    public Warframe(String name, int blueprint, int chassis, int neuroptics, int systems) {
        this.name = name;
        this.blueprint = blueprint;
        this.chassis = chassis;
        this.neuroptics = neuroptics;
        this.systems = systems;
        createCodeName();
        calcTotal();
    }

    /**
     * This returns the warframe's name
     * @return this warframe's name
     */
    public String getName() {
        return name;
    }

    /**
     * This allows the change of the amount of blueprints
     * @param blueprint this warframe's new blueprint amount
     */
    public void setBlueprint(int blueprint) {
        if(blueprint < 0) {
            return;
        }
        this.blueprint = blueprint;
    }

    /**
     * This allows the calling of the amount of blueprints of this warframe
     * @return this warframe's blueprint amount
     */
    public int getBlueprint() {
        return blueprint;
    }

    /**
     * This allows the change of the amount of chassis
     * @param chassis this warframe's new chassis amount
     */
    public void setChassis(int chassis) {
        if(chassis < 0) {
            return;
        }
        this.chassis = chassis;
    }

    /**
     * This allows the calling of the amount of chassis of this warframe
     * @return this warframe's chassis amount
     */
    public int getChassis() {
        return chassis;
    }

    /**
     * This allows the change of the amount of neuroptics
     * @param neuroptics this warframe's new neuroptics amount
     */
    public void setNeuroptics(int neuroptics) {
        if(neuroptics < 0) {
            return;
        }
        this.neuroptics = neuroptics;
    }

    /**
     * This allows the calling of the amount of neuroptics of this warframe
     * @return this warframe's neuroptics amount
     */
    public int getNeuroptics() {
        return neuroptics;
    }

    /**
     * This allows the change of the amount of systems
     * @param system this warframe's new systems amount
     */
    public void setSystems(int system) {
        if(systems < 0){
            return;
        }
        this.systems = system;
    }

    /**
     * This allows the calling of the amount of systems of this warframe
     * @return this warframe's systems amount
     */
    public int getSystem() {
        return systems;
    }

    /**
     * This function calculates how many sets can be made
     */
    private void calcTotal() {
        total = Math.min(Math.min(blueprint, chassis), Math.min(neuroptics,systems));
    }

    /**
     * This allows the calling of the amount of sets of this warframe
     * @return this warframe's set amount
     */
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

    /**
     * This allows the calling of this warframe's code name
     * @return this warframe's code name
     */
    public String getCodeName() {
        return codeName;
    }

    /**
     * This allows the change of the prices of this warframe
     * @param max the maximum price of the warframe
     * @param avg the average price of the warframe
     * @param min the minimum price of the warframe
     */
    public void setSetPrices(double max, double avg, double min) {
        this.max = max;
        this.avg = Double.parseDouble(String.format("%.02f", (float) avg));
        this.min = min;
    }

    /**
     * This allows the calling of this warframe's average price
     * @return this warframe's average price
     */
    public double getSetAVG() {
        return avg;
    }

    /**
     * This allows the calling of this warframe's maximum price
     * @return this warframe's maximum price
     */
    public double getSetMax() {
        return max;
    }

    /**
     * This allows the calling of this warframe's minimum price
     * @return this warframe's minimum price
     */
    public double getSetMin() {
        return min;
    }
}
