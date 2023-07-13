
import java.util.ArrayList;

public class Main {
    public static ArrayList<Warframe> warframeArrayList;
    public static void main(String[] args) {
        JSONHandler json = new JSONHandler();
        ArrayList<Warframe> tempList = json.readJSON();
        Data data = new Data();
        warframeArrayList = data.getWarframeData();
        for (Warframe warframe : warframeArrayList) {
            data.getWarframeSetPrices(warframe);
        }
        data.getWarframeSetPrices(warframeArrayList.get(0));
        System.out.println(warframeArrayList.get(0).getSetMax());
        System.out.println(warframeArrayList.get(0).getSetAVG());
        System.out.println(warframeArrayList.get(0).getSetMin());

        boolean same = warframeArrayList.size()==tempList.size();
        System.out.println("are they equal?" + same);
        MainFrame mframe = new MainFrame("Warframe Plat", warframeArrayList);
    }
}
