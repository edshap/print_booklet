package org.print.model.dao;

import org.print.model.dao.impl.JDBCDaoFactory;

/**
 * Created by Alina on 17.02.2018.
 */
public abstract class DaoFactory {
    private static DaoFactory daoFactory;

    public abstract UserDao createUserDao ();
    public abstract ColorDao createColorDao ();
    public abstract FoldingDao createFoldingDao();
    public abstract FormatDao createFormatDao();
    public abstract GrammDao createGrammDao();
    public abstract BasketDao createBasketDao();

    public static DaoFactory getInstance (){
        if (daoFactory == null){
            synchronized (DaoFactory.class){
                if(daoFactory==null){
                    DaoFactory temp = new JDBCDaoFactory();
                    daoFactory = temp;
                }
            }
        }
        return daoFactory;
    }
}
