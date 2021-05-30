CREATE TABLE msg
(
 id serial PRIMARY KEY,
 	sender varchar(100) NOT NULL,
  receiver varchar(100) NOT NULL ,
 message varchar(100) DEFAULT NULL,
created_at DATE NOT NULL DEFAULT CURRENT_DATE,
stop_untill bigserial NOT NULL
);