import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;
import netscape.javascript.JSObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONHandler {
    private JsonArray makeJSONObject(Warframe warframe) {
        JsonArray frames = new JsonArray();
        for(Warframe warframes : Main.warframeArrayList) {
            JsonObject warframeObj = new JsonObject();
            warframeObj.put("name",warframes.getName());
            warframeObj.put("blueprints", warframes.getBlueprint());
            warframeObj.put("neuroptics", warframes.getNeuroptics());
            warframeObj.put("chassis", warframes.getChassis());
            warframeObj.put("systems",warframes.getSystem());

            frames.add(warframeObj);
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
