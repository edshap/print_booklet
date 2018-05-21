package org.print.model.dao;

import org.print.model.entity.Basket;

import java.sql.SQLException;

public interface BasketDao extends GenericDao<Basket> {
    Basket findByNumberOrder (int NumberOrder) throws SQLException;
    public void deleteOrder (int numberOrder) throws SQLException;
}
