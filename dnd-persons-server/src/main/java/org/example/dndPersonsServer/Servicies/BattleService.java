package org.example.dndPersonsServer.Servicies;

import org.example.dndPersonsServer.Models.Creature;
import org.springframework.stereotype.Service;

@Service
public class BattleService {
    private Creature firstPlayer;
    private Creature secondPlayer;

    public void startOfBattle(Creature firstPlayer, int level){
        this.firstPlayer = firstPlayer;
        createEnemy(level);
    }

    private void createEnemy(int level){
        Creature enemy = new Creature();
        if(level<=4){
            enemy.setMaxHealthPoints(5);
            enemy.setCurrentHealthPoints(5);
        }
        if(level>=10){
            enemy.setMaxHealthPoints(20);
            enemy.setCurrentHealthPoints(20);
        }
        secondPlayer = enemy;
    }

    public void playerAttackAction(Creature who, Creature whom){
        Creature[] currentState = CreatureActionsService.attackAction(who,whom);
        firstPlayer = currentState[0];
        secondPlayer = currentState[1];
    }

    public Creature[] getStateOfBattle() {
        return new Creature[]{firstPlayer,secondPlayer};
    }
}
