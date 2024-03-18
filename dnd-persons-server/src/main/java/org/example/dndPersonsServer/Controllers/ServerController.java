package org.example.dndPersonsServer.Controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dndPersonsServer.Models.Creature;
import org.example.dndPersonsServer.Servicies.BattleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@AllArgsConstructor
public class ServerController {

    private final BattleService battleService;

    @GetMapping("/get")
    @ResponseBody
    public Creature get(){
        return new Creature();
    }

    @MessageMapping("/battleStart")
    @SendTo("/all")
    public Creature[] post (@Payload Creature who,@Payload int level){
        battleService.startOfBattle(who,level);
        return battleService.getStateOfBattle();
    }

    @MessageMapping("/attack")
    @SendTo("/all")
    private Creature[] attack (@Payload Creature who, @Payload Creature whom){
        battleService.playerAttackAction(who,whom);
        return battleService.getStateOfBattle();
    }
}
