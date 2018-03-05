/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papirnyilvantarto;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Properties;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Darázsi Márk
 */
public class DB {
    
    final String user = "root";
    final String pass = "";
    String dbUrl;
    
    int aktev;
    
    public DB() {
        aktev = LocalDate.now().getYear();
        url_be();
    }
    
    private void url_be() {
        Properties beallitasok = new Properties();
        try (FileInputStream be = new FileInputStream("config.properties")) {
            beallitasok.load(be);
            String ip = beallitasok.getProperty("ip");
            dbUrl = "jdbc:mysql://" + ip + ":3306/papirnyilvantarto"
                    + "?useUnicode=true&characterEncoding=UTF-8";
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            dbUrl = "jdbc:mysql://localhost:3306/papirnyilvantarto"
                   + "?useUnicode=true&characterEncoding=UTF-8";
        }
    }
    
    public void keszlet_be(JTable tbl) {
        final DefaultTableModel tm = (DefaultTableModel)tbl.getModel();
        String s = "SELECT * FROM leltar ORDER BY tarhely;";

        try (Connection kapcs = DriverManager.getConnection(dbUrl, user, pass);
                PreparedStatement parancs = kapcs.prepareStatement(s);
                ResultSet eredmeny = parancs.executeQuery()) {
            tm.setRowCount(0);
            //cb.removeAllItems();
            while (eredmeny.next()) {
                Object sor[] = {
                    eredmeny.getString("tarhely"),
                    eredmeny.getString("nev"),
                    eredmeny.getString("gramm"),
                    eredmeny.getString("meret"),
                    eredmeny.getString("szalirany"),
                    eredmeny.getString("mennyiseg"),
                };
                tm.addRow(sor);
                //cb.addItem(eredmeny.getString("tarhely"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.exit(1);
        }
    }
}
