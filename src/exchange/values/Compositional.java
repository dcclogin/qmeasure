package exchange.values;

public interface Compositional<T> {
    T compose(T a);
}
