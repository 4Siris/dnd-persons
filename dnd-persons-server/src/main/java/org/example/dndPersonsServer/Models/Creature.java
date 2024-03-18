package org.example.dndPersonsServer.Models;

import lombok.Getter;
import lombok.Setter;
import org.example.dndPersonsServer.Characteristics;
import org.example.dndPersonsServer.Classes;
import org.example.dndPersonsServer.Races;

import java.util.HashMap;
import java.util.UUID;

public class Creature {
    @Getter
    @Setter
    private UUID id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private Races race;
    @Getter
    @Setter
    private Classes personClass;
    @Getter
    @Setter
    private int level;
    @Getter
    @Setter
    private int experience;
    @Getter
    @Setter
    private HashMap<Characteristics, Integer> characteristics;
    @Getter
    @Setter
    private HashMap<String,Integer> inventory;
    @Getter
    @Setter
    private int maxHealthPoints;
    @Getter
    @Setter
    private int currentHealthPoints;
    @Getter
    @Setter
    private int armorClass;

    public Creature() {
        this.id = UUID.randomUUID();
        this.name = "";
        this.race = Races.HUMAN;
        this.personClass = Classes.FIGHTER;
        this.level = 1;
        this.experience = 0;
        HashMap<Characteristics,Integer> defaultCharacteristics = new HashMap<>();
        defaultCharacteristics.put(Characteristics.STRENGTH,10);
        defaultCharacteristics.put(Characteristics.DEXTERITY,10);
        defaultCharacteristics.put(Characteristics.WISDOM,10);
        defaultCharacteristics.put(Characteristics.CHARISMA,10);
        defaultCharacteristics.put(Characteristics.CONSTITUTION,10);
        defaultCharacteristics.put(Characteristics.INTELLIGENCE,10);
        this.characteristics = defaultCharacteristics;
        this.inventory = new HashMap<>();
        this.maxHealthPoints = 10+getCharacteristicModifier(Characteristics.CONSTITUTION);
        this.currentHealthPoints = this.maxHealthPoints;
        this.armorClass = 10+getCharacteristicModifier(Characteristics.DEXTERITY);
    }

    public Creature(UUID id, String name, Races race, Classes personClass,
                    int level, int experience, HashMap<Characteristics, Integer> characteristics,
                    HashMap<String, Integer> inventory, int healthPoints,
                    int currentHealthPoints, int armorClass) {
        this.id = id;
        this.name = name;
        this.race = race;
        this.personClass = personClass;
        this.level = level;
        this.experience = experience;
        this.characteristics = characteristics;
        this.inventory = inventory;
        this.maxHealthPoints = healthPoints;
        this.currentHealthPoints = currentHealthPoints;
        this.armorClass = armorClass;
    }

    public int getCharacteristicModifier(Characteristics characteristic){
        return (int) (Math.floor((characteristics.get(characteristic)-10)/2.0));
    }
}
