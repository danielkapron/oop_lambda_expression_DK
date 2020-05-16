package controler;

import data.UserData;
import model.Role;
import model.User;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// Klasa kontrolera impelemntuje metody obsługujące
// żądania
public class UserControler {

    public void getAllUsers(){
//        for(User user : UserData.users){
//            System.out.println(user);
//        }

//        UserData.users.           //List<User>
//                stream().         // Stream<User>
//   forEach(user -> System.out.println(user)); // operacja kończąca

        UserData.users.forEach(System.out::println); // uproszczona
    }

    public Optional<User> getUserByEmail(String searchEmail){
        return UserData.users              //List<User>
                .stream()                   // Stream<User>
                .filter(user -> user.getEmail().equals(searchEmail)) // Stream<User>
                .findFirst();             // Optional<User>
    }

//
//    public String getUserByEmailWithValidation(String searchEmail){
//        Optional<User> userOpt = getUserByEmail(searchEmail);
//        if(userOpt.isPresent()){
//            return "Znaleziono użytkownika: " + userOpt.get().toString();
//        }
//        return "Nie znaleziono użytkownika o adresie: " + searchEmail;
//    }


    public String getUserByEmailWithValidation(String searchEmail){  //uproszczona wersja
      Optional<User> userOpt = getUserByEmail(searchEmail);
        return userOpt.map(user -> "Znaleziono użytkownika: " + user.toString()).orElseGet(() -> "Nie znaleziono użytkownika o adresie: " + searchEmail);
    }

    public List<User> getAllUsersWithStatus(boolean whatStatus) {
        return UserData.users.stream().filter(user -> user.isStatus() == whatStatus)
                .collect(Collectors.toList());
    }

    public void updateUserStatusById(int userId, boolean status){
        UserData.users
                .stream()
                .filter(user -> user.getUserId() == userId)
                .forEach(user -> user.setStatus(status));
    }

    public boolean updateUserRolerById(int userId, Role role){
        // sprawdzamy czy jest uzytkownik o danym id
     Optional<User> userOpt = UserData.users
                .stream()
                .filter(user -> user.getUserId() == userId)
                .findFirst();
        if(userOpt.isPresent()){
            // userOpt -> Optional<User>
            // stąd userOpt.get() - > do wyciągnięcia danych z optionala
            userOpt.get().setRole(role);
            return true;
        }
        return false;
    }

    public int countActiveUsers(){
        return (int) UserData.users.stream().filter(User::isStatus).count();
    }

    public int countAdmins(){
        return (int) UserData.users.stream().
                filter(user -> user.getRole() == Role.ROLE_ADMIN)
                .count();
    }

    public List<User> getAllUsersOrderByRegistrationDateDesc(){
        // Desc = descending, od największych do najmniejszych,
        // w tym wypadku od najmłodszych do najstarszych
        return UserData.users
                .stream()
                .sorted(Comparator.comparing(User::getRegistrationDate).reversed())
                .collect(Collectors.toList());
    }

    public List<User> getAllAdminsOrderByEmailAsc(){
        // Asc - ascending, czyli rosnąco
        return UserData.users
                .stream()
                .filter(user -> user.getRole() == Role.ROLE_ADMIN)
                .sorted(Comparator.comparing(User::getEmail))
                .collect(Collectors.toList());
    }

    public List<User> getFirst3UsersOrderByRegistrationDateAsc(){
        return UserData.users
                .stream()
                .sorted(Comparator.comparing(User::getRegistrationDate))
                .limit(3)
                .collect(Collectors.toList());
    }

    public void printAdmins() throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        System.out.println(UserData.users.stream()
                .filter(user -> user.getRole() == Role.ROLE_ADMIN)
                .map(user -> String.format("| %2d | %20s | %20s | %20s | %20s | %20s |", user.getUserId(), user.getName(), user.getLastName(), user.getEmail(),
                        md.digest(user.getPassword().getBytes(StandardCharsets.UTF_8)).toString().replace("[B@", ""), "Administrator"))
                .collect(Collectors.joining("\n")));
    }

}

