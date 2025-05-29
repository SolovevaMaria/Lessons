--1. Перевод денег между двумя пользователями (с проверкой достаточности средств)
CREATE PROC MoneyTransfer
					@cardNumberSender NVARCHAR(19),
					@cardNumberReciver NVARCHAR(19),
					@quantity INT
AS
BEGIN
       IF @quantity > 0
	   BEGIN
	      BEGIN TRANSACTION
		  BEGIN TRY
		    UPDATE CreditCard
			SET Money = Money - @quantity
			WHERE CardNumber LIKE @cardNumberSender


	        UPDATE CreditCard
			SET Money = Money + @quantity
			WHERE CardNumber LIKE @cardNumberReciver

			COMMIT
		  END TRY
		  BEGIN CATCH
		            PRINT('Error transfer')
					ROLLBACK
		  END CATCH
	   END
	   ELSE
	   BEGIN
	       PRINT('Invalid quantity')
	   END
END


EXEC MoneyTransfer  '1234-1234-1234-1234' , '4321-4321-4321-4321' ,7000
EXEC MoneyTransfer  '4341-4324-4323-4324' , '4321-4321-4321-4321' ,2000

SELECT * FROM CreditCard


 --2. Пополнение карты через процедуру с транзакцией
 CREATE PROC CardDeposit
    @cardNumber NVARCHAR(19),
    @quantity INT
AS
BEGIN
    SET NOCOUNT ON

    IF @quantity <= 0
    BEGIN
        PRINT('Invalid quantity.  Deposit amount must be greater than zero.')
        RETURN
    END

    IF NOT EXISTS (SELECT 1 FROM CreditCard WHERE CardNumber = @cardNumber)
    BEGIN
        PRINT('Card not found.')
        RETURN
    END

    BEGIN TRANSACTION

    BEGIN TRY
        UPDATE CreditCard
        SET Money = Money + @quantity
        WHERE CardNumber = @cardNumber

        
        IF @@ROWCOUNT = 0
        BEGIN
            PRINT('Failed to update card. Transaction rolled back.')
            ROLLBACK TRANSACTION
            RETURN
        END

      
        COMMIT TRANSACTION

       

    END TRY
    BEGIN CATCH
        
        IF @@TRANCOUNT > 0
            ROLLBACK TRANSACTION

        THROW
       

    END CATCH

END

EXEC CardDeposit @cardNumber = '1234-1234-1234-1234', @quantity = 100