package lessons.patterns.strategy;

import java.util.*;

/*Поведенческий паттерн*/
public class Strategy {
    private Sortable sortable;

    public void setSortable(Sortable sortable) {
        this.sortable = sortable;
    }

    public void executeSort(List<Integer> list) {
        sortable.sort(list);
    }

    public static void main(String[] args) {

        Sortable right = new RightSorting();

        Sortable reverse = new ReverseSorting();

        Strategy strategy = new Strategy();

        List<Integer> integers = new LinkedList<>();

        integers.addAll(Arrays.asList(-1, 0, -2, 2, 5));

        strategy.setSortable(reverse);

        strategy.executeSort(integers);

        System.out.println(integers);
    }
}


interface Sortable {
    void sort(List<Integer> list);
}

class RightSorting implements Sortable {
    @Override
    public void sort(List<Integer> list) {
        Collections.sort(list);
    }
}

class ReverseSorting implements Sortable {
    @Override
    public void sort(List<Integer> list) {

        Comparator<Integer> comparator = Integer::compare;

        Collections.sort(list, comparator.reversed());
    }
}
