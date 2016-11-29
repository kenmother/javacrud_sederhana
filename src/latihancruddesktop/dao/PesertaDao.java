/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihancruddesktop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import latihancruddesktop.domain.Peserta;
import latihancruddesktop.utils.DatabaseConnection;

/**
 *
 * @author KENDAY
 */


public class PesertaDao {
    
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
public List<Peserta> getAllPeserta(Connection connection) throws SQLException{
    
    try {
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery("select * from peserta");
    List<Peserta> result = new ArrayList<Peserta>();
    while (resultSet.next()) {
    Peserta p = new Peserta();
    p.setId(resultSet.getInt("id"));
    p.setNama(resultSet.getString("nama"));
    p.setAlamat(resultSet.getString("alamat"));
    p.setNomorInduk(resultSet.getString("nomor_induk"));
    p.setJenisKelamin(resultSet.getString("jenis_kelamin"));
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
}}


public Peserta getPeserta(String id, Connection conn) throws SQLException, Exception {
    try {
    Statement statement = conn.createStatement();
    ResultSet resultSet = statement.executeQuery("select * from peserta where id = " + id);
    Peserta p = new Peserta();
    while (resultSet.next()) {
    p.setId(resultSet.getInt("id"));
    p.setNama(resultSet.getString("nama"));
    p.setAlamat(resultSet.getString("alamat"));
    p.setNomorInduk(resultSet.getString("nomor_induk"));
    p.setJenisKelamin(resultSet.getString("jenis_kelamin"));
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

public void insertPeserta(Peserta peserta, Connection conn) throws SQLException, Exception {
    
    try {
    PreparedStatement preparedStatement = conn
    .prepareStatement("insert into peserta (nomor_induk,nama,jenis_kelamin,alamat) "
    + "values ( ?, ?, ?, ? )");
    preparedStatement.setString(1, peserta.getNomorInduk());
    preparedStatement.setString(2, peserta.getNama());
    preparedStatement.setString(3, peserta.getJenisKelamin());
    preparedStatement.setString(4, peserta.getAlamat());
    preparedStatement.executeUpdate();
    close(null, preparedStatement, null);
    } catch (SQLException ex) {
    ex.printStackTrace();
    throw new SQLException("Error Insert to table peserta : " + ex.getMessage());
    }
    }

public void editPeserta(Peserta peserta, Connection conn) throws SQLException, Exception {
    try{
    
        
    PreparedStatement preparedStatement=DatabaseConnection.getConnection().prepareStatement("update peserta set nomor_induk=?,nama=?,jenis_kelamin=?,alamat=? where id=?");
        
    preparedStatement.setString(1, peserta.getNomorInduk());
    preparedStatement.setString(2, peserta.getNama());
    preparedStatement.setString(3, peserta.getJenisKelamin());
    preparedStatement.setString(4, peserta.getAlamat());
    preparedStatement.setInt(5, peserta.getId());
    preparedStatement.executeUpdate();
    
    close(null, preparedStatement, null);
    } catch (SQLException ex) {
    ex.printStackTrace();
    throw new SQLException("Error Edit to table peserta : " + ex.getMessage());
    }
    
    }

public void hapusPeserta(Peserta peserta, Connection conn) throws SQLException, Exception {
    try{
        PreparedStatement preparedStatement=DatabaseConnection.getConnection().prepareStatement("delete from peserta where id=?");
        preparedStatement.setInt(1, peserta.getId());
        preparedStatement.executeUpdate();
    
     close(null, preparedStatement, null);
    } catch (SQLException ex) {
    ex.printStackTrace();
    throw new SQLException("Error Delete to table peserta : " + ex.getMessage());
    }


    
}
}
