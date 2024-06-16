# Products Control Application

## Descrição do Projeto

O **Products Control Application** é uma aplicação desenvolvida em Java usando o framework Spring Boot. A aplicação tem como principal objetivo gerenciar produtos e autenticação de usuários, oferecendo funcionalidades para registro, login e manipulação de produtos (criação e listagem). A aplicação implementa autenticação JWT e autorização baseada em papéis para garantir a segurança das operações.

## Funcionalidades

1. **Autenticação e Autorização de Usuários**
    - Registro de novos usuários (apenas administradores).
    - Login de usuários existentes.
    - Geração e validação de tokens JWT para autenticação.


2. **Gerenciamento de Produtos**
    - Criação de novos produtos (apenas administradores).
    - Listagem de todos os produtos.

## Estrutura do Projeto

O projeto está organizado nas seguintes camadas principais:

2. **Camada de Controle**
    - `AuthenticationController`: Controlador responsável pelas operações de autenticação e registro de usuários.
    - `ProductController`: Controlador responsável pelas operações relacionadas aos produtos.
   

3. **Camada de Domínio**
    - `User`: Classe que representa os usuários da aplicação.
    - `Product`: Classe que representa os produtos da aplicação.
    - DTOs (Data Transfer Objects) para transferência de dados entre as camadas.


4. **Camada de Repositório**
    - `UserRepository`: Interface para acesso aos dados dos usuários.
    - `ProductRepository`: Interface para acesso aos dados dos produtos.


5. **Camada de Segurança**
    - `SecurityConfigurations`: Configurações de segurança da aplicação.
    - `SecurityFilter`: Filtro de segurança para validação de tokens JWT.
    - `TokenService`: Serviço para geração e validação de tokens JWT.


6. **Camada de Serviço**
    - `AuthorizationService`: Serviço para carregamento de detalhes do usuário.


## Endpoints

### Autenticação

- `POST /auth/login`: Autenticar um usuário.
    - Request Body: `AuthenticationDTO` (login, password)
    - Response: `LoginResponseDTO` (token)

- `POST /auth/register`: Registrar um novo usuário (apenas administradores).
    - Request Body: `RegisterDTO` (login, password, role)
    - Response: Status 200 OK ou 400 Bad Request

### Produtos

- `POST /product`: Criar um novo produto (apenas administradores).
    - Request Body: `ProductRequestDTO` (name, price)
    - Response: Status 200 OK

- `GET /product`: Listar todos os produtos.
    - Response: Lista de `ProductResponseDTO`

## Considerações de Segurança

- A aplicação usa JWT (JSON Web Token) para autenticação e autorização.
- Tokens JWT são gerados com um algoritmo HMAC256 e incluem informações do usuário autenticado.
- As requisições são validadas usando filtros de segurança para garantir que apenas usuários autenticados e autorizados (com papéis específicos) possam acessar certos endpoints.
- Senhas de usuários são armazenadas de forma segura usando bcrypt, um algoritmo de hashing robusto.
- A configuração de segurança desabilita CSRF (Cross-Site Request Forgery) e usa política de sessão stateless para melhorar a segurança da aplicação.

## Configuração

### Pré-requisitos

- Java 21 ou superior
- Maven
- Banco de dados PostgreSQL, utilizando supabase (configurado no `application.properties`)
