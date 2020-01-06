package com.yangzg.java.echo.config;

import com.yangzg.java.echo.core.Echo2Server;

import javax.websocket.Endpoint;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpointConfig;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Sam on 2020/1/6.
 */
public class WebsocketConfig implements ServerApplicationConfig {
    @Override
    public Set<ServerEndpointConfig> getEndpointConfigs(Set<Class<? extends Endpoint>> set) {
        return Stream.of(
                ServerEndpointConfig.Builder.create(Echo2Server.class, "/echo2").build()
        ).collect(Collectors.toSet());
    }

    @Override
    public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> set) {
        return set;
    }
}
