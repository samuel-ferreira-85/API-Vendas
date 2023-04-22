package br.com.samuel.rest.controller;

import br.com.samuel.domain.entity.Cliente;
import br.com.samuel.domain.repository.Clientes;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@Controller
//@RequestMapping
public class ClienteControl {

//    @RequestMapping(value = "/hello/{nome}", method = RequestMethod.GET)
//    @ResponseBody
//    public String helloCliente ( @PathVariable("nome") String nomeCliente) {
//        return String.format("Hello %s", nomeCliente);
//    }

    private Clientes clientes;

    public ClienteControl(Clientes clientes) {
        this.clientes = clientes;
    }

    @GetMapping("/api/clientes/{id}")
    @ResponseBody
    public ResponseEntity<Cliente> getClienteById( @PathVariable Integer id){
        Optional<Cliente> clienteId = clientes.findById(id);
        if (clienteId.isPresent()) {
            return ResponseEntity.ok(clienteId.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/api/clientes")
    @ResponseBody
    public ResponseEntity<Cliente> save( @RequestBody Cliente cliente ) {
        Cliente clienteSalvo = clientes.save(cliente);
        return ResponseEntity.ok(clienteSalvo);
    }

    @DeleteMapping("/api/clientes/{id}")
    public ResponseEntity delete( @PathVariable Integer id ) {
        Optional<Cliente> clienteId = clientes.findById(id);
        if (clienteId.isPresent()) {
            clientes.delete(clienteId.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();

    }

    @PutMapping("api/clientes/{id}")
    @ResponseBody
    public ResponseEntity update(@PathVariable Integer id, @RequestBody Cliente cliente) {
        return clientes
                .findById(id)
                .map( clienteExistente -> {
                    cliente.setId( clienteExistente.getId() );
                    clientes.save(cliente);
                    return ResponseEntity.noContent().build();
                }).orElseGet( () -> ResponseEntity.notFound().build() );
    }

    @GetMapping("api/clientes")
    public ResponseEntity find( Cliente filtro ) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filtro, matcher);
        List<Cliente> lista = clientes.findAll(example);
        return ResponseEntity.ok(lista);
    }

    
}
 