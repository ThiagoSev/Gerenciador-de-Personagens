package com.mycompany.mavenproject1;

import java.util.Random;

abstract class RpgClass {
    public int specialAttack(RpgCharacter attackerCharacter, RpgCharacter defenserCharacter){
        Random random = new Random();
        String defenserName = defenserCharacter.getName();
        String attackerName = attackerCharacter.getName();
        int defenseBonus = defenserCharacter.getDefenseBonus();
        int damageTaken =0;
        if(defenserCharacter.getDefense()+defenseBonus < random.nextInt(6)+3){
            damageTaken = (attackerCharacter.getStrength() + 5)*(-1); //dano será sempre negativo
            defenserCharacter.setStamina(damageTaken);
            System.out.println(attackerName + " deu "+damageTaken+" de dano no "+ defenserName);
        }else{
            System.out.println(defenserName + " desviou do ataque");
        }
        defenserCharacter.setDefenseBonus(10);
        return damageTaken;
    }
}