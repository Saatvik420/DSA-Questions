class SnapshotArray {
  TreeMap<Integer, Integer>[] map;
  int snap_id;

  public SnapshotArray(int length) {
    map = new TreeMap[length];
    snap_id = 0;
  }
  
  public void set(int index, int val) {
    if (map[index] == null) map[index] = new TreeMap<>();

    map[index].put(snap_id, val);
  }
  
  public int snap() {
    return snap_id++;
  }
  
  public int get(int index, int snap_id) {
    if (map[index] == null) return 0;
    
    var entry = map[index].floorEntry(snap_id);

    return entry == null ? 0 : entry.getValue();
  }
}