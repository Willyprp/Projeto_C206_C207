package br.inatel.projeto.Classes;

import br.inatel.projeto.Personagem;

public class Caster extends Personagem implements Atirador {

    @Override
    public void atirador() {
        System.out.println("Causa dano utilizando uma combinação de ataques com habilidades");
        System.out.println("Geralmente seus principais itens possuem o Fulgor em sua receita e fornecem tempo de recarga");
    }

    @Override
    public void info() {
        System.out.println("Geralmente começa a ter impacto no jogo após 2 itens finalizados");
    }
}
