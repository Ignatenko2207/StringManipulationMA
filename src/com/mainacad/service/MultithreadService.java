package com.mainacad.service;

import com.mainacad.model.ConnectionInfo;

import java.util.logging.Logger;

public class MultithreadService extends Thread {

    private final ConnectionInfo connectionInfo;
    private final String name;

    private static Logger logger = Logger.getLogger(MultithreadService.class.getName());

    public MultithreadService(ConnectionInfo connectionInfo, String name) {
        this.connectionInfo = connectionInfo;
        this.name = name;
    }

    @Override
    public void run() {
        logger.info(name + " started");
        for (int i = 0; i < 5; i++) {
            FileManagerService.writeText("connections.txt", connectionInfo.toString(), true);
        }

    }
}
