package ejbs;

import dtos.ConfigurationDTO;
import entities.Characteristic;
import entities.Configuration;
import enums.ConfigurationState;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotNull;
import java.util.List;

@Stateless
public class ConfigurationBean extends BaseBean<Configuration, ConfigurationDTO> {

    public ConfigurationDTO create(String configurationName, String description, ConfigurationState state, String softwareName) {
        return create(new ConfigurationDTO(configurationName,description,state,softwareName,getCharacteristicsOfConfiguration(configurationName)));
    }

    public List<Characteristic> getCharacteristicsOfConfiguration(String configurationName) {
        return em.createNamedQuery("getCharacteristicsByConfiguration", Characteristic.class)
                .setParameter("configurationName", configurationName)
                .getResultList();
    }

    public void addCharacteristicToConfiguration(@NotNull String configurationName, @NotNull String characteristicName) {

        try {
            Configuration configuration = findOrFail(configurationName);
            Characteristic characteristic = findOrFail(Characteristic.class,characteristicName);
            configuration.addCharacteristic(characteristic);
        } catch (EntityNotFoundException e) {
            throw new EJBException(e.getMessage(), e);
        }
    }
}
