package assignment_06$03;

public class ValidLogin {
    public static void main(String[] args) {
        String username = "user";
        String password = "1234";
        
        if (username.equals("admin") || password.equals("1234")) {
            System.out.println("Login Successful");
        } else {
            System.out.println("Login Failed");
        }
    }
}