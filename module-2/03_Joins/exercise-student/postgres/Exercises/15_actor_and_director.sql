-- 15. The title of the movie and the name of director for movies where the director was also an actor in the same movie (73 rows)
SELECT title, person_name
FROM movie
         JOIN person p on movie.director_id = p.person_id
         JOIN movie_actor ma on movie.movie_id = ma.movie_id
WHERE director_id = actor_id;
