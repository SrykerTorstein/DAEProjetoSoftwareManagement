package entities;

import enums.ConfigurationState;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "CONFIGURATIONS")
@NamedQueries(value = {
        @NamedQuery(name = "getAllConfigurations",
                query = "SELECT c FROM Configuration c ORDER BY c.name"),

        @NamedQuery(name = "getCharacteristicsByConfiguration",
                query = "SELECT c.characteristics FROM Configuration c WHERE c.name = :configurationName")
})
public class Configuration implements Serializable {
    @Id
    private String name;

    @NotNull
    private String description;

    @NotNull
    private ConfigurationState state;

    @NotNull//@ForeignKey //Uncomment this when Software Entity is implemented
    private String softwareName;

    @ManyToMany
    private List<Characteristic> characteristics;

    public Configuration() {
        characteristics = new LinkedList<>();
    }

    public Configuration(String name, String description, ConfigurationState state, String softwareName) {
        this.name = name;
        this.description = description;
        this.state = state;
        this.softwareName = softwareName;
        characteristics = new LinkedList<>();
    }

    public void addCharacteristic(Characteristic characteristic){
        if(characteristics.contains(characteristic)){
            characteristics.add(characteristic);
        }
    }

    public void removeCharacteristic(Characteristic characteristic){
        if(characteristics.contains(characteristic)){
            characteristics.remove(characteristic);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ConfigurationState getState() {
        return state;
    }

    public void setState(ConfigurationState state) {
        this.state = state;
    }

    public String getSoftwareName() {
        return softwareName;
    }

    public void setSoftwareName(String softwareName) {
        this.softwareName = softwareName;
    }

    public List<Characteristic> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(List<Characteristic> characteristics) {
        this.characteristics = characteristics;
    }
}