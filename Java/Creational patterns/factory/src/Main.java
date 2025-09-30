public class Main {
     //Фабричный метод
    interface Transport {
        void deliver(String cargo);
    }

    static class Truck implements Transport {
        private String type;

        public Truck(String type) {
            this.type = type;
        }

        @Override
        public void deliver(String cargo) {
            System.out.println("Автомобиль " + type + " доставляет: " + cargo);
        }
    }

    static class Ship implements Transport {
        private String type;

        public Ship(String type) {
            this.type = type;
        }

        @Override
        public void deliver(String cargo) {
            System.out.println("Судно " + type + " доставляет: " + cargo);
        }
    }

    static abstract class Logistics {

        protected abstract Transport createTransport();

        public void performDelivery(String cargo) {
            Transport transport = createTransport();
            transport.deliver(cargo);
        }
    }

    static class RoadLogistics extends Logistics {
        @Override
        protected Transport createTransport() {
            return new Truck("грузовой");
        }
    }

    static class SeaLogistics extends Logistics {
        @Override
        protected Transport createTransport() {
            return new Ship("контейнеровоз");
        }
    }

    public static void main(String[] args) {

        Logistics road = new RoadLogistics();
        road.performDelivery("строительные материалы");

        Logistics sea = new SeaLogistics();
        sea.performDelivery("контейнеры");
    }
}
