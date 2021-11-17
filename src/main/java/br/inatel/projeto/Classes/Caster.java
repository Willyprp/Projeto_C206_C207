package br.inatel.projeto.Classes;

import br.inatel.projeto.Personagem;

public class Caster extends Personagem implements Atirador {

    @Override
    public void atirador() {
        System.out.println("Causa dano utilizando uma combinação de ataques com habilidades");
    }
}
