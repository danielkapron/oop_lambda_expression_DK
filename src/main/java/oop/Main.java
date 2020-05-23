package oop;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {


        Task task = new Task("Nauka programowania", LocalDate.now(), LocalDate.of(2020, 9,30));
        Task emptyTask = new Task();

        System.out.println(task.toString());
        System.out.println(emptyTask.toString());

    }

}
