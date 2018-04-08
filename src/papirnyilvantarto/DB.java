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
import java.util.Properties;
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
    String dbUrl =  "jdbc:mysql://localhost:3306/papirnyilvantarto"
                 + "?useUnicode=true&characterEncoding=UTF-8";
    
    
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
    
    public void keszlet_be(JTable tbl, String s) {
        final DefaultTableModel tm = (DefaultTableModel)tbl.getModel();

        try (Connection kapcs = DriverManager.getConnection(dbUrl, user, pass);
                PreparedStatement parancs = kapcs.prepareStatement(s);
                ResultSet eredmeny = parancs.executeQuery()) {
            tm.setRowCount(0);
            while (eredmeny.next()) {
                Object sor[] = {
                    eredmeny.getInt("id"),
                    eredmeny.getString("tarhely"),
                    eredmeny.getString("nev"),
                    eredmeny.getInt("gramm"),
                    eredmeny.getString("meret"),
                    eredmeny.getString("szalirany"),
                    eredmeny.getInt("mennyiseg"),
                };
                tm.addRow(sor);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.exit(1);
        }
    }
    
    private String levag(String s, int n) {
        return s.length() > n ? s.substring(0, n) : s;
    }
    
    public int hozzaad (String tarhely, String nev, String gramm, String meret, String szalirany, String mennyiseg) {
        if (tarhely.isEmpty() || nev.isEmpty() || gramm.isEmpty() || meret.isEmpty() || szalirany.isEmpty() || mennyiseg.isEmpty())
            return 0;
        String s = "INSERT INTO leltar (tarhely, nev, gramm, meret, szalirany, mennyiseg) VALUES (?,?,?,?,?,?);";
        try (Connection kapcs = DriverManager.getConnection(dbUrl, user, pass);
                PreparedStatement parancs = kapcs.prepareStatement(s)) {
            if (tarhely.isEmpty())
                parancs.setNull(1, java.sql.Types.INTEGER);
            else
                parancs.setString(1, levag(tarhely.trim(), 3));
            parancs.setString(2, levag(nev.trim(), 50));
            parancs.setString(3, levag(gramm.trim(), 3));
            parancs.setString(4, levag(meret.trim(), 7));
            parancs.setString(5, levag(szalirany.trim(), 1));
            parancs.setString(6, levag(mennyiseg.trim(), 7));
            return parancs.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return 0;
        }
    }
    
    public int modosit(int id, String tarhely, String nev, String gramm, String meret, String szalirany, String mennyiseg) {
        if (tarhely.isEmpty() || nev.isEmpty() || gramm.isEmpty() || meret.isEmpty() || szalirany.isEmpty() || mennyiseg.isEmpty())
            return 0;
        String s = "UPDATE leltar SET tarhely=?, nev=?, gramm=?, meret=?, szalirany=?, mennyiseg=? "
                 + "WHERE id=?;";
        try (Connection kapcs = DriverManager.getConnection(dbUrl, user, pass);
                PreparedStatement parancs = kapcs.prepareStatement(s)) {
            if (tarhely.isEmpty())
                parancs.setNull(1, java.sql.Types.VARCHAR);
            else
                parancs.setString(1, levag(tarhely.trim(), 3));
            parancs.setString(2, levag(nev.trim(), 50));
            parancs.setString(3, levag(gramm.trim(), 3));
            parancs.setString(4, levag(meret.trim(), 7));
            parancs.setString(5, levag(szalirany.trim(), 1));
            parancs.setString(6, levag(mennyiseg.trim(), 7));
            parancs.setInt(7, id);
            return parancs.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return 0;
        }
    }
    
    public int mennyiseg_modosit(int id, String mennyiseg) {
        if (mennyiseg.isEmpty())
            return 0;
        String s = "UPDATE leltar SET mennyiseg=? "
                 + "WHERE id=?;";
        try (Connection kapcs = DriverManager.getConnection(dbUrl, user, pass);
                PreparedStatement parancs = kapcs.prepareStatement(s)) {
            parancs.setString(1, levag(mennyiseg.trim(), 7));
            parancs.setInt(2, id);
            return parancs.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return 0;
        }
    }
    
    public void torol(int id) {
        String s = "DELETE FROM leltar WHERE id=?;";
        try (Connection kapcs = DriverManager.getConnection(dbUrl, user, pass);
                PreparedStatement parancs = kapcs.prepareStatement(s)) {
            parancs.setInt(1, id);
            parancs.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
}