-- 6. The genres of "The Wizard of Oz" (3 rows)
SELECT genre_name
FROM genre
         JOIN movie_genre mg on genre.genre_id = mg.genre_id
         JOIN movie m on mg.movie_id = m.movie_id
WHERE title = 'The Wizard of Oz';

