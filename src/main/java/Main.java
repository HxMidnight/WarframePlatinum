
import java.util.ArrayList;

public class Main {
    public static ArrayList<Warframe> warframeArrayList;
    public static void main(String[] args) {
        Data data = new Data();
        warframeArrayList = data.getWarframeData();
        warframeArrayList.get(0).setBlueprint(10);
        for (Warframe warframe : warframeArrayList) {
            System.out.println(warframe.getCodeName());
        }
        System.out.println(warframeArrayList.get(0).getSetMax());

        MainFrame mframe = new MainFrame("Warframe Plat", warframeArrayList);
    }
}
