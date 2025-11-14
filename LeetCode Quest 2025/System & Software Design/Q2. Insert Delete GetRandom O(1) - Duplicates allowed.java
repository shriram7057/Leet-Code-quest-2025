class RandomizedCollection {

    private List<Integer> list;
    private Map<Integer, Set<Integer>> map;
    private Random rand;

    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        boolean isNew = !map.containsKey(val);

        map.computeIfAbsent(val, k -> new HashSet<>()).add(list.size());
        list.add(val);

        return isNew;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        // get any index of val
        int removeIdx = map.get(val).iterator().next();
        map.get(val).remove(removeIdx);

        int lastIdx = list.size() - 1;
        int lastVal = list.get(lastIdx);

        // swap only if not removing last
        if (removeIdx != lastIdx) {

            // move lastVal to removeIdx
            list.set(removeIdx, lastVal);

            // update index in map
            map.get(lastVal).remove(lastIdx);
            map.get(lastVal).add(removeIdx);
        }

        // remove last element
        list.remove(lastIdx);

        // remove val set if empty
        if (map.get(val).isEmpty()) {
            map.remove(val);
        }

        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
