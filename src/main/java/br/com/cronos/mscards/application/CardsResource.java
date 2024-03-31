package br.com.cronos.mscards.application;

import br.com.cronos.mscards.application.representation.CardCreateRequest;
import br.com.cronos.mscards.domain.entity.Card;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cards")
public class CardsResource {
    private final CardService service;


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
}
