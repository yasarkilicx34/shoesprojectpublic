
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Operation {
  //Import Edilecekler
    Connection con = null;
    Statement sta = null;
    PreparedStatement psta = null;
    
    public int shoesCount(){
        int label = 0;
        String sorgu = " SELECT COUNT(*) FROM shoes_database";
        
        try {
            sta = con.createStatement();
            ResultSet rs = sta.executeQuery(sorgu);
            rs.next();
            label = rs.getInt(1);
            
        } catch (SQLException ex) {
            Logger.getLogger(Operation.class.getName()).log(Level.SEVERE, null, ex);
            return 0 ;
        }
        return label;
    }
    
    public void shoesDelete(int id){
        String sorgu ="DELETE FROM shoes_database WHERE id=?";
        try {
            psta=con.prepareStatement(sorgu);
            psta.setInt(1, id);
            psta.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   public void bookUpdate(int id, String new_code,String new_name,String new_number,String new_type,String new_stock){
       String sorgu ="Update shoes_database SET shoes_code=?,shoes_name=?,shoes_number=?,shoes_type=?,shoes_stock=? WHERE id=?";
        try {
            psta = con.prepareStatement(sorgu);
            psta.setString(1, new_code);
            psta.setString(2, new_name);
            psta.setString(3, new_number);
            psta.setString(4, new_type);
            psta.setString(5, new_stock);
            psta.setInt(6, id);
            psta.executeUpdate();
           
       
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   }
    
   public void shoesAdd(String code, String name, String number, String type, String stock) {
       String sorgu = "Insert into shoes_database(shoes_code,shoes_name,shoes_number,shoes_type,shoes_stock) VALUES (?,?,?,?,?)";
        try {
            psta = con.prepareStatement(sorgu);
            psta.setString(1, code);
            psta.setString(2, name);
            psta.setString(3, number);
            psta.setString(4, type);
            psta.setString(5, stock);
            psta.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Operation.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   }
   public ArrayList<Shoes> ShoesCome(){
       ArrayList<Shoes> list = new ArrayList<Shoes>();
       String sorgu="Select * from shoes_database";
       
        try {
            sta =con.createStatement();
            ResultSet rs = sta.executeQuery(sorgu);
            
            while(rs.next()){
                int id = rs.getInt("id");
                String shoes_code = rs.getString("shoes_code");
                String shoes_name = rs.getString("shoes_name");
                String shoes_number = rs.getString("shoes_number");
                String shoes_type = rs.getString("shoes_type");
                String shoes_stock = rs.getString("shoes_stock");
                list.add(new Shoes(id,shoes_code,shoes_name,shoes_number,shoes_type,shoes_stock));
                
                        
            }
            return list;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Operation.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
       
       
       
   }
    
    
    
   
    public Operation() {
        
        //url-> jdbc:mysql://host:port/db_name;id;password;
        
        String url ="jdbc:mysql://"+Database.host+":"+Database.port+"/"+Database.db_name;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,Database.id,Database.password);
            System.out.println("You have successfully connected to your database. :)");
            
                    } catch (ClassNotFoundException ex) {
            Logger.getLogger(Operation.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("driver failed to initialize :/");
        } catch (SQLException ex) {
            Logger.getLogger(Operation.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Connection Failed :/");
        }
        
    }
    
   
    
    public static void main(String[] args) {
        Operation op = new Operation();
        
    }
    
}
