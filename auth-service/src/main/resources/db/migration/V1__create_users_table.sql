CREATE TABLE users (
                       id          UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
                       name        VARCHAR(100) NOT NULL,
                       email       VARCHAR(150) NOT NULL UNIQUE,
                       password    VARCHAR(255) NOT NULL,
                       role        VARCHAR(30)  NOT NULL DEFAULT 'ROLE_USER',
                       active      BOOLEAN      NOT NULL DEFAULT TRUE,
                       created_at  TIMESTAMP    NOT NULL DEFAULT NOW(),
                       updated_at  TIMESTAMP    NOT NULL DEFAULT NOW()
);

CREATE INDEX idx_users_email ON users(email);