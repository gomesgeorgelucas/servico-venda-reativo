package org.letscode.servicovenda.domain.service;

import lombok.AllArgsConstructor;
import org.letscode.servicovenda.domain.dto.CreateVendaDTO;
import org.letscode.servicovenda.domain.dto.CreatePedidoDTO;
import org.letscode.servicovenda.domain.model.PedidoModel;
import org.letscode.servicovenda.domain.model.VendaModel;
import org.letscode.servicovenda.domain.repository.PedidoRepository;
import org.letscode.servicovenda.domain.repository.VendaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
@Transactional
public class VendaService {
    private final PedidoRepository pedidoRepository;
    private final VendaRepository vendaRepository;

    public Flux<VendaModel> getAllVendas() {
        return vendaRepository.findAll();
    }

//    public Mono<Flux<PedidoModel>> getPedidosByVendaId(Long vendaId) {
//        return vendaRepository.findById(vendaId).map(vendaModel -> pedidoRepository.findPedidoModelByVendaId(vendaModel.getVendaId()));
//    }


    public Mono<?> createPedido(CreateVendaDTO venda) {
        PedidoModel pedidoT = PedidoModel.builder()
                .produtoId(1L)
                .produtoPreco(BigDecimal.valueOf(2.51))
                .produtoQuantidade(1L)
                .vendaId(1L)
                .build();

        Mono<PedidoModel> pmono = pedidoRepository.save(pedidoT);
        return pmono;
    }
    public Mono<?> createVenda(CreateVendaDTO venda) {
        BigDecimal vendaTotal = calcularTotal(venda);

        VendaModel newVenda =  VendaModel.builder()
                .pessoaId(venda.getPessoaId())
                .vendaTotal(vendaTotal)
                .build();

        Mono<VendaModel> vendaMono = vendaRepository.save(newVenda);

//        vendaMono.flux().subscribe(vendaModel -> pedidoRepository.save(PedidoModel.builder()
//                        .vendaId(vendaModel.getVendaId())
//                .build()));

//        for (CreatePedidoDTO pedido : venda.getPedidoDTOList()) {
//            pedidoRepository.save(PedidoModel.builder()
//                    .vendaId(newVendaId)
//                    .produtoId(pedido.getProdutoId())
//                    .produtoPreco(pedido.getProdutoPreco())
//                    .produtoQuantidade(pedido.getProdutoQuantidade())
//                    .build());
//        }

        return vendaMono;
    }

    private BigDecimal calcularTotal(CreateVendaDTO venda) {
        BigDecimal total = BigDecimal.valueOf(0);
        for (CreatePedidoDTO pedido : venda.getPedidoDTOList()) {
            total = total.add(pedido.getProdutoPreco().multiply(BigDecimal.valueOf(pedido.getProdutoQuantidade())));
        }

        return total;

    }
}
