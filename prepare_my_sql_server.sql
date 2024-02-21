-- Prepares a MySQL server(Creates database and user) for eco_tracks 

CREATE DATABASE IF NOT EXISTS eco_test_db;

USE eco_test_db;

CREATE USER IF NOT EXISTS 'eco_user'@'localhost' IDENTIFIED BY 'eco_user_pwd';

GRANT ALL PRIVILEGES ON eco_test_db.* TO 'eco_user'@'localhost';

GRANT SELECT ON perfomance_schema.* TO 'eco_user'@'localhost';
