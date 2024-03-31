package br.com.cronos.mscards.application.representation;

import br.com.cronos.mscards.domain.constant.FlagCard;
import br.com.cronos.mscards.domain.entity.Card;

import java.math.BigDecimal;

public class CardCreateRequest {

    private String name;
    private FlagCard flag;
    private BigDecimal income;
    private BigDecimal limit;

    public Card toModel() {
        return new Card(name, flag, income, limit);
    }
}
