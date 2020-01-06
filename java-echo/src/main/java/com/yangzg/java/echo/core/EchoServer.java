package com.yangzg.java.echo.core;

import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

/**
 * Created by Sam on 2020/1/6.
 * @author Sam
 */
@ServerEndpoint("/echo")
public class EchoServer {
    /**
     * echo message
     * @param incomingMessage
     * @return
     */
    @OnMessage
    public String echo(String incomingMessage) {
        return String.format("I got this (%s) so I am sending it back!", incomingMessage);
    }
}
