package br.com.cronos.mscards.domain.entity;

import br.com.cronos.mscards.domain.constant.FlagCard;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "flag_card")
    @Enumerated(value = EnumType.STRING)
    private FlagCard flagCard;

    private BigDecimal income;
    private BigDecimal limit;

    public Card(String name, FlagCard flagCard, BigDecimal income, BigDecimal limit) {
        this.name = name;
        this.flagCard = flagCard;
        this.income = income;
        this.limit = limit;
    }
}
