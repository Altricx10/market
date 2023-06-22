CREATE TABLE bloc (
  "id" SERIAL PRIMARY KEY,
  "start_hour" timestamp,
  "end_hour" timestamp,
  "quantity" int,
  "floor_price" float
);

CREATE TABLE park (
  "id" SERIAL PRIMARY KEY,
  "type" VARCHAR(255) NOT NULL,
  "production" int
);

CREATE TABLE offer (
  "id" SERIAL PRIMARY KEY,
  "market" VARCHAR(255) NOT NULL,
  "bloc_id" int,
  "entity" VARCHAR(255) NOT NULL,
  CONSTRAINT FK_BLOC FOREIGN KEY (bloc_id) REFERENCES bloc(id)
);

CREATE TABLE offer_park (
  "offer_id" int,
  "park_id" int,
  CONSTRAINT PK_offer_park PRIMARY KEY (offer_id, park_id)
);