-- FIND all cars
select * from car;

-- Find all Subaru cars
select make, model from car where make = 'Subaru';

-- AVerage price
select avg(msrp) from car;

-- Query all distinct makes!
select DISTINCT make from car;