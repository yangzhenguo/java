package com.yangzg.java.echo.core;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by Sam on 2020/1/6.
 * @author Sam
 */
@ServerEndpoint("/echo/{uid}")
public class EchoServer {
    private static final Map<Long, List<Session>> SESSION_MAP = new ConcurrentHashMap<>();
    static {
        new Thread(() -> {
            try {
                while (true) {
                    TimeUnit.SECONDS.sleep(10);
                    final IntSummaryStatistics statistics = SESSION_MAP.values().stream().mapToInt(List::size).summaryStatistics();
                    final String message = String.format("Echo系统, PV=%d, UV=%d", statistics.getSum(), statistics.getCount());
                    System.out.println(message);
                    SESSION_MAP.forEach((uid, sessions) -> sessions.forEach(session -> session.getAsyncRemote().sendText(String.format("%s at %s", message, new Date().toString()))));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }).start();
    }

    @OnOpen
    public void init(Session session, EndpointConfig config, @PathParam("uid") long uid) {
        session.getUserProperties().put("uid", uid);
        if (SESSION_MAP.containsKey(uid)) {
            SESSION_MAP.get(uid).add(session);
        } else {
            SESSION_MAP.put(uid, new ArrayList<>(Collections.singletonList(session)));
        }
    }

    /**
     * echo message
     * @param incomingMessage
     * @return
     */
    @OnMessage
    public String echo(Session session, String incomingMessage) {
        return String.format("I got this (%s) so I am sending it back!", incomingMessage);
    }

    @OnClose
    public void close(@PathParam("uid") long uid, CloseReason reason, Session session) {
        if (SESSION_MAP.containsKey(uid) && SESSION_MAP.get(uid).isEmpty()) {
            SESSION_MAP.remove(uid);
        } else if (SESSION_MAP.containsKey(uid)) {
            SESSION_MAP.get(uid).remove(session);
        }
        System.out.println(String.format("close %s, reason: %s", session, reason));
    }

    @OnError
    public void error(@PathParam("uid") long uid, Session session, Throwable error) {
        System.out.println("onError: " + error.getMessage());
    }
}
