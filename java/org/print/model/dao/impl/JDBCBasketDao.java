package org.print.model.dao.impl;

import org.print.model.dao.BasketDao;
import org.print.model.entity.Basket;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCBasketDao implements BasketDao {
    private Connection connection;

    public JDBCBasketDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Basket order) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT into basket (numberOrder, formatOrder, " +
                "grammOrder,colorOrder, foldOrder, quantityOrder, summOrder, payCondition, shipment, payType, idUser) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            preparedStatement.setInt(1, order.getNumberOrder());
            preparedStatement.setString(2, order.getFormatOrder());
            preparedStatement.setString(3, order.getGrammOrder());
            preparedStatement.setString(4, order.getColorOrder());
            preparedStatement.setString(5, order.getFoldOrder());
            preparedStatement.setDouble(6, order.getQuantityOrder());
            preparedStatement.setDouble(7, order.getSummOrder());
            preparedStatement.setString(8, order.getPayCondition());
            preparedStatement.setString(9, order.getShipment());
            preparedStatement.setString(10, order.getPayType());
            preparedStatement.setInt(11, order.getIdUser());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            throw new SQLException();
        }
    }

    @Override
    public Basket findById(int id) {
        return null;
    }

    @Override
    public Basket findByNumberOrder(int NumberOrder) throws SQLException {
        Basket basket = new Basket();
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM basket WHERE numberOrder = " + NumberOrder)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                int numberOrder = resultSet.getInt(2);
                String formatOrder = resultSet.getString(3);
                String grammOrder = resultSet.getString(4);
                String colorOrder = resultSet.getString(5);
                String foldOrder = resultSet.getString(6);
                Double quantityOrder = resultSet.getDouble(7);
                Double summOrder = resultSet.getDouble(8);
                String payCondition = resultSet.getString(9);
                String shipment = resultSet.getString(10);
                String payType = resultSet.getString(11);
                int idUser = resultSet.getInt(12);
                basket.setIdBasket(id);
                basket.setNumberOrder(numberOrder);
                basket.setFormatOrder(formatOrder);
                basket.setGrammOrder(grammOrder);
                basket.setColorOrder(colorOrder);
                basket.setFoldOrder(foldOrder);
                basket.setQuantityOrder(quantityOrder);
                basket.setSummOrder(summOrder);
                basket.setPayCondition(payCondition);
                basket.setShipment(shipment);
                basket.setPayType(payType);
                basket.setIdUser(idUser);
            }
        } catch (SQLException e){
            throw new SQLException();
        }

        return basket;
    }

    @Override
    public List<Basket> findAll() {
        List<Basket> baskets = new ArrayList<>();

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM basket")) {
            while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    int numberOrder = resultSet.getInt(2);
                    String formatOrder = resultSet.getString(3);
                    String grammOrder = resultSet.getString(4);
                    String colorOrder = resultSet.getString(5);
                    String foldOrder = resultSet.getString(6);
                    Double quantityOrder = resultSet.getDouble(7);
                    Double summOrder = resultSet.getDouble(8);
                    String payCondition = resultSet.getString(9);
                    String shipment = resultSet.getString(10);
                    String payType = resultSet.getString(11);
                    int idUser = resultSet.getInt(12);

                    Basket basket = new Basket();
                    basket.setIdBasket(id);
                    basket.setNumberOrder(numberOrder);
                    basket.setFormatOrder(formatOrder);
                    basket.setGrammOrder(grammOrder);
                    basket.setColorOrder(colorOrder);
                    basket.setFoldOrder(foldOrder);
                    basket.setQuantityOrder(quantityOrder);
                    basket.setSummOrder(summOrder);
                    basket.setPayCondition(payCondition);
                    basket.setShipment(shipment);
                    basket.setPayType(payType);
                    basket.setIdUser(idUser);
                    baskets.add(basket);
                }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return baskets;
    }

    @Override
    public void update(Basket entity) throws SQLException {

    }

    @Override
    public void delete(int id) {
    }

    public void deleteOrder (int numberOrder) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM basket WHERE numberOrder = " + numberOrder)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {

    }
}
