package com.turtlemint.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {

    public static void main(String[] args) {

        List<Developer> team = new ArrayList<>();

        Developer one = new Developer("one");
        one.add("scala");
        one.add("clojure");
        one.add("go");
        one.add("groovy");

        Developer two = new Developer("two");
        two.add("java");
        two.add("javascript");

        team.add(one);  team.add(two);

        List<String> teamLanguages = team.stream()
                                            .map(d -> d.getLanguages()).flatMap(l -> l.stream())
                                            .collect(Collectors.toList());

    }


}
