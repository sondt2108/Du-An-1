/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Du_An_BLL;

import Du_An_DAL.DALHangSX;
import Du_An_DAL.DALLoaiSP;
import Du_An_DTO.HangSX;
import Du_An_DTO.LoaiSP;
import Du_An_HELPER.Mycombobox;
import Du_An_HELPER.ThongBao;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author Administrator
 */
public class BLLLoaiSP {
   
    
    
    public static void DoDuLieuVaoCBBLoaiSP(JComboBox cbb, String KeyWord){
        cbb.removeAllItems();
        try {
            ResultSet rs = DALLoaiSP.GetDuLieuCBB(KeyWord);
            
            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel)cbb.getModel();
           
            while(rs.next()){
                Mycombobox mb = new Mycombobox(
                                            rs.getString("MaLoaiSP"),rs.getString("TenLoaiSP"));
                cbbModel.addElement(mb);                
            }
        } catch (SQLException ex) {
            ThongBao.ThongBaoSQL("Thông báo", "Lỗi truy vấn dữ liệu.");
        }
    }
    
    public static String TaoMaLSP(){
        String MaLSP = "";
        try {

            MaLSP = "LSP";
            ResultSet rs = DALLoaiSP.CountMaLSP(MaLSP);
            int rowCount = 0;
            if (rs.next()) {
                rowCount = rs.getInt(1);
            }
            boolean dup = false;
            do {
                if (rowCount > 98) {
                    MaLSP = MaLSP + (rowCount + 1);
                } else if (rowCount > 8) {
                    MaLSP = MaLSP + "0" + (rowCount + 1);
                } else {
                    MaLSP = MaLSP + "00" + (rowCount + 1);
                }
                System.out.println("MaLSP: " + MaLSP);
                ResultSet rs2 = DALLoaiSP.GetByMaLSP(MaLSP);
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

        return MaLSP;
    }
    
    
     public static void ThemLoaiSP(LoaiSP lsp) {

         DALLoaiSP.ThemLoaiSP(lsp);
    }
     
     public static String GetMaLSPByTenLSP(String tenLoaiSP){                   
        ResultSet rs = DALLoaiSP.GetByTenLSP(tenLoaiSP);
            
        try { 
            while (rs.next()) {
                String maLoaiSP = rs.getString("MaLoaiSP");            
                return maLoaiSP;
            }
            
        } catch (SQLException ex) {
            ThongBao.ThongBaoSQL("Lỗi", "Lỗi lấy mã loại SP");
        }
        return null;
    }
}
