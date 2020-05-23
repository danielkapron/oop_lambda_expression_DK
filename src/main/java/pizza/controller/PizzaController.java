package pizza.controller;

// klasa kontrolera - obsługa żądań i implementacja logiki biznesowej

import pizza.Ingredient;
import pizza.Pizza;

import java.util.Arrays;
import java.util.Comparator;

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
                .limit(1L)                                                          // Limit 1 (long)
                .findFirst()                                                        // Optional <Pizza>
                .get();                                                             // Pizza
    }


    public Pizza findCheapestSpicy(){

        return null;
    }



    public static void main(String[] args) {

        PizzaController pc = new PizzaController();

        System.out.println("Najtańsza ostra pizza, to: " + pc.findCheapestSpicy());

        System.out.println(pc.getPizzaPrice(Pizza.MARGHERITA));

        System.out.println("Najtańsza pizza: " + pc.findCheapest());



    }





}
