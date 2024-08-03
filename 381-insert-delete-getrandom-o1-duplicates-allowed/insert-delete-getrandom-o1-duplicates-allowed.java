class RandomizedCollection {

    ArrayList<Integer> nums;
    HashMap<Integer, Set<Integer>> locs;
    java.util.Random rand = new java.util.Random();

    public RandomizedCollection() {
        nums = new ArrayList<>();
        locs = new HashMap<Integer, Set<Integer>>();
    }
    
    public boolean insert(int val) {
        boolean present = locs.containsKey(val);
        if(!present){
            locs.put(val,new LinkedHashSet<Integer>());
        }

        locs.get(val).add(nums.size());
        nums.add(val);
        return !present;
    }
    
    public boolean remove(int val) {
        boolean present = locs.containsKey(val);
        if(!present){
            return false;
        }

        int loc = locs.get(val).iterator().next();
        locs.get(val).remove(loc);

        if(loc < nums.size()-1){
            int lastloc = nums.get(nums.size()-1);
            nums.set(loc,lastloc);
            locs.get(lastloc).remove(nums.size()-1);
            locs.get(lastloc).add(loc);
        }

        nums.remove(nums.size() - 1);
        if(locs.get(val).isEmpty())     locs.remove(val);

        return true;
    }
    
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */