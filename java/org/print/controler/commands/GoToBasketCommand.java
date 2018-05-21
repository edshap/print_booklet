package org.print.controler.commands;

import org.print.model.dao.BasketDao;
import org.print.model.dao.DaoFactory;
import org.print.model.dao.UserDao;
import org.print.model.entity.Basket;
import org.print.model.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoToBasketCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) throws SQLException {

        String loginCurrentUser = (String) request.getSession().getAttribute("login");
        DaoFactory daoFactory = DaoFactory.getInstance();
        UserDao userDao = daoFactory.createUserDao();
        User user = userDao.findByLogin(loginCurrentUser);
        int idCurrentUser = user.getId();
        request.getSession().setAttribute("idCurrentUser", idCurrentUser);

        BasketDao basketDao = daoFactory.createBasketDao();
        List<Basket> baskets = basketDao.findAll();
        List<Basket> basketsNew = new ArrayList<>();
        for (Basket basket: baskets) {
            if (basket.getIdUser() == idCurrentUser){
                basketsNew.add(basket);
            }
        }

        request.getSession().setAttribute("basketsNew", basketsNew);

        return "/WEB-INF/UserPage/UserPageBasket.jsp";
    }
}
