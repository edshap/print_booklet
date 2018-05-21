package org.print.model.dao.impl;

import org.print.model.dao.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Alina on 17.02.2018.
 */
public class JDBCDaoFactory extends DaoFactory {
    private DataSource dataSource = ConnectionPoolHolder.getDataSource();

    @Override
    public UserDao createUserDao() {
        return new JDBCUserDao(getConnection());
    }

    @Override
    public ColorDao createColorDao() {
        return new JDBCColorDao(getConnection());
    }

    @Override
    public FoldingDao createFoldingDao() {
        return new JDBCFoldingDao(getConnection());
    }

    @Override
    public FormatDao createFormatDao() {
        return new JDBCFormatDao(getConnection());
    }

    @Override
    public GrammDao createGrammDao() {
        return new JDBCGrammDao(getConnection());
    }

    @Override
    public BasketDao createBasketDao() {
        return new JDBCBasketDao(getConnection());
    }

    private Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e){
            throw new RuntimeException();
        }
    }

}
