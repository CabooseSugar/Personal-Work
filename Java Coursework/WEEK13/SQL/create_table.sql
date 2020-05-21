-- Create table for car
CREATE TABLE car (
  vin INTEGER,
  make VARCHAR(100),
  model VARCHAR(100),
  msrp NUMERIC,
  manufactured_date DATETIME
);

-- add a primary key
ALTER TABLE car ADD CONSTRAINT  pk_car PRIMARY KEY (vin);

-- add some cars!
INSERT INTO car (vin, make, model, msrp, manufactured_date) VALUES
  (44444, 'Chevy', 'Equinox', 25000, '2011-01-01');
INSERT INTO car (vin, make, model, msrp, manufactured_date) VALUES
  (67443, 'BMW', 'M4', 135000, '2011-01-01');




