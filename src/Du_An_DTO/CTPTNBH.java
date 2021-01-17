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
public class CTPTNBH {
    String MaPCTTNBH;
    String Ma_HDXuat;
    String LyDoLoi;
    Date NgayHenTra;
    int SoLuong;
    String MaPTNBH;
    String GhiChu;

    public CTPTNBH() {
    }

    public CTPTNBH(String MaPCTTNBH, String Ma_HDXuat, String LyDoLoi, Date NgayHenTra, int SoLuong, String MaPTNBH, String GhiChu) {
        this.MaPCTTNBH = MaPCTTNBH;
        this.Ma_HDXuat = Ma_HDXuat;
        this.LyDoLoi = LyDoLoi;
        this.NgayHenTra = NgayHenTra;
        this.SoLuong = SoLuong;
        this.MaPTNBH = MaPTNBH;
        this.GhiChu = GhiChu;
    }
    
    
    
    

    public String getMaPCTTNBH() {
        return MaPCTTNBH;
    }

    public void setMaPCTTNBH(String MaPCTTNBH) {
        this.MaPCTTNBH = MaPCTTNBH;
    }

    public String getMa_HDXuat() {
        return Ma_HDXuat;
    }

    public void setMa_HDXuat(String Ma_HDXuat) {
        this.Ma_HDXuat = Ma_HDXuat;
    }

    public String getLyDoLoi() {
        return LyDoLoi;
    }

    public void setLyDoLoi(String LyDoLoi) {
        this.LyDoLoi = LyDoLoi;
    }

    public Date getNgayHenTra() {
        return NgayHenTra;
    }

    public void setNgayHenTra(Date NgayHenTra) {
        this.NgayHenTra = NgayHenTra;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getMaPTNBH() {
        return MaPTNBH;
    }

    public void setMaPTNBH(String MaPTNBH) {
        this.MaPTNBH = MaPTNBH;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }
    
    
    
    
    
    
    
}
