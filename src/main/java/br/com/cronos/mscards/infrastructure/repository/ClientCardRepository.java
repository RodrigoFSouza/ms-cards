package br.com.cronos.mscards.infrastructure.repository;

import br.com.cronos.mscards.domain.entity.Card;
import br.com.cronos.mscards.domain.entity.ClientCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientCardRepository extends JpaRepository<Card, Long> {

    List<ClientCard> findByCpf(String cpf);
}
