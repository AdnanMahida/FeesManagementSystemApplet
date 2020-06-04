/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feesmanagment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author STUD
 */
public class FeesManagment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
     
        LoadScreen ls=new LoadScreen();
        LoginForm lf=new LoginForm();
        ls.setVisible(true);
        try
            {
                for (int i = 0; i <= 100; i++) {
                    Thread.sleep(40);
                    ls.loadingnumber.setText(Integer.toString(i)+"%");
                    ls.loadingprogress.setValue(i);
                    if (i==100) {
                        ls.setVisible(false);
                         lf.setVisible(true);
                    }
             }
            }
            catch(Exception a)
            {
              
            }

}
    public void connect()
    {
         
                      Connection cn=null;
            PreparedStatement ps=null;
                ResultSet rs=null;
               Statement st;
                         try
                         {
                           Class.forName("com.mysql.jdbc.Driver");

                          cn =DriverManager.getConnection("jdbc:mysql://localhost/feesmanagment","root","");
                          }
           catch(Exception a )
           {
           JOptionPane.showMessageDialog(null,"Exception Is"+a.getMessage());
           }
    
    }
}