1.	- Выдайте всю информацию о спортсменах из таблицы sportsman.
- SELECT * FROM sportsman
2.	- Выдайте наименование и мировые результаты по всем соревнованиям.
- SELECT competition_name, world_record FROM competition
3.	- Выберите имена всех спортсменов, которые родились в 1990 году.
- SELECT name FROM sportsman 
- WHERE age_of_birth = 1990
4.	- Выберите наименование и мировые результаты по всем соревнованиям, установленные 12-05-2010 или 15-05-2010.
- SELECT competition_name, world_record 
- FROM competition 
- WHERE set_date = '2010-05-12' OR set_date = '2010-05-15';
5.	- Выберите дату проведения всех соревнований, которые проводились в Москве и полученные на них результаты равны 10 секунд.
- SELECT hold_date 
- FROM result 
- WHERE city = 'Москва' AND result = 10;
6.	- Выберите имена всех спортсменов, у которых персональный рекорд не равен 25 с.
- SELECT sportsman_name 
- FROM sportsman 
- WHERE personal_record != 25;
7.	- Выберите названия всех соревнований, у которых мировой рекорд равен 15 с и дата установки рекорда не равна 12-02-2015.
- SELECT competition_name 
- FROM competition 
- WHERE world_record = 15 AND set_date != '2015-02-12';
8.	- Выберите города проведения соревнований, где результаты принадлежат множеству {13, 25, 17, 9}.
- SELECT city 
- FROM result 
- WHERE result IN (13, 25, 17, 9);
9.	- Выберите имена всех спортсменов, у которых год рождения 2000 и разряд не принадлежит множеству {3, 7, 9}.
- SELECT sportsman_name 
- FROM sportsman 
- WHERE year_of_birth = 2000 AND rank NOT IN (3, 7, 9);
10.	- Выберите дату проведения всех соревнований, у которых город проведения начинается с буквы "М".
- SELECT hold_date FROM result 
- WHERE city LIKE 'М%';
11.	- Выберите имена всех спортсменов, у которых имена начинаются с буквы "М" и год рождения не заканчивается на "6".
- SELECT sportsman_name FROM sportsman 
- WHERE sportsman_name LIKE 'М%' 
- AND year_of_birth NOT LIKE '%6';
12.	- Выберите наименования всех соревнований, у которых в названии есть слово "международные".
- SELECT competition_name
-  FROM competition
-  WHERE competition_name LIKE '%международные%';
13.	- Выберите годы рождения всех спортсменов без повторений.
- SELECT DISTINCT year_of_birth FROM sportsman;
14.	- Найдите количество результатов, полученных 12-05-2014.
- SELECT COUNT(result) FROM result 
- WHERE hold_date = '2014-05-12';
15.	- Вычислите максимальный результат, полученный в Москве.
- SELECT MAX(result) FROM result 
- WHERE city = 'Москва';
16.	- Вычислите минимальный год рождения спортсменов, которые имеют 1 разряд.
- SELECT MIN(year_of_birth) FROM sportsman 
- WHERE rank = 1;
17.	- Определите имена спортсменов, у которых личные рекорды совпадают с результатами, установленными 12-04-2014.
- SELECT sportsman_name FROM sportsman 
- INNER JOIN result ON sportsman.sportsman_id = result.sportsman_id 
- WHERE personal_record = result;
18.	- Выведите наименования соревнований, у которых дата установления мирового рекорда совпадает с датой проведения соревнований в - Москве 20-04-2015.
- SELECT competition_name FROM competition 
- INNER JOIN result ON competition.competition_id = result.competition_id 
- WHERE set_date = hold_date AND city = 'Москва' AND hold_date = '2015-04-20';
19.	- Вычислите средний результат каждого из спортсменов.
- SELECT AVG(result) FROM result GROUP BY sportsman_id;
20.	- Выведите годы рождения спортсменов, у которых результат, показанный в Москве выше среднего по всем спортсменам.
- SELECT year_of_birth FROM sportsman 
- INNER JOIN result ON sportsman.sportsman_id = result.sportsman_id 
- WHERE result > (SELECT AVG(result) FROM result);
21.	- Выведите имена всех спортсменов, у которых год рождения больше, чем год установления мирового рекорда, равного 12 с.
- SELECT sportsman_name
-  FROM sportsman
-  WHERE year_of_birth > 
- (SELECT set_date FROM competition WHERE world_record = 12);
22.	- Выведите список спортсменов в виде 'Спортсмен ' ['имя спортсмена'] 'показал результат' ['результат'] 'в городе' ['город']
- SELECT CONCAT('Спортсмен ', sportsman_name, ' показал результат ', result, ' в городе ', city)
  FROM result
  JOIN sportsman ON result.sportsman_id = sportsman.sportsman_id;
23.	- Выведите имена всех спортсменов, у которых разряд ниже среднего разряда всех спортсменов, родившихся в 2000 году.
- SELECT sportsman_name
- FROM sportsman
- WHERE rank < (SELECT AVG(rank) FROM sportsman WHERE year_of_birth = 2000);
24.	- Выведите данные о спортсменах, у которых персональный рекорд совпадает с мировым.
- SELECT *
- FROM sportsman
- WHERE personal_record = (SELECT world_record FROM competition);
25.	- Определите количество участников с фамилией Иванов, которые участвовали в соревнованиях с названием, содержащим слово 'Региональные'.
- SELECT COUNT(*) AS count
- FROM result
- JOIN sportsman ON result.sportsman_id = sportsman.sportsman_id
- JOIN competition ON result.competition_id = competition.competition_id
- WHERE sportsman_name LIKE '%Иванов%' AND competition_name LIKE '%Региональные%';
26.	- Выведите города, в которых были установлены мировые рекорды.
- SELECT DISTINCT city
- FROM competition
- WHERE competition_id IN (SELECT competition_id FROM result WHERE result = world_record);
27.	- Найдите минимальный разряд спортсменов, которые установили мировой рекорд.
- SELECT MIN(rank) AS min_rank
- FROM sportsman
- WHERE sportsman_id IN (SELECT sportsman_id FROM result WHERE result = world_record);
28.	- Выведите названия соревнований, на которых было установлено максимальное количество мировых рекордов.
- SELECT competition_name
- FROM competition
- WHERE competition_id IN (SELECT competition_id FROM result WHERE result = world_record)
- GROUP BY competition_name
- HAVING COUNT(*) = (SELECT COUNT(*) FROM result WHERE result = world_record);
29.	- Определите, спортсмены какой страны участвовали в соревнованиях больше всего.
- SELECT country, COUNT(*) AS count
- FROM sportsman
- JOIN result ON sportsman.sportsman_id = result.sportsman_id
- GROUP BY country
- ORDER BY count DESC
- LIMIT 1;
30.	- Измените разряд на 1 тех спортсменов, у которых личный рекорд совпадает с мировым.
- UPDATE sportsman
- SET rank = rank + 1
- WHERE sportsman_id IN (SELECT sportsman_id FROM result WHERE result = world_record);
