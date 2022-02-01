// AUTHOR: CSR丶SUSE
// TIME : 2022-02-01  10:59
// FILENAME: BookStore.java
// TOOLS : INTELLIJ IDEA
// STATEMENT: 


package com.evan.beans;

import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.Set;

@ToString
public class BookStore {
    @Setter
    private String[] names;
    @Setter
    private List<String> authors;
    @Setter
    private Map<String, String> categories;
    @Setter
    private Set<String> set;
}
