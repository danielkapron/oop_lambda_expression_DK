import controler.UserControler;
import model.Role;
import model.User;

public class Main {

    public static void main(String[] args) {

        UserControler uc = new UserControler();
        uc.getAllUsers();
        System.out.println(uc.getUserByEmailWithValidation("dk@gmail.com"));
        System.out.println(uc.getUserByEmailWithValidation("xx@gmail.com"));

    }

}
