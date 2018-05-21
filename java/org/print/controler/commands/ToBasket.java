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

public class ToBasket implements Command {
    @Override
    public String execute(HttpServletRequest request) throws SQLException {
        //request.getSession().getAttribute("orders");
        int numberOrder = (int) request.getSession().getAttribute("number");
        String formatOrder= (String) request.getSession().getAttribute("format");
        String grammOrder= (String) request.getSession().getAttribute("gramm");
        String colorOrder= (String) request.getSession().getAttribute("color");
        String foldOrder= (String) request.getSession().getAttribute("fold");
        Double quantityOrder= (double) (request.getSession().getAttribute("quantity"));
        Double summOrder= (double)(request.getSession().getAttribute("summ"));
        String payCondition= request.getParameter("condPay");
        String shipment= request.getParameter("shipment");
        String payType= request.getParameter("typePay");
        String loginCurrentUser = (String) request.getSession().getAttribute("login");

        DaoFactory daoFactory = DaoFactory.getInstance();


        UserDao userDao = daoFactory.createUserDao();
        User user = userDao.findByLogin(loginCurrentUser);
        int idCurrentUser = user.getId();
        request.getSession().setAttribute("idCurrentUser", idCurrentUser);

        BasketDao basketDao = daoFactory.createBasketDao();
        basketDao.create(new Basket(numberOrder, formatOrder, grammOrder, colorOrder, foldOrder, quantityOrder,
                summOrder, payCondition, shipment, payType, idCurrentUser));

        List<Basket> baskets = basketDao.findAll();
        List<Basket> basketsNew = new ArrayList<>();
        for (Basket basket: baskets) {
            if (basket.getIdUser() == idCurrentUser){
                basketsNew.add(basket);
            }
        }

        request.getSession().setAttribute("basketsNew", basketsNew);

        return "/WEB-INF/UserPage/UserPageCalcResult.jsp";
    }
}
