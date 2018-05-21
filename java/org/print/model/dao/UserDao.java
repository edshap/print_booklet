package org.print.model.dao;

import org.print.model.entity.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Alina on 17.02.2018.
 */
public interface UserDao extends GenericDao<User> {

    boolean noEntryInDB (User user);
    User findByLogin (String login) throws SQLException;
    //List<User> findAll();

}
