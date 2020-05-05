package validators.api;

public interface Validator<T> {
     boolean isValid( T obj);
}
