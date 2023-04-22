package br.com.samuel;

import br.com.samuel.domain.entity.Cliente;
import br.com.samuel.domain.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class VendasApplication extends SpringBootServletInitializer {

//    @Bean
//    public CommandLineRunner commandLineRunner(@Autowired Clientes clientes) {
//        return args -> {
//            Cliente c = new Cliente(null, "michael");
//            clientes.save(c);
//        };
//    }

//    @Bean
//    public CommandLineRunner init(
//            @Autowired Clientes clientes,
//            @Autowired Pedidos pedidos) {
//        return args -> {
//
//            System.out.println("Salvando clientes");
//            Cliente fulano = new Cliente("Fulano");
//            clientes.save(fulano);
//
//            Pedido p = new Pedido();
//            p.setCliente(fulano);
//            p.setDataPedido(LocalDate.now());
//            p.setTotal(BigDecimal.valueOf(99.9));
//
//            pedidos.save(p);

//            Cliente clienteful = clientes.findClienteFetchPedidos(fulano.getId());
//            System.out.println(clienteful);
//            System.out.println(clienteful.getPedidos());

//            pedidos.findByCliente(fulano).forEach(System.out::println);


//            clientes.save(new Cliente("Harry"));
//            clientes.save(new Cliente("Hermione"));
//            clientes.save(new Cliente("Ronny"));
//
//            List<Cliente> todosClientes = clientes.findAll();
//            todosClientes.forEach(System.out::println);
//
//            System.out.println("Atualizando clientes");
//            todosClientes.forEach(c -> {
//                c.setNome(c.getNome() + " atualizado.");
//                clientes.save(c);
//            });
//
//            todosClientes = clientes.findAll();
//            todosClientes.forEach(System.out::println);

//            System.out.println("Buscando clientes");
//            clientes.findByNomeContainsIgnoreCase("h").forEach(System.out::println);
//            List<Cliente> result = clientes.encontrarPorNome("H");
//            result.forEach(System.out::println);

//            System.out.println("Deletando clientes");
//            clientes.findAll().forEach(c -> {
//                clientes.delete(c);
//            });

//            todosClientes = clientes.findAll();
//            if (todosClientes.isEmpty()) {
//                System.out.println("Nenhum cliente encontrado");
//            } else {
//                todosClientes.forEach(System.out::println);
//            }
//        };
//    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }

}
