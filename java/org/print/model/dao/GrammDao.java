package org.print.model.dao;

import org.print.model.entity.Gramm;

import java.sql.SQLException;

/**
 * Created by Alina on 17.02.2018.
 */
public interface GrammDao extends GenericDao<Gramm> {
    public double findPriceByGrammByFormat (String gramm, String format) throws SQLException;
}
