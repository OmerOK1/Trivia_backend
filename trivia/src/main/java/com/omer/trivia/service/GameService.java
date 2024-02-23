package com.omer.trivia.service;

import com.corundumstudio.socketio.SocketIOServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GameService {

    @Autowired
    private SocketIOServer socketIoServer;

    private static Map<Integer, Boolean> playersDidRespond = new HashMap<>();

    public void sendStartQuestionsEvent() {
        socketIoServer.getBroadcastOperations().sendEvent("startQuestions");
    }


    // Add more methods as needed
}
