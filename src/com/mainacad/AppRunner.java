package com.mainacad;

import com.mainacad.model.ConnectionInfo;
import com.mainacad.service.ConnectionInfoService;
import com.mainacad.service.FileManagerService;
import java.util.logging.Logger;

public class AppRunner {

    private static Logger logger = Logger.getLogger(AppRunner.class.getName());

    public static void main(String[] args) {

        ConnectionInfo connectionInfo = ConnectionInfoService.generateConectionInfoQueue(1).peek();

//        FileManagerService.writeText("connections.txt", connectionInfo.toString(), true);

        logger.info("\n" + FileManagerService.readText("connections.txt"));

    }
}
