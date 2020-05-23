package lambda_basic;

import lambda_basic.UserControler;
import lambda_basic.model.Role;

import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        UserControler uc = new UserControler();
        uc.getAllUsers();
        System.out.println(uc.getUserByEmailWithValidation("dk@gmail.com"));
        System.out.println(uc.getUserByEmailWithValidation("xx@gmail.com"));

        uc.updateUserStatusById(1,false);
        uc.updateUserStatusById(2, false);
        System.out.println("Aktywni użytkownicy");
        uc.getAllUsersWithStatus(true).forEach(System.out::println);

        System.out.println();

        System.out.println(uc.updateUserRolerById(2, Role.ROLE_ADMIN));
        System.out.println(uc.updateUserRolerById(3, Role.ROLE_ADMIN));
        System.out.println(uc.updateUserRolerById(33, Role.ROLE_ADMIN));

        System.out.println();

        System.out.println("Liczba aktywnych: " + uc.countActiveUsers());
        System.out.println("Liczba administratorów: " + uc.countAdmins());

        System.out.println();

        uc.getAllUsersOrderByRegistrationDateDesc().forEach(System.out::println);

        System.out.println();

        uc.getAllAdminsOrderByEmailAsc().forEach(System.out::println);

        System.out.println();

        uc.getFirst3UsersOrderByRegistrationDateAsc().forEach(System.out::println);

        System.out.println();

        uc.printAdmins();

    }

}
