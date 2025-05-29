--Задание 1: Архивирование удалённых товаров
--Таблицы: Products, ArchiveProducts
--Условие:
--При удалении товара из таблицы Products, информация о нём должна переноситься в ArchiveProducts.
CREATE TRIGGER Archive
ON Products
AFTER DELETE
AS
BEGIN
    INSERT INTO ArchiveProducts ([Name], PrimeCost, [Type], Fabricator, [Cost])
    SELECT deleted.[Name], deleted.PrimeCost, t.[Name], Fabricator.[Name], deleted.[Cost]
    FROM deleted  
    JOIN [Type] AS t ON deleted.TypeId = t.Id  
    JOIN Fabricator  ON deleted.FabricatorId = Fabricator.Id; 

END

--Задание 2: Запрет скидки больше 30%
--Таблица: Clients
--Условие:
--Создай триггер, который не позволяет вставлять нового клиента, если значение Discount больше 30.
CREATE TRIGGER NotSale
ON Clients
INSTEAD OF INSERT
AS
BEGIN
 IF EXISTS (SELECT 1 FROM inserted WHERE Discount > 30)
    BEGIN
        PRINT('Нельзя вставлять клиента со скидкой больше 30%.')
    END
ELSE
    BEGIN
        INSERT INTO Clients (FullName, Email, Phone, Gender, Discount, IsSubcribe, DateSubcribe)
        SELECT FullName, Email, Phone, Gender, Discount, IsSubcribe, DateSubcribe
        FROM inserted
    END
END

--Задание 3: Логирование обновления зарплаты
--Таблицы: Employees, EmployeeLog
--Условие:
--При обновлении записи в таблице Employees, если изменяется поле Salary, записывать:
--старую зарплату,
--новую зарплату,
--имя сотрудника,
--дату изменения
--в таблицу EmployeeLog.

CREATE TABLE EmployeeLog (
    Id INT PRIMARY KEY IDENTITY,
    EmployeeFullName NVARCHAR(50) NOT NULL,
    OldSalary MONEY NOT NULL,
    NewSalary MONEY NOT NULL,
    ChangeDate DATETIME NOT NULL DEFAULT GETDATE()
)

CREATE TRIGGER LogirovanieSalary
ON Employees
AFTER UPDATE
AS
BEGIN
 IF UPDATE(Salary)
    BEGIN
        INSERT INTO EmployeeLog (EmployeeFullName, OldSalary, NewSalary, ChangeDate)
        SELECT deleted.FullName, deleted.Salary, inserted.Salary, GETDATE()
        FROM deleted  
        JOIN inserted  ON deleted.Id = inserted.Id
    END
END