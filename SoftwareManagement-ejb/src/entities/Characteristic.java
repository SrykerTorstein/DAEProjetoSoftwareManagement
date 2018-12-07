package entities;

import org.json.simple.JSONObject;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "CHARACTERISTICS")
@NamedQueries({
        @NamedQuery(name = "getAllCharacteristics",
                query = "SELECT c FROM Characteristic c ORDER BY c.name")
})
public class Characteristic implements Serializable {

    @Id
    private String name;

    @NotNull
    private String jsonString;

    public Characteristic(){

    }

    public Characteristic(String name, String jsonString) {
        this.name = name;
        this.jsonString = jsonString;
    }

    public String getName() {
        return name;
    }

    public void setName(String id) {
        this.name = id;
    }

    public String getJsonString() {
        return jsonString;
    }

    public void setJsonString(String jsonString) {
        this.jsonString = jsonString;
    }

    public void setJsonStringWithJsonObject(JSONObject jsonObject) {
        this.jsonString = jsonObject.toJSONString();
    }
}

