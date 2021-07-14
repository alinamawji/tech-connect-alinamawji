-- 7. The genres of movies that Christopher Lloyd has appeared in (8 rows)
-- Hint: DISTINCT will prevent duplicate values in your query results.
SELECT DISTINCT genre_name
FROM genre
         JOIN movie_genre mg on genre.genre_id = mg.genre_id
         JOIN movie_actor ma on mg.movie_id = ma.movie_id
         JOIN person p on ma.actor_id = p.person_id
WHERE person_name = 'Christopher Lloyd';
