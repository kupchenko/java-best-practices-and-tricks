package me.kupchenko.lambda.collections;

import me.kupchenko.model.QualityAnnotations.Good;
import me.kupchenko.model.QualityAnnotations.CabBeBetter;
import me.kupchenko.model.User;

import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class MapIterating {

    @CabBeBetter("Loop over entrySet requires .getKey() and .getValue()")
    class UsingOldGoodEntrySet {
        public Map<String, String> getUserNames(Map<String, User> users) {
            Map<String, String> userNames = new HashMap<>();
            users.entrySet().forEach(user ->
                    userNames.put(user.getKey(), user.getValue().getName()));
            return userNames;
        }
    }

    @Good("Replaced with loop over map (not entry set)")
    class UsingMapForEach {
        public Map<String, String> getUserNames(Map<String, User> users) {
            Map<String, String> userNames = new HashMap<>();
            users.forEach((key, value) -> userNames.put(key, value.getName()));
            return userNames;
        }
    }

    @Good("Using collectors with entrySet")
    class UsingMapTransform {
        public Map<String, String> getUserNames(Map<String, User> users) {
            return users.entrySet().stream()
                    .collect(toMap(Map.Entry::getKey,
                            entry -> entry.getValue().getName()));
        }
    }
}