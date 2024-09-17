package com.top.sampleRest;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class RestApiController {
    private List<Coffee> coffeeList = new ArrayList<>();

    public RestApiController() {
        coffeeList.addAll(List.of(
                new Coffee("Колумбийский"),
                new Coffee("Арабский"),
                new Coffee("Цейлонский"),
                new Coffee("Индийский")
        ));
    }

    @RequestMapping(value="/coffeeList", method = RequestMethod.GET)
    Iterable<Coffee> getCoffee() {
        return coffeeList;
    }

    @PostMapping(value="/postCoffee")
    String postCoffee(@RequestBody Coffee coffee) {
        coffeeList.add(coffee);
        return "Success";
    }

    @PutMapping("/coffeeList/{id}")
    String putCoffee(@PathVariable String id, @RequestBody Coffee coffee) {
        int coffeeIndex = -1;

        for (Coffee c : coffeeList) {
            if (c.getId().equals(id)) {
                coffeeIndex = coffeeList.indexOf(c);
                coffeeList.set(coffeeIndex, coffee);
            }
        }

        return "Success";
    }

    @DeleteMapping("/coffeeList/{id}")
    void deleteCoffee(@PathVariable int id) {
        System.out.println(coffeeList.size());
        coffeeList.remove(id);
        System.out.println(coffeeList.size());
    }
}