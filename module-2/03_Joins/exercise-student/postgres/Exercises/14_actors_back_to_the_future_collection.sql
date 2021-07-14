-- 14. The names of actors who've appeared in the movies in the "Back to the Future Collection" (28 rows)
SELECT DISTINCT person_name
FROM person
         JOIN movie_actor ma on person.person_id = ma.actor_id
         JOIN movie m on ma.movie_id = m.movie_id
         JOIN collection c on m.collection_id = c.collection_id
WHERE collection_name = 'Back to the Future Collection';

