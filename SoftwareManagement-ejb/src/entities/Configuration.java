package entities;

import enums.ConfigurationState;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "CONFIGURATIONS")
public class Configuration implements Serializable {
    @Id
    private String name;

    @NotNull
    private String description;

    @NotNull
    private ConfigurationState state;

    @NotNull//@ForeignKey //Uncomment this when Software Entity is implemented
    private String softwareName;

    @ManyToOne
    private Characteristic characteristic;
}