package com.mainacad;

import com.mainacad.model.ConnectionInfo;
import com.mainacad.model.Gender;
import com.mainacad.model.User;
import com.mainacad.service.ConnectionInfoService;
import com.mainacad.service.FileManagerService;
import com.mainacad.service.MultithreadService;

import java.util.Collections;
import java.util.logging.Logger;

public class AppRunner {

    private static Logger logger = Logger.getLogger(AppRunner.class.getName());

    public static void main(String[] args) {


        for (int i = 0; i < 10; i++) {
            ConnectionInfo connectionInfo = ConnectionInfoService.generateConectionInfoQueue(1).peek();

            MultithreadService multithreadService = new MultithreadService(connectionInfo, "thread "+(i+1) );

            multithreadService.start();
        }


        logger.info("\n" + FileManagerService.readText("connections.txt"));


    }
}
