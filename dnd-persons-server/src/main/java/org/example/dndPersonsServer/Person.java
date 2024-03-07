package org.example.dndPersonsServer;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.UUID;

public class Person {
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
    private int healthPoints;
    @Getter
    @Setter
    private int currentHealthPoints;
    @Getter
    @Setter
    private int armorClass;

    public Person() {
    }

    public Person(UUID id, String name, Races race, Classes personClass,
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
        this.healthPoints = healthPoints;
        this.currentHealthPoints = currentHealthPoints;
        this.armorClass = armorClass;
    }

    public int getCharacteristicModifier(Characteristics characteristic){
        return (int) (Math.floor((characteristics.get(characteristic)-10)/2.0));
    }
}
