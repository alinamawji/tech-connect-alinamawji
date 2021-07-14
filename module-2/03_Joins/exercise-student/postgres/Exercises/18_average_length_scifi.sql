-- 18. The average length of movies in the "Science Fiction" genre. Name the column 'average_length'.
-- (1 row, expected result around 110-120)
SELECT avg(length_minutes) AS average_length
FROM movie
         JOIN movie_genre mg on movie.movie_id = mg.movie_id
         JOIN genre g on mg.genre_id = g.genre_id
WHERE genre_name = 'Science Fiction';
