package UnionFind;

public class UnionFind4 implements UF {
    private int[] parent;
    private int[] rank;  // rank[i]表示以i为根的集合中元素的个数

    public UnionFind4(int size){
        parent = new int[size];
        rank = new int[size];
        for (int i =0; i < size; i ++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    // 查看元素p所对应的集合编号
    // 时间复杂度：O(h)
    private int find(int p){
        if (p < 0 || p >= parent.length)
            throw new IllegalArgumentException("p is out of bound.");
        while (p != parent[p])
            p = parent[p];
        return p;
    }


    // 查看元素p和元素q是否属于同一集合
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot)
            return;

        // 根据两个元素所在树的元素个数不同判断合并方向
        // 将元素个数少的集合合并到元素个数多的集合上
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        }
        else if (rank[pRoot] > rank[qRoot])
            parent[qRoot] = parent[pRoot];
        else{
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }
    }
}
