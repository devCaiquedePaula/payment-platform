package com.paymentplatform.auth.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class User {
    private UUID id;
    private String name;
    private String email;
    private String password;
    private Role role;
    private boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public User() {
    }

    // Factory method — the only way to create a new User
    public static User create(String name,
                              String email,
                              String password) {
        User user = new User();
        user.id = UUID.randomUUID();
        user.name = name;
        user.email = email;
        user.password = password;
        user.role = Role.ROLE_USER;
        user.active = true;
        user.createdAt = LocalDateTime.now();
        user.updatedAt = LocalDateTime.now();
        return user;
    }

    // Reconstitution method — used by persistence adapter to rebuild from DB
    public static User reconstitute(UUID id, String name,
                                    String email, String password,
                                    Role role, boolean active,
                                    LocalDateTime createdAt, LocalDateTime updatedAt) {
        User user = new User();
        user.id = id;
        user.name = name;
        user.email = email;
        user.password = password;
        user.role = role;
        user.active = active;
        user.createdAt = createdAt;
        user.updatedAt = updatedAt;
        return user;
    }
    
    public void deactivate() {
        this.active = false;
        this.updatedAt = LocalDateTime.now();
    }
    
    public void changeRole(Role newRole){
        this.role = newRole;
        this.updatedAt = LocalDateTime.now();
    }

    // Getters only — no setters, domain object is controlled via methods
    public UUID getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public Role getRole() { return role; }
    public boolean isActive() { return active; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}
