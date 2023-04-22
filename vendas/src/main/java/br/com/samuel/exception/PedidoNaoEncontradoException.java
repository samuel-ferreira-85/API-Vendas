package br.com.samuel.exception;

public class PedidoNaoEncontradoException extends RuntimeException {
    public PedidoNaoEncontradoException() {
        super("pedido não encontrado.");
    }
}
