/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Du_An_BLL;

import Du_An_DAL.DALHangSX;
import Du_An_DTO.HangSX;
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
public class BLLHangSX {
    
    public static void ThemHangSX(HangSX hsx) {

         DALHangSX.ThemHangSX(hsx);
    }
    //3. Hàm đổ dữ liệu vào Combobox Loại sản phẩm
    public static void DoDuLieuVaoCBBHangSX(JComboBox cbb, String KeyWord){
        cbb.removeAllItems();
        try {
            ResultSet rs = DALHangSX.GetDuLieuCBB(KeyWord);
            
            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel)cbb.getModel();
           
            while(rs.next()){
                Mycombobox mb = new Mycombobox(
                                            rs.getString("MaHangSX"),rs.getString("TenHangSX"));
                cbbModel.addElement(mb);                
            }
        } catch (SQLException ex) {
            ThongBao.ThongBaoSQL("Thông báo", "Lỗi truy vấn dữ liệu.");
        }
    }
    
    public static String TaoMaHSX(){
        String MaHSX = "";
        try {

            MaHSX = "HSX";
            ResultSet rs = DALHangSX.CountMaHSX(MaHSX);
            int rowCount = 0;
            if (rs.next()) {
                rowCount = rs.getInt(1);
            }
            boolean dup = false;
            do {
                if (rowCount > 98) {
                    MaHSX = MaHSX + (rowCount + 1);
                } else if (rowCount > 8) {
                    MaHSX = MaHSX + "0" + (rowCount + 1);
                } else {
                    MaHSX = MaHSX + "00" + (rowCount + 1);
                }
                System.out.println("MaHSX: " + MaHSX);
                ResultSet rs2 = DALHangSX.GetByMaHSX(MaHSX);
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

        return MaHSX;
    }
}
