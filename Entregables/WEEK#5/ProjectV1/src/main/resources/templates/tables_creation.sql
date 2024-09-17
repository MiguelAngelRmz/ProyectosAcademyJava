CREATE TABLE IF NOT EXISTS customer (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS transaction (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    source_account_id BIGINT,
    destination_account_id BIGINT,
    amount DECIMAL(15, 2),
    timestamp TIMESTAMP,
    FOREIGN KEY (source_account_id) REFERENCES Account(id),
    FOREIGN KEY (destination_account_id) REFERENCES Account(id)
);

CREATE TABLE IF NOT EXISTS account (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    account_number VARCHAR(255) NOT NULL UNIQUE DEFAULT 'DEFAULT_ACCOUNT_NUMBER',
    account_holder_name VARCHAR(255) NOT NULL,
    account_type ENUM('SAVINGS', 'CHECKING') NOT NULL DEFAULT 'SAVINGS',
    balance DECIMAL(38, 2) NOT NULL DEFAULT 0.00,
    customer_id BIGINT,
    FOREIGN KEY (customer_id) REFERENCES customer(id) ON DELETE SET NULL
);

INSERT INTO customer (name, email) VALUES ('John Doe', 'john.doe@example.com');
INSERT INTO customer (name, email) VALUES ('Jane Smith', 'jane.smith@example.com');


INSERT INTO account (account_number, account_holder_name, account_type, balance, customer_id) 
VALUES ('1234567890', 'John Doe', 'SAVINGS', 1000.00, 1);
INSERT INTO account (account_number, account_holder_name, account_type, balance, customer_id) 
VALUES ('0987654321', 'Jane Smith', 'CHECKING', 500.00, 2);
