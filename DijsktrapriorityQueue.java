
class Solution
{
     static class Pair{
         int node;
         String psf;
         int wsf;
         Pair(int node,String psf,int wsf){
             this.node=node;
             this.psf=psf;
             this.wsf=wsf;
         }
     }
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int n, ArrayList<ArrayList<ArrayList<Integer>>> adj, int s)
    {
        int ans[]=new int[n];
        PriorityQueue<Pair> pq=new PriorityQueue<>(new Comparator<Pair>(){
            @Override
            public int compare(Pair s1, Pair s2){
                return s1.wsf - s2.wsf;
            }
         });
         boolean vis[]=new boolean[n];
       pq.add(new Pair(s,s+"",0));    
       while(pq.size()>0){
           Pair rem=pq.remove();
           if(vis[rem.node]){
               continue;
           }
           vis[rem.node]=true;
           ans[rem.node]=rem.wsf;
           for(int i=0;i<adj.get(rem.node).size();i++){
               int v=adj.get(rem.node).get(i).get(0);
               int w=adj.get(rem.node).get(i).get(1);
               if(!vis[v]){
                   pq.add(new Pair(v,rem.psf+v,rem.wsf+w));
               }
           }
       }
        return ans;
    }
}
