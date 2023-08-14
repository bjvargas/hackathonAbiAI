# Projeto HackathonAbiAI

Evento da ABI-inbev voltado para o uso das inteligências artificiais no dia a dia.

Este é um projeto em Spring Boot que fornece uma API RESTful para consultar a temperatura com base no CEP fornecido. Também é possível buscar produtos em uma base noSQL de acordo com a temperatura atual e/ou estação do ano.

## Características

- **Consulta de temperatura por CEP:** A API aceita um CEP como entrada e retorna a temperatura para esse local.

- **Busca de produtos por temperatura:** A API permite buscar produtos adequados para a temperatura atual. Por exemplo, se a temperatura estiver baixa, a API pode sugerir casacos e outras roupas de inverno.

- **Busca de produtos por estação do ano:** A API permite buscar produtos adequados para a estação do ano atual. Por exemplo, se estiver no verão, a API pode sugerir roupas de banho e protetor solar.

- **Integração com serviço de previsão do tempo:** A aplicação se integra com um serviço de previsão do tempo para obter a temperatura atual para o CEP fornecido.

- **Integração com serviço de geolocalização:** A aplicação se integra com um serviço de geolocalização para converter o CEP fornecido em coordenadas geográficas, que são usadas para consultar o serviço de previsão do tempo.

## Configuração

Antes de executar a aplicação, é necessário configurar suas próprias API keys e URL do MongoDB. Adicione as seguintes configurações no arquivo `application.yml` ou `application.properties`:

```yaml
apiKeys:
  tomorrowWeather: ${API_KEY_TW}
  googleMaps: ${API_KEY_GMAPS}

spring:
  data:
    mongodb:
      database: ${PROD_DATABASE_NAME}
      uri: ${PROD_URI_NAME}
```

Substitua `${API_KEY_TW}`, `${API_KEY_GMAPS}`, `${PROD_DATABASE_NAME}` e `${PROD_URI_NAME}` pelos valores apropriados.

## Tecnologias Utilizadas

- **Spring Boot:** Usado para criar a aplicação.
- **Maven:** Usado para gerenciar as dependências do projeto.
- **Spring Web:** Usado para criar a API RESTful.
- **Spring Data JPA:** Usado para persistir os dados.

## Como Executar

1. Clone o repositório para a sua máquina local usando `git clone`.
2. Navegue até o diretório do projeto.
3. Configure suas próprias API keys e URL do MongoDB conforme mencionado na seção de configuração.
4. Execute `mvn clean package` para construir o projeto.
5. Execute `java -jar target/nome-do-seu-projeto.jar` para iniciar a aplicação.
6. A API estará disponível em `http://localhost:8080`.
