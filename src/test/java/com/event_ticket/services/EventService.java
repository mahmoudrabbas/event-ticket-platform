package com.event_ticket.services;

import com.event_ticket.domain.CreateEventRequest;
import com.event_ticket.domain.entities.Event;

import java.util.UUID;

public interface EventService {

    Event creatEvent(UUID organizerId, CreateEventRequest event);
}
