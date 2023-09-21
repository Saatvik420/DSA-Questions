class Solution {
    public List<List<Integer>> levelOrder(Node node) {
        if (node == null) return new ArrayList<>();
        Map<Integer, List<Integer>> map = new TreeMap<>();
        traverseTree(node, map, 0);
        List<List<Integer>> res = new ArrayList<>();
        for (int key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }

    private void traverseTree(Node node, Map<Integer, List<Integer>> map, int lvl) {
        if (node == null) return;

        lvl++;

        List<Integer> list = map.get(lvl);
        if (list == null) {
            list = new ArrayList<>();
            list.add(node.val);
            map.put(lvl, list);
        } else list.add(node.val);

        for (int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);
            traverseTree(child, map, lvl);
        }
    }
}