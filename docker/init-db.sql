SELECT 'CREATE DATABASE auth_db' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'auth_db')\gexec
SELECT 'CREATE DATABASE payment_db' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'payment_db')\gexec
SELECT 'CREATE DATABASE notification_db' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'notification_db')\gexec

\c auth_db;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

\c payment_db;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

\c notification_db;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";