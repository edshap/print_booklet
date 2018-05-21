package org.print.model.dao.impl;

import org.print.model.dao.ColorDao;
import org.print.model.entity.Color;
import org.print.model.entity.Format;
import org.print.model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Alina on 17.02.2018.
 */
public class JDBCColorDao implements ColorDao {
    public Connection connection;

    public JDBCColorDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Color entity) {

    }

    @Override
    public Color findById(int id) {
        return null;
    }

/*    @Override
    public int findIdByColor(String color, String format) throws SQLException{
        Color colorOfId;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM printbooklet.color " +
            "WHERE color = ? AND format = ?");
            preparedStatement.setString(1, color);
            preparedStatement.setString(2, format);
            ResultSet resultSet = preparedStatement.executeQuery();
            colorOfId=new Color();
            while (resultSet.next()){
                colorOfId.setId(resultSet.getInt(1));
                //colorOfId.setFormat(resultSet.getString());
            }
        } catch (SQLException e){
            throw new SQLException();
        }
        return colorOfId.getId();
    }*/

    @Override
    public double findPriceByColorByFormat(String nameOfFormat, String nameOfColor) throws SQLException {
        Color color;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM printbooklet.color LEFT JOIN printbooklet.format USING (id_format) WHERE format = ? AND color = ? ");
            preparedStatement.setString(1, nameOfFormat.toString() );
            preparedStatement.setString(2, nameOfColor.toString() );

            ResultSet resultSet = preparedStatement.executeQuery();
            color = new Color();
            while (resultSet.next()){
                color.setPrice(resultSet.getDouble(4));
            }
        } catch(SQLException e){
            throw new SQLException();
        }
        return color.getPrice();
    }

    @Override
    public List<Color> findAll() {
        return null;
    }

    @Override
    public void update(Color entity) {

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
