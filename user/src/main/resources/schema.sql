CREATE TABLE sj_user (
  id UUID PRIMARY KEY,
  name VARCHAR(255),
  email VARCHAR(255),
  password VARCHAR(255),
  created TIMESTAMP,
  modified TIMESTAMP,
  last_login TIMESTAMP,
  token VARCHAR(255),
  active BOOLEAN
);

CREATE TABLE sj_telephone (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  number VARCHAR(255),
  citycode VARCHAR(255),
  contrycode VARCHAR(255),
  user_id UUID,
  FOREIGN KEY (user_id) REFERENCES sj_user(id)
);
