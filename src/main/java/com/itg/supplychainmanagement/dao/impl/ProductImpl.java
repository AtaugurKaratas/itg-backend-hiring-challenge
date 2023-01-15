package com.itg.supplychainmanagement.dao.impl;

import com.itg.supplychainmanagement.dao.ProductDao;
import com.itg.supplychainmanagement.dto.ProductDTO;
import com.itg.supplychainmanagement.model.Cart;
import com.itg.supplychainmanagement.model.Product;
import com.itg.supplychainmanagement.model.ProductImage;
import com.itg.supplychainmanagement.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class ProductImpl implements ProductDao {
    @Override
    public int addProduct(String name, float price, int retailerId) {
        int productId = 0;
        try{
            Connection connection = DBUtil.connection();
            String saveProduct = "Insert into product (name, quantity, price, discount, retailerid) values (?, ?, ?, ?, ?)";
            PreparedStatement preStatement = connection.prepareStatement(saveProduct, Statement.RETURN_GENERATED_KEYS);
            preStatement.setString(1, name);
            preStatement.setInt(2, 0);
            preStatement.setFloat(3, price);
            preStatement.setInt(4, 0);
            preStatement.setInt(5, retailerId);
            productId = preStatement.executeUpdate();
            ResultSet generatedKeys = preStatement.getGeneratedKeys();
            if(generatedKeys.next()){
                productId = generatedKeys.getInt("id");
            }
            DBUtil.close(connection, preStatement, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productId;
    }

    @Override
    public void addProductImage(String path, int productId) {
        Connection connection = DBUtil.connection();
        try{
            String saveProduct = "Insert into productimage (path, productId) values (?, ?)";
            PreparedStatement preStatement = connection.prepareStatement(saveProduct);
            preStatement.setString(1, path);
            preStatement.setInt(2, productId);
            preStatement.executeUpdate();
            DBUtil.close(connection, preStatement, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ProductDTO> searchProduct(String name) {
        List<ProductDTO> productList = new ArrayList<>();
        try{
            Connection connection = DBUtil.connection();
            PreparedStatement preStatement = connection.prepareStatement("Select product.id, product.name, product.quantity, " +
                    "product.price, product.discount, product.retailerid, productimage.path from product inner join productimage on product.id=productimage.productid where name like ?");
            preStatement.setString(1, (name + "%"));
            ResultSet rs = preStatement.executeQuery();
            Set<Integer> set = new HashSet<>();
            while (rs.next()){
                ProductDTO productDTO = new ProductDTO();
                productDTO.setProductId(rs.getInt("id"));
                productDTO.setName(rs.getString("name"));
                productDTO.setQuantity(rs.getInt("quantity"));
                productDTO.setPrice(rs.getFloat("price"));
                productDTO.setDiscount(rs.getInt("discount"));
                productDTO.setRetailerId(rs.getInt("retailerId"));
                productDTO.setPath(rs.getString("path"));
                if(!set.contains(productDTO.getProductId()))
                    productList.add(productDTO);
                set.add(productDTO.getProductId());
            }
            DBUtil.close(connection, preStatement, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public List<Cart> addToCart(List<Cart> carts) {
        List<Cart> cartList = carts;
        return cartList;
    }

    @Override
    public List<ProductDTO> outOfStockProduct() {
        ArrayList<ProductDTO> productList = new ArrayList<>();
        try{
            Connection connection = DBUtil.connection();
            PreparedStatement preStatement = connection.prepareStatement("Select product.id, product.name, product.quantity, " +
                    "product.price, product.discount, product.retailerid, productimage.path from product inner join productimage on product.id=productimage.productid where quantity<1");
            ResultSet rs = preStatement.executeQuery();
            Set<Integer> set = new HashSet<>();
            while (rs.next()){
                ProductDTO productDTO = new ProductDTO();
                productDTO.setProductId(rs.getInt("id"));
                productDTO.setName(rs.getString("name"));
                productDTO.setQuantity(rs.getInt("quantity"));
                productDTO.setPrice(rs.getFloat("price"));
                productDTO.setDiscount(rs.getInt("discount"));
                productDTO.setRetailerId(rs.getInt("retailerId"));
                productDTO.setPath(rs.getString("path"));
                if(!set.contains(productDTO.getProductId()))
                    productList.add(productDTO);
                set.add(productDTO.getProductId());
            }
            DBUtil.close(connection, preStatement, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public List<ProductImage> getProductImages(int productId) {
        List<ProductImage> productImageList = new ArrayList<>();
        try{
            Connection connection = DBUtil.connection();
            PreparedStatement preStatement = connection.prepareStatement("Select * from productimage where productid = ?");
            preStatement.setInt(1, productId);
            ResultSet rs = preStatement.executeQuery();
            while (rs.next()){
                ProductImage productImage = new ProductImage();
                productImage.setId(rs.getInt("id"));
                productImage.setPath(rs.getString("path"));
                productImage.setProduct(rs.getInt("productid"));
                productImageList.add(productImage);
            }
            DBUtil.close(connection, preStatement, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productImageList;
    }

    @Override
    public void updateProduct(int id, int quantity, int discount) {
        try{
            Connection connection = DBUtil.connection();
            PreparedStatement preStatement = connection.prepareStatement("Update product set quantity = ?, discount = ? where id = ?");
            preStatement.setInt(1, quantity);
            preStatement.setInt(2, discount);
            preStatement.setInt(3, id);
            preStatement.executeUpdate();
            DBUtil.close(connection, preStatement, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
