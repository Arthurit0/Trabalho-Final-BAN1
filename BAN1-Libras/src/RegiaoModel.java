
import java.sql.Connection;
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
public class RegiaoModel {
    static HashSet listAll(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
            st = con.createStatement();
            String sql = "SELECT id, cidade, estado FROM regiao ORDER BY id";
            ResultSet result = st.executeQuery(sql);
            while(result.next()) {
                list.add(new RegiaoBean(result.getInt(1), result.getString(2), result.getString(3)));
            }
        return list;
    }
}
