package com.event_ticket.dto;

import com.event_ticket.domain.entities.Event;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateTicketTypeRequestDto {
    @NotBlank(message = "Name is required")
    private String name;
    private String description;
    @PositiveOrZero(message = "Price Must be zero or grater")
    private Double price;
    private Integer totalAvailable;
}
