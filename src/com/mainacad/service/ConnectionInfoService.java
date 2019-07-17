package com.mainacad.service;

import com.mainacad.model.ConnectionInfo;
import com.mainacad.model.Gender;
import com.mainacad.model.User;
import com.mainacad.util.Randomizer;

import java.util.Collection;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.Queue;

public class ConnectionInfoService {

    public static Queue<ConnectionInfo> generateConectionInfoQueue(int amount){
        Queue<ConnectionInfo> connections = new PriorityQueue<>();

        for (int i = 0; i < amount; i++) {
            Integer sessionId = Randomizer.getRandomNumber(1_000_000, 9_999_999);
            String userIp = Randomizer.getRandomNumber(100, 255) + "." +
                    Randomizer.getRandomNumber(100, 255) + "." +
                    Randomizer.getRandomNumber(100, 255) + "." +
                    Randomizer.getRandomNumber(100, 255);
            Long time = new Date().getTime() - Randomizer.getRandomNumber(0, 1000*60*60*24*3);

            User user = new User(
                    Randomizer.getRandomNumber(10000, 99999),
                    Randomizer.getRandomString(10),
                    Randomizer.getRandomString(12), Gender.FEMALE);

            ConnectionInfo connectionInfo = new ConnectionInfo(sessionId, userIp, time, user);
            connections.add(connectionInfo);
        }
        return connections;
    }

    public static String getConnectionsAsText(Collection<ConnectionInfo> connections){
        String outText = "";
        for (ConnectionInfo connectionInfo : connections) {
            outText += connectionInfo.toString() + "\n";
        }
        return outText;
    }

    public static Queue<ConnectionInfo> getConnectionsFromText(String text){
        Queue<ConnectionInfo> connections = new PriorityQueue<>();

        String[] lines = text.split("\n");

        for (String line : lines){
            String[] words = line.split(" ");

            User user = new User(Integer.valueOf(words[5]), words[3], words[4], Gender.FEMALE);

            ConnectionInfo connectionInfo = new ConnectionInfo(Integer.valueOf(words[1]),
                    words[2], Long.valueOf(words[0]), user);

            connections.add(connectionInfo);
        }

        return connections;
    }

    public static Queue<ConnectionInfo> filterConnectionsByTime(Collection<ConnectionInfo> allConnections, long from, long to){
        Queue<ConnectionInfo> connections = new PriorityQueue<>();
        for (ConnectionInfo connectionInfo: allConnections) {
            if (connectionInfo.getTime() >= from && connectionInfo.getTime() <= to){
                connections.add(connectionInfo);
            }
        }
        return connections;
    }
}
