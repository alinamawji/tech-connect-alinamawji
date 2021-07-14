-- 19. The genre name and the number of movies in each genre. Name the count column 'num_of_movies'. 
-- (19 rows, expected result for Action is around 180).
SELECT genre_name, count(title) AS num_of_movies
FROM movie
         JOIN movie_genre mg on movie.movie_id = mg.movie_id
         JOIN genre g on mg.genre_id = g.genre_id
GROUP BY genre_name;
