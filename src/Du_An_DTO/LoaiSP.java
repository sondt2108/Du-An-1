/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Du_An_DTO;

/**
 *
 * @author Administrator
 */
public class LoaiSP {
    String MaLoaiSP;
    String TenLoaiSP;
    String MoTa;

    public LoaiSP() {
    }

    public LoaiSP(String MaLoaiSP, String TenLoaiSP, String MoTa) {
        this.MaLoaiSP = MaLoaiSP;
        this.TenLoaiSP = TenLoaiSP;
        this.MoTa = MoTa;
    }

    public LoaiSP(String TenLoaiSP, String MoTa) {
        this.TenLoaiSP = TenLoaiSP;
        this.MoTa = MoTa;
    }

    public String getMaLoaiSP() {
        return MaLoaiSP;
    }

    public void setMaLoaiSP(String MaLoaiSP) {
        this.MaLoaiSP = MaLoaiSP;
    }

    public String getTenLoaiSP() {
        return TenLoaiSP;
    }

    public void setTenLoaiSP(String TenLoaiSP) {
        this.TenLoaiSP = TenLoaiSP;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }
    
    
}
