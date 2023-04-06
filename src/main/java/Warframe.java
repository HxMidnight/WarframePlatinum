import static java.lang.Math.min;

public class Warframe {
    private String name;
    private int blueprint;
    private int chassis;
    private int neuroptics;
    private int system;
    private int total;
    private String codeName;

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

    private void calcTotal() {
        total = Math.min(Math.min(blueprint, chassis), Math.min(neuroptics,system));
    }

    public int getTotal() {
        calcTotal();
        return total;
    }

    private void createCodeName() {
        String[] seperatedName = name.split(" ");
        codeName = seperatedName[0].toLowerCase() + "_" + seperatedName[1].toLowerCase() + "_set";
    }

    public String getCodeName() {
        return codeName;
    }
}
