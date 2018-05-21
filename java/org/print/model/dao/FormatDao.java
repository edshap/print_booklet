package org.print.model.dao;

import org.print.model.entity.Format;

import java.sql.SQLException;

/**
 * Created by Alina on 17.02.2018.
 */
public interface FormatDao extends GenericDao<Format> {
    Format findByFormat (String format) throws SQLException;
}
