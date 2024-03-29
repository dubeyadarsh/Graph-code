// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Graph{
    ArrayList a[];
    Graph(int n){
        a=new ArrayList[n];
        for(int i=0;i<n;i++){
            a[i]=new ArrayList();
        }
    }
    void addEdge(int s,int d,int dis){
        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(d,dis);
        
        a[s].add(hm);
        HashMap<Integer,Integer> hm2=new HashMap<>();
        hm2.put(s,dis);
    //    a[d]=new HashMap();
        a[d].add(hm2);
    }
    void print(){
        for(int i=0;i<a.length;i++){
            System.out.print("Neighbour of vertext "+i+" is:");
            for(int j=0;j<a[i].size();j++){
                System.out.print(a[i].get(j)+" ");
            }
            System.out.println();
        }
    }
        class Pair{
        int ver;
        String psf;
        public Pair(int ver , String psf){
            this.ver=ver;
            this.psf=psf;
        }
    }
     void dfs(int src){
        Stack<Pair> stack=new Stack<>();
        stack.push(new Pair(src,src+""));
        boolean[] vis=new boolean[a.length];
        while(stack.size()>0){
            Pair temp=stack.pop();
            if(vis[temp.ver]){
                continue;
            }
            vis[temp.ver]=true;
           System.out.println(temp.ver+"@"+temp.psf+" ");

            for(int b:a[temp.ver]){
                if(!vis[b]){
                    stack.push(new Pair(b,temp.psf+b));
                }
            }
            
        }
    }
    void bfs(int src){
        ArrayDeque<Pair> queue=new ArrayDeque<>();
        queue.add(new Pair(src,src+""));
        boolean vis[]=new boolean[a.length];
        while(queue.size()>0){
            Pair temp=queue.removeFirst();
            if(vis[temp.ver]){
                continue;
            }
            vis[temp.ver]=true;
            System.out.println(temp.ver+"@"+temp.psf+" ");
            for(int b:a[temp.ver]){
                
                    
                    if(vis[b]==false){
                        queue.add(new Pair(b,temp.psf+b));
                    }
                
                
            }
        }
    }
}
class HelloWorld {
    public static void main(String[] args) {
        Graph gr=new Graph(5);
        gr.addEdge(0,1,5);
        gr.addEdge(1,2,5);
        gr.addEdge(2,3,5);
        gr.addEdge(3,4,5);
        gr.print();
    }
}
