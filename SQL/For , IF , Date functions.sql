--Пользователь вводит целое положительное число. Необходимо с помощью SQL-сценария построить таблицу умножения для этого числа от 1 до 10.
--Результатом должна быть таблица из 10 строк, где каждая строка содержит выражение вида:
--N × i = R,
--где
--N — введённое пользователем число,
--i — множитель от 1 до 10,
--R — результат умножения.

DECLARE @one INT = 2;
DECLARE @two INT = 1;
DECLARE @result INT = @one*@two;
DECLARE @results TABLE (one INT,two INT, result INT)

WHILE @two<=10
BEGIN
INSERT INTO @results VALUES  (@one, @two, @result)
SET @two = @two+1;
SET @result= @one*@two
PRINT (@result)
END 

SELECT * FROM @results

--Пользователь вводит число N. 
--Для каждого числа от 1 до N указать, 
--является ли оно чётным или нечётным.
DECLARE @number INT = 1;
DECLARE @N INT = 10;
DECLARE @type VARCHAR(10);
DECLARE @results TABLE (number INT,type VARCHAR(10))

WHILE @number <= @N 
BEGIN

IF 
@number%2 = 0 
SET @type = 'Even';

ELSE 
SET @type = 'Odd';
INSERT INTO @results VALUES ( @number,  @type) 
   SET @number = @number + 1;
END 

SELECT * FROM @results

--Таблица факториалов от 1 до N
--Условие: Пользователь вводит число N. 
--Построить таблицу, где для каждого числа от 1 до N указано его факториальное значение (1 × 2 × ... × N).
DECLARE @number INT = 1;
DECLARE @N INT = 10;
DECLARE @type VARCHAR(10);
DECLARE @factorial BIGINT;
DECLARE @results TABLE (
        number INT,factorial BIGINT
)

WHILE @number <= @N 
BEGIN
 SET @factorial = 1;  
   DECLARE @i INT = 1; 

    WHILE @i <= @number
   BEGIN
        SET @factorial = @factorial * @i;
        SET @i = @i + 1;
    END;

    INSERT INTO @results (number, factorial)
    VALUES (@number, @factorial);

    SET @number = @number + 1;
END

SELECT *
FROM @results;

--Определение  чисел от N до N
--Условие:Пользователь вводит число N. 
--Для каждого числа от N до N указать, является ли оно чётным или нечётным, 
--положительным или отрицательным , 
--кратная ли 5ти или нет
 -- Объявление переменной для хранения введенного пользователем числа N

DECLARE @N INT = -15;
DECLARE @number INT = @N;

DECLARE @results TABLE (
    number INT,
    even_odd VARCHAR(10),  
    sign VARCHAR(10),       
    multiple_5 VARCHAR(10)  
)

WHILE @number = @N
BEGIN
    DECLARE @even_odd VARCHAR(10);
    IF @number % 2 = 0
        SET @even_odd = 'Even';
    ELSE
        SET @even_odd = 'Odd';

    DECLARE @sign VARCHAR(10);
    IF @number > 0
        SET @sign = 'Positive';
    ELSE IF @number < 0
        SET @sign = 'Negative';
    ELSE
        SET @sign = 'Zero';

    DECLARE @multiple_5 VARCHAR(10);
    IF @number % 5 = 0
        SET @multiple_5 = 'Yes';
    ELSE
        SET @multiple_5 = 'No';
    INSERT INTO @results (number, even_odd, sign, multiple_5)
    VALUES (@number, @even_odd, @sign, @multiple_5);
    BREAK;
END;
SELECT *
FROM @results;
 




