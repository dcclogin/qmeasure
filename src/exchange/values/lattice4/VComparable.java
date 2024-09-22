package exchange.values.lattice4;

import java.util.Optional;

public interface VComparable<T> {
    public Optional<Integer> compareTo(T o);
}
