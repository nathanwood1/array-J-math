package uk.nathanwood.arrayjmath.tensor;

import java.util.ArrayList;
import java.util.List;

public abstract class DataType {

    public static DataType Int = new Int();

    private List<Range> freeRanges = new ArrayList<>();

    private static class Int extends DataType {

        private ArrayList<Integer> vals = new ArrayList<>();

        @Override
        protected void add(int amount) {
            for (int i = 0; i < amount; i++) {
                vals.add(0);
            }
        }

        @Override
        public Object getVal(int i) {
            return vals.get(i);
        }

        @Override
        public void setVal(int i, Object o) {
            if (i == vals.size()) {
                vals.add((Integer) o);
            } else {
                vals.set((Integer) o, i);
            }
        }

        @Override
        public Object add(Object a, Object b) {
            return add((int) a, (int) b);
        }

        public int add(int a, int b) {
            return a + b;
        }

    }

    private static class Range {

        public int start, end;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }

    }

    public int[] allocateArray(int length) {
        int[] indices = new int[length];
        int indicesAllocated = 0;
        while (indicesAllocated != length && !freeRanges.isEmpty()) {
        }
        return indices;
    }

    protected abstract void add(int amount);

    public abstract Object getVal(int i);
    public abstract void setVal(int i, Object a);

    public abstract Object add(Object a, Object b);

}
