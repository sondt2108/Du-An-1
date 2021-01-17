/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Du_An_BLL;

import Du_An_DAL.DALNhaCC;
import Du_An_DTO.NhaCC;
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
public class BLLNhaCC {
    public static void LoadNCC(JTable tblDanhSach) {

        DefaultTableModel tbModel = (DefaultTableModel) tblDanhSach.getModel();
        tbModel.setRowCount(0); // sét số dòng trong bảng về 0
        // Lấy dự liệu danh sách nhân viên từ DAL
        ResultSet rs = DALNhaCC.getALLNCC();
        Object obj[] = new Object[7];
        try {
            while (rs.next()) {

                obj[0] = tbModel.getRowCount() + 1;
                obj[1] = rs.getString("MaNCC");
                obj[2] = rs.getString("TenNCC");
                obj[3] = rs.getString("SDT");
                obj[4] = rs.getString("DiaChi");
                obj[5] = rs.getString("Email");
                obj[6] = rs.getString("GhiChu");
                
                // Thêm obj vào table 
                tbModel.addRow(obj);

            }
        } catch (SQLException e) {
            ThongBao.ThongBaoDangNhap("Thông Báo Lỗi", "Lỗi Lấy Danh Sách Sản Phẩm");
        }
    }
    
    public static NhaCC LayNCCTheoMa(String MaNCC) {
        ResultSet rs = DALNhaCC.getMaNCC(MaNCC);
        try {
            if (rs.next()) {
                // Nếu Có Nhân Viên 
                NhaCC ncc = new NhaCC();
                ncc.setMaNCC(rs.getString("MaNCC"));
                ncc.setTenNCC(rs.getString("TenNCC"));
                ncc.setSDT(rs.getString("SDT"));
                ncc.setDiaChi(rs.getString("DiaChi"));
                ncc.setEmail(rs.getString("Email"));
                ncc.setGhiChu(rs.getString("GhiChu"));
                
                // Trả về nhân viên 
                return ncc;

            }
        } catch (SQLException e) {
            ThongBao.ThongBaoDangNhap("Thông Báo", "Lỗi Lấy Nhân Viên Theo Mã");
        }
        return null;
    }
    
    public static void UpdateNhaCC(NhaCC ncc) {

        DALNhaCC.SuaNhaCC(ncc);
    }
    
    public static void ThemNhaCC(NhaCC ncc) {

        DALNhaCC.ThemNhaCC(ncc);
    }
    
    public static void Delete(List<String> lstMaNCC) {

        String danhSachKhongTheXoa = "";
        String danhSachDaXoa = "";

        for (String MaNCC : lstMaNCC) {

            if (DALNhaCC.kiemtraCoTheXoa(MaNCC)) {
                DALNhaCC.DeleteNCC(MaNCC);
                danhSachDaXoa += MaNCC + " \n";
            } else {
                danhSachKhongTheXoa += MaNCC + " \n";
            }
        }

        if (!danhSachDaXoa.equals("")) {
            ThongBao.ThongBaoSQL("Thông Báo", "Đã Xóa Mã : \n" + danhSachDaXoa);
        }
        if (!danhSachKhongTheXoa.equals("")) {
            ThongBao.ThongBaoSQL("Thông Báo", "Không Thể Xóa Mã :\n" + danhSachKhongTheXoa);
        }

    }
    public static NhaCC LayNCCTheoTen(String TenNCC){
        ResultSet rs = DALNhaCC.TimNCCTheoTen(TenNCC);
        
        try {
            if (rs.next()) {
                NhaCC ncc = new NhaCC();
                ncc.setDiaChi(rs.getString("DiaChi"));
                ncc.setGhiChu(rs.getString("GhiChu"));
                ncc.setMaNCC(rs.getString("MaNCC"));
                ncc.setSDT(rs.getString("SDT"));
                ncc.setTenNCC(rs.getString("TenNCC"));
                
                return ncc;
            }
        } catch (SQLException ex) {
            ThongBao.ThongBaoDangNhap("Lỗi", "Lỗi lấy NCC theo tên");
        }
        return null;
    }
    
    public static String LayTenNCCTheoMaNCC(String maNCC){
        ResultSet rs = DALNhaCC.getMaNCC(maNCC);
        String tenNCC;
        try {
            tenNCC = rs.getString("TenNCC");
            return tenNCC;
        } catch (SQLException ex) {
            ThongBao.ThongBaoSQL("Loi", "Loi lay ten nha cung cap");
        }
        return null;
    }
    
     public static String TaoMaNCC(){
        String MaNCC = "";
        try {

            MaNCC = "NCC";
            ResultSet rs = DALNhaCC.CountMaNCC(MaNCC);
            int rowCount = 0;
            if (rs.next()) {
                rowCount = rs.getInt(1);
            }
            boolean dup = false;
            do {
                if (rowCount > 98) {
                    MaNCC = MaNCC + (rowCount + 1);
                } else if (rowCount > 8) {
                    MaNCC = MaNCC + "0" + (rowCount + 1);
                } else {
                    MaNCC = MaNCC + "00" + (rowCount + 1);
                }
                System.out.println("MaNCC: " + MaNCC);
                ResultSet rs2 = DALNhaCC.GetByMaNCC(MaNCC);
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

        return MaNCC;
    }
     
     public static void TimNhaCC(JTable tblDanhSach, String TenNhaCC) {
        DefaultTableModel tbModel = (DefaultTableModel) tblDanhSach.getModel();
        tbModel.setRowCount(0); // sét số dòng trong bảng về 0
        // Lấy dự liệu danh sách nhân viên từ DAL
        ResultSet rs = DALNhaCC.TimKiem(TenNhaCC);
        Object obj[] = new Object[13];
        try {
            while (rs.next()) {
                obj[0] = tbModel.getRowCount() + 1;
                obj[1] = rs.getString("MaNCC");
                obj[2] = rs.getString("TenNCC");
                obj[3] = rs.getString("SDT");
                obj[4] = rs.getString("DiaChi");
                obj[5] = rs.getString("Email");
                obj[6] = rs.getString("GhiChu");
                // Thêm obj vào table 
                tbModel.addRow(obj);

            }
        } catch (SQLException e) {
            ThongBao.ThongBaoDangNhap("Thông Báo Lỗi", "Lỗi Lấy Danh Sách Nhà CC");
        }
    }
}
