
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Warframe> warframeArrayList;

    public static void main(String[] args) {
        if (new File(String.valueOf(Paths.get("warframe.json"))).isFile()) {
            new IntroWindow("WarframePlat");
        } else {
            Data data = new Data();
            warframeArrayList = data.getWarframeData();
            new MainFrame("WarframePlat");
        }
    }
}
