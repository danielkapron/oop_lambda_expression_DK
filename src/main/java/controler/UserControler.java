package controler;

import data.UserData;
import model.User;

// Klasa kontrolera impelemntuje metody obsługujące
// żądania
public class UserControler {

    public void getAllUsers(){
//        for(User user : UserData.users){
//            System.out.println(user);
//        }
//        UserData.users.           //List<User>
//                stream().         // Stream<User>
//                forEach(user -> System.out.println(user));
        UserData.users.forEach(System.out::println); // uproszczona
    }

    public User getUserById(int userId){
        return 
    }


}

