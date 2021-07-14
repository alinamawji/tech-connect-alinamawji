-- 2. The names and birthdays of actors in "The Fifth Element" (15 rows)
SELECT person_name, birthday
FROM person
         JOIN movie_actor ma on person.person_id = ma.actor_id
         JOIN movie on ma.movie_id = movie.movie_id
WHERE title = 'The Fifth Element';