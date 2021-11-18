package br.inatel.projeto.Classes;
import br.inatel.projeto.Personagem;

public class Burst  extends Personagem implements Mago{

    @Override
    public void mago() {
        System.out.println("Causa muito dano com uma rotação de suas habilidades");
    }
}
