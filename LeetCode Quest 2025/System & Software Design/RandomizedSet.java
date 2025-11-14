import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {

    private Map<Integer, Integer> map;   // val -> index
    private List<Integer> list;
    private Random rand;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;

        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        int idx = map.get(val);
        int lastVal = list.get(list.size() - 1);

        // move last element to idx
        list.set(idx, lastVal);
        map.put(lastVal, idx);

        // remove last element
        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }

    public int getRandom() {
        int idx = rand.nextInt(list.size());
        return list.get(idx);
    }
}
 {
    
}
