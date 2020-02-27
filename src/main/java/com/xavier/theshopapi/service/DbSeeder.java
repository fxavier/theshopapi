package com.xavier.theshopapi.service;

import com.xavier.theshopapi.model.*;
import com.xavier.theshopapi.repository.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

@Service
@Data
public class DbSeeder implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void run(String... args) throws Exception {
        this.categoriaRepository.deleteAll();
        this.mongoTemplate.dropCollection(Categoria.class);
     //   this.produtoRepository.deleteAll();
      //  this.mongoTemplate.dropCollection(Produto.class);
        this.usuarioRepository.deleteAll();
        this.mongoTemplate.dropCollection(Usuario.class);
        this.pedidoRepository.deleteAll();
        this.mongoTemplate.dropCollection(Pedido.class);
        this.itemPedidoRepository.deleteAll();


        Categoria c1 = new Categoria("Phones & Tablet");
        Categoria c2 = new Categoria("Electrodomesticos");
        Categoria c3 = new Categoria("Moda");

        categoriaRepository.saveAll(Arrays.asList(c1, c2, c3));


        Produto p1 = new Produto("iPhone XI", "HD and smart Camera", 10,
                new BigDecimal(90000),true, true, true, c1, null);
        Produto p2 = new Produto("iPad 8", "Good with great camera", 10,  new BigDecimal("60000"),
                true, true, true, c1, null);

        Produto p3 = new Produto("TV LED Curve", "3D", 10,  new BigDecimal("50000"),
                true, true, true, c2, null);


        produtoRepository.saveAll(Arrays.asList(p1, p2, p3));



        Endereco e1 =  new Endereco("Central", "Eduardo Mondlane", "3001");
        Endereco e2 =  new Endereco("Malhangalene", "Karl Marx", "501");


        Usuario u1 = new Usuario(null,"Xavier","fxavier","pass",
                new ArrayList<String>(Arrays.asList("84100000", "87011111")),
               Arrays.asList(e1, e2) ,
                Cidade.MAPUTO);

        Usuario u2 = new Usuario(null,"Lebron","fLebron","pass",
                new ArrayList<String>(Arrays.asList("84100000", "8701111")),
                Arrays.asList(e1, e2) ,
                Cidade.MAPUTO);
        usuarioRepository.saveAll(Arrays.asList(u1, u2));

        ItemPedido ip1 = new ItemPedido(p1, 2, p1.getPreco());
        ItemPedido ip2 = new ItemPedido(p2, 3, p2.getPreco());

        Pedido pe1 = new Pedido(LocalDateTime.now(), u1, EstadoPedido.PENDENTE, Arrays.asList(ip1, ip2), null);


        pedidoService.save(pe1);



    }
}
