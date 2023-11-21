SELECT customer.first_name, inventory.film_id, rental_id 
FROM customer, inventory, rental 
WHERE customer.customer_id = rental.customer_id 
AND inventory.inventory_id = rental.inventory_id 
AND rental.customer_id = 273;