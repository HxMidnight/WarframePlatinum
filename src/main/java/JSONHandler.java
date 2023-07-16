import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;


import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * This class allows the program to handle the writing and reading of JSON files
 */
public class JSONHandler {
    /**
     * This function allows the creation of an object of all frames to be written in a JSON file
     * @return an JSON object including all warframes with their corresponding attributes
     */
    private JsonObject makeJSONObject() {
        JsonArray frames = new JsonArray();
        for(Warframe warframes : Main.warframeArrayList) {
            JsonObject warframeObj = new JsonObject();
            warframeObj.put("name",warframes.getName());
            warframeObj.put("blueprints", warframes.getBlueprint());
            warframeObj.put("neuroptics", warframes.getNeuroptics());
            warframeObj.put("chassis", warframes.getChassis());
            warframeObj.put("systems",warframes.getSystem());
            warframeObj.put("max", warframes.getSetMax());
            warframeObj.put("min",warframes.getSetMin());
            warframeObj.put("avg", warframes.getSetAVG());

            frames.add(warframeObj);
        }
        JsonObject writeFrames = new JsonObject();

        writeFrames.put("frames", frames);

        return writeFrames;
    }

    /**
     * This function allows the writing of the JSON file with all frames available
     */
    public void writeToJSON() {
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get("warframe.json"));

            Jsoner.serialize(makeJSONObject(), writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This allows the read of a previously generated JSON file with frames
     * @return a list of all the saved warframes in the file
     */
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
                BigDecimal max = (BigDecimal) frame.get("max");
                BigDecimal min = (BigDecimal) frame.get("min");
                BigDecimal avg = (BigDecimal) frame.get("avg");
                Warframe tempFrame = new Warframe(name, blueprint.intValue(), chassis.intValue(), neuroptics.intValue(), system.intValue());
                tempFrame.setSetPrices(max.doubleValue(), avg.doubleValue(), min.doubleValue());
                warframeList.add(tempFrame);
            });
            reader.close();
            return warframeList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
