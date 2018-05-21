package org.print.controler.commands;

import org.print.model.dao.BasketDao;
import org.print.model.dao.DaoFactory;
import org.print.model.entity.Basket;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class OrderCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws SQLException {

        int numberOrder = Integer.valueOf(request.getParameter("numberOrder"));
        DaoFactory daoFactory = DaoFactory.getInstance();
        BasketDao basketDao = daoFactory.createBasketDao();
        Basket basketOrder = basketDao.findByNumberOrder(numberOrder);
        request.getSession().setAttribute("basketOrder" , basketOrder);


        /*long serialVersionUID = 1L;
        String SAVE_DIRECTORY = "uploadDir";
        String description = request.getParameter("description");
        System.out.println("Description: " + description);

        // Gets absolute path to root directory of web app.
        String appPath = request.getServletContext().getRealPath("");
        appPath = appPath.replace('\\', '/');

        // The directory to save uploaded file
        String fullSavePath = null;
        if (appPath.endsWith("/")) {
            fullSavePath = appPath + SAVE_DIRECTORY;
        } else {
            fullSavePath = appPath + "/" + SAVE_DIRECTORY;
        }

        // Creates the save directory if it does not exists
        File fileSaveDir = new File(fullSavePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }

        // Part list (multi files).
        for (Part part : request.getParts()) {
            String fileName = extractFileName(part);
            if (fileName != null && fileName.length() > 0) {
                String filePath = fullSavePath + File.separator + fileName;
                System.out.println("Write attachment to file: " + filePath);
                // Write to file
                part.write(filePath);
            }
        }
        // Upload successfully!.
        response.sendRedirect(request.getContextPath() + "/uploadFileResults");
    } catch (Exception e) {
        e.printStackTrace();
        request.setAttribute("errorMessage", "Error: " + e.getMessage());
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsps/uploadFile.jsp");
        dispatcher.forward(request, response);
    }*/
        return "/WEB-INF/UserPage/UserPageOrder.jsp";
    }
}
