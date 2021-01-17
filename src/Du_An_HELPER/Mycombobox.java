/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Du_An_HELPER;

/**
 *
 * @author LENOVO
 */
public class Mycombobox {

    Object Value;
    Object Text;

    public  Mycombobox(Object Value, Object Text) {
        this.Value = Value;
        this.Text = Text;
    }
    
    @Override
    public String toString(){
        return Text.toString();
    }
    
    //Hàm lấy value kiểu int
    public int MaInt(){
        return Integer.parseInt(Text.toString());
    }
    //Hàm lấy value kiểu string
    public String MaString(){
        return Value.toString();
    }

}
