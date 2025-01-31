CREATE DATABASE pooltastic;

\c pooltastic

CREATE TABLE APP_USER (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          username VARCHAR(50) UNIQUE NOT NULL,
                          password VARCHAR(100) NOT NULL,
                          email VARCHAR(100) NOT NULL,
                          role VARCHAR(50) NOT NULL
);

CREATE TABLE APPOINTMENT (
                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                             user_id BIGINT,
                             date DATE,
                             start_time TIME,
                             end_time TIME,
                             status VARCHAR(50),
                             FOREIGN KEY (user_id) REFERENCES APP_USER(id)
);

CREATE TABLE CONSTRAINTS (
                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                             enabledDays VARCHAR(50),
                             maxPerSlot INT,
                             minutesBetweenSlots BIGINT,
                             start TIME,
                             end TIME
);

-- Insertion des contraintes
INSERT INTO CONSTRAINTS (enabledDays, maxPerSlot, minutesBetweenSlots, start, end)
VALUES ('1,2,3,4,5,6,7', 30, 60, '10:00:00', '21:00:00');

-- Insertion de données de test
INSERT INTO APP_USER (username, password, email, role) VALUES ('admin', 'adminpassword', 'admin@example.com', 'ADMIN');
INSERT INTO APP_USER (username, password, email, role) VALUES ('user', 'userpassword', 'user@example.com', 'USER');
INSERT INTO APP_USER (username, password, email, role) VALUES ('lifeguard', 'lifeguardpassword', 'lifeguard@example.com', 'LIFEGUARD');
