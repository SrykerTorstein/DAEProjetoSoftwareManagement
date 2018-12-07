package dtos;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CharacteristicDTO implements DTO {
    private String name;
    private JSONObject jsonObject;

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
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
