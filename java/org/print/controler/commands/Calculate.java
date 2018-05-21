package org.print.controler.commands;

import org.print.model.dao.ColorDao;
import org.print.model.dao.DaoFactory;
import org.print.model.dao.FoldingDao;
import org.print.model.dao.GrammDao;
import org.print.model.entity.Color;
import org.print.model.entity.Folding;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.Date;

public class Calculate implements Command {
    @Override
    public String execute(HttpServletRequest request) throws SQLException {

        String format = request.getParameter("format");
        //request.getSession().getAttribute(format);
        request.getSession().setAttribute("format", format);
        String color = request.getParameter("color");
        request.getSession().setAttribute("color", color);
        String gramm = request.getParameter("gramm");
        request.getSession().setAttribute("gramm", gramm);
        String fold = request.getParameter("fold");
        request.getSession().setAttribute("fold", fold);
        Double quantity = Double.parseDouble(request.getParameter("quantity"));
        request.getSession().setAttribute("quantity", quantity);

        DaoFactory daoFactory = DaoFactory.getInstance();
        ColorDao colorDao = daoFactory.createColorDao();
        double priceByColorByFormat = colorDao.findPriceByColorByFormat(format, color);
        System.out.println(priceByColorByFormat);
        GrammDao grammDao = daoFactory.createGrammDao();
        double priceByGrammByFormat = grammDao.findPriceByGrammByFormat(gramm, format);
        System.out.println(priceByGrammByFormat);
        FoldingDao foldingDao = daoFactory.createFoldingDao();
        double priceByFold = foldingDao.findPriceByFold(fold);
        System.out.println(priceByFold);
        System.out.println(quantity);

        Double summ = (priceByColorByFormat + priceByGrammByFormat + priceByFold) * quantity;
        request.getSession().setAttribute("summ", summ);

        //заглушка
        Double weight = 8.5;
        request.getSession().setAttribute("weight", weight);

        //заглушка
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy E");
        Date newDate = new Date(date.getTime() + 24*3600*1000);
        String dateNow = simpleDateFormat.format(newDate);
        request.getSession().setAttribute("dateNow", dateNow);
        //заглушка
        int number = (int) (1000 + Math.random()*9999);
        request.getSession().setAttribute("number", number);



        //request.getSession().setAttribute("");


        return "/WEB-INF/UserPage/UserPageCalcResult.jsp";
    }
}
