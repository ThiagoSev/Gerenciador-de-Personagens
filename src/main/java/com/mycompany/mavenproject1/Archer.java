package com.mycompany.mavenproject1;
public class Archer implements RpgClass{
    @Override
    public int specialAttack(RpgCharacter attackerCharacter, RpgCharacter defenserCharacter){
        System.out.println("ataque de arco");
        return 0;
    }
}
