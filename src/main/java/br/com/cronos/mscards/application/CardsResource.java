package br.com.cronos.mscards.application;

import br.com.cronos.mscards.application.representation.CardCreateRequest;
import br.com.cronos.mscards.application.representation.ClientCardsResponse;
import br.com.cronos.mscards.domain.entity.Card;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cards")
public class CardsResource {
    private final CardService service;
    private final ClientCardService clientCardService;


    @GetMapping
    public String status() {
        return "ok";
    }

    @PostMapping
    public ResponseEntity create(@RequestBody CardCreateRequest request) {
        Card card = request.toModel();
        service.create(card);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "income")
    public ResponseEntity<List<Card>> listAllCardsByIcomeLessThan(@RequestParam Long income) {
        List<Card> cardsList = service.listAllCardsIncomeLessThan(income);
        return ResponseEntity.ok(cardsList);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<ClientCardsResponse>> listCardsByClient(@RequestParam String cpf) {
        var listClientCard = clientCardService.listAllCardsByClient(cpf);
        var listClientCardResponse = listClientCard.stream()
                .map(ClientCardsResponse::fromModel)
                .toList();

        return ResponseEntity.ok(listClientCardResponse);
    }
}
