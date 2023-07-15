# API RESTFul de Vendas Online

Este projeto é uma API RESTFul de vendas online desenvolvida em Java com o uso do framework Spring Boot. A API utiliza uma combinação de tecnologias para fornecer um sistema robusto, seguro e bem documentado, adequado para gerenciar vendas online de forma eficiente.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação utilizada para desenvolver a API.
- **Spring Boot**: Framework Java que simplifica o processo de criação de aplicativos, fornecendo configurações padrão e facilitando o desenvolvimento.
- **Spring Data JPA**: Biblioteca do Spring que facilita o acesso e a persistência dos dados no banco de dados MySQL.
- **MySQL**: Banco de dados relacional utilizado para armazenar os dados relacionados às vendas.
- **Bean Validation**: Framework utilizado para realizar a validação de entradas na API, garantindo a integridade dos dados.
- **RESTFul**: Padrão arquitetural utilizado para estruturar a API, permitindo que os recursos sejam expostos como endpoints e acessados de forma simples e padronizada.
- **JWT (JSON Web Tokens)**: Recursos de segurança utilizados para autenticação e autorização na API, fornecendo tokens de acesso criptografados.
- **Swagger**: Ferramenta utilizada para gerar automaticamente a documentação da API, facilitando a compreensão dos endpoints, parâmetros e respostas disponíveis.

## Funcionalidades Principais

A API RESTFul de Vendas Online oferece as seguintes funcionalidades principais:

- Cadastro de usuários: Permite o registro de usuários que desejam realizar compras online.
- Autenticação: Permite que os usuários autentiquem-se na API usando suas credenciais, obtendo um token JWT válido.
- Gerenciamento de produtos: Permite adicionar, atualizar, excluir e buscar produtos disponíveis para venda.
- Gerenciamento de pedidos: Permite criar, atualizar, excluir e buscar pedidos realizados pelos usuários.
- Geração de relatórios: Possibilita a geração de relatórios de vendas, fornecendo informações sobre os produtos mais vendidos, valor total das vendas, etc.

## Como executar o projeto

Para executar o projeto em sua máquina local, siga as etapas abaixo:

1. Certifique-se de ter o Java JDK (versão 11 ou superior) instalado em seu sistema.
2. Clone o repositório do projeto para sua máquina.
3. Abra o projeto em sua IDE de preferência (recomenda-se IntelliJ, Eclipse ou VS Code com extensões Java instaladas).
4. Configure as dependências e bibliotecas necessárias utilizando o gerenciador de dependências do projeto (Maven ou Gradle).
5. Configure o banco de dados MySQL e ajuste as configurações de conexão no arquivo de configuração da API.
6. Execute o projeto a partir da classe principal (geralmente anotada com `@SpringBootApplication`).
7. A API será iniciada e estará disponível no endereço `http://localhost:8080`.

## Documentação da API

A documentação da API pode ser acessada através do Swagger. Após iniciar o projeto, você pode acessar a interface Swagger no seguinte endereço: `http://localhost:8080/swagger-ui.html`. Nessa interface, você encontrará informações detalhadas sobre os endpoints disponíveis, parâmetros necessários, exemplos de requisições e respostas, entre outras informações úteis para utilizar a API corretamente.

## Contribuição

Contribuições são bem-vindas! Se você encontrar algum problema, tiver alguma ideia de melhoria ou quiser adicionar novas funcionalidades à API, fique à vontade para abrir uma nova issue ou enviar um pull request para o repositório do projeto.

## Licença

Este projeto é licenciado sob a [MIT License](https://opensource.org/licenses/MIT). Sinta-se à vontade para usar, modificar e distribuir o código conforme as diretrizes da licença.

[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://choosealicense.com/licenses/mit/)

---
Esperamos que esta API RESTFul de vendas online, desenvolvida em Java com o uso do framework Spring Boot, seja útil para o gerenciamento eficiente de vendas online. Em caso de dúvidas ou sugestões, não hesite em entrar em contato.

Aproveite e bons negócios!
