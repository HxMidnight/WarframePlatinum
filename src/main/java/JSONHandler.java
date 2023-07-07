import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;
import netscape.javascript.JSObject;
import org.json.simple.JSONObject;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONHandler {
    private JsonObject makeJSONObject(Warframe warframe) {
        JsonObject frames = new JsonObject();
        for(int x=0; x<Main.warframeArrayList.size();x++) {
            if(warframe.getName().equalsIgnoreCase(Main.warframeArrayList.get(x).getName())) {
                Main.warframeArrayList.get(x).copyFrame(warframe);
            }
            JsonObject warframeObj = new JsonObject();
            warframeObj.put("name",Main.warframeArrayList.get(x).getName());
            warframeObj.put("blueprints", Main.warframeArrayList.get(x).getBlueprint());
            warframeObj.put("neuroptics", Main.warframeArrayList.get(x).getNeuroptics());
            warframeObj.put("chassis", Main.warframeArrayList.get(x).getChassis());
            warframeObj.put("systems",Main.warframeArrayList.get(x).getSystem());
            frames.put("frames",warframeObj);
        }

        return frames;
    }

    public void writeToJSON(Warframe warframe) {
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get("warframe.json"));

            Jsoner.serialize(makeJSONObject(warframe), writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
