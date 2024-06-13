package interfaceDAO;
import java.util.List;

public interface IDAO<T, I> { // OK
    public void insert(T data);
    public List<T> showData(I data);
    public void update(T data, I data2);
    public void delete(I data);
}
