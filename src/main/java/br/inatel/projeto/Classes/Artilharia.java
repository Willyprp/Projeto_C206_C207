package br.inatel.projeto.Classes;
import br.inatel.projeto.Personagem;

public class Artilharia extends Personagem implements Mago{
    public Artilharia(String nome) {
        super(nome);
    }

    @Override
    public void mago() {
        System.out.println("Causa dano usando suas magias de uma longa distância");
        System.out.println("Necessita de itens de poder de habilidade para que suas habilidades causem dano");
    }

    @Override
    public void info() {
        System.out.println("O alcance das habilidades são maiores do que 700 unidades");
    }

    public Artilharia(){
    }
}
