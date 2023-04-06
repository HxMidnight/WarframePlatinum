
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Data data = new Data();
        ArrayList<Warframe> warframeArrayList = data.getWarframeData();
        warframeArrayList.get(0).setBlueprint(10);
        for(int i=0; i<warframeArrayList.size();i++) {
            System.out.println(warframeArrayList.get(i).getCodeName());
        }
        System.out.println(warframeArrayList.get(0).getSetMax());

        MainFrame mframe = new MainFrame("Warframe Plat", warframeArrayList);

    }
}
