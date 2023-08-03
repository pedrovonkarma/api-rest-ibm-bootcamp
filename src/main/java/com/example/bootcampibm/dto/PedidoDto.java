package com.example.bootcampibm.dto;

import com.example.bootcampibm.domain.Cliente;
import com.example.bootcampibm.domain.Pedido;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@Setter
@Getter
public class PedidoDto implements Serializable {

    private Integer id;

    private Date data;

    private Cliente cliente;

    public PedidoDto(Pedido obj){
        id = obj.getId();
        data = obj.getData();
        cliente = obj.getCliente();
    }
}
