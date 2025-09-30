//приготовление разных видов кофе
class TemplateMethodExample {
    public static void main(String[] args) {

        Coffee espresso = new Espresso();
        Coffee cappuccino = new Cappuccino();
        Coffee americano = new Americano();

        System.out.println("Готовим эспрессо:");
        espresso.prepareCoffee();
        System.out.println("\nГотовим капучино:");
        cappuccino.prepareCoffee();
        System.out.println("\nГотовим американо:");
        americano.prepareCoffee();
    }

    abstract static class Coffee {

        final void prepareCoffee() {
            boilWater();
            brewCoffeeGrinds();
            pourInCup();
            addExtras();
        }

        private void boilWater() {
            System.out.println("Кипятим воду");
        }

        private void pourInCup() {
            System.out.println("Наливаем в чашку");
        }

        abstract void brewCoffeeGrinds();
        abstract void addExtras();
    }

    static class Espresso extends Coffee {
        @Override
        void brewCoffeeGrinds() {
            System.out.println("Варим крепкий эспрессо");
        }

        @Override
        void addExtras() {
            System.out.println("Добавляем щепотку соли (по желанию)");
        }
    }

    static class Cappuccino extends Coffee {
        @Override
        void brewCoffeeGrinds() {
            System.out.println("Варим эспрессо для капучино");
        }

        @Override
        void addExtras() {
            System.out.println("Добавляем взбитое молоко");
            System.out.println("Украшаем молочной пеной");
        }
    }

    static class Americano extends Coffee {
        @Override
        void brewCoffeeGrinds() {
            System.out.println("Варим американо");
        }

        @Override
        void addExtras() {
            System.out.println("Добавляем горячую воду");
        }
    }
}
