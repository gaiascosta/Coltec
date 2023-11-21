SELECT rental_date, first_name FROM rental, customer WHERE customer.customer_id = rental.customer_id GROUP BY rental_date, first_name ORDER BY COUNT(first_name) DESC LIMIT 5;

ou

SELECT first_name, rental.customer_id, COUNT(rental.rental_id) FROM customer, rental WHERE customer.customer_id = rental.customer_id GROUP BY rental.customer_id ORDER BY COUNT(renta
l.customer_id) DESC LIMIT 5;