package org.example.dndPersonsServer.Servicies;

import org.example.dndPersonsServer.Characteristics;
import org.example.dndPersonsServer.Dices;
import org.example.dndPersonsServer.Models.Creature;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CreatureActionsService {

    public static Creature[] attackAction(Creature who, Creature whom){
        int result = Dices.D20.roll();
        result+=who.getCharacteristicModifier(Characteristics.DEXTERITY);
        if(whom.getArmorClass()<=result){
            whom.setCurrentHealthPoints(whom.getCurrentHealthPoints()-(Dices.D6.roll()+who.getCharacteristicModifier(Characteristics.STRENGTH)));
        }
        return new Creature[]{who,whom};
    }

    public static Creature useItemAction(Creature who, String itemName){
        HashMap<String, Integer> tempInventory = who.getInventory();
        if(tempInventory.get(itemName)>1){
            int tempAmount = tempInventory.remove(itemName);
            tempAmount--;
            tempInventory.put(itemName,tempAmount);
            who.setInventory(tempInventory);


        }
        if(tempInventory.get(itemName)==1){
            tempInventory.remove(itemName);
            who.setInventory(tempInventory);


        }
        if(tempInventory.get(itemName)<1){
            throw new IllegalArgumentException();
        }
        return who;
    }


}
