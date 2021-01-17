/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Du_An_BLL;

import Du_An_DAL.DALKhachHang;
import Du_An_DAL.DALSanPham;
import Du_An_DTO.KhachHang;
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
public class BLLKhachHang {
  public static void LoadKhachHang(JTable tblDanhSach) {
        DefaultTableModel tbModel = (DefaultTableModel) tblDanhSach.getModel();
        tbModel.setRowCount(0); // sét số dòng trong bảng về 0
        // Lấy dự liệu danh sách nhân viên từ DAL
        ResultSet rs = DALKhachHang.getALLKhachHang();
        Object obj[] = new Object[7];
        try {
            while (rs.next()) {
                obj[0] = tbModel.getRowCount() + 1;
                obj[1] = rs.getString("MaKH");
                obj[2] = rs.getString("TenKH");
                obj[3] = rs.getString("DiaChi");
                obj[4] = rs.getString("SDT");
                obj[5] = rs.getString("Email");
                obj[6] = rs.getString("GhiChu");
                // Thêm obj vào table 
                tbModel.addRow(obj);

            }
        } catch (SQLException e) {
            ThongBao.ThongBaoDangNhap("Thông Báo Lỗi", "Lỗi Lấy Danh Sách Khách Hàng");
        }
    }

    public static KhachHang LayKHTheoMa(String MaKH) {
        ResultSet rs = DALKhachHang.getKhachHang(MaKH);
        try {
            if (rs.next()) {
                // Nếu Có Nhân Viên 
                KhachHang KH = new KhachHang();
                KH.setMaKhachHang(rs.getString("MaKH"));
                KH.setTenKhachHang(rs.getString("TenKH"));
                KH.setDiaChi(rs.getString("DiaChi"));
                KH.setSDT(rs.getString("SDT"));
                KH.setEmail(rs.getString("Email"));
                KH.setGhiChu(rs.getString("GhiChu"));

                // Trả về nhân viên 
                return KH;

            }
        } catch (SQLException e) {
            ThongBao.ThongBaoDangNhap("Thông Báo", "Lỗi Lấy Khách Hàng Theo Mã");
        }
        return null;
    }

    public static void ThemKhachHang(KhachHang kh) {

        // Kiểm tra tên đang nhập đa tồn tại
        // kiểm tra ok -> gọi hàm thêm từ DALNhanVien
        DALKhachHang.ThemKhachHang(kh);
    }
    
    public static void UpdateKhachHang(KhachHang KH) {

        DALKhachHang.UpdateKhachHang(KH);
    }

    public static void Delete(KhachHang KH) {    
        DALKhachHang.DeleteKhachHang(KH);
                

    }

    public static void TimKhachHang(JTable tblDanhSach,String SDT, String Ten) {
        DefaultTableModel tbModel = (DefaultTableModel) tblDanhSach.getModel();
        tbModel.setRowCount(0); // sét số dòng trong bảng về 0
        // Lấy dự liệu danh sách nhân viên từ DAL
       ResultSet rs = DALKhachHang.TimKiem(SDT, Ten);
        Object obj[] = new Object[7];
        try {
            while (rs.next()) {
               obj[0] = tbModel.getRowCount() + 1;
                obj[1] = rs.getString("MaKH");
                obj[2] = rs.getString("TenKH");
                obj[3] = rs.getString("DiaChi");
                obj[4] = rs.getString("SDT");
                obj[5] = rs.getString("Email");
                obj[6] = rs.getString("GhiChu");
                // Thêm obj vào table 
                tbModel.addRow(obj);

            }
        } catch (SQLException e) {
            ThongBao.ThongBaoDangNhap("Thông Báo Lỗi", "Lỗi Lấy Danh Sách Khách Hàng");
        }
    }
    
    public static KhachHang LayKhachHangTheoTen(String tenKH){
        ResultSet rs = DALKhachHang.LayKhachHangTheoTen(tenKH);
        
        try {
            if (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKhachHang(rs.getString("MaKH"));
                kh.setTenKhachHang(rs.getString("TenKH"));
                kh.setDiaChi(rs.getString("DiaChi"));
                kh.setSDT(rs.getString("SDT"));
                kh.setEmail(rs.getString("Email"));
                kh.setGhiChu(rs.getString("GhiChu"));
                
                return kh;
            }
        } catch (SQLException ex) {
            ThongBao.ThongBaoDangNhap("Lỗi", "Lỗi lấy khách hàng theo tên");
        }
        return null;
        
    }  
    
    public static String TaoMaKH(){
        String MaKH = "";
        try {

            MaKH = "KH";
            ResultSet rs = DALKhachHang.CountMaKH(MaKH);
            int rowCount = 0;
            if (rs.next()) {
                rowCount = rs.getInt(1);
            }
            boolean dup = false;
            do {
                if (rowCount > 98) {
                    MaKH = MaKH + (rowCount + 1);
                } else if (rowCount > 8) {
                    MaKH = MaKH + "0" + (rowCount + 1);
                } else {
                    MaKH = MaKH + "00" + (rowCount + 1);
                }
                System.out.println("MaKH: " + MaKH);
                ResultSet rs2 = DALKhachHang.GetByMaKH(MaKH);
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

        return MaKH;
    }
    
    public static void Delete(List<String> lstMaKH) {

        String danhSachKhongTheXoa = "";
        String danhSachDaXoa = "";

        for (String MaKH : lstMaKH) {
            DALKhachHang.DeleteKhachHang(MaKH);
            if (DALKhachHang.kiemtraCoTheXoa(MaKH)) {
                DALKhachHang.DeleteKhachHang(MaKH);
                danhSachDaXoa += MaKH + " \n";
            } else {
                danhSachKhongTheXoa += MaKH + " \n";
            }
        }

        if (!danhSachDaXoa.equals("")) {
            ThongBao.ThongBaoSQL("Thông Báo", "Đã Xóa Mã : \n" + danhSachDaXoa);
        }
        if (!danhSachKhongTheXoa.equals("")) {
            ThongBao.ThongBaoSQL("Thông Báo", "Không Thể Xóa Mã :\n" + danhSachKhongTheXoa);
        }

    }
}
