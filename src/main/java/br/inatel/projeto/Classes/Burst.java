package br.inatel.projeto.Classes;
import br.inatel.projeto.Personagem;

public class Burst  extends Personagem implements Mago{

    @Override
    public void mago() {
        System.out.println("Causa muito dano com uma rotação de suas habilidades");
        System.out.println("Necessita de itens de poder de habilidade para que suas habilidades causem dano");
    }

    @Override
    public void info() {
        System.out.println("Suas habilidades causam muito dano porém possuem alto tempo de recarga");
    }
}
