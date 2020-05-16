package controler;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class SimpleOperations {

    private int[] numbers = {2,1,35,4,3,7,2,6,1,2,55,77,128,16,22};

    public int getMaxValue(){
        return Arrays.stream(numbers)
        .max().getAsInt();
    }

    public int getMinValue(){
        return Arrays.stream(numbers)
                .min().getAsInt();
    }

    public double getAvg(){
        return Arrays.stream(numbers)
                .average().getAsDouble();
    }

    //wypisz elementy tablicy większe od średniej

    public void getElementsGreaterThanAvg(){
        System.out.println("Elementy większe od średniej: " + Arrays.stream(numbers).
                filter(number -> number > getAvg())
                .sorted()
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(",")));
    }

    public void getElementsGreaterThanAvgDesc(){
        System.out.println("Elementy większe od średniej desc: " + Arrays.stream(numbers)
                .filter(number -> number > getAvg())
                .mapToObj(Integer::new)
                .sorted(Comparator.reverseOrder())
                .map(number -> number.toString())
                .collect(Collectors.joining(",")));
    }


    public static void main(String[] args) {

        SimpleOperations so = new SimpleOperations();
        System.out.println("MAX: " + so.getMaxValue());
        System.out.println("MIN: " + so.getMinValue());
        System.out.println("AVG: " + so.getAvg());
        so.getElementsGreaterThanAvg();
        so.getElementsGreaterThanAvgDesc();


    }

}
