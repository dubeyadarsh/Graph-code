
class Solution {
    public Node cloneGraph(Node node) {
       if(node==null) return null;
        Node copy=new Node(node.val);
        Node vis[]=new Node[1000];
        dfs(node,copy,vis);
       return copy;
    }
    void dfs(Node node , Node copy, Node vis[]){

        vis[copy.val]=copy;
         for(Node b:node.neighbors){
              if(vis[b.val]==null){
                  Node newNode = new Node(b.val);
                  copy.neighbors.add(newNode);
                  dfs(b,newNode,vis);
                  
              }
             else{
                 
                 
                  copy.neighbors.add(vis[b.val]);
             }
             
            
        }
    }
}
