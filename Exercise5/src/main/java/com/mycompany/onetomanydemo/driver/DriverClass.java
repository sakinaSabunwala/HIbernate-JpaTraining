package com.mycompany.onetomanydemo.driver;

import com.mycompany.onetomanydemo.dao.AttachmentsDao;
import com.mycompany.onetomanydemo.dao.BaseDao;
import com.mycompany.onetomanydemo.dao.PersonnelDao;
import com.mycompany.onetomanydemo.dao.ProposalDao;
import java.sql.Driver;
import java.util.logging.Logger;

/**
 *
 * @author sakina
 */
public class DriverClass {
private static final Logger LOGGER = Logger.getLogger(Driver.class.getName());

    public static void main(String[] args) {

        BaseDao baseDao = null;
        System.out.println("*******88" + args[0]);
        baseDao = getClassInfo(baseDao, args[0]);
        System.out.println("*************" + args[1]);
        getOperation(baseDao, args[1]);

    }

    public static BaseDao getClassInfo(BaseDao baseDao, String daoClass) {
        switch (daoClass) {
            case "proposal":
                baseDao = new ProposalDao();
                break;
            case "personnel":
                baseDao = new PersonnelDao();
                break;
            case "attachment":
                baseDao = new AttachmentsDao();
                break;
            default:
                LOGGER.info("Invalid Input..");
                break;
        }
        return baseDao;
    }

    public static void getOperation(BaseDao obj, String operation) {
        switch (operation) {
            case "insert":
                obj.add();
                break;
            case "update":
                obj.update();
                break;
            case "delete":
                obj.delete();
                break;
            case "retrive":
                obj.getAll();
                break;
            default:
                LOGGER.info("Invalid Input..");
                break;
        }
    }
}
