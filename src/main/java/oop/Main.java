package oop;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {


        Task task = new Task("Nauka programowania", LocalDate.now(), LocalDate.of(2020, 9,30));
        Task emptyTask = new Task();

        System.out.println(task.toString());
        System.out.println(emptyTask.toString());

        SubTask subTask = new SubTask();
        subTask.setTaskName("Nauka o OOP w Javie");

        System.out.println(subTask.getTaskName());
        System.out.println(subTask);

        SubTask subTask1 = new SubTask(
          "Nauka MySQL",
                LocalDate.of(2020, 6, 6),
                LocalDate.of(2020, 8, 8),
                "Będę się uczył MySQL 2 godziny dziennie"
        );
        System.out.println(subTask1);

        subTask1.editSubTask("x","x");
        System.out.println(subTask1);

        subTask1.editSubTask(
                "Y",
                LocalDate.now(),
                LocalDate.now(),
                "Y"
        );
        System.out.println(subTask1);

        System.out.println(subTask1.taskDescription);

    }

}
