
public class Shoes {
    
    private int id;
    private String shoes_code;
    private String shoes_name;
    private String shoes_number;
    private String shoes_type;
    private String shoes_stock;

    public Shoes(int id, String shoes_code, String shoes_name, String shoes_number, String shoes_type, String shoes_stock) {
        this.id = id;
        this.shoes_code = shoes_code;
        this.shoes_name = shoes_name;
        this.shoes_number = shoes_number;
        this.shoes_type = shoes_type;
        this.shoes_stock = shoes_stock;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShoes_code() {
        return shoes_code;
    }

    public void setShoes_code(String shoes_code) {
        this.shoes_code = shoes_code;
    }

    public String getShoes_name() {
        return shoes_name;
    }

    public void setShoes_name(String shoes_name) {
        this.shoes_name = shoes_name;
    }

    public String getShoes_number() {
        return shoes_number;
    }

    public void setShoes_number(String shoes_number) {
        this.shoes_number = shoes_number;
    }

    public String getShoes_type() {
        return shoes_type;
    }

    public void setShoes_type(String shoes_type) {
        this.shoes_type = shoes_type;
    }

    public String getShoes_stock() {
        return shoes_stock;
    }

    public void setShoes_stock(String shoes_stock) {
        this.shoes_stock = shoes_stock;
    }
    
    
}
