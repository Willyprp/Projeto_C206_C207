package br.inatel.projeto.Classes;
import br.inatel.projeto.Personagem;

public class Artilharia  extends Personagem implements Mago{
    @Override
    public void mago() {
        System.out.println("Causa dano usando suas magias de uma longa distância");
    }

    @Override
    public void info() {
        mago();
    }
}
