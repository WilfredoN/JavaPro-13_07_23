package bank.person;

import bank.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "persons")
@EntityListeners(AuditingEntityListener.class)
public class Person extends BaseEntity {
    private String uid;
    private String name;
    private String email;
}
