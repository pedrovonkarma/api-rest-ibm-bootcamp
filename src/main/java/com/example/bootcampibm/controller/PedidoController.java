package com.example.bootcampibm.controller;

import com.example.bootcampibm.domain.Cliente;
import com.example.bootcampibm.domain.Pedido;
import com.example.bootcampibm.dto.ClienteDto;
import com.example.bootcampibm.dto.PedidoDto;
import com.example.bootcampibm.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Pedido obj){
        obj = pedidoService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> find(@PathVariable Integer id){
        Pedido pedido = pedidoService.find(id);
        return ResponseEntity.ok(pedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update (@RequestBody PedidoDto dto, @PathVariable Integer id){
        Pedido obj = pedidoService.fromDto(dto);
        obj.setId(id);
        pedidoService.update(obj);
        return ResponseEntity.noContent().build();
    }
}
