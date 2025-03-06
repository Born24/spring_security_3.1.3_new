package ru.kata.spring.boot_security.demo.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role", unique = true)
    private String role;

    public Role() {}

    public Role(String role) {this.role = "ROLE_" + role;}

    @Override
    public String getAuthority() {return role;}

    public void setId(Long id) {this.id = id;}

    public Long getId() {return id;}

    public String getRole() {return role;}

    public void setRole(String role) {this.role = role;}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Role other = (Role) obj;

        return Objects.equals(role, other.role);
    }

    @Override
    public int hashCode() {return Objects.hash(role);}

    @Override
    public String toString() {return this.role;}
}

