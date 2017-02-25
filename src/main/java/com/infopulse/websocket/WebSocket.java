package com.infopulse.websocket;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * Created by vedmant on 2/25/17.
 */
@ServerEndpoint(value = "/websock")
public class WebSocket {

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("================== On open ==================");
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        System.out.println("================== On message ==================");
        System.out.println("Message: " + message);

        message = "Server: " + message;

        session.getBasicRemote().sendText(message);
    }
}
