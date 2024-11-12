package pdp.uz.olchawithjakartaweb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    private int id;
    private String name;
    private String colour;
    private int price;

    public Product(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id");
        this.name = resultSet.getString("name");
        this.colour = resultSet.getString("colour");
        this.price = resultSet.getInt("price");
    }

    public Product(String name, String colour, int price) {
        this.name = name;
        this.colour = colour;
        this.price = price;
    }
}

