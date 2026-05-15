CREATE DATABASE cardealer;
USE cardealer;

CREATE TABLE Country (
    name VARCHAR(60) NOT NULL PRIMARY KEY
);

CREATE TABLE Brand (
    name VARCHAR(50) NOT NULL PRIMARY KEY,
    year_created INT(4) NOT NULL,
    origin_country VARCHAR(60) NOT NULL,

    CONSTRAINT fk_brand_country
        FOREIGN KEY (origin_country)
        REFERENCES Country(name),

    CHECK (
        year_created BETWEEN 1886
        AND YEAR(CURRENT_DATE)
    )
);

CREATE TABLE Energy (
    type VARCHAR(30) NOT NULL PRIMARY KEY,
    is_eco_friendly BOOLEAN NOT NULL
);

CREATE TABLE `Option` (
    name VARCHAR(60) NOT NULL PRIMARY KEY,
    description VARCHAR(255),
    value DECIMAL(8,2),

    CHECK (
        value IS NULL
        OR value >= 0
    )
);

CREATE TABLE Garanty (
    type VARCHAR(30) NOT NULL PRIMARY KEY,
    duration INT(3) NOT NULL,

    CHECK (
        duration BETWEEN 1
        AND 120
    )
);

CREATE TABLE State (
    state VARCHAR(50) NOT NULL PRIMARY KEY
);

CREATE TABLE Color (
    hex_color VARCHAR(10) NOT NULL,
    type VARCHAR(30) NOT NULL,
    PRIMARY KEY (hex_color, type),
    CHECK (
        hex_color REGEXP '^#[0-9A-Fa-f]{6}$'
    ),
    CHECK (
        type IN (
            'Matte',
            'Metallic',
            'Glossy',
            'Pearl'
        )
    )
);

CREATE TABLE Locality (
    postal_code INT(8) NOT NULL,
    name VARCHAR(100) NOT NULL,
    country_name VARCHAR(60) NOT NULL,

    PRIMARY KEY (
        postal_code,
        name,
        country_name
    ),

    CONSTRAINT fk_locality_country
        FOREIGN KEY (country_name)
        REFERENCES Country(name),

    CHECK (
        postal_code BETWEEN 1000 AND 99999999
    )
);

CREATE TABLE Customer (
    customer_number INT(8) NOT NULL PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    firstname VARCHAR(30) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone_number VARCHAR(20) NOT NULL,
    address VARCHAR(255) NOT NULL,
    birthday_date DATE,
    postal_code INT(5) NOT NULL,
    locality_name VARCHAR(100) NOT NULL,
    country_name VARCHAR(60) NOT NULL,

    CONSTRAINT fk_customer_locality
        FOREIGN KEY (
            postal_code,
            locality_name,
            country_name
        )
        REFERENCES Locality(
            postal_code,
            name,
            country_name
        ),

    CHECK (
        customer_number BETWEEN 1 AND 99999999
    ),

    CHECK (
        phone_number REGEXP '^\\+[0-9]{2,3}[0-9 ]+$'
    ),

    CHECK (
        email LIKE '%@%.%'
    ),

    CHECK (
        birthday_date IS NULL OR birthday_date <= CURRENT_DATE
    ),

    CHECK (
        CHAR_LENGTH(phone_number) >= 8
    )
);

CREATE TABLE Vehicle (
    vin VARCHAR(17) NOT NULL PRIMARY KEY,
    kilometer DECIMAL(10,2) NOT NULL,
    arrival_date DATE NOT NULL,
    sale_price DECIMAL(8,2) NOT NULL,
    purchase_price DECIMAL(8,2) NOT NULL,
    registration VARCHAR(20),
    power INT(4) NOT NULL,
    gear_box_type VARCHAR(9) NOT NULL,
    gear_number INT(2) NOT NULL,
    door_number INT(1) NOT NULL,
    seat_number INT(1) NOT NULL,
    information VARCHAR(255),
    euro_standard INT(1) NOT NULL,
    is_vat_deductible BOOLEAN NOT NULL,
    production_year YEAR NOT NULL,
    garanty_type VARCHAR(30) NOT NULL,
    hex_color VARCHAR(10) NOT NULL,
    type_color VARCHAR(30) NOT NULL,
    energy VARCHAR(30) NOT NULL,
    brand_name VARCHAR(50) NOT NULL,
    state VARCHAR(50) NOT NULL,
    saler INT(8) NOT NULL,

    CONSTRAINT fk_vehicle_garanty
        FOREIGN KEY (garanty_type)
        REFERENCES Garanty(type),

    CONSTRAINT fk_vehicle_color
        FOREIGN KEY (
            hex_color,
            type_color
        )
        REFERENCES Color(
            hex_color,
            type
        ),

    CONSTRAINT fk_vehicle_energy
        FOREIGN KEY (energy)
        REFERENCES Energy(type),

    CONSTRAINT fk_vehicle_brand
        FOREIGN KEY (brand_name)
        REFERENCES Brand(name),

    CONSTRAINT fk_vehicle_state
        FOREIGN KEY (state)
        REFERENCES State(state),

    CONSTRAINT fk_vehicle_saler
        FOREIGN KEY (saler)
        REFERENCES Customer(customer_number),

    CHECK (
        CHAR_LENGTH(vin) = 17
    ),

    CHECK (
        kilometer BETWEEN 0 AND 999999.99
    ),

    CHECK (
        sale_price BETWEEN 0 AND 999999.99
    ),

    CHECK (
        purchase_price BETWEEN 0 AND 999999.99
    ),

    CHECK (
        sale_price >= purchase_price
    ),

    CHECK (
        power BETWEEN 1 AND 1000
    ),

    CHECK (
        gear_box_type IN (
            'Automatic',
            'Manual'
        )
    ),

    CHECK (
        gear_number BETWEEN 5 AND 8
    ),

    CHECK (
        door_number BETWEEN 3 AND 5
    ),

    CHECK (
        seat_number BETWEEN 1 AND 9
    ),

    CHECK (
        euro_standard BETWEEN 1 AND 7
    ),

    CHECK (
        production_year BETWEEN 1886 AND YEAR(CURRENT_DATE)
    ),

    CHECK (
        arrival_date <= CURRENT_DATE
    )
);

CREATE TABLE Configuration (
    option_name VARCHAR(60) NOT NULL,
    vin_vehicle VARCHAR(17) NOT NULL,

    PRIMARY KEY (
        option_name,
        vin_vehicle
    ),

    CONSTRAINT fk_configuration_option
        FOREIGN KEY (option_name)
        REFERENCES `Option`(name),

    CONSTRAINT fk_configuration_vehicle
        FOREIGN KEY (vin_vehicle)
        REFERENCES Vehicle(vin)
);

CREATE TABLE Entretien (
    date DATE NOT NULL,
    vin_number VARCHAR(17) NOT NULL,

    description VARCHAR(255),
    annotation VARCHAR(255),

    kilometer DECIMAL(10,2) NOT NULL,

    PRIMARY KEY (
        date,
        vin_number
    ),

    CONSTRAINT fk_entretien_vehicle
        FOREIGN KEY (vin_number)
        REFERENCES Vehicle(vin),

    CHECK (
        kilometer BETWEEN 0 AND 999999.99
    ),

    CHECK (
        date <= CURRENT_DATE
    )
);

CREATE TABLE Sale (
    date DATE NOT NULL,
    vin_vehicle VARCHAR(17) NOT NULL,
    payment_method VARCHAR(30) NOT NULL,
    state VARCHAR(30) NOT NULL,
    customer_number INT(8) NOT NULL,
    PRIMARY KEY (
        date,
        vin_vehicle
    ),

    CONSTRAINT fk_sale_vehicle
        FOREIGN KEY (vin_vehicle)
        REFERENCES Vehicle(vin),

    CONSTRAINT fk_sale_customer
        FOREIGN KEY (customer_number)
        REFERENCES Customer(customer_number),

    CHECK (
        payment_method IN (
            'Cash',
            'Card',
            'Bank Transfer',
            'Financing'
        )
    ),

    CHECK (
        state IN (
            'Pending',
            'Completed',
            'Cancelled'
        )
    ),

    CHECK (
        date <= CURRENT_DATE
    )
);

CREATE TABLE Trial (
    date DATE NOT NULL,
    vin_number VARCHAR(17) NOT NULL,
    duration INT(3) NOT NULL,
    comment VARCHAR(255),
    is_potential_sale BOOLEAN NOT NULL,
    customer_number INT(8) NOT NULL,

    PRIMARY KEY (
        date,
        vin_number
    ),

    CONSTRAINT fk_trial_vehicle
        FOREIGN KEY (vin_number)
        REFERENCES Vehicle(vin),

    CONSTRAINT fk_trial_customer
        FOREIGN KEY (customer_number)
        REFERENCES Customer(customer_number),

    CHECK (
        duration BETWEEN 1
        AND 180
    ),

    CHECK (
        date <= CURRENT_DATE
    )
);

INSERT INTO energy VALUES
('Petrol', FALSE),
('Diesel', FALSE),
('Hybrid', TRUE),
('Electric', TRUE),
('LPG', TRUE),
('Hydrogen', TRUE);

INSERT INTO State VALUES
('New'),
('Excellent'),
('Good'),
('Average'),
('Damaged'),
('Sold');


DELIMITER $$

CREATE TRIGGER trg_sale_vehicle_state
AFTER INSERT
ON Sale
FOR EACH ROW
BEGIN

    UPDATE Vehicle
    SET state = 'Sold'
    WHERE vin = NEW.vin_vehicle;

END$$

CREATE TRIGGER trg_customer_email_lowercase
BEFORE INSERT
ON Customer
FOR EACH ROW
BEGIN

    SET NEW.email = LOWER(NEW.email);

END$$

DELIMITER ;