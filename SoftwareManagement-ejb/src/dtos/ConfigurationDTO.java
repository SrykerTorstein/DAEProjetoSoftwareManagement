package dtos;

import entities.Characteristic;
import enums.ConfigurationState;
import java.util.List;

public class ConfigurationDTO implements DTO {

    private String name;
    private String description;
    private ConfigurationState state;
    private String softwareName;
    private List<Characteristic> characteristics;

    public ConfigurationDTO() {
    }

    public ConfigurationDTO(String name, String description, ConfigurationState state, String softwareName, List<Characteristic> characteristics) {
        this.name = name;
        this.description = description;
        this.state = state;
        this.softwareName = softwareName;
        this.characteristics = characteristics;
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

    @Override
    public void clear() {
        name = null;
        description = null;
        state = null;
        softwareName = null;
        characteristics = null;
    }
}
