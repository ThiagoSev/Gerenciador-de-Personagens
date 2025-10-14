package com.mycompany.mavenproject1;
import java.util.ArrayList;
public class Team {
    public ArrayList<RpgCharacter> createTeam(RpgCharacter char1, RpgCharacter char2, RpgCharacter char3){
        ArrayList<RpgCharacter> team = new ArrayList<RpgCharacter>();
        team.add(char1);
        team.add(char2);
        team.add(char3);
        return team;
    }
}
