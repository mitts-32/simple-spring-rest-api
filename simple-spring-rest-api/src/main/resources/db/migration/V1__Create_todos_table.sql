CREATE SCHEMA business CREATE TABLE IF NOT EXISTS business.todos (
    id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    title VARCHAR(64) NULL
);
