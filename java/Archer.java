public class Archer extends Character {

    public Archer(String nome, int forca, int agilidade, int inteligencia) {
        super(nome, forca, agilidade, inteligencia);
    }

    
    public int specialAttack() {
       
        int dano = getAgilidade() * 2 + 3;
        System.out.println(getNome() + " (Arqueiro) disparou Chuva de Flechas! Dano: " + dano);
        return dano;
    }
}