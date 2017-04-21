/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysinfoakademikat;

import sysinfoakademikat.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
/**
 *
 * @author AT
 */
public class Service {
    
    private MahasiswaD mhsD;
    private MataKuliahD mkD;
    private NilaiD nilaiD;
    private Connection conn;
    public void setDataSource(DataSource dataSource){
        try {
            conn = dataSource.getConnection();
            mhsD = new MahasiswaD();
            mhsD.setConn(conn);
            mkD = new MataKuliahD();
            mkD.setConn(conn);
            nilaiD = new NilaiD();
            nilaiD.setConn(conn);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public Mahasiswa save(Mahasiswa mhs){
        try {
            conn.setAutoCommit(false);
            mhsD.save(mhs);
            conn.commit();
            conn.setAutoCommit(true);
        } catch (SQLException ex) {
            try {
                conn.rollback();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return mhs;
    }
    
    public Mahasiswa delete(Mahasiswa mhs){
        try {
            conn.setAutoCommit(false);
            mhsD.delete(mhs);
            conn.commit();
            conn.setAutoCommit(true);
        } catch (SQLException ex) {
            try {
                conn.rollback();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return mhs;
    }
    
    public Mahasiswa getMahasiswa(int npm){
        try {
            return mhsD.getByNpm(npm);
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    public List<Mahasiswa> getAllMhs(){
        try {
            return mhsD.getAllMhs();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public MataKuliah save(MataKuliah mk){
        try {
            conn.setAutoCommit(false);
            mkD.save(mk);
            conn.commit();
            conn.setAutoCommit(true);
        } catch (SQLException ex) {
            try {
                conn.rollback();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return mk;
    }
    
    public Nilai save(Nilai nilai){
        try {
            conn.setAutoCommit(false);
            nilaiD.save(nilai);
            conn.commit();
            conn.setAutoCommit(true);
        } catch (SQLException ex) {
            try {
                conn.rollback();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return nilai;
    }
    
    public List<Nilai> getAll(){
        try {
            return nilaiD.getAll();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
