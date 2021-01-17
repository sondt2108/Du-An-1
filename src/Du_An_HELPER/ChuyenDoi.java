/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Du_An_HELPER;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class ChuyenDoi {
     
     // chuyển đổi ngày tháng date <--> String
    // Tạo đinh dạng ngày tháng 
    static DateFormat dateFomat = new SimpleDateFormat("dd-MM-yyyy");
    
    // Hàm chuyển Date sang String
    public static String LayNgayString(Date date) {
        return dateFomat.format(date);
    }
    
    // Hmaf chuyển String sang date 
    public static Date LayNgayDate(String Ngay){
        try {
            return dateFomat.parse(Ngay);
        } catch (ParseException ex) {
            System.out.println("Lỗi chuyển ngày");
            return  null;
        }
    }
    // Hàm chuyển đổi double <--> String
    // hàm chuyển Double <--> String
    // bsjgavfjvjk
    public static String LaySoString(double so){
        return NumberFormat.getNumberInstance().format(so);
    }
    
    public static double LaySoDouble(String so){
        try {
            return NumberFormat.getNumberInstance().parse(so).doubleValue();
        } catch (ParseException ex) {
            System.out.println("Lỗi chuyển số");
            return 0;
        }
    }
    
    public static String DinhDangTien(double tien) {
        return NumberFormat.getNumberInstance().format(tien);
    }
    
    public static double ChuyenTien(String tien) {
        try {
            return NumberFormat.getNumberInstance().parse(tien).doubleValue();
        } catch (ParseException ex) {
//            GUI.frmHeThong.ThongBao("Thông báo", "Lỗi chuyển dữ liệu");

        }
        return 0;
    }
}
