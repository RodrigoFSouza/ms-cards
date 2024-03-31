package br.com.cronos.mscards.application;

import br.com.cronos.mscards.domain.entity.Card;
import br.com.cronos.mscards.infrastructure.repository.CardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository repository;

    @Transactional
    public Card create(Card card) {
        return repository.save(card);
    }

    public List<Card> listAllCardsIncomeLessThan(Long income) {
        var incomeBigDecimal = BigDecimal.valueOf(income);
        return repository.findByIncomeLessThanEqual(incomeBigDecimal);
    }
}
