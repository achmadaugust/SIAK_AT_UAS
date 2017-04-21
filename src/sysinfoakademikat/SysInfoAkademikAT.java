/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysinfoakademikat;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import sysinfoakademikat.*;

/**
 *
 * @author AT
 */
public class SysInfoAkademikAT {

    public static void main(String[] args) {
        
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("achmad");
        dataSource.setDatabaseName("siakat?serverTimezone=UTC");
        dataSource.setServerName("localhost");
        dataSource.setPortNumber(3306);
        
        Service service = new Service();
        service.setDataSource(dataSource);
        
        Scanner in = new Scanner(System.in);
        
        Boolean login = false;
//        Petugas petugas = null;
        
//        while (!login) {
//            System.out.println("Silakan login terlebih dahulu!\n");
//            System.out.print("Username : ");
//            String username = in.nextLine();
//            System.out.print("Password : ");
//            String password = in.nextLine();
//
//            petugas = service.checkLogin(username, password);
//
//            if (petugas != null) {
//                loggedin = true;
//                System.out.println("\nSelamat datang, " + petugas.getNama() + "!");
//                
                while (!login) {
                    System.out.println("Menu System Informasi Akademi");
                    System.out.println("11. Tambah Data Mahasiswa");
                    System.out.println("12. Update Data Mahasiswa");
                    System.out.println("13. Hapus Data Mahasiswa");
                    System.out.println("14. Lihat Data Mahasiswa");
                    System.out.println("15. Lihat Semua Data Mahasiswa");
                    System.out.println("2. Tambah Data Mata Kuliah");
                    System.out.println("3. Tambah Data Nilai");
                    System.out.println("4. Lihat Data Nilai");
//                    System.out.println();
//                    System.out.println();
//                    System.out.println();
//                    System.out.println();
                    System.out.print("Pilih : ");
                    String pilihan = in.nextLine();
                    switch (Integer.parseInt(pilihan)) {
                        case 11:
                            System.out.print("NPM : ");
                            String npm = in.nextLine();
                            System.out.print("Nama : ");
                            String nama = in.nextLine();
                            System.out.print("Tempat Lahir : ");
                            String tmpLahir = in.nextLine();
                            System.out.print("Tanggal Lahir : ");
                            String tglLahir = in.nextLine();
                            System.out.print("Jurusan : ");
                            String jurusan = in.nextLine();
                            System.out.print("Jenis Kelamin : ");
                            String jKlamin = in.nextLine();
                            System.out.print("Alamat : ");
                            String alamat = in.nextLine();
                            System.out.print("Simpan data? (y/t) : ");
                            String tambah = in.nextLine();
                            if (tambah.toUpperCase().equals("Y")){
                                Mahasiswa mhs = new Mahasiswa();
                                mhs.setNpm(Integer.parseInt(npm));
                                mhs.setNama(nama);
                                mhs.setTmpLahir(tmpLahir);
                                mhs.setTglLahir(tglLahir);
                                mhs.setJurusan(jurusan);
                                mhs.setjKlamin(jKlamin);
                                mhs.setAlamat(alamat);
                                service.save(mhs);                                                
                            }
                            break;
                        case 12:
                            System.out.print("NPM : ");
                            npm = in.nextLine();
                            Mahasiswa mhs_x = service.getMahasiswa(Integer.parseInt(npm));
                            if (mhs_x == null) {
                                System.out.println("Tidak ditemukan mahasiswa dengan NPM " + npm);
                                break;
                            }
                            System.out.print("Nama : ");
                            String nama_x = in.nextLine();
                            System.out.print("Tempat Lahir : ");
                            String tmpLahir_x = in.nextLine();
                            System.out.print("Tanggal Lahir : ");
                            String tglLahir_x = in.nextLine();
                            System.out.print("Jurusan : ");
                            String jurusan_x = in.nextLine();
                            System.out.print("Jenis Kelamin : ");
                            String jKlamin_x = in.nextLine();
                            System.out.print("Alamat : ");
                            String alamat_x = in.nextLine();
                            System.out.print("Simpan data? (y/t) : ");
                            String tambah_x = in.nextLine();
                            if (tambah_x.toUpperCase().equals("Y")){
//                                Mahasiswa mhs = new Mahasiswa();
                                mhs_x.setNpm(Integer.parseInt(npm));
                                mhs_x.setNama(nama_x);
                                mhs_x.setTmpLahir(tmpLahir_x);
                                mhs_x.setTglLahir(tglLahir_x);
                                mhs_x.setJurusan(jurusan_x);
                                mhs_x.setjKlamin(jKlamin_x);
                                mhs_x.setAlamat(alamat_x);
                                service.save(mhs_x);
                            }
                        break;
                        case 13:
                            System.out.print("NPM : ");
                            npm = in.nextLine();
                            Mahasiswa mhs_d = service.getMahasiswa(Integer.parseInt(npm));
                            if (mhs_d == null) {
                                System.out.println("Tidak ditemukan mahasiswa dengan NPM " + npm);
                                break;
                            }
                            System.out.print("Hapus data? (y/t) : ");
                            String hapus = in.nextLine();
                            if (hapus.toUpperCase().equals("y")){
                                service.delete(mhs_d);
                            }
                        break;
                        case 14:
                            System.out.print("NPM : ");
                            npm = in.nextLine();
                            Mahasiswa mhs_s = service.getMahasiswa(Integer.parseInt(npm));
                            if (mhs_s == null) {
                                System.out.println("Tidak ditemukan mahasiswa dengan NPM " + npm);
                                break;
                            } else {
                                System.out.println("\n+------------------------------------------------------------------------------------------------------------------+");
                                System.out.println("| Npm  \t     | Nama\t\t| Tempat Tanggal Lahir\t\t| Jurusan\t\t| Jenis Kelamin | Alamat   |");
                                System.out.println("+------------------------------------------------------------------------------------------------------------------+");
                                System.out.println("| "+mhs_s.getNpm()+"    | "+mhs_s.getNama()+"\t| "+mhs_s.getTmpLahir()+"\t| "+mhs_s.getTglLahir()+"\t| "+mhs_s.getJurusan()+"\t| "+mhs_s.getjKlamin()+"\t| "+mhs_s.getAlamat()+"  |");
                                System.out.println("+------------------------------------------------------------------------------------------------------------------+");
                            }
                        break;
                        case 15:
                            List<Mahasiswa> mahasiswas = service.getAllMhs();
                            if (mahasiswas.isEmpty()){
                                System.out.println("\nBelum ada data");
                            } else {
                                System.out.println("\n+------------------------------------------------------------------------------------------------------------------+");
                                System.out.println("| Npm  \t     | Nama\t\t| Tempat Tanggal Lahir\t\t| Jurusan\t\t| Jenis Kelamin | Alamat   |");
                                System.out.println("+------------------------------------------------------------------------------------------------------------------+");
//                                Mahasiswa mhs = new Mahasiswa();
//                                MataKuliah mk = new MataKuliah();
                                mahasiswas.forEach((mahasiswa) -> {
                                    System.out.println("| "+mahasiswa.getNpm()+"    | "+mahasiswa.getNama()+"\t| "+mahasiswa.getTmpLahir()+"\t "+mahasiswa.getTglLahir()+"\t| "+mahasiswa.getJurusan()+"\t| "+mahasiswa.getjKlamin()+"\t| "+mahasiswa.getAlamat()+"  |");
                                });
                                System.out.println("+------------------------------------------------------------------------------------------------------------------+");
                                System.out.println();
                            }
                        break;
                        case 2:
                            System.out.print("Id Mata Kuliah : ");
                            String idMk = in.nextLine();
                            System.out.print("Nama Mata Kuliah : ");
                            String namaMk = in.nextLine();
                            System.out.print("SKS : ");
                            String sks = in.nextLine();
                            System.out.print("Simpan data? (y/t) : ");
                            tambah = in.nextLine();
                            if (tambah.toUpperCase().equals("Y")){
                                MataKuliah mk = new MataKuliah();
                                mk.setIdMk(Integer.parseInt(idMk));
                                mk.setNamaMk(namaMk);
                                mk.setSks(Integer.parseInt(sks));
                                service.save(mk);
                            }
                            break;
                        case 3:
                            System.out.print("NPM : ");
                            npm = in.nextLine();
                            System.out.print("Id Mata Kuliah : ");
                            idMk = in.nextLine();
                            System.out.print("Nilai : ");
                            String nAngka = in.nextLine();
                            System.out.print("Simpan data? (y/t) : ");
                            tambah = in.nextLine();
                            if (tambah.toUpperCase().equals("Y")){
                                Nilai nilai = new Nilai();
                                nilai.setNpm(Integer.parseInt(npm));
                                nilai.setIdMk(Integer.parseInt(idMk));
                                nilai.setnAngka(Integer.parseInt(nAngka));
                                service.save(nilai);
                            }
                            break;
                        case 4:
                            List<Nilai> nilais = service.getAll();
                            if (nilais.isEmpty()){
                                System.out.println("\nBelum ada data");
                            } else {
                                System.out.println("\n+------------------------------------------------------------------------------------+");
                                System.out.println("| No.  | Npm\t\t| Nama\t\t| Mata Kuliah\t\t\t| SKS\t| NA |");
                                System.out.println("+------------------------------------------------------------------------------------+");
                                MataKuliah mk = new MataKuliah();
                                nilais.forEach((nilai) -> {
                                    System.out.println("| "+nilai.getId()+"    | "+nilai.getNpm()+"\t| "+nilai.getNama()+"\t| "+nilai.getNamaMk()+"\t| "+nilai.getSks()+"\t| "+nilai.getnHuruf()+"  |");
                                });
                                System.out.println("+------------------------------------------------------------------------------------+");
                                System.out.println();
                            }
                            break;
//                        case 5:
//                            break;
//                        case 6:
//                            System.out.println("\nAnda telah berhasil keluar!\n");
//                            petugas = null;
//                            loggedin = false;
//                            break;
                        default:
                            break;
                    }
                }
                
//            } else {
//                System.out.println("\nUsername atau password yang anda masukkan salah!\n");
//            }
//        }
       
        try {
            dataSource.getConnection().close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
