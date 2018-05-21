package org.print.model.dao.impl;

import org.print.model.dao.FoldingDao;
import org.print.model.entity.Folding;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Alina on 17.02.2018.
 */
public class JDBCFoldingDao implements FoldingDao {
    public Connection connection;

    public JDBCFoldingDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Folding entity) {

    }

    @Override
    public double findPriceByFold(String fold) throws SQLException {
        Folding folding;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM printbooklet.folding WHERE fold = ?");
            preparedStatement.setString(1, fold);
            ResultSet resultSet = preparedStatement.executeQuery();
            folding = new Folding();
            while (resultSet.next()){
                folding.setPrice(resultSet.getDouble(3));
            }

        } catch (SQLException e){
            throw new SQLException();

        }
        return folding.getPrice();
    }

    @Override
    public Folding findById(int id) {
        return null;
    }

    @Override
    public List<Folding> findAll() {
        return null;
    }

    @Override
    public void update(Folding entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
