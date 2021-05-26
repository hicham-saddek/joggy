import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParametrizedTests {

    @ParameterizedTest
    @ValueSource(ints = { 2, 4, 6 })
    void testEvenNumbers(int i){
        Assertions.assertEquals(0,i%2);
    }

    @ParameterizedTest
    @MethodSource("randomNumbers")
    void testEvenRandomNumbers(int i){
        Assertions.assertEquals(0,i%2, "odd number");
    }

    static IntStream randomNumbers(){

        return IntStream.of(((int)(Math.random()*1))*2, ((int)(Math.random()*10))*2, ((int)(Math.random()*100))*2);
    }

    // Methode à tester
    public ArrayList<Integer> sortAscending(ArrayList<Integer> ints) {

        for (int i = 0; i < ints.size(); i++) {
            int s = i;
            for (int j = i; j < ints.size(); j++) {
                s = ints.get(s) < ints.get(j) ? j : s;
            }
            if (s != i) Collections.swap(ints, i, s);
        }

        return ints;
    }

    @ParameterizedTest
    @CsvSource({"1, 2, 3", "3, 2, 1", "2, 1, 3", "3, 1, 2"})
    void testListIntValues(int i, int j, int k){
        ArrayList <Integer> ints = new ArrayList<>();
        ints.add(i);
        ints.add(j);
        ints.add(k);
        Collections.sort(ints);
        Assertions.assertEquals(ints, this.sortAscending(ints));
    }

    @ParameterizedTest
    @MethodSource("listInts")
    void testArgsValues(int i, int j, int k){
        ArrayList <Integer> ints = new ArrayList<>();
        ints.add(i);
        ints.add(j);
        ints.add(k);
        Collections.sort(ints);
        Assertions.assertEquals(ints, this.sortAscending(ints));
    }

    static Stream<Arguments> listInts(){

        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(3, 2, 1),
                Arguments.of(2, 1, 3),
                Arguments.of(3, 1, 2)
                );
    }

    @ParameterizedTest
    @MethodSource("randomListInts")
    void testRandomArgsValues(int i, int j, int k){
        ArrayList <Integer> ints = new ArrayList<>();
        ints.add(i);
        ints.add(j);
        ints.add(k);
        Collections.sort(ints);
        Assertions.assertEquals(ints, this.sortAscending(ints));
    }

    static Stream<Arguments> randomListInts(){

        return Stream.of(
                Arguments.of(1+(int)(Math.random()*3), 1+(int)(Math.random()*3), 1+(int)(Math.random()*3)),
                Arguments.of(1+(int)(Math.random()*3), 1+(int)(Math.random()*3), 1+(int)(Math.random()*3)),
                Arguments.of(1+(int)(Math.random()*3), 1+(int)(Math.random()*3), 1+(int)(Math.random()*3)),
                Arguments.of(1+(int)(Math.random()*3), 1+(int)(Math.random()*3), 1+(int)(Math.random()*3))
        );
    }
}
