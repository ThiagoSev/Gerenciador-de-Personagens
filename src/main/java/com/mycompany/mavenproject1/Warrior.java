package com.mycompany.mavenproject1;

import java.util.Random;

public class Warrior implements RpgClass {
    @Override
    public int specialAttack(RpgCharacter attackerCharacter, RpgCharacter defenserCharacter){
        Random random = new Random();
        String defenserName = defenserCharacter.getName();
        String attackerName = attackerCharacter.getName();
        if(defenserCharacter.getDefense() > random.nextInt(6)+3){
            System.out.println("\n"+defenserName + " stamina: "+ defenserCharacter.getStamina());
            System.out.println(attackerName + " attacks "+ defenserName);
            int damageTaken = (attackerCharacter.getStrength() + 5)*(-1); //dano será sempre negativo
            defenserCharacter.setStamina(damageTaken);
            System.out.println(defenserName + " stamina: "+ defenserCharacter.getStamina());
            return damageTaken;
        }else{
            System.out.println(defenserName + " desviou do ataque");
            return 0;
        }
    }
}
