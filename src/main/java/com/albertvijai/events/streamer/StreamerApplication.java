package com.albertvijai.events.streamer;

import com.albertvijai.events.streamer.handlers.Processor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableBinding(value = { Sink.class, Processor.class })
public class StreamerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StreamerApplication.class, args);
	}

	@StreamListener(Sink.INPUT)
	public void handle(Person person){
		System.out.println("Received "+ person );
	}

	public static class Person {
		@Getter
		@Setter
		private String name;
		@Override public String toString() {
			return this.name;
		}
	}

}