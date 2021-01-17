/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Du_An_HELPER;

import javax.swing.JTextField;

/**
 *
 * @author LENOVO
 */
public class HoTroNhapSo {
     public static void luonNhapSo(java.awt.event.KeyEvent evt){
        JTextField textfield = (JTextField) evt.getSource();
        
        try{
            Integer.parseInt(textfield.getText());
        }catch(Exception e){
            textfield.setText(textfield.getText().replaceAll("[^\\d.]", ""));
        }    
    }
    
}
