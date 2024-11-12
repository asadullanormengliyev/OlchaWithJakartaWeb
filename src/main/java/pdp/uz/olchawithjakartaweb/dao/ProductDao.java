package pdp.uz.olchawithjakartaweb.dao;

import pdp.uz.olchawithjakartaweb.model.Product;
import pdp.uz.olchawithjakartaweb.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDao extends DatabaseConnection {
    private static final String CREATE_USER = "select * from add_product(i_name := ?, i_colour := ?, i_price := ?)";
    private static final String GET_PRODUCT_LIST = "select * from product";

    public User createUser(Product product) {
        try (Connection connection = connection();
             PreparedStatement preparedStatement1 = connection.prepareStatement(CREATE_USER)) {
            preparedStatement1.setString(1, product.getName());
            preparedStatement1.setString(2, product.getColour());
            preparedStatement1.setInt(3, product.getPrice());
            ResultSet resultSet = preparedStatement1.executeQuery();
            resultSet.next();
            return new User(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Database connection is lost");
        }
    }

    public List<Product> productList() {
        try(Connection connection = connection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCT_LIST)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Product> productList = new ArrayList<>();
            while (resultSet.next()) {
                Product product = new Product(resultSet);
                productList.add(product);
            }
            return productList;
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Database connection is lost");
        }
    }
}
