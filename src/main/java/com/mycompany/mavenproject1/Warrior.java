package com.mycompany.mavenproject1;
import java.util.Random;

public class Warrior implements RpgClass {
    @Override
    public int specialAttack(RpgCharacter attackerCharacter, RpgCharacter defenserCharacter){
        System.out.println("\nataque de espada");
        return 0;
    }
}
