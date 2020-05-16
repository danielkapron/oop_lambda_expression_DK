package model;

// Klasa modelu - determinuje strukturę danych w przepłwie informacji
// w projekcie

import java.time.LocalDateTime;

public class User {

    // prywatne pola klasowe

    private String name;
    private String lastName;
    private String email;
    private String password;
    private LocalDateTime registrationDate = LocalDateTime.now();
    private boolean status = true;

    // przypisanie uprawnień

    private Role role = new Role.ROLE_USER();



}
