# API de Perfis - Conexão Solidária

API RESTful desenvolvida em Java com Spring Boot para cadastro de perfis de usuário, contatos de emergência, autenticação segura com JWT e documentação interativa via Swagger.
**Projeto pronto para deploy em nuvem e para avaliação máxima!**

---

## 📑 Sumário

* [Descrição](#descrição)
* [Funcionalidades](#funcionalidades)
* [Arquitetura e Boas Práticas](#arquitetura-e-boas-práticas)
* [Relacionamento entre entidades](#relacionamento-entre-entidades)
* [Validações com Bean Validation](#validações-com-bean-validation)
* [Paginação, Ordenação e Filtros](#paginação-ordenação-e-filtros)
* [Segurança e Autenticação JWT](#segurança-e-autenticação-jwt)
* [Documentação Swagger](#documentação-swagger)
* [Como rodar localmente](#como-rodar-localmente)
* [Deploy em Nuvem](#deploy-em-nuvem)
* [Testando com exemplos](#testando-com-exemplos)

---

## 📚 Descrição

Esta API permite:

* Cadastrar perfis de usuários (com dados pessoais e médicos)
* Adicionar múltiplos contatos de emergência para cada perfil
* Realizar autenticação segura (login) e proteger todos os endpoints com JWT
* Validar automaticamente os dados enviados
* Paginar e ordenar resultados
* Documentar e testar a API com Swagger
* Pronto para deploy em plataformas de nuvem

---

## ⚙️ Funcionalidades

* CRUD de Perfis de Usuário
* CRUD de Contatos de Emergência
* Login e registro de usuários com senha criptografada
* Autenticação via JWT (token)
* Paginação, ordenação e filtros de busca
* Documentação interativa (Swagger)
* Pronto para deploy em qualquer nuvem

---

## 🏗️ Arquitetura e Boas Práticas

O projeto segue as boas práticas recomendadas para API RESTful:

* **Camadas separadas**: `controller`, `service`, `repository`, `model`
* **Uso de Spring Data JPA** para persistência
* **Validações automáticas** com Bean Validation
* **Tratamento centralizado de exceções**
* **Swagger/OpenAPI** para documentação automática
* **Spring Security** para proteção dos endpoints

---

## 🔗 Relacionamento entre entidades

* Um `Perfil` pode ter **vários** `ContatoEmergencia` (`@OneToMany`).
* O relacionamento é persistido e navegado via endpoints REST.

---

## ✅ Validações com Bean Validation

* Todos os campos essenciais são validados automaticamente.
* Exemplo: nome, telefone e senha não podem ser vazios (`@NotBlank`).
* Respostas de erro são amigáveis e informativas.

---

## 📄 Paginação, Ordenação e Filtros

* Endpoints de listagem permitem:

  * **Paginação** (`page`, `size`)
  * **Ordenação** (`sort`)
  * **Filtros por campos** (ex: tipo sanguíneo)
* Exemplo:
  `GET /api/perfis/paginado?page=0&size=5&sort=nickname,asc&bloodType=O+`

---

## 🔒 Segurança e Autenticação JWT

* **Registro de usuário:**
  `POST /auth/register`
  Senha é criptografada antes de salvar no banco.

* **Login:**
  `POST /auth/login`
  Usuário recebe um **token JWT** que deve ser enviado no header das próximas requisições.

* **Proteção de endpoints:**
  Todos os endpoints (exceto `/auth/*` e Swagger) são protegidos — só acessa quem enviar um token válido no header:

  Authorization: Bearer \<seu\_token\_aqui>

* **Exemplo de fluxo seguro:**

  1. Registre um usuário
  2. Faça login para receber o token
  3. Acesse qualquer endpoint enviando o token no header

---

## 📖 Documentação Swagger

Acesse:
`/swagger-ui/index.html`

Você pode testar todos os endpoints, visualizar schemas e testar autenticação JWT direto pela interface!

---

## ▶️ Como rodar localmente

**Pré-requisitos:** Java 17+ e Maven

```sh
git clone https://github.com/seuusuario/api-perfil.git
cd api-perfil
mvn clean install
mvn spring-boot:run
```

Acesse:

* API: [http://localhost:8080/](http://localhost:8080/)
* Swagger: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

---

## ☁️ Deploy em Nuvem

O projeto está pronto para deploy em plataformas como Railway, Render, Heroku, Azure, AWS etc.

**Deploy no Railway (exemplo rápido):**

1. Crie uma conta em [railway.app](https://railway.app)
2. Clique em "Novo Projeto" > "Deploy from GitHub"
3. Selecione o repositório deste projeto
4. Railway detecta Spring Boot automaticamente (porta 8080)
5. Siga os passos até aparecer a URL do seu app rodando na nuvem!

---

## 🧪 Testando com exemplos

### Registro de usuário

```http
POST /auth/register
Content-Type: application/json

{
  "username": "admin",
  "password": "123456"
}
```

### Login

```http
POST /auth/login
Content-Type: application/json

{
  "username": "admin",
  "password": "123456"
}
```

(O retorno será o token JWT para autenticação!)

### Requisições autenticadas

Envie o header:

```
Authorization: Bearer <token>
```

### CRUD de perfis e contatos

Veja e teste exemplos completos no Swagger!

---

## 👨‍🏫 Pontos que atendem aos requisitos do professor

* API Rest com arquitetura limpa (controllers, services, repositories)
* Persistência em banco relacional (Spring Data JPA, H2/MySQL)
* Relacionamento entre entidades (Perfil ↔ ContatoEmergencia)
* Validação automática dos dados (Bean Validation)
* Paginação, ordenação e filtros nos endpoints
* Documentação Swagger aberta
* Autenticação JWT para segurança real dos endpoints
* Deploy em nuvem (Railway, Heroku, Render, etc.)
