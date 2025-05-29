--1 Выведи все книги, у которых цена больше 200.
SELECT * FROM books 
WHERE Price>200 
--2 Выведи книги, у которых количество страниц от 300 до 600 включительно.
SELECT * FROM books 
WHERE Pages>=300 AND Pages<=600
--3 Показать книги, изданные издательством 'DiaSoft'.
SELECT * FROM books 
WHERE izd= 'DiaSoft'
--4 Показать книги, у которых Date не указана.
SELECT * FROM books 
WHERE date is NULL
--5 Вывести все уникальные издательства (Izd) из таблицы.
SELECT DISTINCT Izd
FROM books
--6 Выбери книги, у которых цена — 10, 50, 100 или 150.
SELECT  * FROM books 
WHERE Price in (10, 50, 100, 150)
--7 Показать книги, где название начинается с "SQL".
SELECT * FROM books 
WHERE Name LIKE 'SQL%'
--8 Вывести книги, у которых Pressrun равен 1.
SELECT  * FROM books 
WHERE  Pressrun=1
--9 Показать книги, у которых название содержит Fə.
SELECT * FROM books
WHERE Name LIKE N'Fə%'

--10 Вывести книги, у которых цена не равна 100.
SELECT  * FROM books
WHERE Price != 100
--11 Показать 3% самых дешёвых книг, у которых страниц больше 300, и цена не входит в (100, 200, 300).
SELECT TOP (3) PERCENT *
FROM books 
WHERE Pages>300 AND Price not in (100, 200, 300)
--12 Показать книги, где Price > 150, Izd не "DiaSoft", и дата указана (Date IS NOT NULL).
SELECT  * FROM books
WHERE Price > 150 AND Izd not in ('DiaSoft') AND Date IS NOT NULL
--13 Вывести книги, где название состоит из 3 букв, первая — "Д", третья — "К".
SELECT  Name 
FROM books 
WHERE Name LIKE 'Д_К'
--14 Сгруппировать книги по New (0 и 1), и показать статус: old или new.
SELECT Name ,
CASE
  WHEN New = 0 THEN 'Old'
  WHEN New = 1 THEN 'New' 
END as 'status',
Price,Pressrun  
FROM books
--15 Вывести название книги, цену и текстовую "оценку стоимости" через IIF, по таким правилам:
     --> 300 → "очень дорогая"
     --> 200 → "дорогая"
     --> 100 → "не очень дорогая"
     --<= 100 → "дешёвая"
     --NULL → "нет информации"
SELECT Name , 
IIF(Price > 300 , 'очень дорогая',IIF(Price > 200 , 'дорогая', IIF(Price > 100 , 'не очень дорогая',IIF(Price <= 100 , 'дешёвая',IIF(Price IS NULL ,'cheap','нет информации'))))) as 'cost',
Price,Pressrun  
FROM books 
--16 Выведи книги, у которых:
--Pages > 500
--и это одна самая дорогая книга по этому условию**
SELECT  * FROM books
WHERE Pages > 500
--17 Составь запрос, который покажет:
--Name, Price, Pressrun,
--статус тиража (IIF(Pressrun = 1) → "1 экз.", IS NULL → "нет данных", иначе — "в наличии")**
SELECT  Name, Price, Pressrun,
IIF(Pressrun = 1, '1 экз.',IIF(Pressrun IS NULL, 'нет данных',  'в наличии')) AS 'Статус тиража'
FROM books 
--18 Показать книги, у которых:
--Izd содержит одну букву из набора [а-яa-z], как 2-й символ,
--и название не начинается с "A"**
SELECT DISTINCT Izd
FROM books
WHERE Izd LIKE '_[а-яa-z]%' AND Name NOT LIKE 'А%'
--Вывести все книги, отсортированные по убыванию стоимости всего тиража (Price * Pressrun).
SELECT Name, Price * Pressrun AS 'стоимость всего тиража'
FROM books 
ORDER BY Price * Pressrun DESC
--Вывести книги, где цена NULL или <= 100, но Pressrun больше 3000.
SELECT Name, Price, Pressrun 
FROM books 
WHERE (Price IS NULL OR Price<=100) AND Pressrun >3000
