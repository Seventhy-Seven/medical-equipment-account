-- Создание бд (не требуется)
--CREATE DATABASE equipment_management;

-- Создание таблицы "пользователи"
CREATE TABLE IF NOT EXISTS "users"
(
    id       SERIAL PRIMARY KEY,
    position VARCHAR(50),
    password VARCHAR(100)
);

-- Создание таблицы "оборудование"
CREATE TABLE IF NOT EXISTS equipment
(
    id                      SERIAL PRIMARY KEY,
    status                  VARCHAR(20),
    name                    VARCHAR(100),
    location                VARCHAR(100),
    serial_number           VARCHAR(50),
    inventory_number        VARCHAR(50),
    manufacturer            VARCHAR(100),
    quantity                INTEGER,
    types_of_work           VARCHAR(200),
    past_inventory_date     VARCHAR(50),
    future_inventory_date   VARCHAR(50),
    past_calibration_date   VARCHAR(50),
    future_calibration_date VARCHAR(50)
);

-- Создание таблицы "оборудование в ремонте"
CREATE TABLE IF NOT EXISTS equipment_under_repair
(
    id                      SERIAL PRIMARY KEY,
    status                  VARCHAR(20),
    name                    VARCHAR(100),
    location                VARCHAR(100),
    serial_number           VARCHAR(50),
    inventory_number        VARCHAR(50),
    manufacturer            VARCHAR(100),
    quantity                INTEGER,
    types_of_work           VARCHAR(200),
    past_inventory_date     VARCHAR(50),
    future_inventory_date   VARCHAR(50),
    past_calibration_date   VARCHAR(50),
    future_calibration_date VARCHAR(50)
);

INSERT INTO users(position, password)
VALUES ('администратор', '123456'),
       ('инженер', '123456'),
       ('пользователь', '123456');

INSERT INTO equipment(status, name, location, serial_number, inventory_number, manufacturer, quantity, types_of_work,
                      past_inventory_date, future_inventory_date, past_calibration_date, future_calibration_date)
VALUES ('работает', 'Equipment 1', 'Location 1', 'SN001', 'INV001', 'Manufacturer 1', 10, 'Maintenance, Repair',
        '2021-01-01', '2022-01-01', '2021-02-01', '2022-02-01'),
       ('не работает', 'Equipment 2', 'Location 2', 'SN002', 'INV002', 'Manufacturer 2', 5, 'Calibration', '2021-03-01',
        '2022-03-01', '2021-04-01', '2022-04-01'),
       ('работает', 'Equipment 3', 'Location 3', 'SN003', 'INV003', 'Manufacturer 1', 2, 'Inspection', '2021-05-01',
        '2022-05-01', '2021-06-01', '2022-06-01'),
       ('работает', 'Equipment 4', 'Location 3', 'SN003', 'INV003', 'Manufacturer 1', 2, 'Inspection', '2021-05-01',
        '2022-05-01', '2021-06-01', '2022-06-01')
;

INSERT INTO equipment_under_repair(status, name, location, serial_number, inventory_number, manufacturer, quantity,
                                   types_of_work, past_inventory_date, future_inventory_date, past_calibration_date,
                                   future_calibration_date)
VALUES ('не работает', 'Equipment 4', 'Location 4', 'SN004', 'INV004', 'Manufacturer 3', 1, 'Repair', '2021-07-01',
        '2022-07-01', '2021-08-01', '2022-08-01'),
       ('не работает', 'Equipment 5', 'Location 5', 'SN005', 'INV005', 'Manufacturer 2', 3, 'Maintenance', '2021-09-01',
        '2022-09-01', '2021-10-01', '2022-10-01'),
       ('не работает', 'Equipment 6', 'Location 6', 'SN006', 'INV006', 'Manufacturer 1', 2, 'Calibration', '2021-11-01',
        '2022-11-01', '2021-12-01', '2022-12-01');
