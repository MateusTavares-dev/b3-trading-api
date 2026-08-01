# 📈 B3 Trading Engine Mock - REST API

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white)
![JUnit5](https://img.shields.io/badge/JUnit5-25A162?style=for-the-badge&logo=junit5&logoColor=white)

Um simulador de motor de negociações (Home Broker) focado em regras de negócio e processamento de ordens via API RESTful. Desenvolvido para demonstrar conceitos avançados de Engenharia de Software aplicados ao ecossistema do mercado financeiro.

## 🚀 O Projeto

Esta aplicação simula o *backoffice* de uma corretora conectada à B3. O foco do projeto está na construção de uma arquitetura de **backend resiliente** e **testável**, garantindo que as regras de negócio financeiras sejam estritamente respeitadas antes de qualquer ordem ser executada.

### ✨ Funcionalidades e Regras de Negócio
* **Validação de Saldo em Tempo Real:** O sistema bloqueia instantaneamente ordens de compra cujo volume total ultrapasse o saldo em conta do usuário.
* **Gerenciamento de Estado (Singleton):** A classe de serviço mantém o estado do saldo em memória durante o ciclo de vida da aplicação (Escopo Singleton do Spring), simulando uma sessão contínua de *trading*.
* **Cálculo Dinâmico no Frontend:** A interface calcula o volume total da ordem assincronamente via JavaScript puro antes do envio do payload para a API.
* **Design Pattern de Interface:** UI em *Dark Mode* inspirada em terminais profissionais de mercado (ex: ProfitChart, TradingView) para redução de fadiga visual, operando em porta local.

## 🛠️ Tecnologias Utilizadas

* **Backend:** Java 17, Spring Boot 3.x
* **Testes Automatizados:** JUnit 5 (Garantia de Qualidade e Prevenção de Falhas Críticas)
* **Build Tool:** Gradle Wrapper
* **Frontend:** HTML5, CSS3 (Custom Properties / Dark Theme) e Vanilla JavaScript (Fetch API)
* **Ambiente:** GitHub Codespaces (Cloud Development Environment) / Linux

## ⚙️ Como Executar o Projeto

O projeto utiliza o **Gradle Wrapper**, o que significa que não é necessário ter o Gradle instalado globalmente na máquina.

1. Clone o repositório:
```bash
git clone [https://github.com/SEU_USUARIO/b3-trading-api.git](https://github.com/SEU_USUARIO/b3-trading-api.git)
cd b3-trading-api