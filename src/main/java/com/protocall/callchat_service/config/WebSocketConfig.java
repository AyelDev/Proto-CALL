package com.protocall.callchat_service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.protocall.callchat_service.handler.SocketHandler;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

  @Override
public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
    // Missing () fixed, and passing your custom handler class
    registry.addHandler(new SocketHandler(), "/socket")
            .setAllowedOrigins("*"); 
}

}
