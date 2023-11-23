package jpa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    String uid;
    String name;
    String email;
    @Enumerated(EnumType.STRING)
    UserRole role;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
