package com.example.bootcampibm.controller;

import com.example.bootcampibm.domain.Cliente;
import com.example.bootcampibm.domain.Produto;
import com.example.bootcampibm.dto.ClienteDto;
import com.example.bootcampibm.dto.ProdutoDto;
import com.example.bootcampibm.service.ClienteService;
import com.example.bootcampibm.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Produto produto){
        Produto obj = service.insert(produto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> find(@PathVariable Integer id){
        Produto produto = service.find(id);
        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update (@RequestBody ProdutoDto dto, @PathVariable Integer id){
        Produto obj = service.fromDto(dto);
        obj.setId(id);
        service.update(obj);
        return ResponseEntity.noContent().build();
    }

}
