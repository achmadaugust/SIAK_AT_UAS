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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import sysinfoakademikat.Mahasiswa;
/**
 *
 * @author AT
 */
public class MahasiswaD {
    
    private Connection conn;
    private PreparedStatement insertStmt;
    private PreparedStatement updateStmt;
    private PreparedStatement deleteStmt;
    private PreparedStatement getByNpmStmt;
    private PreparedStatement getAllStmt;
    
    private final String insertQuery = "insert into t_mahasiswa(npm,nama," + 
            "tmp_lahir,tgl_lahir,jurusan,jn_klamin,alamat) values(?,?,?,?,?,?,?)";
    private final String updateQuery = "update t_mahasiswa set nama=?, "
            + " tmp_lahir=?, tgl_lahir=?, jurusan=?, jn_klamin=?, alamat=?"
            + " where npm=?";
    private final String deleteQuery = "delete from t_mahasiswa where npm=?";
    private final String getByIdQuery = "select * from t_mahasiswa where npm =?";
    private final String getAllQuery = "select * from t_mahasiswa";
    
    public void setConn(Connection conn) throws SQLException {
        this.conn = conn;
        insertStmt = this.conn.prepareStatement(insertQuery);
        updateStmt = this.conn.prepareStatement(updateQuery);
        deleteStmt = this.conn.prepareStatement(deleteQuery);
        getByNpmStmt = this.conn.prepareStatement(getByIdQuery);
        getAllStmt = this.conn.prepareStatement(getAllQuery);
    }
    
    public Mahasiswa save(Mahasiswa mhs) throws SQLException{
        if (mhs.getNpm() != 0){
            insertStmt.setInt(1, mhs.getNpm());
            insertStmt.setString(2, mhs.getNama());
            insertStmt.setString(3, mhs.getTmpLahir());
            insertStmt.setString(4, mhs.getTglLahir());
            insertStmt.setString(5, mhs.getJurusan());
            insertStmt.setString(6, mhs.getjKlamin());
            insertStmt.setString(7, mhs.getAlamat());
            int npm = (int) insertStmt.executeUpdate();
            mhs.setNpm(npm);
        } else {
            updateStmt.setString(1, mhs.getNama());
            updateStmt.setString(2, mhs.getTmpLahir());
            updateStmt.setString(3, mhs.getTglLahir());
            updateStmt.setString(4, mhs.getJurusan());
            updateStmt.setString(5, mhs.getjKlamin());
            updateStmt.setString(6, mhs.getAlamat());
            updateStmt.setInt(7, mhs.getNpm());
            updateStmt.executeUpdate();
        }
        return mhs;
    }
    
    public Mahasiswa delete(Mahasiswa mhs) throws SQLException{
        deleteStmt.setInt(1, mhs.getNpm());
        deleteStmt.executeUpdate();
        return mhs;
    }
    
    public Mahasiswa getByNpm(int npm) throws SQLException{
        getByNpmStmt.setInt(1, npm);
        ResultSet rs = getByNpmStmt.executeQuery();
        if (rs.next()){
            Mahasiswa mhs = new Mahasiswa();
            mhs.setNpm(rs.getInt("npm"));
            mhs.setNama(rs.getString("nama"));
            mhs.setTmpLahir(rs.getString("tmp_lahir"));
            mhs.setTglLahir(rs.getString("tgl_lahir"));
            mhs.setJurusan(rs.getString("jurusan"));
            mhs.setjKlamin(rs.getString("jn_klamin"));
            mhs.setAlamat(rs.getString("alamat"));
            return mhs;            
        }
        return null;
    }
    
    public List<Mahasiswa> getAllMhs() throws SQLException{
        List<Mahasiswa> mahasiswas = new ArrayList<>();
        ResultSet rs = getAllStmt.executeQuery();
        while (rs.next()){
            Mahasiswa mhs = new Mahasiswa();
            mhs.setNpm(rs.getInt("npm"));
            mhs.setNama(rs.getString("nama"));
            mhs.setTmpLahir(rs.getString("tmp_lahir"));
            mhs.setTglLahir(rs.getString("tgl_lahir"));
            mhs.setJurusan(rs.getString("jurusan"));
            mhs.setjKlamin(rs.getString("jn_klamin"));
            mhs.setAlamat(rs.getString("alamat"));
            mahasiswas.add(mhs);
        }
        return mahasiswas;
    }
}
