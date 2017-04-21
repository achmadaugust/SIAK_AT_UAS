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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import sysinfoakademikat.Nilai;
/**
 *
 * @author AT
 */
public class NilaiD {
    private Connection conn;
    private PreparedStatement insertStmt;
    private PreparedStatement getAllStmt;
    
    private final String insertQuery = "insert into t_nilai(npm,id_mk,nilai) " +
            "values(?,?,?)";
    private final String getAllQuery = "select t_nilai.nomor, t_mahasiswa.npm,"
            + "t_mahasiswa.nama, t_matakuliah.nama_mk, t_matakuliah.sks,"
            + "case "
            + "when nilai >= 80 then 'A'"
            + "when nilai >= 70 then 'B'"
            + "when nilai >= 60 then 'C'"
            + "when nilai >= 50 then 'D'"
            + "else 'E'"
            + "end "
            + "as n_akhir "
            + "from t_nilai,t_mahasiswa,t_matakuliah "
            + "where t_nilai.id_mk=t_matakuliah.id_mk and t_nilai.npm=t_mahasiswa.npm "
            + "order by nomor;";
    
    public void setConn(Connection conn) throws SQLException {
        this.conn = conn;
        insertStmt = this.conn.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
        getAllStmt = this.conn.prepareStatement(getAllQuery);
    }
    
    public Nilai save(Nilai nilai) throws SQLException{
        insertStmt.setInt(1, nilai.getNpm());
        insertStmt.setInt(2, nilai.getIdMk());
        insertStmt.setInt(3, nilai.getnAngka());
        insertStmt.executeUpdate();
        return nilai;
    }
    
    public List<Nilai> getAll() throws SQLException{
        List<Nilai> nilais = new ArrayList<>();
        ResultSet rs = getAllStmt.executeQuery();
        while(rs.next()){
            Nilai nilai = new Nilai();
            nilai.setId(rs.getInt("t_nilai.nomor"));
            nilai.setNpm(rs.getInt("t_mahasiswa.npm"));
            nilai.setNama(rs.getString("t_mahasiswa.nama"));
            nilai.setNamaMk(rs.getString("t_matakuliah.nama_mk"));
            nilai.setSks(rs.getInt("t_matakuliah.sks"));
            nilai.setnHuruf(rs.getString("n_akhir"));
            nilais.add(nilai);
        }
        return nilais;
    }

}
