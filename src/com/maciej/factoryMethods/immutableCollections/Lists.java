package com.maciej.factoryMethods.immutableCollections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lists {

    // Characteristics of Immutable List:
    // - We cannot add, modify and delete their elements
    // - They don’t allow null elements
    // - They are serializable if all elements are serializable

    // Java 8
    public List createImmutableEmptyListJava8() {
        return Collections.emptyList();
    }

    public List<String> createImmutableListJava8() {
        // It returns an unmodifiable view of the specified list
        return Collections.unmodifiableList(Arrays.asList("X", "Y", "Z"));
    }


    // Java 9
    public List createImmutableEmptyListJava9() {
        return List.of();
    }

    public List<String> createImmutableListJava9() {
        // We can create list with 1 - 10 elements with this method
        return List.of("X", "Y", "Z");
    }
}
