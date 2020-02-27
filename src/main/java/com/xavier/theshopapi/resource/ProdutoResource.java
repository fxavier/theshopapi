package com.xavier.theshopapi.resource;

import com.xavier.theshopapi.model.Produto;
import com.xavier.theshopapi.repository.ProdutoRepository;
import com.xavier.theshopapi.repository.filter.ProdutoFilter;
import com.xavier.theshopapi.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping()
    public List<Produto> findAll() {
        return produtoService.findAll();
    }

    @GetMapping("/bestReviews")
    public List<Produto> findBestReviews() {
        return produtoService.findAllByGreatReviews();
    }

    @GetMapping("/{featured}")
    public List<Produto> findFeaturedProducts(@PathVariable Boolean featured) {
        return produtoService.findFeaturedProdutos(featured);
    }

    @GetMapping("/search/{text}")
    public List<Produto> search(@PathVariable String text) {
        return produtoService.search(text);
    }

   /* @GetMapping("/fullsearch")
    public List<Produto> fullSearch(
            @RequestParam(value = "categoriaId", required = false) String categoriaId,
            @RequestParam(value = "nome", required = false) String nome,
            @RequestParam(value = "preco", required = false) BigDecimal preco) {
        return produtoService.fullSearch(categoriaId, nome, preco);
    }*/

   /* @GetMapping("/fullsearch")
    public List<Produto> fullSearch(@RequestParam(required = false) String id) {
        return produtoRepository.fullsearch(id);
    }
*/

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto create(@Valid @RequestBody Produto produto) {
        return produtoService.save(produto);
    }

    @PutMapping("/{id}")
    public Produto update(@PathVariable String id, @Valid @RequestBody Produto produto) {
        produto.setId(id);
        return produtoService.save(produto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        produtoService.delete(id);
    }
}
