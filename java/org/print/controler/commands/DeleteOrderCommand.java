package org.print.controler.commands;

import org.print.model.dao.BasketDao;
import org.print.model.dao.DaoFactory;
import org.print.model.entity.Basket;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class DeleteOrderCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws SQLException {
        int numberOrder = Integer.valueOf(request.getParameter("numberOrder"));
        DaoFactory daoFactory = DaoFactory.getInstance();
        BasketDao basketDao = daoFactory.createBasketDao();
        basketDao.deleteOrder(numberOrder);

        return "/WEB-INF/UserPage/UserPage.jsp";
    }
}
