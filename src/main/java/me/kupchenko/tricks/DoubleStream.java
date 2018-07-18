package me.kupchenko.tricks;

import java.util.Random;
import java.util.stream.LongStream;

public class DoubleStream {
    public static void main(String[] args) {
        long[] numbers = getLongs();
        getAverageWithSimpleStreamAPI(numbers);

        //Next two: the most accuracy result
        getAverageWithKahanSummation(numbers);
        getAverageWithKahanSummationInParallelMode(numbers);

        getAverageInStandardWay(numbers);

    }

    private static long[] getLongs() {
        return new Random(55).longs(1000).toArray();
    }

    /**
     * FIRST: long summation
     * SECOND: calculating average (can be values -> Long.MAX_VALUE or Long.MIN_VALUE) value overflow
     * THIRD: get double value
     */
    private static double getAverageWithSimpleStreamAPI(long[] numbers) {
        return LongStream.of(numbers).average().getAsDouble();
    }

    /**
     * Different order of long summation
     */
    private static double getAverageWithKahanSummationInParallelMode(long[] numbers) {
        return LongStream.of(numbers).asDoubleStream().parallel().average().getAsDouble();
    }

    /**
     * Kahan summation algorithm,
     * Significantly reduces the numerical error in the total obtained
     */
    private static double getAverageWithKahanSummation(long[] numbers) {
        return LongStream.of(numbers).asDoubleStream().average().getAsDouble();
    }

    /**
     * Numerical error appears during calculation
     */
    private static double getAverageInStandardWay(long[] numbers) {
        double asDouble3 = 0.0;
        for (long number : numbers) {
            asDouble3 += number;
        }
        asDouble3 /= numbers.length;
        return asDouble3;
    }
}
