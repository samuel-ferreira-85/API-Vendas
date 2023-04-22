package br.com.samuel.rest.controller;

import br.com.samuel.domain.entity.ItemPedido;
import br.com.samuel.domain.entity.Pedido;
import br.com.samuel.domain.enums.StatusPedido;
import br.com.samuel.rest.dto.AtualizacaoStatusPedidoDTO;
import br.com.samuel.rest.dto.InformacoesItemPedidoDTO;
import br.com.samuel.rest.dto.InformacoesPedidosDTO;
import br.com.samuel.rest.dto.PedidoDTO;
import br.com.samuel.services.PedidoService;
import org.hibernate.event.spi.PreCollectionUpdateEventListener;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Integer save (@RequestBody @Valid PedidoDTO dto) {
        Pedido pedido = service.salvar(dto);
        return pedido.getId();
    }

    @GetMapping("{id}")
    public InformacoesPedidosDTO getById( @PathVariable Pedido id) {
        return service.obterPedidoCompleto(id.getId())
                .map(p -> converter(p))
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
    }

    private InformacoesPedidosDTO converter(Pedido pedido) {
        return InformacoesPedidosDTO.builder()
                .codigo(pedido.getId())
                .dataPedido(pedido.getDataPedido().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .cpf(pedido.getCliente().getCpf())
                .nomeCliente(pedido.getCliente().getNome())
                .total(pedido.getTotal())
                .status(pedido.getStatus().name())
                .items(converter(pedido.getItens()))
                .build();
    }

    @PatchMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void updateStatus( @PathVariable Integer id,
                              @RequestBody AtualizacaoStatusPedidoDTO dto) {
        String novoStatus = dto.getNovoStatus();
        service.atualizaStatus(id, StatusPedido.valueOf(novoStatus));
    }

    private List<InformacoesItemPedidoDTO> converter(List<ItemPedido> itens) {
        if(CollectionUtils.isEmpty(itens)) {
            return Collections.emptyList();
        }

        return itens.stream()
                .map( item -> {
                    return InformacoesItemPedidoDTO
                                    .builder().descricaoProduto(item.getProduto().getDescricao())
                                    .precoUnitario(item.getProduto().getPreco())
                                    .quantidade(item.getQuantidade())
                                    .build();
                        }
                ).collect(Collectors.toList());
    }

}
