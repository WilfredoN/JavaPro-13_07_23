package bank.account;

import bank.entity.BaseEntity;
import bank.person.Person;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "accounts")
@EntityListeners(AuditingEntityListener.class)
public class Account extends BaseEntity {
    private String uid;
    private String iban;
    private int balance;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person personId;
}
