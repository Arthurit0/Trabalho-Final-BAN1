
import java.util.Scanner;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.sql.Connection;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author desenv06
 */
public class UsuarioController {
    public void createUsuario(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os seguintes dados para criar um novo Usuário: ");
        System.out.print("Nome: ");
        String nome = input.nextLine();
        System.out.print("Email: ");
        String email = input.nextLine();
        System.out.print("Digite o valor de avaliação inicial do usuário: ");
        float avaliacao = input.nextFloat();
        System.out.print("Instituição: ");
        input.nextLine();
        String instituicao = input.nextLine();
        System.out.print("Profissão: ");
        String profissao = input.nextLine();
        System.out.print("Senha: ");
        String senha = input.next();
        System.out.print("Digite uma quantidade de denúncias inicial para este usuário: ");
        int denuncias = input.nextInt();
        String opcAdm;
        Boolean isAdm = false;
        
        System.out.print("É admin? S/N: ");
        opcAdm = input.next();

        if(opcAdm.equals("S")){
            isAdm = true;
        }
            
        
        System.out.println("\nLista de regiões no sistema:\n");
        
        HashSet allRegions = RegiaoModel.listAll(con);
        
        if(!allRegions.isEmpty()){
            Iterator<RegiaoBean> itRegions = allRegions.iterator();
            
            while(itRegions.hasNext()) {
                System.out.println(itRegions.next().toString());
            }

            int id_regiao;
            
            do{
                System.out.print("\nSelecione o id da região desejada: ");
                id_regiao = input.nextInt();

                if(id_regiao < 1 || id_regiao > allRegions.size()){
                    System.out.println("\nId inválido, tente novamente!");
            }
                            
            }while(id_regiao < 1 || id_regiao > allRegions.size());
            
            UsuarioBean user = new UsuarioBean(nome, email, id_regiao, avaliacao, instituicao, profissao, senha, denuncias, isAdm);
            UsuarioModel.create(user, con);
        
            System.out.println("\nUsuário criado com sucesso!");
            
        }else{
            System.out.println("Não há regiões cadastradas no sistema! Cadastre-as na database! Cancelando operação...");
        }
    }
    
    void listUsuarios(Connection con) throws SQLException{
        HashSet allUsers = UsuarioModel.listAll(con);
        Iterator<UsuarioBean> itUsers = allUsers.iterator();
        
        if(!allUsers.isEmpty()){
            System.out.println("\nLista de usuários no sistema:\n");            
            while(itUsers.hasNext()) {
                System.out.println(itUsers.next().toString());
            }
        }else{
            System.out.println("\nNão há nenhum usuário cadastrado no sistema!\n");  
        }
        

    }
}
