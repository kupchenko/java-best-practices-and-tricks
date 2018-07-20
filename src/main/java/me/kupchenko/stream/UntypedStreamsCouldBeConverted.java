package me.kupchenko.stream;

import me.kupchenko.model.QualityAnnotations.Good;
import me.kupchenko.model.QualityAnnotations.Ugly;

import java.util.List;

public class UntypedStreamsCouldBeConverted {
    @Ugly
    class ProcessOnlyValuesOfSpecialType {
        public int countDoubleNaNs(List numbers) {
            int count = 0;
            for (Object e : numbers) {
                if (e instanceof Double) {
                    Double d = (Double) e;
                    if (d.isNaN()) {
                        count++;
                    }
                }
            }
            return count;
        }
    }

    @Good
    class TypeOfStreamCouldBeChanged {
        public int countDoubleNaNs(List numbers) {
            return (int) numbers.stream()
                    .filter(Double.class::isInstance)
                    .mapToDouble(Double.class::cast)
                    .filter(Double::isNaN)
                    .count();
        }

    }
}