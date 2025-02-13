package Demowebshop;

public class TestData {
    public static String email;
    public static String password = "Test@12345";

    // Генерация email, если он еще не задан
    public static String generateEmail() {
        if (email == null) {
            email = "user" + System.currentTimeMillis() + "@example.com";
        }
        return email;
    }
}
