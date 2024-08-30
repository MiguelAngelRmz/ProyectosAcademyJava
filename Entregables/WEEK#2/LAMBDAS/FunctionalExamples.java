// Miguel Angel Ramirez Juarez
// Functional Interfaces Examples

import java.util.function.*;

public class FunctionalExamples {

    public static void main(String[] args) {
        // 4 examples of each of the functional interfaces
        
        // Supplier
        System.out.println("\n$$ Supplier<T>");
        Supplier<String> s1 = () -> "Hello, Java!";
        System.out.println("> () -> \"Hello, Java!\"");
        System.out.println(s1.get());

        Supplier<Double> s2 = Math::random;
        System.out.println("> Math::random;");
        System.out.println(s2.get());

        Supplier<int[]> s3 = () -> new int[]{1, 2, 3, 4, 5};
        System.out.println("> () -> new int[]{1, 2, 3, 4, 5};");
        System.out.println(java.util.Arrays.toString(s3.get()));

        Supplier<Rectangle> s4 = Rectangle::new;
        System.out.println("> Rectangle::new;");
        System.out.println(s4.get());

        // Consumer
        System.out.println("\n$$ Consumer<T>");
        Consumer<Double> c1 = d -> System.out.printf("%.2f%n", d);
        System.out.println("> d -> System.out.printf(\"%.2f%n\", d);");
        c1.accept(Math.PI);

        Rectangle r1 = new Rectangle(5, 10);
        Consumer<Rectangle> c2 = r -> System.out.println("Rectangle Area: " + (r.width * r.height));
        System.out.println("> r -> System.out.println(\"Rectangle Area: \" + (r.width * r.height));");
        c2.accept(r1);

        Consumer<String> c3 = System.out::println;
        System.out.println("> System.out::println;");
        c3.accept("Functional Interfaces!");

        Consumer<String> c4 = FunctionalExamples::printUpperCase;
        System.out.println("> FunctionalExamples::printUpperCase;");
        c4.accept("java programming");

        // BiConsumer<T, U>
        System.out.println("\n$$ BiConsumer<T, U>");
        BiConsumer<String, Integer> bc1 = (s, i) -> System.out.println(s + " has " + i + " characters.");
        System.out.println("> (s, i) -> System.out.println(s + \" has \" + i + \" characters.\");");
        bc1.accept("Hello", 5);

        BiConsumer<Rectangle, Integer> bc2 = (r, i) -> System.out.println("Rectangle with width " + r.width + " and height " + r.height + " with increment " + i);
        System.out.println("> (r, i) -> System.out.println(\"Rectangle with width \" + r.width + \" and height \" + r.height + \" with increment \" + i);");
        bc2.accept(r1, 3);

        BiConsumer<Double, String> bc3 = (d, s) -> System.out.println(s + " value is " + d);
        System.out.println("> (d, s) -> System.out.println(s + \" value is \" + d);");
        bc3.accept(Math.E, "Euler's constant");

        // Predicate<T>
        System.out.println("\n$$ Predicate<T>");
        Predicate<String> pre1 = s -> s.length() < 10;
        System.out.println("> s -> s.length() < 10;");
        System.out.println(pre1.test("short"));

        Predicate<Integer> pre2 = FunctionalExamples::isEven;
        System.out.println("> FunctionalExamples::isEven;");
        System.out.println(pre2.test(4));

        Predicate<Rectangle> pre3 = r -> r.width == r.height;
        System.out.println("> r -> r.width == r.height;");
        System.out.println(pre3.test(r1));

        Predicate<String> pre4 = FunctionalExamples::isNonEmpty;
        System.out.println("> FunctionalExamples::isNonEmpty;");
        System.out.println(pre4.test("Not empty"));

        // BiPredicate<T, U>
        System.out.println("\n$$ BiPredicate<T, U>");
        BiPredicate<Integer, Integer> bp1 = (a, b) -> a % b == 0;
        System.out.println("> (a, b) -> a % b == 0;");
        System.out.println(bp1.test(10, 2));

        BiPredicate<String, Integer> bp2 = (s, i) -> s.length() == i;
        System.out.println("> (s, i) -> s.length() == i;");
        System.out.println(bp2.test("Length", 6));

        BiPredicate<Rectangle, Integer> bp3 = (r, n) -> r.width > n && r.height > n;
        System.out.println("> (r, n) -> r.width > n && r.height > n;");
        System.out.println(bp3.test(r1, 4));

        BiPredicate<String, String> bp4 = String::equalsIgnoreCase;
        System.out.println("> String::equalsIgnoreCase;");
        System.out.println(bp4.test("Hello", "hello"));

        // Function<T, R>
        System.out.println("\n$$ Function<T, R>");
        Function<String, String> f1 = s -> s.toLowerCase();
        System.out.println("> s -> s.toLowerCase();");
        System.out.println(f1.apply("UPPERCASE"));

        Function<Integer, String> f2 = FunctionalExamples::intToBinary;
        System.out.println("> FunctionalExamples::intToBinary;");
        System.out.println(f2.apply(10));

        Function<Rectangle, Integer> f3 = r -> r.width * r.height;
        System.out.println("> r -> r.width * r.height;");
        System.out.println(f3.apply(r1));

        Function<String, Integer> f4 = String::length;
        System.out.println("> String::length;");
        System.out.println(f4.apply("Length"));

        // BiFunction<T, U, R>
        System.out.println("\n$$ BiFunction<T, U, R>");
        BiFunction<Integer, Integer, Integer> bf1 = (a, b) -> a * b;
        System.out.println("> (a, b) -> a * b;");
        System.out.println(bf1.apply(5, 4));

        BiFunction<String, String, String> bf2 = (s1, s2) -> s1 + " " + s2;
        System.out.println("> (s1, s2) -> s1 + \" \" + s2;");
        System.out.println(bf2.apply("Hello", "World"));

        BiFunction<Rectangle, Integer, Rectangle> bf3 = (r, n) -> new Rectangle(r.width + n, r.height + n);
        System.out.println("> (r, n) -> new Rectangle(r.width + n, r.height + n);");
        System.out.println(bf3.apply(r1, 2));

        BiFunction<Double, Double, Boolean> bf4 = (d1, d2) -> d1.equals(d2);
        System.out.println("> (d1, d2) -> d1.equals(d2);");
        System.out.println(bf4.apply(1.23, 1.23));

        // UnaryOperator<T>
        System.out.println("\n$$ UnaryOperator<T>");
        UnaryOperator<String> uo1 = s -> s.trim();
        System.out.println("> s -> s.trim();");
        System.out.println(uo1.apply("   trimmed   "));

        UnaryOperator<Integer> uo2 = i -> i + 100;
        System.out.println("> i -> i + 100;");
        System.out.println(uo2.apply(50));

        UnaryOperator<Rectangle> uo3 = r -> new Rectangle(r.width * 2, r.height * 2);
        System.out.println("> r -> new Rectangle(r.width * 2, r.height * 2);");
        System.out.println(uo3.apply(r1));

        UnaryOperator<String> uo4 = FunctionalExamples::reverseString;
        System.out.println("> FunctionalExamples::reverseString;");
        System.out.println(uo4.apply("reversed"));

        // BinaryOperator<T>
        System.out.println("\n$$ BinaryOperator<T>");
        BinaryOperator<Double> bo1 = (d1, d2) -> d1 - d2;
        System.out.println("> (d1, d2) -> d1 - d2;");
        System.out.println(bo1.apply(10.5, 4.2));

        BinaryOperator<Integer> bo2 = (i1, i2) -> i1 / i2;
        System.out.println("> (i1, i2) -> i1 / i2;");
        System.out.println(bo2.apply(20, 4));

        BinaryOperator<String> bo3 = String::toUpperCase;
        System.out.println("> String::toUpperCase;");
        System.out.println(bo3.apply("mixed case"));

        BinaryOperator<String> bo4 = String::concat;
        System.out.println("> String::concat;");
        System.out.println(bo4.apply("Hello ", "World"));

    }

    static boolean isEven(int i) {
        return i % 2 == 0;
    }

    static boolean isNonEmpty(String s) {
        return !s.isEmpty();
    }

    static String intToBinary(int i) {
        return Integer.toBinaryString(i);
    }

    static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    static class Rectangle {
        int width;
        int height;

        Rectangle() {
            this.width = 1;
            this.height = 1;
        }

        Rectangle(int width, int height) {
            this.width = width;
            this.height = height;
        }
    }

    static void printUpperCase(String s) {
        System.out.println(s.toUpperCase());
    }
}
