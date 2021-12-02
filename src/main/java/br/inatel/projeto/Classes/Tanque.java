package br.inatel.projeto.Classes;
import br.inatel.projeto.Personagem;

public class Tanque  extends Personagem{
    @Override
    public void info() {
        System.out.println("Aguenta uma grande quantidade de dano");
        System.out.println("Geralmente possuem fortes controles de grupo em suas habilidades");
    }
}
