create table currencyconversionrate
(
    id int PRIMARY KEY AUTO_INCREMENT,
    exchange_rate decimal
(6,3) not null,
    source_currency varchar
(5) not null,
    target_currency varchar
(5) not null
);

insert into currencyconversionrate
    (exchange_rate, source_currency, target_currency)
values(90, 'GBP', 'INR');

insert into currencyconversionrate
    (exchange_rate, source_currency, target_currency)
values(75, 'USD', 'INR');

insert into currencyconversionrate
    (exchange_rate, source_currency, target_currency)
values(50, 'SGD', 'INR');