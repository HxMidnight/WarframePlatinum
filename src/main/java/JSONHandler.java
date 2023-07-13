import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;
import netscape.javascript.JSObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class JSONHandler {
    private JsonObject makeJSONObject(Warframe warframe) {
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
        JsonObject writeFrames = new JsonObject();

        writeFrames.put("frames", frames);

        return writeFrames;
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

    public ArrayList<Warframe> readJSON() {
        try {

            Reader reader = Files.newBufferedReader(Paths.get("warframe.json"));

            JsonObject parser = (JsonObject) Jsoner.deserialize(reader);

            JsonArray frames = (JsonArray) parser.get("frames");

            ArrayList<Warframe> warframeList = new ArrayList<>();

            frames.forEach(entry -> {
                JsonObject frame = (JsonObject) entry;
                String name = (String) frame.get("name");
                BigDecimal blueprint = (BigDecimal) frame.get("blueprints");
                BigDecimal chassis = (BigDecimal) frame.get("chassis");
                BigDecimal system = (BigDecimal) frame.get("systems");
                BigDecimal neuroptics = (BigDecimal) frame.get("neuroptics");
                Warframe tempFrame = new Warframe(name, blueprint.intValue(), chassis.intValue(), neuroptics.intValue(), system.intValue());
                warframeList.add(tempFrame);
            });
            reader.close();
            return warframeList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
