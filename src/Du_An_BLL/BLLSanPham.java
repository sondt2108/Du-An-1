/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Du_An_BLL;

import Du_An_DAL.DALHangSX;
import Du_An_DAL.DALLoaiSP;
import Du_An_DAL.DALSanPham;
import Du_An_DTO.SanPham;
import Du_An_HELPER.ChuyenDoi;
import Du_An_HELPER.ThongBao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class BLLSanPham {
    
    
    public static void LoadSanPham(JTable tblDanhSach) {

        DefaultTableModel tbModel = (DefaultTableModel) tblDanhSach.getModel();
        tbModel.setRowCount(0); // sét số dòng trong bảng về 0
        // Lấy dự liệu danh sách nhân viên từ DAL
        ResultSet rs = DALSanPham.getALLSanPham();
        //ResultSet ls = DALLoaiSP.getALL;
        Object obj[] = new Object[13];
        try {
            while (rs.next()) {

                obj[0] = tbModel.getRowCount() + 1;
                obj[1] = rs.getString("MaSP");
                obj[2] = rs.getString("TenSP");
                obj[3] = rs.getInt("SoLuong");
                obj[4] = rs.getString("DonViTinh");
                obj[5] = ChuyenDoi.LaySoString(rs.getDouble("GiaNhap"));
                obj[6] = ChuyenDoi.LaySoString(rs.getDouble("GiaBan"));
                obj[7] = ChuyenDoi.LayNgayString(rs.getDate("NgayNhap"));
                obj[8] = LayTenLoaiSP(rs.getString("MaLoaiSP"));
                obj[9] = LayTenHangSX(rs.getString("MaHangSX"));
                obj[10] = (rs.getString("ThoiGianBH"));
                obj[11] = rs.getString("HinhAnh");
                obj[12] = rs.getString("GhiChu");
                // Thêm obj vào table 
                tbModel.addRow(obj);

            }
        } catch (SQLException e) {
            ThongBao.ThongBaoDangNhap("Thông Báo Lỗi", "Lỗi Lấy Danh Sách Sản Phẩm");
        }
    }
    
    public static String LayTenLoaiSP(String MaLoaiSP) {
        ResultSet rs = DALLoaiSP.GetTenLoaiSP(MaLoaiSP);
        try {
            if(rs.next()) {
                return rs.getString("TenLoaiSP");
            }
        } catch (SQLException ex) {
            ThongBao.ThongBaoSQL("Thông báo", "Lỗi lấy tên loại sản phẩm");
        }
        return "";
    }
    
    public static String LayTenHangSX(String MaHangSX) {
        ResultSet rs = DALHangSX.GetTenHangSX(MaHangSX);
        try {
            if(rs.next()) {
                return rs.getString("TenHangSX");
            }
        } catch (SQLException ex) {
            ThongBao.ThongBaoSQL("Thông báo", "Lỗi lấy tên loại sản phẩm");
        }
        return "";
    }
    
    //Láy sản phẩm theo mã
    public static SanPham LaySanPhamTheoMa(String MaSP) {
        ResultSet rs = DALSanPham.getSanPham(MaSP);
        try {
            if (rs.next()) {
                // Nếu Có Nhân Viên 
                SanPham sp = new SanPham();
                sp.setMaSanPham(rs.getString("MaSP"));
                sp.setTenSanPham(rs.getString("TenSP"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setDonViTinh(rs.getString("DonViTinh"));
                sp.setGiaNhap(rs.getDouble("GiaNhap"));
                sp.setGiaBan(rs.getDouble("GiaBan"));
                sp.setNgayNhap(rs.getDate("NgayNhap"));
                sp.setMaLoaiSP(rs.getString("MaLoaiSP"));
                sp.setMaHangSX(rs.getString("MaHangSX"));
                sp.setThoiGianBH(rs.getString("ThoiGianBH"));
                sp.setHinhAnh(rs.getString("HinhAnh"));
                sp.setGhiChu(rs.getString("GhiChu"));
                
                return sp;

            }
        } catch (SQLException e) {
            ThongBao.ThongBaoDangNhap("Thông Báo", "Lỗi Lấy Sản Phẩm Theo Mã");
        }
        return null;
    }
    
    
    
    public static void ThemSanPham(SanPham sp) {

       
        DALSanPham.ThemSanPham(sp);
    }
    
    // Hàm tạo mã sản phẩm
    public static String TaoSP(){
        String SP = "";
        try {

            SP = "SP";
            ResultSet rs = DALSanPham.CountMaSP(SP);
            int rowCount = 0;
            if (rs.next()) {
                rowCount = rs.getInt(1);
            }
            boolean dup = false;
            do {
                if (rowCount > 98) {
                    SP = SP + (rowCount + 1);
                } else if (rowCount > 8) {
                    SP = SP + "0" + (rowCount + 1);
                } else {
                    SP = SP + "00" + (rowCount + 1);
                }
                System.out.println("SP: " + SP);
                ResultSet rs2 = DALSanPham.GetByMaSP(SP);
                if (rs2.next()) {
                    dup = true;
                    rowCount++;
                    
                } else {
                    dup = false;
                }
            } while (dup);

        } catch (SQLException ex) {
            System.out.println("Lỗi số hóa đơn");
        }

        return SP;
    }
    
    public static void UpdateSanPham(SanPham sp) {

       
        DALSanPham.UpdateSanPham(sp);
    }
    
    
    public static void Delete(List<String> lstMaSP) {

        String danhSachKhongTheXoa = "";
        String danhSachDaXoa = "";

        for (String MaSP : lstMaSP) {
            DALSanPham.DeleteSanPham(MaSP);
            if (DALSanPham.kiemtraCoTheXoa(MaSP)) {
                DALSanPham.DeleteSanPham(MaSP);
                danhSachDaXoa += MaSP + " \n";
            } else {
                danhSachKhongTheXoa += MaSP + " \n";
            }
        }

        if (!danhSachDaXoa.equals("")) {
            ThongBao.ThongBaoSQL("Thông Báo", "Đã Xóa Mã : \n" + danhSachDaXoa);
        }
        if (!danhSachKhongTheXoa.equals("")) {
            ThongBao.ThongBaoSQL("Thông Báo", "Không Thể Xóa Mã :\n" + danhSachKhongTheXoa);
        }

    }
    
    
    public static void TimSanPham(JTable tblDanhSach, String TuKhoa) {
        DefaultTableModel tbModel = (DefaultTableModel) tblDanhSach.getModel();
        tbModel.setRowCount(0); // sét số dòng trong bảng về 0
        // Lấy dự liệu danh sách nhân viên từ DAL
        ResultSet rs = DALSanPham.TimKiem(TuKhoa);
        Object obj[] = new Object[13];
        try {
            while (rs.next()) {

                obj[0] = tbModel.getRowCount() + 1;
                obj[1] = rs.getString("MaSP");
                obj[2] = rs.getString("TenSP");
                obj[3] = rs.getInt("SoLuong");
                obj[4] = rs.getString("DonViTinh");
                obj[5] = ChuyenDoi.LaySoString(rs.getDouble("GiaNhap"));
                obj[6] = ChuyenDoi.LaySoString(rs.getDouble("GiaBan"));
                obj[7] = ChuyenDoi.LayNgayString(rs.getDate("NgayNhap"));
                obj[8] = LayTenLoaiSP(rs.getString("MaLoaiSP"));
                obj[9] = LayTenHangSX(rs.getString("MaHangSX"));
                obj[10] = (rs.getString("ThoiGianBH"));
                obj[11] = rs.getString("HinhAnh");
                obj[12] = rs.getString("GhiChu");
                // Thêm obj vào table 
                tbModel.addRow(obj);

            }
        } catch (SQLException e) {
            ThongBao.ThongBaoDangNhap("Thông Báo Lỗi", "Lỗi Lấy Danh Sách Sản Phẩm");
        }
    }
    
    public static void LoadSanPhamHoaDon(JTable tblDanhSach) {
        DefaultTableModel tbModel = (DefaultTableModel) tblDanhSach.getModel();
        tbModel.setRowCount(0); // sét số dòng trong bảng về 0
        // Lấy dự liệu danh sách nhân viên từ DAL
        ResultSet rs = DALSanPham.getALLSanPham();
        Object obj[] = new Object[4];
        try {
            while (rs.next()) {

                obj[0] = rs.getString("MaSP");
                obj[1] = rs.getString("TenSP");
                obj[2] = rs.getInt("SoLuong");
                obj[3] = rs.getDouble("GiaNhap");

                // Thêm obj vào table 
                tbModel.addRow(obj);

            }
        } catch (SQLException e) {
            ThongBao.ThongBaoDangNhap("Thông Báo Lỗi", "Lỗi Lấy Danh Sách Sản Phẩm");
        }
    }
    
    public static void LoadSanPhamHoaDonXuat(JTable tblDanhSach) {
        DefaultTableModel tbModel = (DefaultTableModel) tblDanhSach.getModel();
        tbModel.setRowCount(0); // sét số dòng trong bảng về 0
        // Lấy dự liệu danh sách nhân viên từ DAL
        ResultSet rs = DALSanPham.getALLSanPham();
        Object obj[] = new Object[4];
        try {
            while (rs.next()) {

                obj[0] = rs.getString("MaSP");
                obj[1] = rs.getString("TenSP");
                obj[2] = rs.getInt("SoLuong");
                obj[3] = rs.getDouble("GiaBan");
                System.out.println(rs.getDouble("GiaBan"));

                // Thêm obj vào table 
                tbModel.addRow(obj);

            }
        } catch (SQLException e) {
            ThongBao.ThongBaoDangNhap("Thông Báo Lỗi", "Lỗi Lấy Danh Sách Sản Phẩm");
        }
    }
    
    public static void LocDSSPTheoMaLoaiSP(JTable tblDanhSach, String maLoaiSP){
        DefaultTableModel tbModel = (DefaultTableModel) tblDanhSach.getModel();
        tbModel.setRowCount(0);
        
        ResultSet rs = DALSanPham.LocDSSPTheoMaLoaiSP(maLoaiSP);
        Object obj[] = new Object[4];
        try {
            while (rs.next()) {

                obj[0] = rs.getString("MaSP");
                obj[1] = rs.getString("TenSP");
                obj[2] = rs.getInt("SoLuong");
                obj[3] = rs.getDouble("GiaNhap");

                // Thêm obj vào table 
                tbModel.addRow(obj);

            }
        } catch (SQLException e) {
            ThongBao.ThongBaoDangNhap("Thông Báo Lỗi", "Lỗi Lấy Danh Sách Sản Phẩm");
        }
    }
    
    public static void LocDSSP(JTable tblDanhSach, String keyWord, String maLoaiSP){
         DefaultTableModel tbModel = (DefaultTableModel) tblDanhSach.getModel();
        tbModel.setRowCount(0);
        
        ResultSet rs = DALSanPham.LocDSSP(keyWord, maLoaiSP);
        Object obj[] = new Object[4];
        try {
            while (rs.next()) {

                obj[0] = rs.getString("MaSP");
                obj[1] = rs.getString("TenSP");
                obj[2] = rs.getInt("SoLuong");
                obj[3] = rs.getDouble("GiaNhap");

                // Thêm obj vào table 
                tbModel.addRow(obj);

            }
        } catch (SQLException e) {
            ThongBao.ThongBaoDangNhap("Thông Báo Lỗi", "Lỗi Lấy Danh Sách Sản Phẩm");
        }
    }
    
    public static void LocDSSPTheoKeyWord(JTable tblDanhSach, String keyWord){
        DefaultTableModel tbModel = (DefaultTableModel) tblDanhSach.getModel();
        tbModel.setRowCount(0);
        
        ResultSet rs = DALSanPham.LocDSSPTheoKeyWord(keyWord);
        Object obj[] = new Object[4];
        try {
            while (rs.next()) {

                obj[0] = rs.getString("MaSP");
                obj[1] = rs.getString("TenSP");
                obj[2] = rs.getInt("SoLuong");
                obj[3] = rs.getDouble("GiaNhap");

                // Thêm obj vào table 
                tbModel.addRow(obj);

            }
        } catch (SQLException e) {
            ThongBao.ThongBaoDangNhap("Thông Báo Lỗi", "Lỗi Lấy Danh Sách Sản Phẩm");
        }
    }
}
