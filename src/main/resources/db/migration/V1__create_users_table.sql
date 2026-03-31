CREATE TABLE  ${table_prefix}users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    enabled BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE  ${table_prefix}authorities (
    user_id INT NOT NULL,
    authority VARCHAR(50) NOT NULL,
    CONSTRAINT fk_authorities_users FOREIGN KEY (user_id) REFERENCES ${table_prefix}users(id) ON DELETE CASCADE
);

CREATE UNIQUE INDEX ix_auth_username ON ${table_prefix}authorities (user_id, authority);


CREATE TABLE ${table_prefix}calls (
    id INT AUTO_INCREMENT PRIMARY KEY,
    caller_id INT NULL,
    callee_id INT NULL,
    call_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    duration INT DEFAULT 0,
    FOREIGN KEY (caller_id) REFERENCES ${table_prefix}users(id) ON DELETE SET NULL,
    FOREIGN KEY (callee_id) REFERENCES ${table_prefix}users(id) ON DELETE SET NULL
);

CREATE INDEX idx_calls_caller ON ${table_prefix}calls (caller_id);
CREATE INDEX idx_calls_callee ON ${table_prefix}calls (callee_id);