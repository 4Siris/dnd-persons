package org.example.dndPersonsServer;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class PersonActionsService {

    public void attackAction(Person who, Person whom){
        int result = Dices.D20.roll();
        result+=who.getCharacteristicModifier(Characteristics.DEXTERITY);
        if(whom.getArmorClass()<=result){
            whom.setCurrentHealthPoints(whom.getCurrentHealthPoints()-(Dices.D6.roll()+who.getCharacteristicModifier(Characteristics.STRENGTH)));
        }
    }

    public void useItem(Person who, String itemName){
        HashMap<String, Integer> tempInventory = who.getInventory();
        if(tempInventory.get(itemName)>1){
            int tempAmount = tempInventory.remove(itemName);
            tempAmount--;
            tempInventory.put(itemName,tempAmount);
            who.setInventory(tempInventory);


        }
        if(tempInventory.get(itemName)==1){
            int tempAmount = tempInventory.remove(itemName);
            who.setInventory(tempInventory);


        }
        if(tempInventory.get(itemName)<1){
            throw new IllegalArgumentException();
        }
    }


}
