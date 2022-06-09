package utils;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

public class HibernateListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce)  {
		HibernateUtil.getSessionFactory();
		System.out.println("init執行");
	}
	
	@Override
  	public void contextDestroyed(ServletContextEvent sce)  {
		HibernateUtil.shutdown();
		System.out.println("Destroyed執行");
		Enumeration<Driver> drivers = DriverManager.getDrivers();
        Driver d = null;
        while (drivers.hasMoreElements()) {
            try {
                d = drivers.nextElement();
                DriverManager.deregisterDriver(d);
            } catch (SQLException ex) {
            }
        }
        // 注意：mysql8版本的jar好像shutdown方法私有了，只能调用checkedShutdown或uncheckedShutdown
		AbandonedConnectionCleanupThread.checkedShutdown();
		
	}
}
