package com.yangzg.java.echo.core;

import com.yangzg.java.echo.util.RedisUtil;
import redis.clients.jedis.Jedis;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Sam on 2020/1/6.
 * @author Sam
 */
@ServerEndpoint("/words")
public class RandomWordServer {
    public static final List<RandomWordServer> sockets = new ArrayList<>();

    static {
        new Thread(() -> {
            while (true) {
                try {
                    System.out.println(sockets);
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    @OnMessage
    public String echo(String message) {
        return message;
    }

    @OnOpen
    public void onOpen(@PathParam("clientId") String clientId, Session session) {
        sockets.add(this);
        try (Jedis jedis = RedisUtil.JEDIS_POOL.getResource()) {
            while (true) {
                final List<String> words = jedis.blpop((int) TimeUnit.MINUTES.toSeconds(1), "words");
                try {
                    synchronized (sockets) {
                        if (sockets.contains(this) && session.isOpen()) {
                            words.remove(0);
                            session.getBasicRemote().sendText(String.join(",", words));
                        } else {
                            break;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println(sockets.size());
                }
            }
        }
    }

    @OnClose
    public void onClose(Session session) {
        synchronized (sockets) {
            sockets.remove(this);
        }
    }

    @OnError
    public void onError(Throwable error) {
        error.printStackTrace();
    }
}
