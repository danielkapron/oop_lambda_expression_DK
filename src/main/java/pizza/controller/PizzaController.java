package pizza.controller;

// klasa kontrolera - obsługa żądań i implementacja logiki biznesowej

import com.sun.source.tree.Tree;
import pizza.Ingredient;
import pizza.Pizza;

import java.util.*;
import java.util.stream.Collectors;

public class PizzaController {

    //Zaimplementować klasę z następującymi metodami:
    //o Pizza findCheapestSpicy() - metoda zwracająca najtańszą ostrą pizzę.
    //o Pizza findMostExpensiveVegetarian() - metoda zwracająca najdroższą pizzę wegetariańską.
    //o List iLikeMeat() - metoda zwracająca same pizzę mięsne, posortowane malejąco po liczbie składników mięsnych.
    //o Map groupByPrice() - metoda grupujące pizzę po cenie.
    //o String formatedMenu() - metoda zwracająca string w postaci nazwa_pizzy: składnik1, składnik2, składnik3 - cena, kolejne pizzę oddzielone znakiem nowej linii.
    //• Wszystkie metody zaimplementować z wykorzystaniem Stream API, najlepiej w postaci pojedynczego wyrażenia. Wewnątrz metod nie mogą się zanajdować instrukcje sterujące (warunki, pętle).


    // metoda zwracajaca cene pizzy podanej w argumencie metody

    public double getPizzaPrice(Pizza pizza){

        return pizza.getIngredients()               // List <Ingredient>
                .stream()                           // Stream <Ingredient>
                .mapToDouble(Ingredient::getPrice)  // Double
                .sum();                             // Double (suma)
    }

    // Wyszukaj najtańszą pizze

    public Pizza findCheapest(){
        return Arrays.stream(Pizza.values())                                        // Stream <Pizza>
                .sorted((Comparator.comparing(pizza -> getPizzaPrice(pizza))))      // Stream <Pizza>
                .findFirst()                                                        // Optional <Pizza>
                .get();                                                             // Pizza
    }

    //o Pizza findCheapestSpicy() - metoda zwracająca najtańszą ostrą pizzę.

    public Pizza findCheapestSpicy(){

        return Arrays.stream(Pizza.values())                                                          // Stream <Pizza>
                .filter(pizza -> pizza.getIngredients().
                        stream()
                       .anyMatch(ingredient -> ingredient.isSpicy()))
                        .min(Comparator.comparing(pizza -> getPizzaPrice(pizza)))
                        .get();

    }

    //o Pizza findMostExpensiveVegetarian() - metoda zwracająca najdroższą pizzę wegetariańską

    public Pizza findMostExpensiveVegetarian(){

        return Arrays.stream(Pizza.values())
                .filter(pizza -> pizza.getIngredients()
                        .stream()
                .allMatch(ingredient -> ingredient.isMeat() == false))
                    //    .noneMatch(Ingredient::isMeat))                       // Dwa sposoby
                .max(Comparator.comparing(pizza -> getPizzaPrice(pizza)))      // Stream <Pizza>
                .get();
    }

    //o List iLikeMeat() - metoda zwracająca same pizzę mięsne, posortowane malejąco po liczbie składników mięsnych.

    public List <Pizza> iLikeMeat(){
        return Arrays.stream(Pizza.values())
                .filter(pizza -> pizza.getIngredients()
                .stream()
                .anyMatch(Ingredient::isMeat))
                .sorted(Comparator.comparing(pizza -> pizza.getIngredients()
                        .stream()
                        .filter(Ingredient::isMeat)
                        .count()
                        , Comparator.reverseOrder()))
                .collect(Collectors.toList());
    }

    //o Map groupByPrice() - metoda grupujące pizzę po cenie

    public Map groupByPrice(){
        return Arrays.stream(Pizza.values())
                .collect(Collectors.groupingBy(pizza -> getPizzaPrice(pizza)));
    }

        // metoda grupująca pizze po liczbie składników ostrych



    public static void main(String[] args) {

        PizzaController pc = new PizzaController();

        System.out.println("Najtańsza ostra pizza, to: " + pc.findCheapestSpicy());

        System.out.println(pc.getPizzaPrice(Pizza.MARGHERITA));

        System.out.println("Najtańsza pizza: " + pc.findCheapest());

        System.out.println("Najdroższa pizza wege: " + pc.findMostExpensiveVegetarian());

        pc.iLikeMeat().forEach(pizza -> System.out.println(
                pizza + " " +
                pizza.getIngredients().size() + " " +
                pizza.getIngredients().stream().filter(Ingredient::isMeat).count()
        ));

        System.out.println("Pizze grupowane po cenie");
    //    System.out.println(pc.groupByPrice());
        pc.groupByPrice()
                .forEach((key, value) -> System.out.printf("%5.1f | %s \n", key, value));
        System.out.println("Posortowana lista pizz");
        new TreeMap<>(pc.groupByPrice())
                .forEach((key, value) -> System.out.printf("%5.1f | %s \n", key, value));




    }





}
