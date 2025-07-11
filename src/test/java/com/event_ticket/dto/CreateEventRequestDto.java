package com.event_ticket.dto;

import com.event_ticket.domain.CreateTicketTypeRequest;
import com.event_ticket.enums.EventStatus;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateEventRequestDto {
    @NotBlank(message = "Name is required")
    private String name;
    private LocalDateTime start;
    private LocalDateTime end;

    @NotBlank(message = "Venue is required")
    private String venue;
    private LocalDateTime salesStart;
    private LocalDateTime salesEnd;
    @NotBlank(message = "Event Status is required")
    private EventStatus status;
    @NotEmpty(message = "At Least one ticket provided")
    @Valid
    private List<CreateTicketTypeRequest> ticketType = new ArrayList<>();
}
