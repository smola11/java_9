package com.maciej.factoryMethods.immutableCollections;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Sets {

    // Java 8
    public Set<Object> createImmutableEmptySetJava8() {
        return Collections.emptySet();
    }

    public Set<String> createImmutableSetJava8() {
        // It returns an unmodifiable view of the specified set
        Set<String> set = new HashSet<>();
        set.add("1");
        set.add("2");
        set.add("3");
        return Collections.unmodifiableSet(set);
    }


    // Java 9
    public Set<Object> createImmutableEmptySetJava9() {
        return Set.of();
    }

    public Set<String> createImmutableSetJava9() {
        // We can create set with 1 - 10 elements with this method
        return Set.of("1", "2", "3");
    }

    public Set<String> createImmutableSetVarArgsJava9() {
        // We can create set with arbitrary number of elements
        return Set.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12");
    }

    public Set<String> createImmutableSetVarArgsArrayJava9() {
        String[] strings = {"1", "2", "3"};
        return Set.of(strings);
    }

    public Set<String[]> createImmutableSetWithArrayInsideJava9() {
        String[] strings = {"1", "2", "3"};
        return Set.<String[]>of(strings);
    }
}
