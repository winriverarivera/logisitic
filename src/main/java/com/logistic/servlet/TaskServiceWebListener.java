package com.logistic.servlet;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.core.env.Environment;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.logistic.common.EnumDriverBD;
import com.logistic.common.Sql;


@WebListener
public class TaskServiceWebListener implements ServletContextListener{
	
	@Override
    public void contextInitialized(ServletContextEvent event) {
        loadDatabase(event);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

    private void loadDatabase(ServletContextEvent event) {
        Environment env = WebApplicationContextUtils.getRequiredWebApplicationContext(event.getServletContext()).getBean(Environment.class);
        String driver = env.getProperty("spring.datasource.driver-class-name").replaceAll("\\.", "").toUpperCase();
        EnumDriverBD enumDriverDB = EnumDriverBD.valueOf(driver);
        String db = enumDriverDB.getDB();
        Sql.setMyConfig(db);
    }
}
