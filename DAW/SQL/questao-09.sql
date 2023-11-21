SELECT name, COUNT(inventory.film_id) 
FROM category, film_category, inventory 
WHERE category.category_id = film_category.category_id 
AND inventory.film_id = film_category.film_id 
GROUP BY name;