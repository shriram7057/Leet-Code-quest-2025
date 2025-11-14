class SummaryRanges {

    private TreeMap<Integer, int[]> map;

    public SummaryRanges() {
        map = new TreeMap<>();
    }

    public void addNum(int value) {
        if (map.containsKey(value)) return; // exact match

        // find interval before value
        Integer lowerKey = map.floorKey(value);
        if (lowerKey != null) {
            int[] lower = map.get(lowerKey);

            // already inside interval → do nothing
            if (lower[1] >= value) return;

            // connect to previous interval
            if (lower[1] + 1 == value) {
                lower[1] = value;

                // maybe merge with next interval
                Integer higherKey = map.higherKey(value);
                if (higherKey != null) {
                    int[] higher = map.get(higherKey);

                    if (higher[0] == value + 1) {
                        lower[1] = higher[1];
                        map.remove(higherKey);
                    }
                }
                return;
            }
        }

        // try merge with next interval only
        Integer higherKey = map.higherKey(value);
        if (higherKey != null) {
            int[] higher = map.get(higherKey);

            if (higher[0] == value + 1) {
                map.remove(higherKey);
                map.put(value, new int[]{value, higher[1]});
                return;
            }
        }

        // create new interval
        map.put(value, new int[]{value, value});
    }

    public int[][] getIntervals() {
        return map.values().toArray(new int[map.size()][]);
    }
}
