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
// 1)A node that does not have any incoming edge can only be reached by itself.
// 2)Any other node with incoming edges can be reached from some other node
// 3) We only have to count the number of nodes with zero incoming edges.
