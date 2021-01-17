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
public class HangSX {
    String MaHangSX;
    String TenHangSX;
    String GhiChu;

    public HangSX() {
    }

    public HangSX(String MaHangSX, String TenHangSX, String GhiChu) {
        this.MaHangSX = MaHangSX;
        this.TenHangSX = TenHangSX;
        this.GhiChu = GhiChu;
    }

    public HangSX(String TenHangSX, String GhiChu) {
        this.TenHangSX = TenHangSX;
        this.GhiChu = GhiChu;
    }

    public String getMaHangSX() {
        return MaHangSX;
    }

    public void setMaHangSX(String MaHangSX) {
        this.MaHangSX = MaHangSX;
    }

    public String getTenHangSX() {
        return TenHangSX;
    }

    public void setTenHangSX(String TenHangSX) {
        this.TenHangSX = TenHangSX;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }
    
    
    
    
}
