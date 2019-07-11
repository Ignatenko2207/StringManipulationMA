package com.mainacad;

import com.mainacad.model.ConnectionInfo;
import com.mainacad.service.ConnectionInfoService;
import com.mainacad.util.Randomizer;

import java.util.Queue;
import java.util.logging.Logger;

public class AppRunner {

    private static Logger logger = Logger.getLogger(AppRunner.class.getName());

    public static void main(String[] args) {

        Queue<ConnectionInfo> connections = ConnectionInfoService.generateConectionInfoQueue(5);

        logger.info(String.format("My system generated %d connections. %s", connections.size(), "It's cool!"));
//
        String connectionsAsText = ConnectionInfoService.getConnectionsAsText(connections);
        logger.info("\n" + connectionsAsText);



    }
}
