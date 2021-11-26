
class Solution
{
    static class Node{
        int u;
        int v;
        int w;
        public Node(int u,int v,int w){
            this.u=u;
            this.v=v;
            this.w=w;
        }
    }
    // This is Kuruskals Algorithm
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int par [];
    static int rank [];
    static int spanningTree(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        par=new int[v];
        rank=new int[v];
        for(int i=0;i<v;i++) par[i]=i;
        boolean vis[]=new boolean[v];
        ArrayList<Node>  graph=new ArrayList<>();
        for(int i=0;i<v;i++){
            vis[i]=true;
            for(ArrayList<Integer> b:adj.get(i)){
            
            int a=b.get(0);
            int w=b.get(1);
            if(!vis[a])
            graph.add(new Node(i,a,w));
            }
        }
        Collections.sort(graph,new Comparator<Node>(){
           @Override
           public int compare(Node n1,Node n2){
               return n1.w-n2.w;
           }
        });
        int cost=0;
        for(int i=0;i<graph.size();i++){
             
            Node rem=graph.get(i);
            if(find(rem.u)==find(rem.v)) continue;
            //  System.out.println(graph.get(i).u+""+graph.get(i).v+""+graph.get(i).w);
            union(rem.u,rem.v);
            cost+=rem.w;
        }
        // for(int i=0;i<graph.size();i++)
      
        return cost;
    }
    static int find(int x){
        if(x==par[x]) return x;
        int temp=find(par[x]);
        par[x]=temp;
        return temp;
    }
    static void  union(int x,int y){
        int lx=find(x);
        int ly=find(y);
        if(lx!=ly){
            if(rank[lx]>rank[ly]){
                par[ly]=lx;
            }
            else if(rank[ly]>rank[lx]) par[lx]=ly;
            else {
                par[lx]=ly;
                rank[ly]++;
            }
        }
    }
    
}
