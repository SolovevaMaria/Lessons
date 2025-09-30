class PaymentSystemDemo {
    public static void main(String[] args) {
        interface PaymentSystem {
            void processPayment(double amount);
        }

        class RealPaymentSystem implements PaymentSystem {
            @Override
            public void processPayment(double amount) {
                System.out.println("Обработка платежа на сумму: " + amount + " рублей");
                System.out.println("Платёж успешно проведён");
            }
        }

        class PaymentProxy implements PaymentSystem {
            private RealPaymentSystem realSystem;

            @Override
            public void processPayment(double amount) {

                if (amount <= 0) {
                    System.out.println("Ошибка: сумма платежа должна быть положительной");
                    return;
                }

                System.out.println("Начинается обработка платежа...");

                if (realSystem == null) {
                    realSystem = new RealPaymentSystem();
                }

                realSystem.processPayment(amount);

                System.out.println("Платёж обработан успешно");
            }
        }

        System.out.println("Пример 1: корректный платёж");
        PaymentSystem payment = new PaymentProxy();
        payment.processPayment(1000);

        System.out.println("\nПример 2: некорректная сумма");
        payment.processPayment(-500);

        System.out.println("\nПример 3: повторный платёж");
        payment.processPayment(2000);
    }
}
