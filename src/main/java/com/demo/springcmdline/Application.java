package com.demo.springcmdline;

import com.demo.springcmdline.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by Alan Huang.
 * Date: 2020-07-08 11:08
 */
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Application application = Application.getInstance();
        application.initialize();

        logger.info("Application started!");

        UserService userService = (UserService)application.getBean("userService");
        System.out.println(userService.toString());
        userService.findById(1);
    }


    private static final Application instance = new Application();
    public static Application getInstance() {
        return instance;
    }


    private ApplicationContext appContext;

    public void initialize() {
        logger.info("application context initializing...");
        this.appContext = new ClassPathXmlApplicationContext("beans.xml");
        logger.info("application context initialized");
    }

    public Object getBean(String name) {
        return appContext.getBean(name);
    }

}
