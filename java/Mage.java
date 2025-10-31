public class Mage extends Character {

    public Mage(String nome, int forca, int agilidade, int inteligencia) {
        super(nome, forca, agilidade, inteligencia);
    }


    public int specialAttack() {
       
        int dano = getInteligencia() * 3;
        System.out.println(getNome() + " (Mago) conjurou Bola de Fogo! Dano: " + dano);
        return dano;
    }
}