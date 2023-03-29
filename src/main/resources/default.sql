-- Terminate all sessions connected to the database
SELECT pg_terminate_backend(pg_stat_activity.pid)
FROM pg_stat_activity
WHERE pg_stat_activity.datname = 'loms';

-- Drop the database
DROP DATABASE IF EXISTS loms;

-- Drop the user role
DROP ROLE IF EXISTS loms;

-- Recreate the user role and database
CREATE ROLE loms WITH
    LOGIN
    CREATEDB
    CREATEROLE
    INHERIT
    NOREPLICATION
    CONNECTION LIMIT -1
    PASSWORD 'loms';

CREATE DATABASE loms
    WITH
    OWNER = loms
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;

-- Create the users table
CREATE TABLE app_users
(
    id bigserial PRIMARY KEY,
    email character varying(255) NOT NULL,
    firstname character varying(255) NOT NULL,
    lastname character varying(255) NOT NULL,
    password character varying(255),
    username character varying(255) NOT NULL,
    title character varying(255) NOT NULL,
    created_at timestamp without time zone DEFAULT now(),
    updated_at timestamp without time zone
);

ALTER TABLE app_users OWNER to loms;
