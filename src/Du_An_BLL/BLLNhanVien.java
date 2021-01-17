/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Du_An_BLL;

import Du_An_DAL.DALNhanVien;
import Du_An_DTO.NhanVien;
import Du_An_HELPER.ChuyenDoi;
import Du_An_HELPER.ThongBao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class BLLNhanVien {
    public static void LoadNhanVien(JTable tblDanhSach) {
        DefaultTableModel tbModel = (DefaultTableModel) tblDanhSach.getModel();
        tbModel.setRowCount(0); // sét số dòng trong bảng về 0
        // Lấy dự liệu danh sách nhân viên từ DAL
        ResultSet rs = DALNhanVien.getALLNhanVien();
        Object obj[] = new Object[14];
        try {
            while (rs.next()) {
                obj[0] = tbModel.getRowCount() + 1;
                obj[1] = rs.getString("MaNV");
                obj[2] = rs.getString("TenNV");
                
                boolean gt = rs.getBoolean("GioiTinh");
                if (gt) {
                    obj[3] = "Nam";
                } else {
                    obj[3] = "Nữ";
                }
                obj[4] = ChuyenDoi.LayNgayString(rs.getDate("NgaySinh"));
                obj[5] = LayTenChucVu(rs.getString("MaChucVu"));
                obj[6] = ChuyenDoi.LayNgayString(rs.getDate("NgayVaoLam"));
                obj[7] = rs.getString("SDT");
                obj[8] = rs.getString("DiaChi");
                obj[9] = rs.getString("CMND");
                obj[10] = rs.getString("Email");
                obj[11] = rs.getString("TenDangNhap");
                obj[12] = rs.getString("MatKhau");
                obj[13] = rs.getString("HinhAnh");
                // Thêm obj vào table 
                tbModel.addRow(obj);

            }
        } catch (SQLException e) {
            ThongBao.ThongBaoDangNhap("Thông Báo Lỗi", "Lỗi Lấy Danh Sách Nhân Viên");
        }
    }
    
    // Hàm lấy tên chức vụ theo mã
    public static String LayTenChucVu(String MaCV) {
        ResultSet rs = DALNhanVien.getChucVu(MaCV);
        try {
            if(rs.next()) {
                return rs.getString("TenChucVu");
            }
        } catch (SQLException ex) {
            ThongBao.ThongBaoSQL("Thông báo", "Lỗi lấy tên loại sản phẩm");
        }
        return "";
    }
    
    public static NhanVien DangNhap(String TenDangNhap, String MatKhau) {
        try {
            ResultSet rs = DALNhanVien.DangNhap(TenDangNhap, MatKhau);
            if (rs.next()) {
                return LayNhanVienTheoMa(rs.getString("MaNV"));
            }
        } catch (SQLException ex) {
            ThongBao.ThongBaoDangNhap("Thông báo lỗi", "Lỗi SQL đăng nhập!");
        }
        
        return new NhanVien();
    }
    
    //Hàm tạo mã nhân viên tự động
    
    public static String TaoMaNV(){
        String MaNV = "";
        try {

            MaNV = "NV";
            ResultSet rs = DALNhanVien.CountMaNV(MaNV);
            int rowCount = 0;
            if (rs.next()) {
                rowCount = rs.getInt(1);
            }
            boolean dup = false;
            do {
                if (rowCount > 98) {
                    MaNV = MaNV + (rowCount + 1);
                } else if (rowCount > 8) {
                    MaNV = MaNV + "0" + (rowCount + 1);
                } else {
                    MaNV = MaNV + "00" + (rowCount + 1);
                }
                System.out.println("MaNV: " + MaNV);
                ResultSet rs2 = DALNhanVien.GetByMaNV(MaNV);
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

        return MaNV;
    }
    
     public static NhanVien LayNhanVienTheoMa(String MaNV) {
        ResultSet rs = DALNhanVien.getNhanVien(MaNV);
        try {
            if (rs.next()) {
                // Nếu Có Nhân Viên 
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("MaNV"));
                nv.setTenNV(rs.getString("TenNV"));
                nv.setGioiTinh(rs.getBoolean("GioiTinh"));
                nv.setNgaySinh(rs.getDate("NgaySinh"));
                nv.setChucVu(rs.getString("MaChucVu"));
                nv.setNgayVaoLam(rs.getDate("NgayVaoLam"));
                nv.setSDT(rs.getString("SDT"));
                nv.setDiaChi(rs.getString("DiaChi"));
                nv.setCMND(rs.getString("CMND"));
                nv.setEmail(rs.getString("Email"));
                nv.setTenDangNhap(rs.getString("TenDangNhap"));
                nv.setMatKhau(rs.getString("MatKhau"));
                nv.getHinhAnh();
                
                // Trả về nhân viên 
                return nv;

            }
        } catch (SQLException e) {
            ThongBao.ThongBaoDangNhap("Thông Báo", "Lỗi Lấy Nhân Viên Theo Mã");
        }
        return null;
    }
     
     public static void ThemNhanVien(NhanVien nv) {

        // Kiểm tra tên đang nhập đa tồn tại
        // kiểm tra ok -> gọi hàm thêm từ DALNhanVien
        DALNhanVien.ThemNhanVien(nv);
    }
     
      public static void SuaNhanVien(NhanVien nv) {

        // Kiểm tra tên đang nhập đa tồn tại
        // kiểm tra ok -> gọi hàm thêm từ DALNhanVien
        DALNhanVien.SuaNhanVien(nv);
    }
      
      public static void Delete(List<String> lstMaNV) {

        String danhSachKhongTheXoa = "";
        String danhSachDaXoa = "";

        for (String MaNV : lstMaNV) {

            if (DALNhanVien.kiemtraCoTheXoa(MaNV)) {
                DALNhanVien.DeleteNhanVien(MaNV);
                danhSachDaXoa += MaNV + " \n";
            } else {
                danhSachKhongTheXoa += MaNV + " \n";
            }
        }

        if (!danhSachDaXoa.equals("")) {
            ThongBao.ThongBaoSQL("Thông Báo", "Đã Xóa Mã : \n" + danhSachDaXoa);
        }
        if (!danhSachKhongTheXoa.equals("")) {
            ThongBao.ThongBaoSQL("Thông Báo", "Không Thể Xóa Mã :\n" + danhSachKhongTheXoa);
        }

    }
      
     public static void TimNhanVien(JTable tblDanhSach, String TenNhanVien) {
        DefaultTableModel tbModel = (DefaultTableModel) tblDanhSach.getModel();
        tbModel.setRowCount(0); // sét số dòng trong bảng về 0
        // Lấy dự liệu danh sách nhân viên từ DAL
        ResultSet rs = DALNhanVien.TimKiem(TenNhanVien);
        Object obj[] = new Object[14];
        try {
            while (rs.next()) {
                obj[0] = tbModel.getRowCount() + 1;
                obj[1] = rs.getString("MaNV");
                obj[2] = rs.getString("TenNV");
                
                boolean gt = rs.getBoolean("GioiTinh");
                if (gt) {
                    obj[3] = "Nam";
                } else {
                    obj[3] = "Nữ";
                }
                obj[4] = rs.getDate("NgaySinh");
                obj[5] = LayTenChucVu(rs.getString("MaChucVu"));
                obj[6] = rs.getDate("NgayVaoLam");
                obj[7] = rs.getString("SDT");
                obj[8] = rs.getString("DiaChi");
                obj[9] = rs.getString("CMND");
                obj[10] = rs.getString("Email");
                obj[11] = rs.getString("TenDangNhap");
                obj[12] = rs.getString("MatKhau");
                obj[13] = rs.getString("HinhAnh");
                // Thêm obj vào table 
                tbModel.addRow(obj);

            }
        } catch (SQLException e) {
            ThongBao.ThongBaoDangNhap("Thông Báo Lỗi", "Lỗi Lấy Danh Sách Nhân Viên");
        }
    }
     
     public static NhanVien LayNVTheoTen( String tenNV){
        ResultSet rs = DALNhanVien.LayNVTheoTen(tenNV);
        try {
            if (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("MaNV"));
                nv.setTenNV(rs.getString("TenNV"));
                nv.setGioiTinh(rs.getBoolean("GioiTinh"));
                nv.setNgaySinh(rs.getDate("NgaySinh"));
                nv.setChucVu(rs.getString("MaChucVu"));               
                nv.setSDT(rs.getString("SDT"));
                nv.setDiaChi(rs.getString("DiaChi"));
                nv.setCMND(rs.getString("CMND"));
                nv.setTenDangNhap(rs.getString("TenDangNhap"));
                nv.setMatKhau(rs.getString("MatKhau"));
                nv.setNgayVaoLam(rs.getDate("NgayVaoLam"));
                nv.setHinhAnh(rs.getString("HinhAnh"));
                nv.setEmail("Email");
                
                return nv;
            }
        } catch (SQLException ex) {
            ThongBao.ThongBaoSQL("Lỗi", "Lỗi lấy nhân viên theo tên");
        }
        return null;
    }
}
