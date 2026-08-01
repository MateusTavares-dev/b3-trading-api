# B3 Trading API - Mock Engine

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white)
![JUnit5](https://img.shields.io/badge/JUnit5-25A162?style=for-the-badge&logo=junit5&logoColor=white)

API RESTful desenvolvida em Java e Spring Boot que simula o backoffice de uma corretora de valores. O projeto implementa um motor de negociações simples, focado em validar regras de negócio antes da execução de ordens de compra.

## Sobre o Projeto

O objetivo principal desta aplicação é demonstrar uma arquitetura backend organizada em camadas (MVC), utilizando boas práticas de desenvolvimento como comunicação via DTOs, padronização de status HTTP e testes unitários.

**Principais características:**
* **Validação de Saldo:** Bloqueio de ordens de compra caso o volume total ultrapasse o saldo em conta.
* **Controle de Estado:** O saldo do usuário é mantido na memória da aplicação durante a execução (escopo Singleton), simulando uma sessão de trading.
* **Respostas Padronizadas:** Uso de `ResponseEntity` para garantir retornos semânticos (`201 Created` para sucesso, `400 Bad Request` para erros de negócio).
* **Frontend Integrado:** Boleta de operações (HTML/JS puro) que se comunica com a API enviando payloads em JSON.

## Arquitetura e Organização

O código segue o padrão de responsabilidade única, dividido nos seguintes pacotes:

```text
src/main/java/com/b3/trading/
 ├── controller/   # Endpoints REST e orquestração HTTP
 ├── service/      # Regras de negócio e controle de saldo
 ├── dto/          # Data Transfer Objects (ex: OrdemRequest)
 └── TradingApiApplication.java
Stack Tecnológica
Linguagem: Java 17

Framework: Spring Boot 3.x

Testes: JUnit 5

Build: Gradle Wrapper

Frontend: HTML5, CSS3, Vanilla JS

Como Executar Localmente
O projeto utiliza o Gradle Wrapper, o que dispensa a instalação global do Gradle na sua máquina.

Clone o repositório:

Bash
git clone [https://github.com/SEU_USUARIO/b3-trading-api.git](https://github.com/SEU_USUARIO/b3-trading-api.git)
cd b3-trading-api
Dê permissão de execução ao script (Ambientes Linux/macOS):

Bash
chmod +x gradlew
Inicie o servidor Spring Boot:

Bash
./gradlew bootRun
Acesse a interface web pelo navegador:

Plaintext
http://localhost:8080
Testes Automatizados
A aplicação possui uma suíte de testes unitários para garantir a integridade das regras financeiras. Os cenários cobrem desde transações validadas com sucesso até exceções lançadas por saldo insuficiente.

Para rodar os testes, execute:

Bash
./gradlew test

Depois de salvar o arquivo no Codespaces, os comandos para subir a alteração para o GitHub continuam os mesmos:

```bash
git add .
git commit -m "docs: atualiza e formata o README.md"
git push