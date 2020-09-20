package com.albertvijai.events.streamer.handlers;

import com.albertvijai.events.streamer.models.In;
import com.albertvijai.events.streamer.models.Out;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

//Interface that binds multiple channel topics for processing Pub/Sub messages.
@EnableBinding(value = { In.class, Out.class })
public interface Processor extends Source, Sink {
    @Input
    SubscribableChannel in();

    @Input
    SubscribableChannel inner();

    @Output
    MessageChannel out();

    @Output
    MessageChannel outer();
}
