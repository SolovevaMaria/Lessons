
--Выведи название, цену и тираж, а также добавь колонку "Общая сумма", где будет Price * Pressrun.
--(Используй AS для красивого имени 
SELECT [Name] AS 'Название книги',Price AS Цена,Pressrun AS Тираж ,
       Price * Pressrun AS 'Общая сумма ' 
FROM books
--Выведи книги, отсортированные по тиражу (от большего к меньшему), а если тираж одинаковый — по цене (по возрастанию). 
SELECT * FROM books
ORDER BY Pressrun DESC, Price ASC
--Выведи книги, отсортированные по формату (Format) по алфавиту, а затем по дате (Date) по убыванию. 
SELECT * FROM books
ORDER BY Format

SELECT * FROM books
ORDER BY Format DESC
--Переименуй колонки: Name → "Книга", Price → "Цена", Pressrun → "Тираж".
--(Только переименование, без сортировки) 
SELECT [Name] AS 'Книга',Price AS Цена,Pressrun AS Тираж 
FROM books
--Выведи названия книг и коды (Code), отсортированные по названию по алфавиту. 
SELECT name,Code
FROM books
ORDER BY  Name
--Покажи только Name, Pages и Format, отсортированные по количеству страниц (Pages) по убыванию. 
SELECT Name, Pages, Format
FROM books
ORDER BY Pages DESC
--Выведи все книги, добавив колонку "Цена за 1 страницу", рассчитанную как Price / Pages. 
SELECT Name,Price,Izd,Pages,Format,Date,Pressrun,Themes,Category,upsize_ts,
       Price/Pages AS "Цена за 1 страницу" 
FROM books
--Отсортируй книги по Category, потом по Themes, потом по Name. 
SELECT * FROM books
ORDER BY Category,Themes,  Name
--Выведи название книги, цену и дату, отсортированные по дате (сначала самые новые).
SELECT [Name] AS 'Название книги',Price AS Цена,Date AS Дата 
FROM books
ORDER BY Date DESC
