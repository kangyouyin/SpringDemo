package com.kyy.springmvc.controllers;

import com.kyy.springmvc.handler.UserHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by kangyouyin on 2018/10/11.
 */
@Controller
@RequestMapping("/test")
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private UserHandler userHandler;

    /**
     * http://localhost:8080/test/printInfo?informations=first
     *
     * @param informations
     * @return
     */
    @ResponseBody
    @RequestMapping("/printInfo")
    public String printInfo(String informations) {
        logger.info("Informations: " + informations);
        return informations;
    }

    /**
     * http://localhost:8080/test/getUserInfo
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/getUserInfo")
    public Object getUserInfo() {
        return userHandler.getUserInfo();
    }
}