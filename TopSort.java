// dfs
import java.util.*;
public class Solution 
{
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int n, int e) 
    {
        // Write your code here
         ArrayList < ArrayList < Integer >> edg=new ArrayList<>();
      for(int i=0;i<n;i++){
          edg.add(new ArrayList<Integer>());
      }
      for(ArrayList<Integer> al:edges){
//           System.out.println(al);
          edg.get(al.get(0)).add(al.get(1));
      }
      boolean vis[]=new boolean[n];
      Stack<Integer> ans=new Stack<>();
      for(int i=0;i<n;i++){
          if(!vis[i] ) {
          is(i,vis,edg,ans);
          }
          
      }
//         System.out.println(ans);
        ArrayList<Integer> al=new ArrayList<>();
        for(int l:ans) al.add(l);
        Collections.reverse(al);
    return al;
    }
    static void is(int i,boolean vis[],ArrayList < ArrayList < Integer >> edges, Stack<Integer> ans){
        if(vis[i]) return;
        vis[i]=true;
        for(int  p:edges.get(i)){
            is(p,vis,edges,ans);
        }
        ans.add(i);
    }
}

// /bfs or kahn's
import java.util.*;
public class Solution 
{
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int n, int e) 
    {
        // Write your code here
         ArrayList < ArrayList < Integer >> edg=new ArrayList<>();
      for(int i=0;i<n;i++){
          edg.add(new ArrayList<Integer>());
      }
         int indegree[]=new int[n];
      for(ArrayList<Integer> al:edges){
//           System.out.println(al);
          edg.get(al.get(0)).add(al.get(1));
         indegree[al.get(1)]++;
      }
       

      ArrayList<Integer> al=new ArrayList<>();

          is(indegree,edg,al);
        
          

//         System.out.println(al);
       
    
    return al;
    }
    static void is(int[] indeg,ArrayList < ArrayList < Integer >> edges, ArrayList<Integer> al){
        Queue<Integer> que=new LinkedList<>();
      for(int p=0;p<indeg.length;p++) if(indeg[p]==0){
       
          que.add(p);
      } 
      int cnt = 0;
       while(que.size()>0){
           int t=que.poll();
           al.add(t);
           for(int k:edges.get(t)){
               
               indeg[k]=indeg[k]-1;
               if(indeg[k]==0) que.add(k);
           }
         cnt++;
       } 
//       if(cnt!=indeg.length) return "there is cycle"
    }
}

// If u have to check for cycle then chgeck line no 87
  
