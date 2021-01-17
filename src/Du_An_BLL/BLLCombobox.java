/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Du_An_BLL;

import Du_An_HELPER.Mycombobox;
import Du_An_HELPER.ThongBao;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class BLLCombobox {
    // hàm đỗ dữ liệu   vào combobox

        public static void Load(JComboBox cbb, ResultSet rs, boolean chon) {
        DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
        cbbModel.removeAllElements();// xoá hết item trong cbb
        if (chon) {
            Mycombobox mc = new Mycombobox(-1, "Chọn");
            cbbModel.addElement(mc);
        }
        try {
            while (rs.next()) {

                Mycombobox mycbb = new Mycombobox(
                        rs.getObject(1),
                        rs.getObject(2));

                cbbModel.addElement(mycbb);

            }
        } catch (Exception e) {
            ThongBao.ThongBaoDangNhap("Thông Báo", "Lỗi Load Dữ Liệu COmbobox");
        }
    }
        
        
        public static void LoadTK(JComboBox cbb, ResultSet rs, boolean chon) {
        DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
        cbbModel.removeAllElements();// xoá hết item trong cbb
        if (chon) {
            Mycombobox mc = new Mycombobox(-1, "Chon");
            cbbModel.addElement(mc);
        }
        try {
            while (rs.next()) {

                Mycombobox mycbb = new Mycombobox(
                        rs.getObject(1),
                        rs.getObject(2));

                cbbModel.addElement(mycbb);

            }
        } catch (Exception e) {
            ThongBao.ThongBaoDangNhap("Thông Báo", "Lỗi Load Dữ Liệu COmbobox");
        }
    }
       
    
    public static void setComboSelectValue(JComboBox cbb, String key){

        DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
        for(int i = 0; i < cbbModel.getSize(); i++){
            Mycombobox mc = (Mycombobox) cbb.getItemAt(i);
            if(mc.MaString().equals(key)){
                cbb.setSelectedIndex(i);
                break;
            }
        }
    }

    public static String LayGiaTriDuocChon(JComboBox cbb) {
        Mycombobox mycbb = (Mycombobox) cbb.getSelectedItem();
        if (mycbb == null) {
            return "";
        }
        return mycbb.MaString();
    }
}
