-- ������� ��� ������ �� ������� books, ��� ����� (Pressrun) ������ 1000. 
SELECT * FROM books
WHERE Pressrun>100

-- �������� ������ �������� ���� (Name) � ���������� ������� (Pages). 
SELECT Name, Pages
FROM books

-- ����� �����, � ������� ���� ������ 200. 
SELECT * FROM books
WHERE Price<200

-- ����� �����, � ������� Pages = 0 ��� Price = 0. 
SELECT * FROM books
WHERE Pages = 0 OR Price = 0

-- ����� �����, ��� Pressrun ������ 500 � ���� ������ 300. 
SELECT * FROM books
WHERE Pressrun>500 AND Price<300

-- ������������� ����� �� ����������� ���������� �������.
SELECT * FROM books
ORDER BY Pages ASC

-- ������� 10 ����� ������� ����. 
SELECT TOP 10  Name,Price
FROM books
ORDER BY Price ASC


-- �������� ���� ��������� (Izd), �������� ������� ���������� �� ����� 'A'. 
SELECT Izd
FROM books
WHERE Izd LIKE 'A%'

-- ���������� ���������� ����, ��� ���������� ������� ������ 150. 
SELECT COUNT(Name)AS 'Name' FROM books
WHERE Pages>150

-- ����� ������� ���� ����, ��� Pressrun ������ 1000.
SELECT AVG(Price) FROM books
WHERE Pressrun>1000

-- ����� ����������� � ������������ �������� � ������� Pages. 
SELECT MAX(Pages) FROM books
SELECT MIN(Pages) FROM books

-- ������� �����, � �������� ������� ���� ������ '1'.  
SELECT Name
FROM books
WHERE Name LIKE '%1%'

-- ������������� ����� �� ����������� ������������ Price * Pages. 
SELECT * FROM books
ORDER BY (Price * Pages) ASC

-- �������� �����, � ������� Pages ����� 50 � 250. 
SELECT * FROM books
WHERE Pages>=50 AND Pages<=250

-- ������� �����, � ������� ���� ���������� ������ 01.01.2015.
SELECT * FROM books
WHERE Date> '01.01.2015'

-- ��������� ���������� ���� ��� ������� ��������, ��� Pages > 200. 
SELECT Izd ,COUNT(Name) 
FROM books
WHERE Pages > 200
GROUP BY Izd

-- ����� ������������, � ������� ������� ���� ���� ������ 300.
SELECT Izd, AVG(Price) FROM books
GROUP BY Izd
HAVING AVG(Price)<300

-- ����� ����� � ����������� ��������� Price * Pages.
SELECT MIN(Price * Pages) 
FROM books

-- ����� �������� ����� ������ ����� �� ���� (Date). 
SELECT  TOP 1 Name, MAX(Date)
FROM books
GROUP BY Name

-- ����� �������� � ���������� ��������� ������� (Pressrun).
SELECT Izd, MAX(Pressrun)
FROM books
GROUP BY Izd
ORDER BY MAX(Pressrun) DESC

-- �������� ����� ����� � ��������� 'Learning SQL', ����� 450, ������������� 'EduBooks' � 320 ����������. 
INSERT INTO books (Name,Price,Izd,Pages)
VALUES ('Learning SQL',450,'EduBooks',320)

-- �������� 3 �����, � ������� ���� = 999, �� � ���� ������ ��������. 
INSERT INTO books (Name,Price,Izd)
VALUES ('Learning SQL',999,'EduBooks'),
('Learning SQL',999,'Books'),
('Learning SQL',999,'Edu')

-- ������� ��� �����, � ������� �������� ���������� � 'Test'. 
DELETE books 
WHERE  Name LIKE  'Test%' 

-- ��������� ���� �� 15% ��� ���� ����, � ������� Price < 300. 
UPDATE books
SET Price = Price+45
WHERE Price < 300

-- ������������� ��� ����� � ��������� 'Old Title' �� 'Modern SQL Guide'.
UPDATE books
SET Name = 'Modern SQL Guide' 
WHERE Name = 'Old Title'

