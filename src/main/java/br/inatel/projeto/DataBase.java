package br.inatel.projeto;

import br.inatel.projeto.Classes.Artilharia;
import br.inatel.projeto.Classes.Atirador;
import br.inatel.projeto.Classes.Auto_Ataque;

import java.sql.*;
import java.util.ArrayList;

public class DataBase {
    Connection connection;   // objeto responsável por fazer a conexão com o servidor do MySQL
    Statement statement;     // objeto responsável por preparar consultas "SELECT"
    ResultSet result;        // objeto responsável por executar consultas "SELECT"
    PreparedStatement pst;   // objeto responsável por preparar querys de manipulação dinâmicas (INSERT, UPDATE, DELETE)
    static final String user = "root";            // usuário da instância local do servidor
    static final String password = "Ab140204";    // senha do usuário da instância local do servidor
    static final String database = "projeto";     // nome do banco de dados a ser utilizado
    // string com URL de conexão com servidor
    static final String url = "jdbc:mysql://localhost:3306/" + database + "?useTimezone=true&serverTimezone=UTC&useSSL=false";
    private boolean check = false;       // variável interna para confirmação de métodos do CRUD
    public void connect(){
        try {
            connection = DriverManager.getConnection(url, user, password);
            //System.out.println("Conexão feita com sucesso: "+ connection);
        }catch (SQLException e){
            System.out.println("Erro de conexão: " + e.getMessage());
        }
    }
    // ----------------------------INSERINDO NOVO REGISTRO----------------------------
    public boolean insertJogador(Jogador jogador){
        connect();
        String sql = "INSERT INTO Jogador(nome, email, telefone, personagem_nome) VALUES(?, ?, ?, ?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, jogador.getNome());      // concatena nome na primeira ? do comando
            pst.setString(2, jogador.getEmail());        // concatena nome na segunda ? do comando
            pst.setString(3, jogador.getTelefone());
            pst.setString(4, "cadastro");
            pst.execute();                           // executa o comando
            check = true;
        } catch (SQLException e) {
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        }
        finally {
            try{
                connection.close();
                pst.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }
    
    // ----------------------------BUSCANDO PERSONAGENS PELA ROTA/CLASSE------------------------------
    public ArrayList<Personagem> researchPersonagem(String classe, String rota){
        connect();
        ArrayList<Personagem> personagens = new ArrayList<>();
        String sql = "SELECT distinct c.personagem_nome, p.personagem_nome FROM Classe as c, personagem_has_rota as p WHERE c.nome = '"+classe+"' AND p.rota_nome = '"+rota+"' and p.Personagem_nome = c.personagem_nome";

            try {
                statement = connection.createStatement();
                result = statement.executeQuery(sql);
                while (result.next()) {
                    Personagem personagemTemp = new Auto_Ataque(result.getString("personagem_nome"));
                    personagemTemp.setNome(result.getString("personagem_nome"));
                    System.out.println("Nome = " + personagemTemp.getNome());
                    System.out.println("------------------------------");
                    personagens.add(personagemTemp);
                }
            } catch (SQLException e) {
                System.out.println("Erro de operação: " + e.getMessage());
            } finally {
                try {
                    connection.close();
                    statement.close();
                    result.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar a conexão: " + e.getMessage());
                }
            }
            return personagens;
    }
    // ----------------------------SELECIONANDO PERSONAGEM NO REGISTRO----------------------------
    public ArrayList<Personagem> escolhaPersonagem(String pNome){
        connect();
        ArrayList<Personagem> personagens = new ArrayList<>();
        String sql = "SELECT * FROM Personagem WHERE nome = '"+pNome+"'";

        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            while (result.next()) {
                Personagem personagemTemp = new Auto_Ataque(result.getString("nome"),result.getInt("vida"),
                        result.getInt("mana"),result.getInt("danoAtaque"),result.getInt("armadura"),
                        result.getInt("resistenciaMagica"));
                System.out.println("Nome = " + personagemTemp.getNome());
                System.out.println("Vida = " + personagemTemp.getVida());
                System.out.println("Mana = " + personagemTemp.getMana());
                System.out.println("Dano de ataque = " + personagemTemp.getDanoAtaque());
                System.out.println("Armadura = " + personagemTemp.getArmadura());
                System.out.println("Resistência Mágica = " + personagemTemp.getResistenciaMagica());
                System.out.println("------------------------------");
                personagens.add(personagemTemp);
            }
        } catch (SQLException e) {
            System.out.println("Erro de operação: " + e.getMessage());
        } finally {
            try {
                connection.close();
                statement.close();
                result.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return personagens;
    }

    // ----------------------------ATUALIZANDO NOME NO REGISTRO----------------------------
    public boolean updateJogador(String nome){
        connect();
        String sql = "UPDATE Jogador SET Personagem_nome=? WHERE Personagem_nome = 'cadastro'";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, nome);
            pst.execute();
            check = true;
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        }finally {
            try {
                connection.close();
                pst.close();
            }catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }
}