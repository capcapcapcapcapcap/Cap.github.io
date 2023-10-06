    static class Fenwick {
        int n;
        int[] tr;

        Fenwick(int len) {
            n = len;
            tr = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                tr[i] = 0;
            }
        }

        int lowbit(int x) {
            return x & -x;
        }

        void modify(int x, int c) {
            for (int i = x; i <= n; i += lowbit(i)) {
                tr[i] += c;
            }
        }

        void modify(int l, int r, int c) {
            modify(l, c);
            if (r + 1 <= n) {
                modify(r + 1, -c);
            }
        }

        int query(int x) {
            int res = 0;
            for (int i = x; i > 0; i -= lowbit(i)) {
                res += tr[i];
            }
            return res;
        }

        int query(int l, int r) {
            return query(r) - query(l - 1);
        }
    }