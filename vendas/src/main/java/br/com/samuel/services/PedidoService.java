package br.com.samuel.services;

import br.com.samuel.domain.entity.Pedido;
import br.com.samuel.domain.enums.StatusPedido;
import br.com.samuel.rest.dto.PedidoDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface PedidoService {

    Pedido salvar(PedidoDTO dto);
    Optional<Pedido> obterPedidoCompleto(Integer id);
    void atualizaStatus(Integer id, StatusPedido statusPedido);

}
