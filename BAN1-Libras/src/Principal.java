/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author rebeca
 */
public class Principal {

    public static void main(String[] args) throws SQLException, ParseException {
        Conexao c = new Conexao();
        Connection con = c.getConnection();
        int op = 0;
        do{
            op = menu();
            
            for(int i=0; i<1000; i++){
                System.out.println();
            }
            
            try {
                switch (op) {
                    case 1: new UsuarioController().createUsuario(con);
                            break;
                    case 2: new PublicacaoController().createPublicacao(con);
                            break;
                    case 3: new UsuarioController().listUsuarios(con);
                            break;
                    case 4: new PublicacaoController().listPublicacoes(con);
                            break;
                    case 5: new PublicacaoController().listPublicacoesEUsuarios(con);
                            break;
                    case 6: new PublicacaoController().listPubsSameRegionAsUser(con);
                        break;
                    
                }
                
                System.out.println("Pressione enter para continuar...");
                Scanner input = new Scanner(System.in);
                String enter = input.nextLine();
                
            }catch(SQLException ex) {
                //ex.printStackTrace();
                System.out.println(ex.getMessage());
                continue;
            }
        } while(op>0 && op<7);  
        con.close();
    }    
    
    private static int menu() {
        System.out.println("");
        System.out.println("Informe o n??mero da op????o que desejas executar: ");
        System.out.println("1 - Inserir um novo Usu??rio");
        System.out.println("2 - Inserir uma nova Publica????o");
        System.out.println("3 - Exibir todos os usu??rios");
        System.out.println("4 - Exibir todas as publica????es");
        System.out.println("5 - Exibir publica????es com os dados de seus usu??rios autores");
        System.out.println("6 - Exibir pergunta com mais likes da mesma regi??o de um usu??rio (n??o autor da pergunta)");
        System.out.println("Digite qualquer outro valor para sair");
        System.out.print("Sua op????o: ");
        Scanner input = new Scanner(System.in);
            return input.nextInt();
    }
}
