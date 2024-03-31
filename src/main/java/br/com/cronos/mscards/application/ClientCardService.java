package br.com.cronos.mscards.application;

import br.com.cronos.mscards.domain.entity.ClientCard;
import br.com.cronos.mscards.infrastructure.repository.ClientCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientCardService {
    private ClientCardRepository clientCardRepository;

    public List<ClientCard> listAllCardsByClient(String cpf) {
        return clientCardRepository.findByCpf(cpf);
    }
}
