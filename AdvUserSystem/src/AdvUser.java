package AdvUserSystem.src;

import java.util.Objects;

public class AdvUser {

    private static int idCounter = 100;

    private int id;
    private String name;
    private String email;
    private AdvRole role;
    private boolean active;

    public AdvUser(String name, String email, AdvRole role, boolean active) {
        this.id = ++idCounter;  
        this.name = name;
        this.email = email;
        this.role = role;
        this.active = active;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public AdvRole getRole() { return role; }
    public boolean isActive() { return active; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AdvUser)) return false;
        AdvUser other = (AdvUser) obj;
        return Objects.equals(this.email, other.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return "User [ID=" + id + ", Name=" + name +  ", Email=" + email +  ", Role=" + role + ", Active=" + active + "]";
    }
}
