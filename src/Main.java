import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UserNotFoundException, AccessDeniedException {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Введите логин");
        String login = scanner.nextLine();
        System.out.println("Введите пароль");
        String password = scanner.nextLine();

        getUserByLoginAndPassword(login,password);
        validateUser(getUserByLoginAndPassword(login,password));

        System.out.println("Доступ предоставлен");
    }
    public static User[] getUsers() {
        User user1 = new User("drsh", "1234", 20, "ddrraa@gmail.com");
        User user2 = new User("abc", "abc", 16, "abc@mail.ru");
        User user3 = new User("vvv", "vvv", 25, "vvv@icloud.com");

        return new User[]{user1, user2, user3};
    }

    public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
        User[] users = getUsers();
        for (User user : users) {
        if ( login.equals(user.login) && password.equals(user.password)){
            return user;
            }
        }
        throw new UserNotFoundException("User not found");
    }
    public static void validateUser(User user) throws AccessDeniedException {
        User[] users = getUsers();
        for (User u : users){
            if ( user.age < 18){
                throw new AccessDeniedException("Error, age < 18");}
        }
    }
}