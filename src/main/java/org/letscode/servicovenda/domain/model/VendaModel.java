package org.letscode.servicovenda.domain.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Table(value = "lc_vendas")
@Data
@Builder
public class VendaModel {

    @Id
    @Column(value = "id_venda")
    private Long vendaId;

    @Column(value = "id_pessoa")
    private Long pessoaId;

    @Column(value = "total_venda")
    private BigDecimal vendaTotal;
}
