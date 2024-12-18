package org.example;

public class LinearProbingHashST<Key, Value> {
    private int N;
    private int M;
    private Key[] keys;
    private Value[] vals;

    public LinearProbingHashST(int size) {
        M = size;
        N = 0;
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void put(Key key, Value val) {
        int i;
            for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        N++;

        if (N > M / 2) {
            resize(2 * M);
        }
    }

    private void resize(int newSize) {
        LinearProbingHashST<Key, Value> temp = new LinearProbingHashST<>(newSize);
        for (int i = 0; i < M; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], vals[i]);
            }
        }
        keys = temp.keys;
        vals = temp.vals;
        M = temp.M;
        N = temp.N;
    }

    public double averageSearchCost() {
        if (N == 0) return 0.0;
        int totalProbes = 0;

        for (int i = 0; i < M; i++) {
            if (keys[i] != null) {
                int probes = 0;
                for (int j = hash(keys[i]); keys[j] != null; j = (j + 1) % M) {
                    probes++;
                    if (keys[j].equals(keys[i])) {
                        break;
                    }
                }
                totalProbes += probes;
            }
        }

        return (double) totalProbes / N;
    }

    public static void main(String[] args) {
        LinearProbingHashST<String, Integer> st = new LinearProbingHashST<>(10);

        st.put("one", 1);
        st.put("two", 2);
        st.put("three", 3);
        st.put("four", 4);
        st.put("five", 5);
        st.put("six", 6);
        st.put("seven", 7);
        st.put("eight", 8);
        st.put("nine", 9);
        st.put("ten", 10);

        double avgCost = st.averageSearchCost();
        System.out.println("Средняя стоимость промаха: " + avgCost);
    }
}