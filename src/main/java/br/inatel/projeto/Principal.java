package br.inatel.projeto;

import br.inatel.projeto.Classes.*;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int escolha;
        boolean flag = true;
        boolean cadastrado = false;
        while(flag){
            System.out.println("Bem vindo!");
            System.out.println("O que deseja fazer?");
            System.out.println("1 - Cadastro jogador:");
            System.out.println("2 - Seleção de personagem:");
            System.out.println("3 - Explicação das classes:");
            System.out.println("4 - Sair");
            escolha = sc.nextInt();
            switch (escolha){
                case 1:
                    sc.nextLine();
                    System.out.println("Entre com seu nome:");
                    String nome = sc.nextLine();
                    System.out.println("Entre com seu email:");
                    String email = sc.nextLine();
                    System.out.println("Entre com seu telefone:");
                    String telefone = sc.nextLine();
                    Jogador jogador = new Jogador(nome,email,telefone);
                    cadastrado = true;
                    break;
                case 2:
                    if(cadastrado){
                        int rota;
                        int classe;
                        System.out.println("Escolha sua rota:");
                        System.out.println("1 - Topo");
                        System.out.println("2 - Caçador");
                        System.out.println("3 - Meio");
                        System.out.println("4 - Atirador");
                        System.out.println("5 - Suporte");
                        rota = sc.nextInt();
                        System.out.println("Escolha sua classe");
                        System.out.println("1 - Artilharia");
                        System.out.println("2 - Assassino");
                        System.out.println("3 - Auto Ataque");
                        System.out.println("4 - Burst");
                        System.out.println("5 - Caster");
                        System.out.println("6 - Encantador");
                        System.out.println("7 - Tanque");
                        classe = sc.nextInt();
                        // Puxar do banco e fazer o switch do personagem q ira querer jogar
                    }
                    else{
                        System.out.println("Realize o cadastro antes de prosseguir!");
                        break;
                    }
                case 3:
                    int explicacao;
                    System.out.println("1 - Artilharia");
                    System.out.println("2 - Assassino");
                    System.out.println("3 - Auto Ataque");
                    System.out.println("4 - Burst");
                    System.out.println("5 - Caster");
                    System.out.println("6 - Encantador");
                    System.out.println("7 - Tanque");
                    System.out.println("8 - Sair");
                    explicacao = sc.nextInt();
                    switch (explicacao){ // Trocar por while
                        case 1:
                            Artilharia artilharia = new Artilharia();
                            artilharia.info();
                            break;
                        case 2:
                            Assassino assassino = new Assassino();
                            assassino.info();
                            break;
                        case 3:
                            Auto_Ataque auto = new Auto_Ataque();
                            auto.info();
                            break;
                        case 4:
                            Burst burst = new Burst();
                            burst.info();
                            break;
                        case 5:
                            Caster caster = new Caster();
                            caster.info();
                            break;
                        case 6:
                            Encantador encantador = new Encantador();
                            encantador.info();
                            break;
                        case 7:
                            Tanque tanque = new Tanque();
                            tanque.info();
                            break;
                        case 8:
                            break;
                        default:
                            System.out.println("Valor Inválido.");
                    }
                case 4:
                    System.out.println("Obrigado pela participação!");
                    flag = false;
                    break;
                default:
                    System.out.println("Valor incorreto");
                    break;
            }

        }
    }
}
