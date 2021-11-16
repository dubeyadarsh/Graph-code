class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
//         Answer will be only that vertex who has 0 indegree
        int in[]=new int[n];
        ArrayList<Integer> al=new ArrayList<>();
        for(List<Integer> edge:edges){
            in[edge.get(1)]=1;
        }
        for(int i=0;i<n;i++){
            if(in[i]==0) al.add(i);
        }
        return al;
    }
}
