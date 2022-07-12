package az.fintech.unitechms.model;

import az.fintech.unitechms.enumeration.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    private User user;

    private String name;

    private Double balance;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;
}
