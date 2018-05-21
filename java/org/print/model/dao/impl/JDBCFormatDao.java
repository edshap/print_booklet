package org.print.model.dao.impl;

import org.print.model.dao.FormatDao;
import org.print.model.entity.Format;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Alina on 17.02.2018.
 */
public class JDBCFormatDao implements FormatDao {
    public Connection connection;

    public JDBCFormatDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Format entity) {

    }

    @Override
    public Format findByFormat(String nameOfFormat) throws SQLException {
        Format format;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM printbooklet.format WHERE format = ?");
            preparedStatement.setString(1, nameOfFormat);
            ResultSet resultSet = preparedStatement.executeQuery();
            format = new Format();
            while (resultSet.next()){
                format.setFormat(resultSet.getString(1));
            }
        } catch (SQLException e){
            throw new SQLException ();
        }
        return format;
    }

    @Override
    public Format findById(int id) {
        return null;
    }

    @Override
    public List<Format> findAll() {
        return null;
    }

    @Override
    public void update(Format entity) {

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
