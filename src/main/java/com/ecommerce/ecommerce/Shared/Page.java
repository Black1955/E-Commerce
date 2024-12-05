package com.ecommerce.ecommerce.Catalog.core.domain.category;

import java.util.List;
import java.util.ArrayList;

public class Page<T> {
    private int page;
    private int size;
    private List<T> elements = new ArrayList<>();

    public Page(int page, int size, List<T> elements) {
        this.page = page;
        this.elements = elements;
        this.size = size;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public List<T> getElements() {
        return elements;
    }
}
