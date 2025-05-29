--������� 1: ������������� �������� �������
--�������: Products, ArchiveProducts
--�������:
--��� �������� ������ �� ������� Products, ���������� � �� ������ ������������ � ArchiveProducts.
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

--������� 2: ������ ������ ������ 30%
--�������: Clients
--�������:
--������ �������, ������� �� ��������� ��������� ������ �������, ���� �������� Discount ������ 30.
CREATE TRIGGER NotSale
ON Clients
INSTEAD OF INSERT
AS
BEGIN
 IF EXISTS (SELECT 1 FROM inserted WHERE Discount > 30)
    BEGIN
        PRINT('������ ��������� ������� �� ������� ������ 30%.')
    END
ELSE
    BEGIN
        INSERT INTO Clients (FullName, Email, Phone, Gender, Discount, IsSubcribe, DateSubcribe)
        SELECT FullName, Email, Phone, Gender, Discount, IsSubcribe, DateSubcribe
        FROM inserted
    END
END

--������� 3: ����������� ���������� ��������
--�������: Employees, EmployeeLog
--�������:
--��� ���������� ������ � ������� Employees, ���� ���������� ���� Salary, ����������:
--������ ��������,
--����� ��������,
--��� ����������,
--���� ���������
--� ������� EmployeeLog.

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