package com.mycompany.mavenproject1;
import java.util.Random;

public class RpgCharacter{
    private String name;
    private String rpgClassName;
    private RpgClass rpgClass;

    private int stamina;
    private int defense;
    private int mana;

    private int strength;
    private int agility;
    private int vitality;
    private int intelligence;

    public RpgCharacter(String name, int tempRpgClass, int strength, int agility, int vitality, int intelligence){
        this.name = name;
        switch(tempRpgClass){
            case 0:
                this.rpgClassName = "Warrior";
                this.rpgClass = new Warrior();
                this.stamina = 20+this.vitality;
                this.defense = 5;
                this.mana = 2;
                break;
            case 1:
                this.rpgClassName = "Archer";
                this.rpgClass = new Archer();
                this.stamina = 17+this.vitality;
                this.defense = 4;
                this.mana = 2;
                break;
            case 2:
                this.rpgClassName = "Mage";
                this.rpgClass = new Mage();
                this.stamina = 12+this.vitality;
                this.defense = 3;
                this.mana = 5;
                break;
            default:
                System.out.println("opção invalida");
                break;
        }
        this.strength = strength;
        this.agility = agility;
        this.vitality = vitality;
    }
    public int commonAttack(RpgCharacter attackerCharacter, RpgCharacter defenserCharacter){
        Random random = new Random();
        String defenserName = defenserCharacter.getName();
        String attackerName = attackerCharacter.getName();
        if(defenserCharacter.getDefense() > random.nextInt(6)+1){
            System.out.println("\n"+defenserName + " stamina: "+ defenserCharacter.getStamina());
            System.out.println(attackerName + " attacks "+ defenserName);
            int damageTaken = (attackerCharacter.getStrength() + 3)*(-1);
            defenserCharacter.setStamina(damageTaken);
            System.out.println(defenserName + " stamina: "+ defenserCharacter.getStamina());
            return damageTaken;
        }else{
            System.out.println(defenserName + " desviou do ataque");
            return 0;
        }
    }
    public int specialAttack(){
        return rpgClass.specialAttack();
    }
    public int deflect(){
        //decide se o personagem consegue desviar
        return rpgClass.specialAttack();
    }
    public String getName() {
        return this.name;
    }
    public String getRpgClassName(){
        return this.rpgClassName;
    }
    public int getDefense(){
        return this.defense;
    }
    public int getStamina(){
        return this.stamina;
    }
    public void setStamina(int num) {
        this.stamina += num;
    }
    public int getMana(){
        return 1;
    }
    public RpgClass getRpgClass(){
        return this.rpgClass;
    }
    
    public int getStrength() {
        return this.strength;
    }
    public int getAgility() {
        return this.agility;
    }
}