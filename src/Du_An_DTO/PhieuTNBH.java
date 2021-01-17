/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Du_An_DTO;

import java.util.Date;

/**
 *
 * @author Administrator
 */
public class PhieuTNBH {
    
    String MaPTN;
    String MaNV;
    Date NgayHenTra;

    public PhieuTNBH(String MaPTN, String MaNV, Date NgayHenTra) {
        this.MaPTN = MaPTN;
        this.MaNV = MaNV;
        this.NgayHenTra = NgayHenTra;
    }

    public PhieuTNBH() {
    }
    
    
    

    public String getMaPTN() {
        return MaPTN;
    }

    public void setMaPTN(String MaPTN) {
        this.MaPTN = MaPTN;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public Date getNgayHenTra() {
        return NgayHenTra;
    }

    public void setNgayHenTra(Date NgayHenTra) {
        this.NgayHenTra = NgayHenTra;
    }
    
    
    
    
}
