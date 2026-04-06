package com.paymentplatform.auth.domain.event;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserCreatedEvent {
    private final UUID userId;
    private final String email;
    private final String name;
    private final LocalDateTime occurredAt;
    
    public UserCreatedEvent(UUID userId, String email, String name) {
        this.userId = userId;
        this.email = email;
        this.name = name;
        this.occurredAt = LocalDateTime.now();
    }

    public UUID getUserId() { return userId; }
    public String getEmail() { return email; }
    public String getName() { return name; }
    public LocalDateTime getOccurredAt() { return occurredAt; }
}
