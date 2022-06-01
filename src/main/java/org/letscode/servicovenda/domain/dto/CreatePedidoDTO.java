package org.letscode.servicovenda.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CreatePedidoDTO {
    private Long produtoId;
    private Long produtoQuantidade;
    private BigDecimal produtoPreco;
}
