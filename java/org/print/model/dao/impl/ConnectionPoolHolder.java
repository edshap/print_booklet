package org.print.model.dao.impl;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

/**
 * Created by Alina on 17.02.2018.
 */
public class ConnectionPoolHolder {
    private static volatile DataSource dataSource;

    public static DataSource getDataSource() {
        if (dataSource == null) {
            synchronized (ConnectionPoolHolder.class){
                if (dataSource == null){
                    BasicDataSource bds = new BasicDataSource();
                    bds.setUrl("jdbc:mysql://localhost:3306/printbooklet");
                    bds.setUsername("root");
                    bds.setPassword("root");
                    bds.setMinIdle(5);
                    bds.setMaxIdle(10);
                    bds.setMaxOpenPreparedStatements(100);
                    dataSource = bds;
                }
            }
        }

        return dataSource;
    }
}
