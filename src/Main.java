import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

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

        minMaxConsumer.accept(
                stream.min(order).orElse(null),
                stream.max(order).orElse(null)
        );
    }

    public static long countOfEven(List<Integer> list) {
//        Реализуйте метод, который принимает на вход Список целых чисел
//        и определяет количество четных и выводит их в консоль.
//        Решать именно с применением Stream API
        return list.stream()
                .filter(i -> i % 2 == 0)
                .count();
    }
}