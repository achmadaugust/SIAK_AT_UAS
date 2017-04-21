/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysinfoakademikat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import sysinfoakademikat.MataKuliah;
/**
 *
 * @author AT
 */
public class MataKuliahD {
    
    private Connection conn;
    private PreparedStatement insertStmt;
    
    private final String insertQuery = "insert into t_matakuliah(id_mk,nama_mk," +
            "sks) values(?,?,?)";
    
    public void setConn(Connection conn) throws SQLException {
        this.conn = conn;
        insertStmt = this.conn.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
    }
    
    public MataKuliah save(MataKuliah mk) throws SQLException{
        insertStmt.setInt(1, mk.getIdMk());
        insertStmt.setString(2, mk.getNamaMk());
        insertStmt.setInt(3, mk.getSks());
        insertStmt.executeUpdate();
        return mk;
    }

}
