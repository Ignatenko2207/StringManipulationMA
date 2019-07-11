package com.mainacad.service;

import com.mainacad.model.ConnectionInfo;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Queue;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionInfoServiceTest {

    private static Logger logger = Logger.getLogger(ConnectionInfoServiceTest.class.getName());
    @Test
    void getConnectionsAsText() {
        Queue<ConnectionInfo> connections = ConnectionInfoService.generateConectionInfoQueue(5);
        String result = ConnectionInfoService.getConnectionsAsText(Arrays.asList(connections.peek()));
        logger.info(result);

        assertEquals(3, StringUtils.countMatches(result, "."));


//        assertTrue(result.matches(".*(\\d{3}\\.\\d{3}\\.\\d{3}\\.\\d{3}).*"));
    }
}