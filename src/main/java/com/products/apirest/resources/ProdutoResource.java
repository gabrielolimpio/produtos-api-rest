package com.products.apirest.resources;

import com.products.apirest.models.Produto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.products.apirest.repository.ProdutoRepository;

import java.util.List;

@RestController
@RequestMapping(value="/api")
@Tag(name = "produtos", description = "API REST Produtos")
@CrossOrigin(origins = "*")
public class ProdutoResource {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/produtos")
    @Operation(summary = "Retorna uma lista de produtos")
    public List<Produto> listaProdutos(){
        return produtoRepository.findAll();
    }

    @GetMapping("/produto/{id}")
    @Operation(summary = "Retorna um produto unico")
    public Produto listaProdutoUnico(@PathVariable(value="id") long id){
        return produtoRepository.findById(id);
    }

    @PostMapping("/produto")
    @Operation(summary = "Salva um produto")
    public Produto salvaProduto(@RequestBody @Valid Produto produto) {
        return produtoRepository.save(produto);
    }

    @DeleteMapping("/produto")
    @Operation(summary = "Deleta um produto")
    public void deletaProduto(@RequestBody @Valid Produto produto) {
        produtoRepository.delete(produto);
    }

    @PutMapping("/produto")
    @Operation(summary = "Atualiza um produto")
    public Produto atualizaProduto(@RequestBody @Valid Produto produto) {
        return produtoRepository.save(produto);
    }

}
