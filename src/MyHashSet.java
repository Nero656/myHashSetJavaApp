import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MyHashSet<T>
{
    private static final int SIZE = 16;
    private List<T>[] buckets;

    public MyHashSet() {
        buckets = new List[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int getIndex(T value) {
        return Math.abs(value.hashCode() % SIZE);
    }

    public void insert(T value){
        int index = getIndex(value);
        if (!buckets[index].contains(value)) {
            buckets[index].add(value);
        }
    }


    public void remove(T value) {
        int index = getIndex(value);
        buckets[index].remove(value);
    }

    @Override
    public String toString() {
        return Arrays.toString(buckets);
    }
}
