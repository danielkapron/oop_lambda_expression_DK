import model.Role;
import model.User;

public class Main {

    public static void main(String[] args) {

        User u1 = new User();
        User u2 = new User("Daniel",
                "Kapron",
                "kapron.daniel@gmail.com",
                "dk");

        System.out.println(u2);

        // edycja roli użytkownika

        u2.setRole(Role.ROLE_ADMIN);
        System.out.println("Nowa rola: " + u2.getRole());
        System.out.println(u2);
        User u3 = new User("Daniel2",
                "Kapron2",
                "kapron.daniel2@gmail.com",
                "dk2");
        System.out.println(u3);

        

    }

}
