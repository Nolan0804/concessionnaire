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

INSERT INTO Country VALUES
('Belgium'),
('France'),
('Germany'),
('Japan'),
('USA');

INSERT INTO Brand VALUES
('BMW', 1916, 'Germany'),
('Audi', 1909, 'Germany'),
('Toyota', 1937, 'Japan'),
('Ford', 1903, 'USA'),
('Renault', 1899, 'France');

INSERT INTO Garanty VALUES
('Basic', 12),
('Premium', 24),
('Gold', 36);

INSERT INTO Color VALUES
('#000000', 'Glossy'),
('#FFFFFF', 'Matte'),
('#FF0000', 'Metallic'),
('#0000FF', 'Pearl'),
('#808080', 'Glossy');

INSERT INTO `Option` VALUES
('GPS', 'Integrated navigation system', 500),
('Leather Seats', 'Premium leather interior', 1200),
('Sunroof', 'Electric panoramic roof', 900),
('Parking Camera', 'Rear parking camera', 400),
('Heated Seats', 'Front heated seats', 350);

INSERT INTO Locality VALUES
(1000, 'Brussels', 'Belgium'),
(75000, 'Paris', 'France'),
(10115, 'Berlin', 'Germany'),
(10001, 'New York', 'USA'),
(150000, 'Tokyo', 'Japan');

INSERT INTO Customer VALUES
(
    1,
    'Dupont',
    'Jean',
    'jean.dupont@gmail.com',
    '+32471234567',
    'Rue de la Loi 1',
    '1990-05-12',
    1000,
    'Brussels',
    'Belgium'
),

(
    2,
    'Martin',
    'Claire',
    'claire.martin@gmail.com',
    '+33612345678',
    'Avenue Victor Hugo',
    '1985-03-20',
    75000,
    'Paris',
    'France'
),

(
    3,
    'Smith',
    'John',
    'john.smith@gmail.com',
    '+15551234567',
    '5th Avenue',
    '1992-11-01',
    10001,
    'New York',
    'USA'
);

INSERT INTO Vehicle VALUES
(
    'JT123456789ABCDEF',
    45000,
    '2024-01-15',
    25000,
    18000,
    '1-ABC-123',
    190,
    'Automatic',
    6,
    5,
    5,
    'BMW Serie 3 full option',
    6,
    TRUE,
    2020,
    'Premium',
    '#000000',
    'Glossy',
    'Diesel',
    'BMW',
    'Excellent',
    1
),

(
    'WAU987654321ABCDE',
    12000,
    '2024-03-10',
    32000,
    25000,
    '2-DEF-456',
    220,
    'Automatic',
    7,
    5,
    5,
    'Audi A4 sport',
    6,
    TRUE,
    2022,
    'Gold',
    '#FFFFFF',
    'Matte',
    'Hybrid',
    'Audi',
    'Good',
    2
),

(
    'WBA123456789ABCDE',
    5000,
    '2024-04-01',
    40000,
    33000,
    '3-GHI-789',
    180,
    'Automatic',
    6,
    5,
    5,
    'Toyota Prius Hybrid',
    7,
    TRUE,
    2023,
    'Gold',
    '#808080',
    'Glossy',
    'Hybrid',
    'Toyota',
    'New',
    3
);

INSERT INTO Configuration VALUES
('GPS', 'WBA123456789ABCDE'),
('Leather Seats', 'WBA123456789ABCDE'),

('Parking Camera', 'WAU987654321ABCDE'),
('Sunroof', 'WAU987654321ABCDE'),

('Heated Seats', 'JT123456789ABCDEF');

INSERT INTO Entretien VALUES
(
    '2024-02-01',
    'WBA123456789ABCDE',
    'Oil change',
    'Everything OK',
    43000
),

(
    '2024-04-10',
    'WAU987654321ABCDE',
    'Brake replacement',
    'Front brakes replaced',
    11000
);

INSERT INTO Trial VALUES
(
    '2024-05-01',
    'WAU987654321ABCDE',
    45,
    'Very comfortable car',
    TRUE,
    1
),

(
    '2024-05-03',
    'JT123456789ABCDEF',
    30,
    'Customer interested',
    TRUE,
    2
);

INSERT INTO Sale VALUES
(
    '2024-05-15',
    'WBA123456789ABCDE',
    'Bank Transfer',
    'Completed',
    1
);