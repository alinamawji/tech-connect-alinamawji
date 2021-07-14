-- 16. The names and birthdays of actors born in the 1950s who acted in movies that were released in 1985 (20 rows)
SELECT DISTINCT person_name, birthday
FROM person
         JOIN movie_actor ma on person.person_id = ma.actor_id
         JOIN movie m on ma.movie_id = m.movie_id
WHERE (EXTRACT(YEAR FROM release_date) = 1985) AND
    (EXTRACT(YEAR FROM birthday) >= 1950) AND
    (EXTRACT(YEAR FROM birthday) <= 1959);
