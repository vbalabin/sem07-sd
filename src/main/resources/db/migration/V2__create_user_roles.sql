CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE roles (
  name VARCHAR(255) NOT NULL,
   CONSTRAINT pk_roles PRIMARY KEY (name)
);
CREATE TABLE users (
  id UUID NOT NULL,
   first_name VARCHAR(255) NOT NULL,
   last_name VARCHAR(255) NOT NULL,
   role_name VARCHAR(255),
   CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE users ADD CONSTRAINT FK_USERS_ON_ROLE_NAME FOREIGN KEY (role_name) REFERENCES roles (name);
