package latihancruddesktop.domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KENDAY
 */
public class Peserta {
    
private int id;
private String nomorInduk;
private String nama;
private String jenisKelamin;
private String alamat;

public int getId() {
return id;
}
public void setId(int id) {
this.id = id;
}
public String getNomorInduk() {
return nomorInduk;
}public void setNomorInduk(String nomorInduk) {
this.nomorInduk = nomorInduk;
}
public String getNama() {
return nama;
}
public void setNama(String nama) {
this.nama = nama;
}
public String getJenisKelamin() {
return jenisKelamin;
}
public void setJenisKelamin(String jenisKelamin) {
this.jenisKelamin = jenisKelamin;
}
public String getAlamat() {
return alamat;
}
public void setAlamat(String alamat) {
this.alamat = alamat;
}
    
}
