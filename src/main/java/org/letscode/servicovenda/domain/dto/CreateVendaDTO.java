package org.letscode.servicovenda.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CreateVendaDTO {
    private Long pessoaId;
    private List<CreatePedidoDTO> pedidoDTOList;
}
