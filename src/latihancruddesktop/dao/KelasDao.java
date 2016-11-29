/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihancruddesktop.dao;

/**
 *
 * @author KENDAY
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;import java.util.ArrayList;
import java.util.List;
import latihancruddesktop.domain.Kelas;
import latihancruddesktop.domain.Peserta;
import latihancruddesktop.utils.DatabaseConnection;

public class KelasDao {
    
   private void close(ResultSet resultSet, Statement statement, Connection conn) throws Exception
{
     try {
        if (resultSet != null) {
        resultSet.close();
        }
        if (statement != null) {
        statement.close();
        }
        if (conn != null) {
        conn.close();
        }
        } catch (Exception e) {
        throw new Exception("Error clossing connections");
        }
}
   
   public List<Kelas> getAllKelas(Connection connection) throws SQLException{
    
    try {
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery("select * from kelas");
    List<Kelas> result = new ArrayList<Kelas>();
    while (resultSet.next()) {
    Kelas p = new Kelas();
    p.setId(resultSet.getInt("id"));
    p.setNama_kelas(resultSet.getString("nama_kelas"));
    p.setNama_peserta(resultSet.getString("nama_peserta"));
    result.add(p);
    }
    
close(resultSet, statement, null);
return result;
} catch (SQLException ex) {
ex.printStackTrace();
throw new SQLException("Cannot read database : " + ex.getMessage());
} catch (Exception ex) {
ex.printStackTrace();
throw new SQLException("System Error : " + ex.getMessage());
}
   }
   
   
public Kelas getKelas(String id, Connection conn) throws SQLException, Exception {
    
    try {
        
    Statement statement = conn.createStatement();
    ResultSet resultSet = statement.executeQuery("select * from kelas where id = " + id);
    Kelas p = new Kelas();
    while (resultSet.next()) {
    p.setId(resultSet.getInt("id"));
    p.setNama_kelas(resultSet.getString("nama_kelas"));
    p.setNama_peserta(resultSet.getString("nama_peserta"));
    }
    close(resultSet, statement, null);
    return p;
    } catch (SQLException ex) {
    ex.printStackTrace();
    throw new SQLException("Cannot read database : " + ex.getMessage());
    } catch (Exception ex) {
    ex.printStackTrace();
    throw new SQLException("System Error : " + ex.getMessage());
    }
}

public void insertKelas(Kelas kelas, Connection conn) throws SQLException, Exception {
    
    try {
    PreparedStatement preparedStatement = conn
    .prepareStatement("insert into kelas (nama_kelas,nama_peserta) "
    + "values ( ?, ? )");
    preparedStatement.setString(1, kelas.getNama_kelas());
    preparedStatement.setString(2, kelas.getNama_peserta());
    preparedStatement.executeUpdate();
    close(null, preparedStatement, null);
    } catch (SQLException ex) {
    ex.printStackTrace();
    throw new SQLException("Error Insert to table kelas : " + ex.getMessage());
    }
    }

public void editKelas(Kelas kelas, Connection conn) throws SQLException, Exception {
    try{
    
        
    PreparedStatement preparedStatement=DatabaseConnection.getConnection().prepareStatement("update kelas set nama_kelas=?,nama_peserta=? where id=?");
        
    preparedStatement.setString(1, kelas.getNama_kelas());
    preparedStatement.setString(2, kelas.getNama_peserta());
    preparedStatement.setInt(3, kelas.getId());
    preparedStatement.executeUpdate();
    
    close(null, preparedStatement, null);
    } catch (SQLException ex) {
    ex.printStackTrace();
    throw new SQLException("Error Edit to table kelas : " + ex.getMessage());
    }
    
    }

public void hapusKelas(Kelas kelas, Connection conn) throws SQLException, Exception {
    try{
        PreparedStatement preparedStatement=DatabaseConnection.getConnection().prepareStatement("delete from kelas where id=?");
        preparedStatement.setInt(1, kelas.getId());
        preparedStatement.executeUpdate();
    
     close(null, preparedStatement, null);
    } catch (SQLException ex) {
    ex.printStackTrace();
    throw new SQLException("Error Delete to table kelas : " + ex.getMessage());
    }


    
}
    
}
