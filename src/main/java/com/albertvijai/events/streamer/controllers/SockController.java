package com.albertvijai.events.streamer.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Configuration
@EnableWebSocket
public class SockController implements WebSocketConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(SockController.class);

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new SockTextHandler(), "/text").withSockJS();
        registry.addHandler(new SockBinaryHandler(), "/binary");
        registry.addHandler(new SockProtoBuffer(), "/protobuff");
    }

    @Component
    public static class SockTextHandler extends TextWebSocketHandler {
        public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
            super.handleTextMessage(session, message);
        }
    }

    @Component
    public static class SockBinaryHandler extends BinaryWebSocketHandler {
        public void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws Exception{
            super.handleBinaryMessage(session, message);
        }
    }

    @Component
    public class SockProtoBuffer extends BinaryWebSocketHandler {
        @Override
        protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws Exception {
            super.handleBinaryMessage(session, message);
        }
    }

}
