
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author desenv06
 */
public class UsuarioModel {
    public static void create(UsuarioBean u, Connection con) throws SQLException {
        PreparedStatement st;
            st = con.prepareStatement("INSERT INTO usuario (nome, email, id_regiao, avaliacao, instituicao, profissao, senha, cont_denuncias, is_adm) VALUES (?,?,?,?,?,?,?,?,?)");
            st.setString(1, u.getNome());
            st.setString(2, u.getEmail());
            st.setInt(3, u.getRegiao());
            st.setFloat(4, u.getAvaliacao());
            st.setString(5, u.getInstituicao());
            st.setString(6, u.getProfissao());
            st.setString(7, u.getSenha());
            st.setInt(8, u.getContadorDeDenuncias());
            st.setBoolean(9, u.getIsAdm());
            st.execute();
            st.close();  
    }

    static HashSet listAll(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
            st = con.createStatement();
            String sql = "SELECT id, nome, email, id_regiao, avaliacao, instituicao, profissao, senha, cont_denuncias, is_adm FROM usuario ORDER BY id";
            ResultSet res = st.executeQuery(sql);
            while(res.next()) {
                list.add(new UsuarioBean(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4), res.getFloat(5), res.getString(6), res.getString(7), res.getString(8), res.getInt(9), res.getBoolean(10)));
            }
        return list;
    }
}
