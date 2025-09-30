import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private Connection connection;

    public Database(Connection connection) {
        this.connection = connection;
    }

    // 1. Insert с параметрами
    public void insertStudent(int id, String firstname, String lastname, int age) throws SQLException {
        String query = "INSERT INTO Students (id, firstname, lastname, age) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.setString(2, firstname);
            ps.setString(3, lastname);
            ps.setInt(4, age);
            ps.executeUpdate();
        }
    }

    // 2. Delete по условию
    public void deleteOldBooks() throws SQLException {
        String query = "DELETE FROM Books WHERE year < 2000";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.executeUpdate();
        }
    }

    // 3. Update имени
    public void updateCityName(String oldName, String newName) throws SQLException {
        String query = "UPDATE Cities SET name = ? WHERE name = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, newName);
            ps.setString(2, oldName);
            ps.executeUpdate();
        }
    }

    // 4. Select с фильтром
    public List<Product> getCheapProducts() throws SQLException {
        String query = "SELECT * FROM Products WHERE price < 100";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<Product> products = new ArrayList<>();
            while (rs.next()) {
                products.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price")));
            }
            return products;
        }
    }

    // 5. Подсчёт строк
    public int countEmployees() throws SQLException {
        String query = "SELECT COUNT(*) FROM Employees";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        }
    }

    // 6. Insert без ID
    public void addCategory(String name, String description) throws SQLException {
        String query = "INSERT INTO Categories (name, description) VALUES (?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setString(2, description);
            ps.executeUpdate();
        }
    }

    // 7. Update зарплаты
    public void increaseSalary() throws SQLException {
        String query = "UPDATE Employees SET salary = salary * 1.1";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.executeUpdate();
        }
    }

    // 8. Delete по ID
    public void deleteOrder(int orderId) throws SQLException {
        String query = "DELETE FROM Orders WHERE order_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, orderId);
            ps.executeUpdate();
        }
    }

    // 9. Select сортировка
    public List<Customer> getAllCustomersSorted() throws SQLException {
        String query = "SELECT * FROM Customers ORDER BY lastname";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<Customer> customers = new ArrayList<>();
            while (rs.next()) {
                customers.add(new Customer(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname")));
            }
            return customers;
        }
    }

    // 10. Select с ограничением
    public List<Product> getTop5ExpensiveProducts() throws SQLException {
        String query = "SELECT * FROM Products ORDER BY price DESC LIMIT 5";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<Product> products = new ArrayList<>();

            while (rs.next()) {
                products.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("description")
                ));
            }
            return products;
        }
    }
