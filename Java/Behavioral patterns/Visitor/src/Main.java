// расчёт стоимости элементов заказа
class VisitorPatternExample {
    public static void main(String[] args) {

        MenuItem burger = new Burger(150.00);
        MenuItem drink = new Drink(179.00);
        MenuItem dessert = new Dessert(190.00);

        PriceCalculator visitor = new PriceCalculator();

        System.out.println("Стоимость бургера: " + burger.accept(visitor)+" руб");
        System.out.println("Стоимость напитка: " + drink.accept(visitor)+" руб");
        System.out.println("Стоимость десерта: " + dessert.accept(visitor)+" руб");

        DiscountVisitor discountVisitor = new DiscountVisitor(0.1); // 10% скидка
        System.out.println("\nСтоимость бургера со скидкой: " + burger.accept(discountVisitor) +" руб");
    }

    interface MenuItem {
        double accept(Visitor visitor);
    }

    static class Burger implements MenuItem {
        private double price;

        public Burger(double price) {
            this.price = price;
        }

        @Override
        public double accept(Visitor visitor) {
            return visitor.visit(this);
        }
    }

    static class Drink implements MenuItem {
        private double price;

        public Drink(double price) {
            this.price = price;
        }

        @Override
        public double accept(Visitor visitor) {
            return visitor.visit(this);
        }
    }

    static class Dessert implements MenuItem {
        private double price;

        public Dessert(double price) {
            this.price = price;
        }

        @Override
        public double accept(Visitor visitor) {
            return visitor.visit(this);
        }
    }

    interface Visitor {
        double visit(Burger burger);
        double visit(Drink drink);
        double visit(Dessert dessert);
    }

    static class PriceCalculator implements Visitor {
        @Override
        public double visit(Burger burger) {
            return burger.price;
        }

        @Override
        public double visit(Drink drink) {
            return drink.price;
        }

        @Override
        public double visit(Dessert dessert) {
            return dessert.price;
        }
    }

    static class DiscountVisitor implements Visitor {
        private double discount;

        public DiscountVisitor(double discount) {
            this.discount = discount;
        }

        @Override
        public double visit(Burger burger) {
            return burger.price * (1 - discount);
        }

        @Override
        public double visit(Drink drink) {
            return drink.price * (1 - discount);
        }

        @Override
        public double visit(Dessert dessert) {
            return dessert.price * (1 - discount);
        }
    }
}
