package com.maciej.factoryMethods.immutableCollections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;

public class Maps {

    // Java 8
    public Map createImmutableEmptyMapJava8() {
        return Collections.emptyMap();
    }

    public Map<Integer, String> createImmutableMapJava8() {
        // It returns an unmodifiable view of the specified map
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");
        return Collections.unmodifiableMap(map);
    }


    // Java 9
    public Map createImmutableEmptyMapJava9() {
        return Map.of();
    }

    public Map createImmutableMapJava9() {
        // We can create map with 1 - 10 entries with this method
        return Map.of(1, "1", 2, "2", 3, "3");
    }

    public Map createImmutableMapOfEntriesEmptyJava9() {
        return Map.ofEntries();
    }

    public Map createImmutableMapOfEntriesJava9() {
        // This var-args method is useful to create an Immutable Map with zero or one or more elements using Entries
        return Map.ofEntries(entry(1, "one"), entry(2, "two"), entry(3, "three"));
    }

    public Map createImmutableMapUsingMapEntryJava9() {
        // It is used as part of Map.ofEntries() method to create an Immutable Map
        Map.Entry<Integer, String> immutableMapEntry1 = Map.entry(1, "1");
        Map.Entry<Integer, String> immutableMapEntry2 = Map.entry(2, "2");
        Map.Entry<Integer, String> immutableMapEntry3 = Map.entry(3, "3");
        return Map.ofEntries(immutableMapEntry1, immutableMapEntry2, immutableMapEntry3);
    }
}
