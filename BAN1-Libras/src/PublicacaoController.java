
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author desenv06
 */
public class PublicacaoController {
        Scanner input = new Scanner(System.in);
    public void createPublicacao(Connection con) throws SQLException, ParseException {
        
        HashSet allUsers = UsuarioModel.listAll(con);
        Iterator<UsuarioBean> itUsers = allUsers.iterator();
        HashSet allPubs;
        Iterator<PublicacaoBean> itPubs;
        
        if(!allUsers.isEmpty()){
            System.out.println("Insira os seguintes dados para criar uma nova Publicacao: ");
            System.out.println("\nLista de usuários no sistema:\n");            
            while(itUsers.hasNext()) {
                System.out.println(itUsers.next().toString());
            }

            int id_autor;
            
            do{
                System.out.print("\nSelecione o id do usuário autor da publicação: ");
                 id_autor = input.nextInt();
                 
                 if(id_autor < 1 || id_autor > allUsers.size()){
                     System.out.println("\nId inválido, tente novamente!");
                 }
                
            }while(id_autor < 1 || id_autor > allUsers.size());
            
            input.nextLine();
            System.out.print("Digite o texto da publicação: ");
            String texto = input.nextLine();
            System.out.print("Digite a quantidade de likes inicial da publicação: ");
            int likes = input.nextInt();
            System.out.print("Digite a quantidade de deslikes inicial da publicação: ");
            int deslikes = input.nextInt();
            System.out.print("Digite a data da publicação (formato DD/MM/YYYY): ");
            String dataStr = input.next();
            SimpleDateFormat parser = new SimpleDateFormat("DD/MM/YYYY");
            Date dataPub = parser.parse(dataStr);
            input.nextLine();
            String tipoPub, arquivo="";
            int id_pub = -1, id_regiao = -1, id_mencao = -1;
            
            do{
                System.out.print("A publicação será uma pergunta (P), resposta (R) ou comentário (C)? ");
                tipoPub = input.nextLine();
                
                switch(tipoPub){
                    case "P":
                        System.out.println("\nLista de regiões no sistema:\n");
                        HashSet allRegions = RegiaoModel.listAll(con);
                        
                        Iterator<RegiaoBean> itRegions = allRegions.iterator();
                        
                        while(itRegions.hasNext()) {
                            System.out.println(itRegions.next().toString());
                        }
                        
                        do{
                            System.out.print("\nSelecione o id da região desejada: ");
                            id_regiao = input.nextInt();
                            
                            if(id_regiao < 1 || id_regiao > allRegions.size()){
                                System.out.println("\nId inválido, tente novamente!");
                            }
                            
                        }while(id_regiao < 1 || id_regiao > allRegions.size());
                        break;
                    case "R":
                        HashSet<PublicacaoBean> allPergs = PublicacaoModel.listAllPerguntas(con);
                        Iterator<PublicacaoBean> itPerg = allPergs.iterator();
                        
                        if(!allPergs.isEmpty()){
                            System.out.println("\nLista de Perguntas no sistema:\n");
                            ArrayList<Integer> listPergs = new ArrayList<>();
                            
                            while(itPerg.hasNext()){
                                PublicacaoBean pubIterada = itPerg.next();
                                listPergs.add(pubIterada.getId());
                                System.out.println(pubIterada.toString());
                            }
                            
                            do{
                                System.out.print("\nSelecione o id da pergunta que deseja responder: ");
                                id_pub = input.nextInt();
                                
                                if(id_pub < 1 || id_pub > allUsers.size() || !listPergs.contains(id_pub)){
                                    System.out.println("\nId inválido, tente novamente!");
                                }
                                
                            }while(id_pub < 1 || id_pub > allUsers.size() || !listPergs.contains(id_pub));
                            

                            System.out.print("Digite o link do arquivo para a resposta: ");
                            arquivo = input.next();
                        }else{
                            System.out.println("\nNão há perguntas para responder!\n");
                            tipoPub = "";
                        }
                        break;
                    case "C":
                        allPubs = PublicacaoModel.listAll(con);
                        itPubs = allPubs.iterator();
                        
                        if(!allPubs.isEmpty()){
                            if(allUsers.size() > 1){
                                System.out.println("\nLista de publicações no sistema:\n");
                                while(itPubs.hasNext()){
                                    System.out.println(itPubs.next().toString());
                                }
                                
                                do{
                                    System.out.print("Selecione o id da publicacao que deseja comentar: ");
                                    id_pub = input.nextInt();

                                    if(id_pub < 1 || id_pub > allPubs.size()){
                                        System.out.println("\nId inválido, tente novamente!");
                                    }
                                
                                }while(id_pub < 1 || id_pub > allPubs.size());
                                
                                    allUsers = UsuarioModel.listAll(con);
                                    itUsers = allUsers.iterator();

                                System.out.println("\nLista de usuários no sistema:\n");

                                while(itUsers.hasNext()) {
                                    System.out.println(itUsers.next().toString());
                                }
                                
                                do{
                                    System.out.print("Selecione o id do usuário autor da publicação comentada: ");
                                    id_mencao = input.nextInt();

                                    if(id_mencao < 1 || id_mencao > allUsers.size()){
                                        System.out.println("\nId inválido, tente novamente!");
                                    }
                                
                                } while(id_mencao < 1 || id_mencao > allUsers.size());


                                if(id_autor == id_mencao){
                                    System.out.println("\nUm usuário não pode mencionar a si mesmo!\n");
                                    tipoPub = "";
                                }
                            }else{
                                System.out.println("\nSão necessários mais usuários no sistema!\n");
                                tipoPub = "";
                            }
                        }else{
                            System.out.println("\nNão há outras publicações para comentar!\n");
                            tipoPub = "";
                        }
                        break;
                    default:
                        break;
                }
            }while(!tipoPub.equals("P") && !tipoPub.equals("R") && !tipoPub.equals("C"));
            
            PublicacaoBean p = new PublicacaoBean(id_autor, texto, likes, deslikes, dataPub, tipoPub, id_regiao, id_pub, id_mencao, arquivo);
            PublicacaoModel.create(p, con);
            
            System.out.println("\nNova publicação criada com sucesso!");
        }else{
            System.out.println("\nNão há usuarios cadastrados no sistema! Cadastre-os, e depois associe publicações a eles!");     
        }
    }
    
    void listPublicacoes(Connection con) throws SQLException{
        HashSet allPubs = PublicacaoModel.listAll(con);
        Iterator<PublicacaoBean> itPubs = allPubs.iterator();
        if(!allPubs.isEmpty()){
            System.out.println("\nLista de publicações no sistema:\n");
            while(itPubs.hasNext()){
                System.out.println(itPubs.next().toString());
            }
        }else{
            System.out.println("\nNão há nenhuma publicação cadastrada no sistema!\n");
        }
    }
    
    void listPublicacoesEUsuarios(Connection con) throws SQLException{
        HashSet allPubsNUsers = PublicacaoModel.listPublicacoesEAutores(con);
        Iterator<PublicacaoBean> itPubsNUsers = allPubsNUsers.iterator();
        if(!allPubsNUsers.isEmpty()){
            System.out.println("\nLista de publicações com seus usuários no sistema:\n");
            while(itPubsNUsers.hasNext()){
                System.out.println(itPubsNUsers.next().toString());
            }
        }else{
            System.out.println("\nNão há nenhuma usuário cadastrado ou publicação cadastrada no sistema!\n");
        }
    }
    
    void listPubsSameRegionAsUser(Connection con) throws SQLException{
        HashSet<UsuarioBean> allUsers = UsuarioModel.listAll(con);
        Iterator<UsuarioBean> itUsers = allUsers.iterator();
        
     if(!allUsers.isEmpty()){
        System.out.println("\nLista de usuários no sistema:\n");
        while(itUsers.hasNext()){
            System.out.println(itUsers.next().toString());
        }
            
            System.out.print("\nSelecione o id do usuário da mesma região da publicação desejada: ");
            int id_usuario = input.nextInt();
            System.out.println();
            
        HashSet highestPub = PublicacaoModel.listMaxPublicacaoRegiao(id_usuario, con);
        
        if(!highestPub.isEmpty()){
            Iterator<PublicacaoBean> itHighest = highestPub.iterator();
            
            while(itHighest.hasNext()){
                System.out.println(itHighest.next().toString());
            }
            
        }else{
            System.out.println("\nNada retornou do resultado da consulta. Ou seja, não há perguntas da mesma região deste usuário!\n");
        }
        
        }else{
         System.out.println("\nNão há nenhum usuário cadastrado no sistema!\n");
        }
    }
}
