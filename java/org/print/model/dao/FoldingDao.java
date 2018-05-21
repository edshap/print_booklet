package org.print.model.dao;

import org.print.model.dao.GenericDao;
import org.print.model.entity.Folding;

import java.sql.SQLException;

/**
 * Created by Alina on 17.02.2018.
 */
public interface FoldingDao extends GenericDao<Folding> {
    public double findPriceByFold (String fold) throws SQLException;
}
