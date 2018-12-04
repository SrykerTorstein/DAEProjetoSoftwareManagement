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
    private JSONObject jsonObject = new JSONObject();

    public Characteristic(){

    }

    public Characteristic(String name, JSONObject jsonObject) {
        this.name = name;
        this.jsonObject = jsonObject;
    }

    public String getName() {
        return name;
    }

    public void setName(String id) {
        this.name = id;
    }
}

