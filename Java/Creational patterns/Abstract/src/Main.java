//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    // Абстрактная фабрика
    interface Transport {
        void deliver(String cargo);
    }

    interface DeliveryService {
        void processOrder(String orderId);
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

    static class RoadDeliveryService implements DeliveryService {
        @Override
        public void processOrder(String orderId) {
            System.out.println("Обработка заказа " + orderId + " службой дорожной доставки");
        }
    }

    static class SeaDeliveryService implements DeliveryService {
        @Override
        public void processOrder(String orderId) {
            System.out.println("Обработка заказа " + orderId + " службой морской доставки");
        }
    }

    interface LogisticsFactory {
        Transport createTransport();
        DeliveryService createDeliveryService();
    }

    static class RoadLogisticsFactory implements LogisticsFactory {
        @Override
        public Transport createTransport() {
            return new Truck("грузовой");
        }

        @Override
        public DeliveryService createDeliveryService() {
            return new RoadDeliveryService();
        }
    }

    static class SeaLogisticsFactory implements LogisticsFactory {
        @Override
        public Transport createTransport() {
            return new Ship("контейнеровоз");
        }

        @Override
        public DeliveryService createDeliveryService() {
            return new SeaDeliveryService();
        }
    }

    public static void main(String[] args) {

        LogisticsFactory roadFactory = new RoadLogisticsFactory();
        Transport roadTransport = roadFactory.createTransport();
        DeliveryService roadService = roadFactory.createDeliveryService();

        roadService.processOrder("№123");
        roadTransport.deliver("строительные материалы");


        LogisticsFactory seaFactory = new SeaLogisticsFactory();
        Transport seaTransport = seaFactory.createTransport();
        DeliveryService seaService = seaFactory.createDeliveryService();

        seaService.processOrder("№456");
        seaTransport.deliver("контейнеры");
    }
}
