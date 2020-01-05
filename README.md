# docker-micro-service

Docker micro service examples

#### Build Currency conversion container (exchange rates for different currencies)

```
docker-compose up -d

docker-compose logs -f
```

#### Build Currency exchange container (return the currency amount value give a certain souce currency)

```
docker build -t currency-exchange-service:0.0.1-SNAPSHOT .

docker container run -dit -p 9090:9090 --name currency-exchange-service --env-file .env --network ccyconversionservice_currency-bridge currency-exchange-service:0.0.1-SNAPSHOT

NOTE: The value for the 'network' parameter should be from the network created by the docker-componse.yml file/step for currency conversion container setup.
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
