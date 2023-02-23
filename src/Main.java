import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        findMinMax(
                new ArrayList<Integer>() {{
                    add(1);
                    add(2);
                    add(3);
                    add(4);
                    add(5);
                    add(6);
                    add(7);
                }}.stream(),
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        if (o1.equals(o2)) return 0;
                        return o1 > o2 ? 1 : -1;
                    }
                },
                new BiConsumer<Integer, Integer>(){
                    @Override
                    public void accept(Integer integer, Integer integer2) {
                        System.out.println("min: " + integer);
                        System.out.println("max: " + integer2);
                    }
                }
        );
    }

    public static <T> void findMinMax(Stream<? extends T> stream,
                                      Comparator<? super T> order,
                                      BiConsumer<? super T, ? super T> minMaxConsumer) {
//        Напишите метод findMinMax, находящий в стриме минимальный
//        и максимальный элементы в соответствии порядком, заданным Comparator'ом.
//        Найденные минимальный и максимальный элементы передайте в minMaxConsumer следующим образом:
//        minMaxConsumer.accept(min, max);
//        Если стрим не содержит элементов, то вызовите
//        minMaxConsumer.accept(null, null);
        List<? extends T> list = stream.toList();
        minMaxConsumer.accept(
                list.stream().min(order).orElse(null),
                list.stream().max(order).orElse(null)
        );
    }

    public static long countOfEven(List<Integer> list) {
//        Реализуйте метод, который принимает на вход Список целых чисел
//        и определяет количество четных и выводит их в консоль.
//        Решать именно с применением Stream API
        return list.stream()
                .filter(i -> i % 2 == 0)
                .peek(System.out::println)
                .count();
    }
}