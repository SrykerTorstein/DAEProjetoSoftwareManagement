package dtos;

import org.json.simple.JSONObject;

public class CharacteristicDTO implements DTO {
    private String name;
    private JSONObject jsonObject;

    public CharacteristicDTO() {
    }

    public CharacteristicDTO(String name, JSONObject jsonObject) {
        this.name = name;
        this.jsonObject = jsonObject;
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

    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }
}
