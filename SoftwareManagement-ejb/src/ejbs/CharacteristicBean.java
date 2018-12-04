package ejbs;

import dtos.CharacteristicDTO;
import entities.Characteristic;
import org.json.simple.JSONObject;

import javax.ejb.Stateless;

@Stateless
public class CharacteristicBean extends BaseBean<Characteristic, CharacteristicDTO> {

    public Characteristic create(String name, JSONObject jsonObject) {
        Characteristic characteristic = new Characteristic(name, jsonObject);

        em.persist(characteristic);

        return characteristic;
    }
}
