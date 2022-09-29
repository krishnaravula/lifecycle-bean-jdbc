package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

import java.sql.SQLException;

public class Test {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {


        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        StudentDao dao = context.getBean("student",StudentDao.class);

        dao.selectAllRows();
        dao.deleteRows(12);
        dao.closeConnection();
    }
}
