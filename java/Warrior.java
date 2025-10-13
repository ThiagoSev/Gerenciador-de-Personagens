public class Warrior extends Character {

    public Warrior(String nome, int forca, int agilidade, int inteligencia) {
        super(nome, forca, agilidade, inteligencia);
    }

   
    public int specialAttack() {
      
        int dano = getForca() * 2 + 5;
        System.out.println(getNome() + " (Guerreiro) usou Ataque Poderoso! Dano: " + dano);
        return dano;
    }
}