/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Du_An_DAL;

import Du_An_DTO.CTPTNBH;
import Du_An_DTO.PhieuBaoHanh;
import Du_An_DTO.PhieuTNBH;
import Du_An_HELPER.ChuyenDoi;
import Du_An_HELPER.SQLHelper;
import java.sql.ResultSet;

/**
 *
 * @author Administrator
 */
public class DALBaoHanh {

    public static ResultSet LoadBH() {
        String sql = "SELECT        SanPham.MaSP, SanPham.TenSP, SanPham.ThoiGianBH, HD_Xuat.NgayTao , HD_Xuat.MaKH, CTHD_Xuat.Ma_HD_Xuat, KhachHang.TenKH,  "
                + "                         PhieuBH.Ma_PBH, PhieuBH.TenKhoHang, PhieuBH.DiaChiKhoHang, PhieuBH.SDT_KhoHang, NhanVien.TenNV "
                + "FROM            CTHD_Xuat INNER JOIN "
                + "                         HD_Xuat ON CTHD_Xuat.Ma_HD_Xuat = HD_Xuat.Ma_HD_Xuat INNER JOIN "
                + "                         KhachHang ON HD_Xuat.MaKH = KhachHang.MaKH INNER JOIN "
                + "                         NhanVien ON HD_Xuat.MaNV = NhanVien.MaNV INNER JOIN "
                + "                         PhieuBH ON HD_Xuat.Ma_HD_Xuat = PhieuBH.Ma_HD_Xuat AND KhachHang.MaKH = PhieuBH.MaKH AND NhanVien.MaNV = PhieuBH.MaNV INNER JOIN "
                + "                         SanPham ON CTHD_Xuat.MaSP = SanPham.MaSP";
        return SQLHelper.executeQuery(sql);
    }

    public static ResultSet TimKiem(String TenKH, String SDT) {
        String sql = "{call sp_CheckBH (? ,?)}";
        return SQLHelper.executeQuery(sql, TenKH, SDT);
    }

    public static void ThemPTNBH(PhieuTNBH bh) {
        String sql = "SET DATEFORMAT DMY INSERT INTO [dbo].[PhieuTiepNhanBH] "
                + "           ([Ma_PTNBH],[MaNV],[NgayTao]) "
                + "     VALUES "
                + "           (?, ?, ?)";

        SQLHelper.executeUpdate(sql,
                bh.getMaPTN(),
                bh.getMaNV(),
                ChuyenDoi.LayNgayString(bh.getNgayHenTra()));

    }

    public static void ThemPCTTNBH(CTPTNBH cttn) {
        String sql = "SET DATEFORMAT DMY "
                + "INSERT INTO [dbo].[ChiTiet_PTNBH] "
                + "           ([Ma_PCTTNBH] "
                + "           ,[Ma_HD_Xuat] "
                + "           ,[LyDoLoi] "
                + "           ,[NgayHenTra] "
                + "           ,[SoLuong] "
                + "           ,[Ma_PTNBH] "
                + "           ,[GhiChu]) "
                + "     VALUES "
                + "           (?, ?, ?, ?, ?, ?, ?)";
        SQLHelper.executeUpdate(sql,
                cttn.getMaPCTTNBH(),
                cttn.getMa_HDXuat(),
                cttn.getLyDoLoi(),
                ChuyenDoi.LayNgayString(cttn.getNgayHenTra()),
                cttn.getSoLuong(),
                cttn.getMaPTNBH(),
                cttn.getGhiChu());
    }

    public static ResultSet CountMaPTNBH(String MaPTNBH) {
        String sql = "select Count(*) from PhieuTiepNhanBH where Ma_PTNBH like ?";
        return SQLHelper.executeQuery(sql, "%" + MaPTNBH + "%");
    }

    public static ResultSet GetByMaPTNBH(String MaPTNBH) {
        String sql = "select *  from PhieuTiepNhanBH where Ma_PTNBH = ?";
        return SQLHelper.executeQuery(sql, MaPTNBH);
    }

    public static ResultSet CountMaPCTTNBH(String MaPTNBH) {
        String sql = "select Count(*) from ChiTiet_PTNBH where Ma_PCTTNBH like ?";
        return SQLHelper.executeQuery(sql, "%" + MaPTNBH + "%");
    }

    public static ResultSet GetByMaPCTTNBH(String MaCTPTNBH) {
        String sql = "select *  from ChiTiet_PTNBH where Ma_PCTTNBH = ?";
        return SQLHelper.executeQuery(sql, MaCTPTNBH);
    }

    public static ResultSet GetByMaBH(String MaPTNBH) {
        String sql = "select * from PhieuTiepNhanBH where Ma_PTNBH = ?";
        return SQLHelper.executeQuery(sql, MaPTNBH);
    }

    public static void ThemBH(PhieuBaoHanh bh) {
        String sql = "SET DATEFORMAT DMY INSERT INTO [dbo].[PhieuBH] "
                + "           ([Ma_PBH] "
                + "           ,[TenKhoHang] "
                + "           ,[DiaChiKhoHang] "
                + "           ,[SDT_KhoHang] "
                + "           ,[MaNV] "
                + "           ,[MaKH] "
                + "           ,[Ma_HD_Xuat] "
                + "           ,[NgayMuaSp]) "
                + "     VALUES "
                + "           (?, ?, ?, ?, ?, ?, ?, ?)";

        SQLHelper.executeUpdate(sql,
                bh.getMaPBH(),
                bh.getTenKhoHang(),
                bh.getDiaChiKhoHang(),
                bh.getSDTKhoHang(),
                bh.getMaNV(),
                bh.getMaKH(),
                bh.getMaHDXuat(),
                ChuyenDoi.LayNgayString(bh.getNgayMuaSP()));

    }
    
    
    public static ResultSet CountMaPBH(String MaPBH) {
        String sql = "select Count(*) from PhieuBH where Ma_PBH like ?";
        return SQLHelper.executeQuery(sql, "%" + MaPBH + "%");
    }

    public static ResultSet GetByMaPBH(String MaPBH) {
        String sql = "select *  from PhieuBH where Ma_PBH = ?";
        return SQLHelper.executeQuery(sql, MaPBH);
    }

}
