package com.albertvijai.events.streamer.handlers;

import com.albertvijai.events.streamer.models.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

import java.util.UUID;
import java.util.function.Function;

@EnableBinding(value = { Message.class})
public interface MessageProcessor extends Source, Sink {

    static final Logger log = LoggerFactory.getLogger(MessageProcessor.class);

//    @Input("DEMO_INBOX")
//    SubscribableChannel in();
//
//    @Output("SOLACE_MSG_QUEUE")
//    MessageChannel out();

    @Bean
    default public Function<Message, Message> emitAMessage() {
       return message -> {
           System.out.println("Receiving message from space !! ");
           return new Message();
       };
    }

}
