package controler;

import data.UserData;
import model.User;

import java.util.Optional;

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

    public String getUserByEmailWithValidation(String searchEmail){
      Optional<User> userOpt = getUserByEmail(searchEmail);
        if(userOpt.isPresent()){
            return "Znaleziono użytkownika: " + userOpt.get().toString();
        }
        return "Nie znaleziono użytkownika o adresie: " + searchEmail;
    }


}

