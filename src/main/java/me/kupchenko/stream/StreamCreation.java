package me.kupchenko.stream;

import me.kupchenko.model.QualityAnnotations.Good;
import me.kupchenko.model.QualityAnnotations.Ugly;
import me.kupchenko.model.Permission;
import me.kupchenko.model.Role;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCreation {
    @Ugly
    public Stream<Permission> getStreamFromList() {
        return Arrays.asList(Permission.ADD, Permission.DELETE).stream();
    }

    @Good
    public Stream<Permission> getStreamFromElements() {
        return Stream.of(Permission.ADD, Permission.DELETE);
    }

    @Ugly
    public Stream<Role> generateStreamByMappingCopies(int n) {
        return Collections.nCopies(n, "ignored").stream()
                .map(s -> new Role());
    }

    @Ugly
    public Stream<Role> generateStreamFromRange(int n) {
        return IntStream.range(0, n).mapToObj(i -> new Role());
    }

    @Good
    public Stream<Role> generateStreamFromSupplierWithLimit(int n) {
        return Stream.generate(Role::new).limit(n);
    }

    @Ugly
    public Stream<Role> generateStreamFromArrayWithRange(Role[] roles, int max) {
        int to = Integer.min(roles.length, max);
        return IntStream.range(0, to).mapToObj(i -> roles[i]);
    }

    @Good
    public Stream<Role> generateStreamFromArrayWithLimit(Role[] roles, int max) {
        return Stream.of(roles).limit(max);
    }
}
