/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Du_An_HELPER;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author LENOVO
 */
public class ThongBao {
     // Hàm thông Báo
    public static void ThongBaoDangNhap(String Title, String Content) {
        JOptionPane.showMessageDialog(new JFrame(),
                Content, Title, JOptionPane.INFORMATION_MESSAGE);
    }
    public static void ThongBaoSQL(String Title, String Content) {
        JOptionPane.showMessageDialog(new JFrame(),
                Content, Title, JOptionPane.INFORMATION_MESSAGE);
    }
}
