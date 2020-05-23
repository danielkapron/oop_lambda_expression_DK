package oop;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
public class SubTask extends Task {

    protected String taskDescription;

    public SubTask(String taskName, LocalDate startDate, LocalDate stopDate, String taskDescription) {
        super(taskName, startDate, stopDate);
        this.taskDescription = taskDescription;
        System.out.println("Jestem w subtask");
    }

    //------------Przeciążanie-------------------------

    public void editSubTask(String taskName, LocalDate startDate, LocalDate stopDate, String taskDescription){
        setTaskName(taskName);
        setStartDate(startDate);
        setStopDate(stopDate);
        this.taskDescription = taskDescription;
    }

    public void editSubTask(String taskName, String taskDescription){
        setTaskName(taskName);
        this.taskDescription = taskDescription;
    }

    //-----------------------------------------------


    @Override
    public String toString() {
        return "SubTask{" +
                "taskDescription='" + taskDescription + '\'' +
                "} " + super.toString();
    }

}
