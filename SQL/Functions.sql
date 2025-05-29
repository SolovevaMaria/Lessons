--�������
--1. ���������������� ������� ���������� ���������� ���������� �����������.
CREATE FUNCTION UniqClient()
RETURNS INT
BEGIN
	DECLARE @uniqueClient INT  = (SELECT DISTINCT COUNT(*) AS 'Unique Clients' FROM Clients);
	RETURN @uniqueClient
END


SELECT dbo.UniqClient()

--2. ���������������� ������� ���������� ������� ���� ������ ����������� ����.
--	 ��� ������ ��������� � �������� ���������. ��������, ������� ���� �����.
CREATE FUNCTION AvgByType(@type NVARCHAR(50))
RETURNS INT
AS
BEGIN
   
DECLARE @AvgByTypeResult INT =  (SELECT AVG(Products.PrimeCost) 
        FROM Products
        JOIN Type ON Products.TypeId = Type.Id
        WHERE Type.Name like @type )

RETURN @AvgByTypeResult
END

SELECT dbo.AvgByType('Training apparatus')

--3. ���������������� ������� ���������� ������� ���� ������� �� ������ ����, ����� �������������� �������.
CREATE FUNCTION AverageSalePriceByDate()
RETURNS @ResultTable TABLE
(
  SaleDate DATE,
  AveragePrice DECIMAL(18, 2)
)
AS
BEGIN
INSERT INTO @ResultTable
SELECT Sales.[Date], AVG(Products.[Cost])  
FROM Sales 
JOIN Storage  ON Sales.StorageId = Storage.Id
JOIN Products  ON Storage.ProductId = Products.Id  
GROUP BY  Sales.[Date];
RETURN
END

SELECT * FROM AverageSalePriceByDate()

--4. ���������������� ������� ���������� ���������� � ��������� ��������� ������. �������� ����������� ���������� ���������� ������: ���� �������.
CREATE FUNCTION GetLastSoldProductInfo()
RETURNS @ResultTable TABLE
(
  ProductId INT,
  ProductName NVARCHAR(50),
  SaleDate DATE,
  EmployeeFullName NVARCHAR(50),
  ClientFullName NVARCHAR(50)
)
AS
BEGIN
INSERT INTO @ResultTable
SELECT TOP (1) Products.Id AS ProductId, Products.Name AS ProductName,  Sales.[Date] AS SaleDate, 
Employees.FullName AS EmployeeFullName, Clients.FullName AS ClientFullName
FROM Sales 
JOIN Storage  ON Sales.StorageId = Storage.Id
JOIN Products  ON Storage.ProductId = Products.Id
JOIN Employees ON Sales.EmployeeId = Employees.Id
JOIN Clients ON Sales.ClientId = Clients.Id
ORDER BY Sales.[Date] DESC;
RETURN
END

SELECT * FROM GetLastSoldProductInfo()

--5. ���������������� ������� ���������� ���������� � ������ ��������� ������. �������� ����������� ������� ���������� ������: ���� �������.
CREATE FUNCTION GetFirstSoldProductInfo()
RETURNS @ResultTable TABLE
(
    ProductId INT,
    ProductName NVARCHAR(50),
    SaleDate DATE,
    EmployeeFullName NVARCHAR(50),
	ClientFullName NVARCHAR(50)
)
AS
BEGIN
INSERT INTO @ResultTable
SELECT TOP (1) Products.Id AS ProductId,Products.Name AS ProductName,Sales.[Date] AS SaleDate,
Employees.FullName AS EmployeeFullName,Clients .FullName AS ClientFullName
FROM Sales 
JOIN Storage  ON Sales.StorageId = Storage.Id
JOIN Products  ON Storage.ProductId = Products.Id
JOIN Employees ON Sales.EmployeeId = Employees.Id
JOIN Clients  ON Sales.ClientId = Clients .Id
ORDER BY Sales.[Date] ASC;
RETURN
END

SELECT * FROM GetFirstSoldProductInfo()

--���������
--1. �������� ��������� ���������� ���������� � ���� ��������� 
CREATE PROCEDURE GetEmployeeInfo
AS
BEGIN
SELECT Employees.Id AS EmployeeId,Employees.FullName AS EmployeeFullName, Positions.Name AS PositionName,
Employees.EmploymentDate,  Employees.Gender, Employees.Salary
FROM  Employees  
JOIN Positions ON Employees.PositionId = Positions.Id  
ORDER BY Employees.FullName  
END

EXEC GetEmployeeInfo

--2. �������� ��������� ���������� ���������� � ���� ����������� 
CREATE PROCEDURE GetClientInfo
AS
BEGIN
SELECT Id AS ClientId,FullName, Email, Phone,  Gender,Discount,IsSubcribe,DateSubcribe
FROM Clients
ORDER BY FullName;
END

EXEC GetClientInfo

--3. �������� ��������� ���������� ������ ���������� � �������� 
CREATE PROCEDURE GetSalesDetails
AS
BEGIN
SELECT Sales.Id AS SaleId,Sales.Quantity, Sales.[Date] AS SaleDate,Employees.FullName AS EmployeeFullName, Clients.FullName AS ClientFullName,
Storage.ProductId, Products.Name AS ProductName  
FROM Sales 
JOIN  Employees  ON Sales.EmployeeId = Employees.Id
JOIN  Clients    ON Sales.ClientId = Clients.Id
JOIN  Storage    ON Sales.StorageId = Storage.Id
JOIN  Products   ON Storage.ProductId = Products.Id  
ORDER BY Sales.[Date] DESC
END

EXEC GetSalesDetails

--4. �������� ��������� ���������� ������ ���������� � ���� �������� � ���������� ����.
--���� ������� ��������� � �������� ��������� 
CREATE PROCEDURE GetSalesDetailsByDate
(
   @SaleDate DATE
)
AS
BEGIN
SELECT Sales.Id AS SaleId, Sales.Quantity,  Sales.[Date] AS SaleDate, Employees.FullName AS EmployeeFullName, Clients.FullName AS ClientFullName,
Storage.ProductId, Products.Name AS ProductName  
FROM Sales 
JOIN  Employees ON Sales.EmployeeId = Employees.Id
JOIN  Clients   ON Sales.ClientId = Clients.Id
JOIN  Storage   ON Sales.StorageId = Storage.Id
JOIN  Products  ON Storage.ProductId = Products.Id  
WHERE Sales.[Date] = @SaleDate
ORDER BY Sales.[Date] DESC
END

EXEC GetSalesDetailsByDate '2021-05-19'


--5. �������� ��������� ���������� ������ ���������� � ���� �������� � ��������� ��������� ��������. 
--���� ������ � ����� �������� ��������� � �������� ��������� 
CREATE PROCEDURE GetSalesDetailsByDateRange
(
    @StartDate DATE,
    @EndDate DATE
)
AS
BEGIN
SELECT Sales.Id AS SaleId, Sales.Quantity,  Sales.[Date] AS SaleDate,Employees.FullName AS EmployeeFullName,Clients.FullName AS ClientFullName, Storage.ProductId,  Products.Name AS ProductName  
FROM Sales 
JOIN Employees ON Sales.EmployeeId = Employees.Id
JOIN Clients   ON Sales.ClientId = Clients.Id
JOIN Storage   ON Sales.StorageId = Storage.Id
JOIN Products  ON Storage.ProductId = Products.Id 
WHERE   Sales.[Date] >= @StartDate AND Sales.[Date] <= @EndDate
ORDER BY Sales.[Date] DESC;
END

EXEC GetSalesDetailsByDateRange '2021-05-19', '2023-11-15'

