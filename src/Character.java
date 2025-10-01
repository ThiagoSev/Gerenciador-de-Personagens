import java.util.Scanner;
import java.util.Random;

public class Character{
    private String name;
    private RpgClass rpgClass;

    private int stamina;
    private int defense;
    private int mana;

    private int strength;
    private int agility;
    private int vitality;
    private int inteligence;
    private int wisdow;
    private int charisma;

    public Character(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("escolha um nome para o personagem:");
        this.name = scanner.nextLine();
        System.out.println("escolha a classe para o personagem:\n1-Guerreiro.\n2-Arqueiro.\n3-Mago"); //na interface gráfica, a escolha deverá ser por meio de botões ao invés de text input
        int tempRpgClass = scanner.nextInt();
        switch(tempRpgClass){
            case 1:
                this.rpgClass = new Warrior();
                this.vitality = 20+this.vitality;
                this.mana = 2;
                break;
            case 2:
                this.rpgClass = new Archer();
                this.vitality = 17+this.vitality;
                this.mana = 2;
                break;
            case 3:
                this.rpgClass = new Mage();
                this.vitality = 12+this.vitality;
                this.mana = 5;
                break;
            default:
                System.out.println("opção invalida");
                break;
        }

        System.out.println("Atributos: "); //caixas de texto
        System.out.println("Você tem 15 pontos para distribuir nos 6 atributos");
        System.out.println("quantos pontos deseja gastar em força?");
        this.strength = scanner.nextInt();
        System.out.println("quantos pontos deseja gastar em agilidade?");
        this.agility = scanner.nextInt();
        System.out.println("quantos pontos deseja gastar em vitalidade?");
        this.vitality = scanner.nextInt();
        System.out.println("quantos pontos deseja gastar em inteligência?");
        this.inteligence = scanner.nextInt();
        System.out.println("quantos pontos deseja gastar em sabedoria?");
        this.wisdow = scanner.nextInt();
        System.out.println("quantos pontos deseja gastar em carisma?");
        this.charisma = scanner.nextInt();

    }
    public int commonAttack(Character attackerCharacter, Character defenserCharacter){
        Random random = new Random();
        String defenserName = defenserCharacter.getName();
        String attackerName = attackerCharacter.getName();
        if(defenserCharacter.getDefense() > random.nextInt(6)+1){
            System.out.println(defenserName + " stamina: "+ defenserCharacter.getStamina());
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
    public int getDefense(){
        return this.defense;
    }
    public int getStamina(){
        return this.stamina;
    }
    public void setStamina(int num) {
        this.stamina += num;
    }
    public RpgClass getRpgClass(){
        return this.rpgClass;
    }
    public String getName() {
        return this.name;
    }
    public int getStrength() {
        return this.strength;
    }
}