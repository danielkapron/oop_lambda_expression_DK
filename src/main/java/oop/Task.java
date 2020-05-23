package oop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

// LOMBOK! - dodany przez Maven

@NoArgsConstructor   // Implementuje konstruktur domyślny, bez argumentów
@AllArgsConstructor // Implementuje konstruktur ze wszystkimi argumentami
@Data               // Implementuje gettery, settery i toString, można zrobić osobno przez @Getter, @Setter, @ToString

public class Task {

    private String taskName;
    private LocalDate startDate;
    private LocalDate stopDate;




}
