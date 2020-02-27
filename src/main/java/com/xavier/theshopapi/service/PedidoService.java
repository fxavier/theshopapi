package com.xavier.theshopapi.service;

import com.xavier.theshopapi.model.EstadoPedido;
import com.xavier.theshopapi.model.ItemPedido;
import com.xavier.theshopapi.model.Pedido;
import com.xavier.theshopapi.repository.ItemPedidoRepository;
import com.xavier.theshopapi.repository.PedidoRepository;
import com.xavier.theshopapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Pedido save(Pedido pedido) {
        for (ItemPedido item : pedido.getItems()) {
            item.setPreco(item.getProduto().getPreco());
            itemPedidoRepository.save(item);
        }
        pedido.setDataCriacao(LocalDateTime.now());
        pedido.setUsuario(usuarioRepository.findById(pedido.getUsuario().getId()).get());
        pedido.setItems(pedido.getItems());
        pedido.setEstadoPedido(EstadoPedido.PENDENTE);
        return   pedidoRepository.save(pedido);
    }
}
