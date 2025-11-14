class SubrectangleQueries {

    private int[][] rect;
    private List<int[]> updates;

    public SubrectangleQueries(int[][] rectangle) {
        rect = rectangle;
        updates = new ArrayList<>();
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        updates.add(new int[]{row1, col1, row2, col2, newValue});
    }

    public int getValue(int row, int col) {
        for (int i = updates.size() - 1; i >= 0; i--) {
            int[] u = updates.get(i);

            int r1 = u[0], c1 = u[1], r2 = u[2], c2 = u[3], val = u[4];

            if (row >= r1 && row <= r2 && col >= c1 && col <= c2) {
                return val;
            }
        }

        return rect[row][col];
    }
}
