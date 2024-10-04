
# 🌟 Meu Currículo 🌟

**Meu Currículo** é uma plataforma que permite aos usuários gerenciar suas informações curriculares de forma eficiente e intuitiva. O projeto foi desenvolvido com o objetivo de facilitar o armazenamento e a atualização de dados como experiências profissionais, formações e certificados.

---

## 🚀 Tecnologias Utilizadas

- **Spring Boot**: Framework para criação de aplicações Java.
- **Spring Data JPA**: Para interações com o banco de dados.
- **Swagger**: Para documentação da API.
- **PostgreSQL**: Banco de dados relacional utilizado.

---

## 📦 Funcionalidades

- **CRUD** para currículos, experiências, formações e certificados.
- Validação de dados.
- Endpoint para busca de currículos por nome e competência.
- Atualização de meios de contato e localidade.
- Documentação da API com Swagger.

---

## 🔗 Links Úteis

- **GitHub**: [Meu Currículo GitHub](https://github.com/ceciliasimoes/MeuCurriculo)
- **API Swagger**: [Meu Currículo Swagger](https://meucurriculo-a8eq.onrender.com/swagger-ui/index.html#)

---

## 🛠️ Como Executar o Projeto

### Pré-requisitos

- Java 17 ou superior
- Maven
- PostgreSQL

### Passo a Passo

1. Clone o repositório:

   ```bash
   git clone https://github.com/ceciliasimoes/MeuCurriculo.git
   ```

2. Navegue até o diretório do projeto:

   ```bash
   cd MeuCurriculo
   ```

3. Configure o banco de dados no `application.properties`:

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/meu_curriculo
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   ```

4. Execute o projeto:

   ```bash
   mvn spring-boot:run
   ```

5. Acesse a API através do Swagger no navegador: [Swagger UI](https://meucurriculo-a8eq.onrender.com/swagger-ui/index.html#)

---

## 📄 Exemplo de Uso

### Criar um Currículo

```http
POST /curriculos
Content-Type: application/json

{
  "nome": "Seu Nome",
  "competencias": ["Java", "Spring", "PostgreSQL"],
  "meiosDeContato": ["seuemail@example.com"]
}
```

### Listar Currículos

```http
GET /curriculos
```

---

## 👩‍💻 Contribuições

Sinta-se à vontade para contribuir com o projeto!

1. Faça um fork do repositório
2. Crie sua branch (`git checkout -b feature/nome-da-sua-feature`)
3. Faça um commit (`git commit -m 'Adicionando nova funcionalidade'`)
4. Envie para o repositório remoto (`git push origin feature/nome-da-sua-feature`)
5. Crie um novo Pull Request

---

## 📝 Licença

Este projeto é licenciado sob a MIT License. 

---
