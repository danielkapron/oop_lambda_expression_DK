package lambda_basic;

import lambda_basic.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface UserData {

    // publicznie statyczne finalne
    List<User> users = new ArrayList<>(Arrays.asList(
            new User("Daniel",
                    "K",
                    "dk@gmail.com",
                    "dk"),
            new User("Tomasz",
                    "S",
                    "ts@gmail.com",
                    "ts"),
            new User("Jan",
                    "R",
                    "jr.com",
                    "jr"),
            new User("Robert",
                    "S",
                    "rs@gmail.com",
                    "rs"),
            new User("Zbyszek",
                    "W",
                    "zw@gmail.com",
                    "zw"),
            new User("Janusz",
                    "G",
                    "jg@gmail.com",
                    "jg")
    )
    );


}
