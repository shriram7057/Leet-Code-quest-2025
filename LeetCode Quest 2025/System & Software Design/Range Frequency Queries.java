class RangeFreqQuery {

    private Map<Integer, List<Integer>> map;

    public RangeFreqQuery(int[] arr) {
        map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
    }

    public int query(int left, int right, int value) {
        if (!map.containsKey(value)) return 0;

        List<Integer> list = map.get(value);

        int l = lowerBound(list, left);
        int r = upperBound(list, right);

        return r - l;
    }

    private int lowerBound(List<Integer> list, int target) {
        int idx = Collections.binarySearch(list, target);
        if (idx < 0) idx = -idx - 1;
        return idx;
    }

    private int upperBound(List<Integer> list, int target) {
        int idx = Collections.binarySearch(list, target);
        if (idx < 0) idx = -idx - 1;
        else idx += 1;
        return idx;
    }
}
