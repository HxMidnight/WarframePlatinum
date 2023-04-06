import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This Class allows the program to obtain the data needed from APIs
 */
public class Data {
    /**
     * This function allows the calling to the warframe api and collects objects of all prime warframes currently
     * @return a list with all prime warframes in game
     */
    public ArrayList<Warframe> getWarframeData() {
        try{

            URL url = new URL("https://api.warframestat.us/warframes/search/prime/");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();


            if(responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {
                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while(scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }
                scanner.close();

                System.out.println(informationString);

                JSONParser parse = new JSONParser();
                JSONArray dataObject = (JSONArray) parse.parse(String.valueOf(informationString));

                int length = dataObject.size();

                ArrayList<Warframe> warframeArrayList = new ArrayList<>();
                int index = 0;

                for(int i = 0; i<length; i++) {
                    JSONObject object = (JSONObject) dataObject.get(i);
                    String name = (String) object.get("name");
                    System.out.println(name);
                    if(name!="Excalibur Prime") {
                        warframeArrayList.add(new Warframe(name));
                        getWarframeSetPrices(warframeArrayList.get(index));
                        index++;
                    }
                }
                return warframeArrayList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void getWarframeSetPrices(Warframe warframe) {
        try {
            URL url = new URL("https://api.warframe.market/v1/items/"+warframe.getCodeName()+"/orders?order_type=sell");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();

            if(responseCode != 200) {
                throw new RuntimeException("HttpsResponseCode: " + responseCode);
            } else {
                StringBuilder informationString = new StringBuilder();

                Scanner scanner = new Scanner(url.openStream());

                while(scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }
                scanner.close();


                String filteredString = String.valueOf(informationString).replace("{\"payload\": {\"orders\": ","");
                filteredString = filteredString.replace("}}","");


                JSONParser parse = new JSONParser();
                JSONArray dataObject = (JSONArray) parse.parse(filteredString);

                int length = dataObject.size();
                double max = 0;
                double min = 9999999;
                double avg = 0;

                for(int i=0; i<length;i++) {
                    JSONObject object = (JSONObject) dataObject.get(i);
                    long pricelng =  (long) object.get("platinum");
                    double price = (double) pricelng;
                    if(max < price) {
                        max = price;
                    }
                    if(min > price) {
                        min = price;
                    }
                    avg = avg + price;
                }
                avg = avg/(length);
                warframe.setSetPrices(max, avg, min);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
