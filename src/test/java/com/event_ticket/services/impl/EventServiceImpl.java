package com.event_ticket.services.impl;

import com.event_ticket.domain.CreateEventRequest;
import com.event_ticket.domain.entities.Event;
import com.event_ticket.domain.entities.TicketType;
import com.event_ticket.domain.entities.User;
import com.event_ticket.exceptions.UserNotFoundException;
import com.event_ticket.repositories.EventRepository;
import com.event_ticket.repositories.UserRepository;
import com.event_ticket.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    @Override
    public Event creatEvent(UUID organizerId, CreateEventRequest eventRequest) {
        User Organizer = userRepository.findById(organizerId)
                .orElseThrow(() -> new UserNotFoundException(String.format("User not found found with id '%s'", organizerId)));
        Event event = new Event();

        event.setName(eventRequest.getName());
        event.setStart(eventRequest.getStart());
        event.setEnd(eventRequest.getEnd());
        event.setVenue(eventRequest.getVenue());
        event.setStatus(eventRequest.getStatus());
        event.setSalesStart(eventRequest.getSalesStart());
        event.setSalesEnd(eventRequest.getSalesEnd());

        List<TicketType> ticketTypeToCreate = eventRequest.getTicketType().stream().map(ticketTypeRequest -> {
            TicketType ticketType = new TicketType();
            ticketType.setName(ticketTypeRequest.getName());
            ticketType.setDescription(ticketTypeRequest.getDescription());
            ticketType.setPrice(ticketTypeRequest.getPrice());
            ticketType.setTotalAvailable(ticketTypeRequest.getTotalAvailable());
            return ticketType;
        }).toList();

        event.setTicketType(ticketTypeToCreate);


        eventRepository.save(event);

        return null;
    }
}
