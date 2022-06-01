package org.letscode.servicovenda.controller;

import lombok.AllArgsConstructor;
import org.letscode.servicovenda.domain.dto.CreateVendaDTO;
import org.letscode.servicovenda.domain.model.PedidoModel;
import org.letscode.servicovenda.domain.model.VendaModel;
import org.letscode.servicovenda.domain.service.VendaService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/loja-cloud/venda")
@AllArgsConstructor
public class VendaController {
    private final VendaService vendaService;

    @GetMapping
    public Flux<VendaModel> getAllVendas() {
        return vendaService.getAllVendas();
    }

//    @GetMapping("/{vendaId}")
//    public Mono<?> getPedidosByVendaId(@PathVariable Long vendaId) {
//        return vendaService.getPedidosByVendaId(vendaId);
//    }

    @PostMapping
    public Mono<?> createVenda(@RequestBody CreateVendaDTO venda) {
        Mono<VendaModel> vendaCriada = (Mono<VendaModel>) vendaService.createVenda(venda);
        Mono<PedidoModel> pedidoCriado = (Mono<PedidoModel>) vendaService.createPedido(venda);
        return pedidoCriado;
    }
}
