package bank.card;

import bank.account.Account;
import bank.entity.BaseEntity;
import bank.person.Person;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cards")
@EntityListeners(AuditingEntityListener.class)
public class Card extends BaseEntity {
    private String uid;
    private String pan;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expirationDate;
    private String pin;
    private String cvv;
    @Enumerated(EnumType.STRING)
    private CardStatus status;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}
