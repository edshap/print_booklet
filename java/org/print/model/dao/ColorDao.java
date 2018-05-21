package org.print.model.dao;

import org.print.model.entity.Color;
import org.print.model.entity.Format;

import java.sql.SQLException;

/**
 * Created by Alina on 17.02.2018.
 */
public interface ColorDao extends GenericDao<Color>  {
    public double findPriceByColorByFormat(String nameOfFormat, String nameOfColor) throws SQLException;
    //public int findIdByColor(String color, String format) throws SQLException;

}
