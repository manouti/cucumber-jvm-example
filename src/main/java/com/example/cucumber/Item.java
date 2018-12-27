package com.example.cucumber;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@EqualsAndHashCode(of = "name")   // items are identified by name
@AllArgsConstructor
public class Item {

    @NonNull String name;
    @NonNull String category;

}
