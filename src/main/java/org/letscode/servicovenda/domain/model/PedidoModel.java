package org.letscode.servicovenda.domain.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Table(value = "lc_vendas_pedido")
@Data
@Builder
public class PedidoModel {
    @Id
    @Column(value = "id_pedido")
    private Long pedidoId;

    @Column(value = "id_venda")
    private Long vendaId;

    @Column(value = "id_produto")
    private Long produtoId;

    @Column(value = "quantidade_produto")
    private Long produtoQuantidade;

    @Column(value = "preco_produto")
    private BigDecimal produtoPreco;
}
