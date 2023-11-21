SELECT actor.first_name, COUNT(actor.first_name) 
FROM actor, film_actor 
WHERE actor.actor_id = film_actor.actor_id 
GROUP BY actor.first_name;