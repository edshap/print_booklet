package org.print.model.dao.impl;

import org.print.model.dao.GrammDao;
import org.print.model.entity.Format;
import org.print.model.entity.Gramm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Alina on 17.02.2018.
 */
public class JDBCGrammDao implements GrammDao {
    public Connection connection;

    public JDBCGrammDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Gramm entity) {

    }

    @Override
    public double findPriceByGrammByFormat(String nameOfGramm, String nameOfFormat) throws SQLException {
        Gramm gramm;
        try{
            PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM printbooklet.gramm LEFT JOIN printbooklet.format USING (id_format) WHERE gramm=? AND format=?");
            preparedStatement.setString(1, nameOfGramm);
            preparedStatement.setString(2, nameOfFormat);

            ResultSet resultSet = preparedStatement.executeQuery();
            gramm = new Gramm();
            while (resultSet.next()){
                gramm.setPrice(resultSet.getDouble(4));
            }
        } catch (SQLException e) {
            throw new SQLException();
        }

        return gramm.getPrice();
    }

    @Override
    public Gramm findById(int id) {
        return null;
    }

    @Override
    public List<Gramm> findAll() {
        return null;
    }

    @Override
    public void update(Gramm entity) {

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
