
import java.util.ArrayList;

public class Main {
    public static ArrayList<Warframe> warframeArrayList;
    public static void main(String[] args) {
        JSONHandler json = new JSONHandler();
        ArrayList<Warframe> tempList = json.readJSON();
        Data data = new Data();
        warframeArrayList = data.getWarframeData();
        for (Warframe warframe : warframeArrayList) {
            System.out.println(warframe.getCodeName());
        }
        System.out.println(warframeArrayList.get(0).getSetMax());

        boolean same = warframeArrayList.size()==tempList.size();
        System.out.println("are they equal?" + same);
        MainFrame mframe = new MainFrame("Warframe Plat", warframeArrayList);
    }
}
