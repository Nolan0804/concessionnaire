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
        REFERENCES country(name),

    CHECK (
        year_created BETWEEN 1886
        AND YEAR(CURRENT_DATE)
    )
);

CREATE TABLE Energy (
    type VARCHAR(30) NOT NULL PRIMARY KEY,
    is_eco_friendly BOOLEAN NOT NULL
);

CREATE TABLE Option (
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

-- =====================================================
-- STATE
-- =====================================================

CREATE TABLE state (
    state VARCHAR(50) NOT NULL PRIMARY KEY,

    CHECK (
        state IN (
            'New',
            'Excellent',
            'Good',
            'Average',
            'Damaged',
            'Sold'
        )
    )
);

-- =====================================================
-- COLOR
-- =====================================================

CREATE TABLE color (
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

-- =====================================================
-- LOCALITY
-- =====================================================

CREATE TABLE locality (
    postal_code INT(5) NOT NULL,
    name VARCHAR(100) NOT NULL,
    country_name VARCHAR(60) NOT NULL,

    PRIMARY KEY (
        postal_code,
        name,
        country_name
    ),

    CONSTRAINT fk_locality_country
        FOREIGN KEY (country_name)
        REFERENCES country(name),

    CHECK (
        postal_code BETWEEN 1000
        AND 99999
    )
);

-- =====================================================
-- CUSTOMER
-- =====================================================

CREATE TABLE customer (
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
        REFERENCES locality(
            postal_code,
            name,
            country_name
        ),

    CHECK (
        customer_number BETWEEN 1
        AND 99999999
    ),

    CHECK (
        email LIKE '%@%.%'
    ),

    CHECK (
        birthday_date IS NULL
        OR birthday_date <= CURRENT_DATE
    ),

    CHECK (
        CHAR_LENGTH(phone_number) >= 8
    )
);

-- =====================================================
-- VEHICLE
-- =====================================================

CREATE TABLE vehicle (
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

    state VARCHAR(50) NOT NULL DEFAULT 'Good',

    saler INT(8) NOT NULL,

    CONSTRAINT fk_vehicle_garanty
        FOREIGN KEY (garanty_type)
        REFERENCES garanty(type),

    CONSTRAINT fk_vehicle_color
        FOREIGN KEY (
            hex_color,
            type_color
        )
        REFERENCES color(
            hex_color,
            type
        ),

    CONSTRAINT fk_vehicle_energy
        FOREIGN KEY (energy)
        REFERENCES energy(type),

    CONSTRAINT fk_vehicle_brand
        FOREIGN KEY (brand_name)
        REFERENCES brand(name),

    CONSTRAINT fk_vehicle_state
        FOREIGN KEY (state)
        REFERENCES state(state),

    CONSTRAINT fk_vehicle_saler
        FOREIGN KEY (saler)
        REFERENCES customer(customer_number),

    CHECK (
        CHAR_LENGTH(vin) = 17
    ),

    CHECK (
        kilometer BETWEEN 0
        AND 999999.99
    ),

    CHECK (
        sale_price BETWEEN 0
        AND 999999.99
    ),

    CHECK (
        purchase_price BETWEEN 0
        AND 999999.99
    ),

    CHECK (
        sale_price >= purchase_price
    ),

    CHECK (
        power BETWEEN 1
        AND 3000
    ),

    CHECK (
        gear_box_type IN (
            'Automatic',
            'Manual'
        )
    ),

    CHECK (
        gear_number BETWEEN 4
        AND 10
    ),

    CHECK (
        door_number BETWEEN 2
        AND 6
    ),

    CHECK (
        seat_number BETWEEN 1
        AND 9
    ),

    CHECK (
        euro_standard BETWEEN 1
        AND 7
    ),

    CHECK (
        production_year BETWEEN 1886
        AND YEAR(CURRENT_DATE)
    ),

    CHECK (
        arrival_date <= CURRENT_DATE
    )
);

-- =====================================================
-- CONFIGURATION
-- =====================================================

CREATE TABLE configuration (
    option_name VARCHAR(60) NOT NULL,
    vin_vehicle VARCHAR(17) NOT NULL,

    PRIMARY KEY (
        option_name,
        vin_vehicle
    ),

    CONSTRAINT fk_configuration_option
        FOREIGN KEY (option_name)
        REFERENCES `option`(name),

    CONSTRAINT fk_configuration_vehicle
        FOREIGN KEY (vin_vehicle)
        REFERENCES vehicle(vin)
);

-- =====================================================
-- ENTRETIEN
-- =====================================================

CREATE TABLE entretien (
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
        REFERENCES vehicle(vin),

    CHECK (
        kilometer BETWEEN 0
        AND 999999.99
    ),

    CHECK (
        date <= CURRENT_DATE
    )
);

-- =====================================================
-- SALE
-- =====================================================

CREATE TABLE sale (
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
        REFERENCES vehicle(vin),

    CONSTRAINT fk_sale_customer
        FOREIGN KEY (customer_number)
        REFERENCES customer(customer_number),

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

-- =====================================================
-- TRIAL
-- =====================================================

CREATE TABLE trial (
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
        REFERENCES vehicle(vin),

    CONSTRAINT fk_trial_customer
        FOREIGN KEY (customer_number)
        REFERENCES customer(customer_number),

    CHECK (
        duration BETWEEN 1
        AND 180
    ),

    CHECK (
        date <= CURRENT_DATE
    )
);

-- =====================================================
-- DEFAULT DATA
-- =====================================================

INSERT INTO energy VALUES
('Petrol', FALSE),
('Diesel', FALSE),
('Hybrid', TRUE),
('Electric', TRUE),
('LPG', TRUE),
('Hydrogen', TRUE);

INSERT INTO state VALUES
('New'),
('Excellent'),
('Good'),
('Average'),
('Damaged'),
('Sold');

-- =====================================================
-- TRIGGERS
-- =====================================================

DELIMITER $$

CREATE TRIGGER trg_sale_vehicle_state
AFTER INSERT
ON sale
FOR EACH ROW
BEGIN

    UPDATE vehicle
    SET state = 'Sold'
    WHERE vin = NEW.vin_vehicle;

END$$

CREATE TRIGGER trg_no_double_sale
BEFORE INSERT
ON sale
FOR EACH ROW
BEGIN

    DECLARE vehicle_state VARCHAR(50);

    SELECT state
    INTO vehicle_state
    FROM vehicle
    WHERE vin = NEW.vin_vehicle;

    IF vehicle_state = 'Sold' THEN

        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Vehicle already sold';

    END IF;

END$$

CREATE TRIGGER trg_trial_sold_vehicle
BEFORE INSERT
ON trial
FOR EACH ROW
BEGIN

    DECLARE vehicle_state VARCHAR(50);

    SELECT state
    INTO vehicle_state
    FROM vehicle
    WHERE vin = NEW.vin_number;

    IF vehicle_state = 'Sold' THEN

        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Cannot test a sold vehicle';

    END IF;

END$$

CREATE TRIGGER trg_customer_email_lowercase
BEFORE INSERT
ON customer
FOR EACH ROW
BEGIN

    SET NEW.email = LOWER(NEW.email);

END$$

CREATE TRIGGER trg_registration_uppercase
BEFORE INSERT
ON vehicle
FOR EACH ROW
BEGIN

    IF NEW.registration IS NOT NULL THEN
        SET NEW.registration = UPPER(NEW.registration);
    END IF;

END$$

DELIMITER ;