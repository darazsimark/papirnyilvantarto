/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papirnyilvantarto;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author Darázsi Márk
 */
public class DB {
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
            dbUrl = "jdbc:mysql://" + ip + ":3306/nyilvantartas"
                    + "?useUnicode=true&characterEncoding=UTF-8";
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            dbUrl = "jdbc:mysql://localhost:3306/nyilvantartas"
                   + "?useUnicode=true&characterEncoding=UTF-8";
        }
    }
}
