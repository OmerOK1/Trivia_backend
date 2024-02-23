package com.omer.trivia.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.corundumstudio.socketio.SocketIOServer;

@Configuration
public class SocketIoConfig {

    @Bean
    public SocketIOServer socketIOServer() {
        com.corundumstudio.socketio.Configuration config = new com.corundumstudio.socketio.Configuration();
        config.setHostname("localhost"); // Set your hostname
        config.setPort(8080); // Set your port
        return new SocketIOServer(config);
    }
}
