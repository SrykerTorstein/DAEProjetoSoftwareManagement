package dtos;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;

public class CharacteristicDTO implements DTO {

    private String name;
    private JSONObject jsonObject;
    private String property;

    public CharacteristicDTO() {

    }

    public CharacteristicDTO(String name, String jsonString) {
        this.name = name;
        JSONParser parser = new JSONParser();

        try {
            jsonObject = (JSONObject) parser.parse(jsonString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void clear() {
        name = null;
        jsonObject = null;
    }

    public String getName() {
        return name;
    }

    public String getProperty() {
        return property;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(String jsonString) {
        JSONParser parser = new JSONParser();
        try {
            jsonObject = (JSONObject) parser.parse(jsonString);
            //TODO make a properties list to iterate through using the concept below! :D
            property = "";
            for (Object key : jsonObject.keySet()) {
                property += key.toString() + " -> " + jsonObject.get(key) + "/";
            }
            //property = jsonObject.toString();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
