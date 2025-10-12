package com.mycompany.mavenproject1;
import java.util.Random;

public class Warrior implements RpgClass {
    @Override
    public int specialAttack(){
        System.out.println("ataque de espada");
        return 0;
    }
}
