# Payment Platform

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.4-brightgreen)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-21-orange)](https://www.oracle.com/java/)
[![Kafka](https://img.shields.io/badge/Apache%20Kafka-3.6.0-black)](https://kafka.apache.org/)

Plataforma escalável de processamento de pagamentos baseada em arquitetura de microsserviços, projetada com foco em consistência eventual, resiliência e alta disponibilidade.

## 🏗️ Arquitetura e Design Patterns

O projeto foi desenvolvido para resolver desafios críticos em sistemas distribuídos de missão crítica, implementando os seguintes padrões:

*   **Saga Pattern (Coreografia):** Gerenciamento de transações distribuídas entre os serviços de pagamento e notificação sem o uso de *Two-Phase Commit* (2PC), garantindo escalabilidade.
*   **Transactional Outbox:** Garantia de entrega de mensagens (*At-least-once delivery*), assegurando que o estado do banco de dados e os eventos do Kafka estejam sempre sincronizados.
*   **Idempotency Pattern:** Implementação de chaves de idempotência via **Redis** para prevenir processamentos duplicados em cenários de instabilidade de rede ou retentativas.
*   **API Gateway:** Ponto único de entrada para roteamento, balanceamento de carga e segurança perimetral.

## 🛠️ Stack Tecnológica

| Camada | Tecnologia |
| :--- | :--- |
| **Backend** | Java 21, Spring Boot 3.2, Spring Data JPA |
| **Segurança** | Spring Security, OAuth2, JWT |
| **Mensageria** | Apache Kafka (Event Backbone) |
| **Bancos de Dados** | PostgreSQL (Relacional), Redis (Cache/Idempotência) |
| **Resiliência** | Resilience4j (Circuit Breaker, Retry, Rate Limiter) |
| **Observabilidade** | Micrometer, Zipkin, Prometheus, Grafana |
| **Infraestrutura** | Docker, Docker Compose |

## 🧩 Microsserviços

1.  **Auth Service:** Provedor de identidade e emissão de tokens de acesso.
2.  **Payment Service:** Orquestrador do ciclo de vida dos pagamentos e gerenciamento de transações.
3.  **Notification Service:** Consumidor de eventos para processamento de comunicações externas.
4.  **API Gateway:** Filtro de autenticação e roteamento inteligente.

## 📈 Observabilidade e Resiliência

Para garantir a confiabilidade da plataforma em produção:
*   **Distributed Tracing:** Implementado com Micrometer e Zipkin para rastreamento de requisições *end-to-end*.
*   **Circuit Breaker:** Proteção contra falhas em cascata utilizando Resilience4j, permitindo o funcionamento degradado do sistema em caso de indisponibilidade de dependências.
*   **Health Checks:** Monitoramento em tempo real via Spring Boot Actuator exposto para o Prometheus.

## 🚀 Como Executar

### Pré-requisitos
*   Docker & Docker Compose
*   JDK 21
*   Maven 3.9.x

### Instalação

1. Clone o repositório:
```bash
git clone [https://github.com/seu-usuario/payment-platform.git](https://github.com/seu-usuario/payment-platform.git)
cd payment-platform
```
2. Suba a infraestrutura necessária (Kafka, Postgres, Redis, Zipkin):
```bash
docker-compose -f docker/docker-compose.yml up -d
```
3. Compile e instale os módulos:
```bash
mvn clean install
```
4. Execute os serviços através da sua IDE ou via terminal em cada diretório de módulo.

---
Desenvolvido com foco em boas práticas de engenharia de software e padrões de sistemas distribuídos.
