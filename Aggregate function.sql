-- ¬ывести все записи из таблицы books, где тираж (Pressrun) больше 1000. 
SELECT * FROM books
WHERE Pressrun>100

-- ѕоказать только названи€ книг (Name) и количество страниц (Pages). 
SELECT Name, Pages
FROM books

-- Ќайти книги, у которых цена меньше 200. 
SELECT * FROM books
WHERE Price<200

-- Ќайти книги, у которых Pages = 0 или Price = 0. 
SELECT * FROM books
WHERE Pages = 0 OR Price = 0

-- Ќайти книги, где Pressrun больше 500 и цена меньше 300. 
SELECT * FROM books
WHERE Pressrun>500 AND Price<300

-- ќтсортировать книги по возрастанию количества страниц.
SELECT * FROM books
ORDER BY Pages ASC

-- ¬ывести 10 самых дешЄвых книг. 
SELECT TOP 10  Name,Price
FROM books
ORDER BY Price ASC


-- ѕоказать всех издателей (Izd), названи€ которых начинаютс€ на букву 'A'. 
SELECT Izd
FROM books
WHERE Izd LIKE 'A%'

-- ѕодсчитать количество книг, где количество страниц больше 150. 
SELECT COUNT(Name)AS 'Name' FROM books
WHERE Pages>150

-- Ќайти среднюю цену книг, где Pressrun больше 1000.
SELECT AVG(Price) FROM books
WHERE Pressrun>1000

-- Ќайти минимальное и максимальное значение в колонке Pages. 
SELECT MAX(Pages) FROM books
SELECT MIN(Pages) FROM books

-- ¬ывести книги, в названии которых есть символ '1'.  
SELECT Name
FROM books
WHERE Name LIKE '%1%'

-- ќтсортировать книги по возрастанию произведени€ Price * Pages. 
SELECT * FROM books
ORDER BY (Price * Pages) ASC

-- ѕоказать книги, у которых Pages между 50 и 250. 
SELECT * FROM books
WHERE Pages>=50 AND Pages<=250

-- ¬ывести книги, у которых дата публикации старше 01.01.2015.
SELECT * FROM books
WHERE Date> '01.01.2015'

-- ѕосчитать количество книг дл€ каждого издател€, где Pages > 200. 
SELECT Izd ,COUNT(Name) 
FROM books
WHERE Pages > 200
GROUP BY Izd

-- Ќайти издательства, у которых средн€€ цена книг меньше 300.
SELECT Izd, AVG(Price) FROM books
GROUP BY Izd
HAVING AVG(Price)<300

-- Ќайти книгу с минимальным значением Price * Pages.
SELECT MIN(Price * Pages) 
FROM books

-- Ќайти название самой старой книги по дате (Date). 
SELECT  TOP 1 Name, MAX(Date)
FROM books
GROUP BY Name

-- Ќайти издател€ с наибольшим суммарным тиражом (Pressrun).
SELECT Izd, MAX(Pressrun)
FROM books
GROUP BY Izd
ORDER BY MAX(Pressrun) DESC

-- ƒобавить новую книгу с названием 'Learning SQL', ценой 450, издательством 'EduBooks' и 320 страницами. 
INSERT INTO books (Name,Price,Izd,Pages)
VALUES ('Learning SQL',450,'EduBooks',320)

-- ƒобавить 3 книги, в которых цена = 999, но у всех разные издатели. 
INSERT INTO books (Name,Price,Izd)
VALUES ('Learning SQL',999,'EduBooks'),
('Learning SQL',999,'Books'),
('Learning SQL',999,'Edu')

-- ”далить все книги, у которых название начинаетс€ с 'Test'. 
DELETE books 
WHERE  Name LIKE  'Test%' 

-- ”величить цену на 15% дл€ всех книг, у которых Price < 300. 
UPDATE books
SET Price = Price+45
WHERE Price < 300

-- ѕереименовать все книги с названием 'Old Title' на 'Modern SQL Guide'.
UPDATE books
SET Name = 'Modern SQL Guide' 
WHERE Name = 'Old Title'

