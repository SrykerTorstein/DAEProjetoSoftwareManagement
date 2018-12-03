package entities;

import org.json.simple.JSONObject;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "CHARACTERISTICS")
public class Characteristic implements Serializable {

    @Id
    private String name;

    @NotNull
    private JSONObject jsonObject = new JSONObject();

    public String getName() {
        return name;
    }

    public void setName(String id) {
        this.name = id;
    }
}

