package com.codingever.algorithms.mergeSort;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by andrii on 06.09.16.
 */
public class MergeSort02 {
    public static List<Integer> sort(List<Integer> xs) {
        if (xs == null || xs.isEmpty() || xs.size() == 1) {
            return xs;
        }
        int size = xs.size();
        return Stream.<List<Integer>>of(sort(xs.subList(0, size / 2)), sort(xs.subList(size / 2, size)))
                .reduce((x, s) -> merge(x, s, new ArrayList<>(x.size() + s.size()))).get();
    }

    private static List<Integer> merge(List<Integer> x, List<Integer> s, List<Integer> merged) {
        if (x.isEmpty()) {
            merged.addAll(s);
        } else if (s.isEmpty()) {
            merged.addAll(x);
        } else if (x.get(0) > s.get(0)) {
            merged.add(s.get(0));
            merge(x, s.subList(1, s.size()), merged);
        } else {
            merged.add(x.get(0));
            merge(x.subList(1, x.size()), s, merged);
        }
        return merged;
    }

    public static void main(String[] args) {
        List<Integer> xs = Stream.of(7, 1, 2, 5, -100, 6, 2, -99, -101).collect(Collectors.toList());
        List<Integer> sorted = sort(xs);
        System.out.println(sorted);
    }
}
