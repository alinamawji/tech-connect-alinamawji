-- 8. The genres of movies that Robert De Niro has appeared in that were released in 2010 or later (6 rows)
SELECT DISTINCT genre_name
FROM genre
         JOIN movie_genre mg on genre.genre_id = mg.genre_id
         JOIN movie_actor ma on mg.movie_id = ma.movie_id
         JOIN movie m on ma.movie_id = m.movie_id
         JOIN person p on ma.actor_id = p.person_id
WHERE (person_name = 'Robert De Niro') AND (EXTRACT(YEAR FROM release_date) >= 2010);


