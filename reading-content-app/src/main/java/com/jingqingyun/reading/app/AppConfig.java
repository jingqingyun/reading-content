package com.jingqingyun.reading.app;

import cqrs.CommandGateway;
import cqrs.CommandHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * AppConfig
 *
 * @author jingqingyun
 * @date 2020/11/26
 */
@Configuration
public class AppConfig {

    @SuppressWarnings({"rawtypes"})
    @Bean
    public CommandGateway commandGateway(List<CommandHandler> commandHandlers) {
        return new CommandGateway(commandHandlers);
    }

}
