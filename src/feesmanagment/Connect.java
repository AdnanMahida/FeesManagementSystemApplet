/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feesmanagment;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Adnan
 */
public class Connect {
        public Connection cn;
        public Statement st;
        public ResultSet rs;
        public  PreparedStatement ps;
         public Connect()
        {
                            try
                            {
                                 Class.forName("com.mysql.jdbc.Driver");
                                cn =DriverManager.getConnection("jdbc:mysql://localhost/feesmanagment","root","");
                              st =cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
                                st =cn.createStatement();
                            } 
                            catch (SQLException e)
                            {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            }
                             catch (ClassNotFoundException e)
                            {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            }
                            catch (Exception e)
                            {
                                JOptionPane.showMessageDialog(null, e.getMessage());
                            }

        }    
}
