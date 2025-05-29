--✅ 1. Вывести названия всех книг и имена их авторов, отсортированных по имени автора (по возрастанию).
--Используй: SELECT, JOIN, ORDER BY
SELECT * FROM Books
SELECT * FROM Authors

SELECT Books.Name , Authors.FirstName + ' ' + Authors.LastName AS 'Aвторы'  FROM Books
JOIN Authors ON  Authors.Id = Books.Id_Author
ORDER BY Authors.FirstName ASC

--✅ 2. Вывести всех студентов, у которых ещё нет читательских билетов (S_Cards).
--Используй: LEFT JOIN, WHERE, IS NULL
SELECT * FROM S_Cards
SELECT * FROM Students
SELECT * FROM Students 
LEFT JOIN S_Cards ON Students.Id = S_Cards.Id_Student  
WHERE S_Cards.DateIn IS NULL; 

--✅ 3. Посчитать, сколько книг издаёт каждое издательство (Press) и отсортировать по убыванию.
--Используй: JOIN, GROUP BY, COUNT, ORDER BY
SELECT * FROM Books
SELECT * FROM Press
SELECT Press.Name, COUNT(Books.Id) AS NumberOfBooks  
FROM  Press
INNER JOIN Books ON Press.Id = Books.Id_Press  
GROUP BY Press.Name         
ORDER BY  NumberOfBooks DESC;      

--✅ 4. Вывести имена и фамилии всех преподавателей, которых нет среди студентов.
--Используй: EXCEPT
SELECT * FROM Students
SELECT * FROM Teachers
SELECT FirstName,LastName
FROM Teachers
EXCEPT
SELECT FirstName,LastName
FROM Students

--✅ 5. Показать список всех факультетов, даже если на них нет ни одного студента.
--Используй: LEFT JOIN
SELECT * FROM Faculties
SELECT * FROM Students

SELECT Faculties.Name  
FROM Faculties
LEFT JOIN  Students ON Faculties.Id = Students.Id
GROUP BY  Faculties.Name  

--✅ 6. Вывести список всех книг, темы которых начинаются на A или B.
--Используй: JOIN, LIKE
SELECT * FROM Books
SELECT * FROM Themes

SELECT  Books.Name  
FROM Books
INNER JOIN  Themes ON Books.Id_Themes = Themes.Id  
WHERE Themes.Name LIKE 'A%' OR Themes.Name LIKE 'B%'

--✅ 7. Найти всех студентов с фамилией длиннее 8 символов.
--Используй: WHERE, ?
SELECT * FROM Students
WHERE LastName LIKE '________%'

--✅ 8. Показать количество студентов в каждой группе.
--Используй: GROUP BY, COUNT
SELECT * FROM Groups
SELECT  Groups.Name, 
COUNT(Students.Id) AS NumberOfStudents
FROM Groups
LEFT JOIN Students ON Groups.Id = Students.Id_Group  
GROUP BY Groups.Name     

--✅ 9. Вывести топ 5 авторов по количеству книг, которые они написали.
--Используй: JOIN, GROUP BY, COUNT, ORDER BY, TOP 
SELECT * FROM Authors
SELECT TOP 5  Authors.FirstName + ' ' + Authors.LastName AS AuthorName,  
COUNT(Books.Id) AS NumberOfBooks  
FROM Authors
INNER JOIN  Books ON Authors.Id = Books.Id_Author  
GROUP BY   Authors.FirstName, Authors.LastName  
ORDER BY  NumberOfBooks DESC;  

--✅ 10. Обновить фамилию всех студентов с именем "Ali" на "Aliev".
--Используй: UPDATE, WHERE
UPDATE Students
SET LastName =  'Aliev'
WHERE FirstName =  'Ali'