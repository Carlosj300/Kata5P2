package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MailListReaderBD {
    
    public List<String> read() throws SQLException {
        
        String sql = "SELECT Mail FROM EMAIL";
        List<String> mail = new ArrayList<>();
        
        try(Connection con  = this.connect();
                Statement stmt  = con.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)){
            
            while(rs.next()){
                mail.add(rs.getString("Mail"));
            }
        }
        
        return mail;
    }

    private Connection connect() {
        String url = "jdbc:sqlite:KATA5.db";
        
        Connection con = null;
        try {
            con = DriverManager.getConnection(url);
            System.out.println("Conexion establecida");
        } catch( SQLException e){
            System.out.println(e.getMessage());
        }
        
        return con;
    }

}
