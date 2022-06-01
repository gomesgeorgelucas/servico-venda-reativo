package org.letscode.servicovenda.domain.repository;

import org.letscode.servicovenda.domain.model.PedidoModel;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface PedidoRepository extends ReactiveCrudRepository<PedidoModel, Long> {
    //Flux<PedidoModel> findPedidoModelByVendaId(Long vendaId);
}
