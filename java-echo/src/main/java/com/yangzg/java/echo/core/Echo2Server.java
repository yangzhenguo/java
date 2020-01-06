package com.yangzg.java.echo.core;

import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.Session;
import java.io.IOException;

/**
 * Created by Sam on 2020/1/6.
 * @author Sam
 */
public class Echo2Server extends Endpoint {

    @Override
    public void onOpen(Session session, EndpointConfig endpointConfig) {
        System.out.println(session.getQueryString());
        session.addMessageHandler(String.class, message -> {
            try {
                session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
