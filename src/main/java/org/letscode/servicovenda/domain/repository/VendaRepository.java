package org.letscode.servicovenda.domain.repository;

import org.letscode.servicovenda.domain.model.VendaModel;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface VendaRepository extends ReactiveCrudRepository<VendaModel, Long> {
}
