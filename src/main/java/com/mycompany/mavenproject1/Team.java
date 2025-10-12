package com.mycompany.mavenproject1;
public class Team {
    public int createTeam(RpgCharacter char1, RpgCharacter char2, RpgCharacter char3){
        System.out.println("time montado!");
        System.out.println("Integrantes:");
        System.out.println(char1.getRpgClassName()+ " "+char1.getName());
        System.out.println(char2.getRpgClassName()+ " "+char2.getName());
        System.out.println(char3.getRpgClassName()+ " "+char3.getName());
        return 0;
    }
}
