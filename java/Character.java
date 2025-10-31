import java.util.Random;

public abstract class Character implements RpgClass {
    private String name;
    private int forca;      
    private int agilidade; 
    private int inteligencia; 
    private String imagem; 

   
    private int stamina = 100; 
    private int defense = 5;
    private int mana = 10;
    
    
    public Character(String nome, int forca, int agilidade, int inteligencia) {
        this.name = nome;
        this.forca = forca;
        this.agilidade = agilidade;
        this.inteligencia = inteligencia;
        
       
        this.stamina = 50 + (forca * 5); 
        this.defense = 5 + (agilidade / 2);
        this.mana = 10 + (inteligencia * 3);
    }
    
   
    public abstract int specialAttack(); 

    // Getters e Setters necessários para CadastroPersonagem.java
    
    public String getNome() { 
        return this.name;
    }
    
    public int getForca() {
        return forca;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public int getInteligencia() {
        return inteligencia;
    }
    
    public void setImagem(String caminhoImagem) {
        this.imagem = caminhoImagem;
    }
    
    public String getImagem() {
        return this.imagem;
    }
    
    
    
    public int commonAttack(Character attackerCharacter, Character defenserCharacter){
        Random random = new Random();
        String defenserName = defenserCharacter.getName();
        String attackerName = attackerCharacter.getName();
        if(defenserCharacter.getDefense() > random.nextInt(6)+1){
            System.out.println(defenserName + " stamina: "+ defenserCharacter.getStamina());
            System.out.println(attackerName + " attacks "+ defenserName);
            int damageTaken = (attackerCharacter.getForca() + 3)*(-1); // Usa getForca()
            defenserCharacter.setStamina(damageTaken);
            System.out.println(defenserName + " stamina: "+ defenserCharacter.getStamina());
            return damageTaken;
        }else{
            System.out.println(defenserName + " desviou do ataque");
            return 0;
        }
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
    public String getName() {
        return this.name;
    }
}