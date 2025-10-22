package com.mycompany.mavenproject1;
public class Mage implements RpgClass{
    @Override
    public int specialAttack(RpgCharacter attackerCharacter, RpgCharacter defenserCharacter){
        System.out.println("ataque de magia");
        return 0;
    }
}
