DESC rental;
DESC customer;
SELECT rental_date, first_name FROM rental, customer WHERE customer.customer_id = rental.customer_id; 