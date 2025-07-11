package com.event_ticket.domain;

import com.event_ticket.domain.entities.Event;
import com.event_ticket.domain.entities.Ticket;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateTicketTypeRequest {
    private String name;
    private String description;
    private Double price;
    private Integer totalAvailable;
    private Event event;
}
