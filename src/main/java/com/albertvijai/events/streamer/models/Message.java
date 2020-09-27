package com.albertvijai.events.streamer.models;

import lombok.*;
import java.util.Date;
import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    private UUID id;
    private Date timestamp;
    private String description;
    private String message;

}
