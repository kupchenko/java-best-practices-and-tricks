package me.kupchenko.lambda.collections;

import me.kupchenko.model.QualityAnnotations.Good;
import me.kupchenko.model.QualityAnnotations.CabBeBetter;
import me.kupchenko.model.User;

import java.util.*;

//Multi MAP - simple map, where value is collection
public class EmulateMultimap {
    private final Map<String, Set<User>> usersByRoleName = new HashMap<>();

    @CabBeBetter("Code is not very readable, null check when retrieve set from map and " +
            "when trying to add item to set in map")
    class LegacyCreationOnFirstValueForTheKey {
        public void addUser(User user) {
            user.getRoles().forEach(r -> {
                Set<User> usersInRole = usersByRoleName.get(r.getName());
                if (usersInRole == null) {
                    usersInRole = new HashSet<>();
                    usersByRoleName.put(r.getName(), usersInRole);
                }
                usersInRole.add(user);
            });
        }

        public Set<User> getUsersInRole(String role) {
            Set<User> users = usersByRoleName.get(role);
            return users == null ? Collections.emptySet() : users;
        }
    }

    @Good("NULL check can be replaced with computeIfAbsent and to retrieve set getOrDefault")
    class ComputeEmptySetIfKeyIsAbsent {
        public void addUser(User user) {
            user.getRoles().forEach(r -> usersByRoleName
                    .computeIfAbsent(r.getName(), k -> new HashSet<>())
                    .add(user));
        }

        public Set<User> getUsersInRole(String role) {
            return usersByRoleName.getOrDefault(role, Collections.emptySet());
        }
    }
}
