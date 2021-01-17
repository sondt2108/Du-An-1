/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Du_An_BLL;

import Du_An_DAL.DALCTHDNhap;
import Du_An_DTO.CTHDNhap;
import Du_An_HELPER.ChuyenDoi;
import Du_An_HELPER.ThongBao;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class BLLCTHDNhap {

    public static String TaoMaCTHDN() {
        String MaCTHDN = "";
        try {

            MaCTHDN = "CTN";
            ResultSet rs = DALCTHDNhap.CountMaCTHDNhap(MaCTHDN);
            int rowCount = 0;
            if (rs.next()) {
                rowCount = rs.getInt(1);
            }
            boolean dup = false;
            do {
                if (rowCount > 98) {
                    MaCTHDN = MaCTHDN + (rowCount + 1);
                } else if (rowCount > 8) {
                    MaCTHDN = MaCTHDN + "0" + (rowCount + 1);
                } else {
                    MaCTHDN = MaCTHDN + "00" + (rowCount + 1);
                }
                ResultSet rs2 = DALCTHDNhap.GetByMaCTHDN(MaCTHDN);
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

        return MaCTHDN;
    }

    public static void ThemCTHDNhap(JTable tbl, String maHD) {
        for (int i = 0; i < tbl.getRowCount(); i++) {
            CTHDNhap cthdNhap = new CTHDNhap();

            cthdNhap.setMa_CTHD_Nhap(TaoMaCTHDN());
            cthdNhap.setMa_HD_Nhap(maHD);

            String maSP = tbl.getValueAt(i, 1).toString();
            cthdNhap.setMaSP(maSP);

            String soLuong = tbl.getValueAt(i, 3).toString();
            cthdNhap.setSoLuong(soLuong);

            double tongTien = ChuyenDoi.LaySoDouble(tbl.getValueAt(i, 5).toString());
            cthdNhap.setThanhTien(tongTien);

            String ghiChu = tbl.getValueAt(i, 6).toString();
            cthdNhap.setGhiChu(ghiChu);

            DALCTHDNhap.ThemCTHDNhap(cthdNhap);
        }
    }

    public static void LoadTBLChiTietHDNhap(String maHD, JTable tbl) {
        ResultSet rs = DALCTHDNhap.LayCTHDTheoMaHD(maHD);

        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[6];

        try {
            while (rs.next()) {
                obj[0] = rs.getString("Ma_CTHD_Nhap");
                obj[1] = rs.getString("Ma_HD_Nhap");
                obj[2] = rs.getString("MaSP");
                obj[3] = rs.getInt("SoLuong");
                obj[4] = ChuyenDoi.DinhDangTien(rs.getDouble("ThanhTien"));
                obj[5] = rs.getString("GhiChu");

                tbModel.addRow(obj);
            }
        } catch (SQLException ex) {
            ThongBao.ThongBaoDangNhap("Thông Báo Lỗi", "Lỗi Lấy Danh Sách Chi Tiết Hóa Đơn");
        }
    }
}
