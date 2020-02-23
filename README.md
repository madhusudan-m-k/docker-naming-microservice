# docker-micro-service

Docker micro service examples

## Registering standalone microservices to the standalone consul naming server

#### Start consul service

```
On windows
E:\Software\Consul-1-6-2>consul agent -server -bootstrap-expect=1 -data-dir=consul-data -ui -bind=127.0.0.1

Run on specific port
E:\Software\Consul-1-6-2>consul agent -server -bootstrap-expect=1 -http-port=8761 -data-dir=consul-data -ui -bind=127.0.0.1

Build and run individual microservice container
```

#### Build and Start currency exchange service

```
Go to ccy-exchange-service project and run the following docker commands

docker network create dockernamingmicroservice_currency-bridge

docker build -t currency-exchange-service:0.0.1-SNAPSHOT .

docker container run -dit -p 9090:9090 --name currency-exchange-service --env-file .env --network dockernamingmicroservice_currency-bridge currency-exchange-service:0.0.1-SNAPSHOT
```

#### Build and Start currency conversion database service

```
Go to ccy-conversion-service\db project and run the following docker commands

docker build -t currency-conversion-db:0.0.1-SNAPSHOT ..\

docker container run -dit -p 9090:9090 --name currency-conversion-db --env-file .env --network dockernamingmicroservice_currency-bridge currency-conversion-db:0.0.1-SNAPSHOT
```

#### Build and Start currency conversion service

```
Go to ccy-conversion-service project and run the following docker commands

docker build -t currency-conversion-service:0.0.1-SNAPSHOT .

docker container run -dit -p 9090:9090 --name currency-conversion-service --env-file .env --network dockernamingmicroservice_currency-bridge currency-conversion-service:0.0.1-SNAPSHOT
```

#### Building and running entire stack of microservices container, database container, consule container using docker compose

```
Just build the container do not run.
docker-compose up -d --build

OR

Build and run the container and force recreate if there were existing images
docker-compose up -d --force-recreate

docker-compose logs -f
```

#### Build Currency exchange container (return the currency amount value give a certain souce currency)

##### Access consul UI

```
http://192.168.99.101:8761
or
http://192.168.99.101:8761/ui
```

##### URL to access to invoke Currency conversion rates query service

```
http://192.168.99.101:8080/conversionservice/conversionrate/from/USD/to/INR

Sample output -

{
  "id": 2,
  "sourceCurrency": "USD",
  "targetCurrency": "INR",
  "exchangeRate": 75.000
}
```

##### URL to access to invoke Currency exchange service

```
http://192.168.99.101:9090/currencyexchange/exchangeccy/from/GBP/to/INR/amount/100

Sample output -
{
  "id": 1,
  "sourceCurrency": "GBP",
  "targetCurrency": "INR",
  "exchangeRate": 90.000,
  "sourceCcyAmount": 100,
  "targetCcyAmount": 9000.000
}
```
