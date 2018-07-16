package me.kupchenko.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.EnumSet;
import java.util.Set;

@Data
@EqualsAndHashCode
public class Role {
    private String name;
    private Set<Permission> permissions = EnumSet.noneOf(Permission.class);
}
