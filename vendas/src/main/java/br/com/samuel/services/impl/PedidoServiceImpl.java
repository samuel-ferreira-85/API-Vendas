package br.com.samuel.services.impl;

import br.com.samuel.domain.entity.Cliente;
import br.com.samuel.domain.entity.ItemPedido;
import br.com.samuel.domain.entity.Pedido;
import br.com.samuel.domain.entity.Produto;
import br.com.samuel.domain.enums.StatusPedido;
import br.com.samuel.domain.repository.Clientes;
import br.com.samuel.domain.repository.ItensPedido;
import br.com.samuel.domain.repository.Pedidos;
import br.com.samuel.domain.repository.Produtos;
import br.com.samuel.exception.PedidoNaoEncontradoException;
import br.com.samuel.exception.RegraNegocioException;
import br.com.samuel.rest.dto.ItemPedidoDTO;
import br.com.samuel.rest.dto.PedidoDTO;
import br.com.samuel.services.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PedidoServiceImpl implements PedidoService {

    private final Pedidos pedidosRepository;
    private final Produtos produtosRepository;
    private final Clientes clientesRepository;
    private final ItensPedido itensPedidoRepository;



    @Override
    public Pedido salvar(PedidoDTO dto) {
        Integer idCliente = dto.getCliente();
        Cliente cliente = clientesRepository
                .findById(idCliente)
                .orElseThrow(() -> new RegraNegocioException("Código de cliente inválido."));

        Pedido pedido = new Pedido();
        pedido.setTotal(dto.getTotal());
        pedido.setDataPedido(LocalDate.now());
        pedido.setCliente(cliente);
        pedido.setStatus(StatusPedido.REALIZADO);

        List<ItemPedido> itemsPedido = converterItems(pedido, dto.getItems());
        pedidosRepository.save(pedido);
        itensPedidoRepository.saveAll(itemsPedido);
        pedido.setItens(itemsPedido);

        return pedido;
    }

    @Override
    public Optional<Pedido> obterPedidoCompleto(Integer id) {
        return pedidosRepository.findByIdFetchItens(id);
    }

    @Override
    @Transactional
    public void atualizaStatus(Integer id, StatusPedido statusPedido) {
        pedidosRepository
                .findById(id)
                .map( p -> {
                    p.setStatus(statusPedido);
                    return pedidosRepository.save(p);
                }).orElseThrow( () -> new PedidoNaoEncontradoException());
    }

    private List<ItemPedido> converterItems (Pedido pedido, List<ItemPedidoDTO> items) {

        if(items.isEmpty()) {
            throw new RegraNegocioException("Não é possível realizar um pedido sem itens.");
        }
        return items
                .stream()
                .map( dto -> {
                    Integer idProduto = dto.getProduto();
                    Produto produto = produtosRepository
                            .findById(idProduto)
                            .orElseThrow(
                                    () -> new RegraNegocioException(
                                            "Código de produto inválido." + idProduto)
                            );
                    ItemPedido itemPedido = new ItemPedido();
                    itemPedido.setQuantidade(dto.getQuantidade());
                    itemPedido.setPedido(pedido);
                    itemPedido.setProduto(produto);
                    return itemPedido;
                }).collect(Collectors.toList());
    }

}
