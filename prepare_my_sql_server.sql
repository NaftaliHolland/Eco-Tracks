-- Prepares a MySQL server(Creates database and user) for eco_tracks 

CREATE DATABASE IF NOT EXISTS eco_dev_db;

USE eco_dev_db;

CREATE USER IF NOT EXISTS 'eco_user'@'localhost';

GRANT ALL PRIVILEGES ON eco_dev_db.* TO 'eco_user'@'localhost';

GRANT SELECT ON perfomance_schema.* TO 'eco_user'@'localhost';
