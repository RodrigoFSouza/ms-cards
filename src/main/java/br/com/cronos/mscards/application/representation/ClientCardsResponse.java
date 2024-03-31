package br.com.cronos.mscards.application.representation;

import br.com.cronos.mscards.domain.entity.ClientCard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientCardsResponse {
    private String name;
    private String flag;
    private BigDecimal limit;

    public static ClientCardsResponse fromModel(ClientCard clientCard) {
        return new ClientCardsResponse(
                clientCard.getCard().getName(),
                clientCard.getCard().getFlagCard().toString(),
                clientCard.getLimit()
        );
    }
}
