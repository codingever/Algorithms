package com.codingever.algorithms.mergeSort;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by andrii on 06.09.16.
 */
public class MergeSort01 {
    public static List<Integer> sort(List<Integer> xs) {
        if (xs == null || xs.isEmpty() || xs.size() == 1) {
            return xs;
        }
        int size = xs.size();
        return Stream.<List<Integer>>of(sort(xs.subList(0, size/2)), sort(xs.subList(size/2, size)))
                .reduce(MergeSort01::merge).get();
    }

    private static List<Integer> merge(List<Integer> x, List<Integer> s) {
        if (x.isEmpty()) {
            return s;
        } else if (s.isEmpty()) {
            return x;
        }
        List<Integer> merged = new ArrayList<>(x.size() + s.size());
        if (x.get(0) > s.get(0)) {
            merged.add(s.get(0));
            merged.addAll(merge(x, s.subList(1, s.size())));
        } else {
            merged.add(x.get(0));
            merged.addAll(merge(x.subList(1, x.size()), s));
        }
        return merged;
    }

    public static void main(String[] args) {
        List<Integer> xs = Stream.of(7, 1, 2, 5, -100, 6, 2, -99, -101).collect(Collectors.toList());
        List<Integer> sorted = sort(xs);
        System.out.println(sorted);
    }
}
