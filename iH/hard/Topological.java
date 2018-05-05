package GI.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Topological {
	 private boolean[] marked;          // marked[v] = has v been marked in dfs?
	    private int[] pre;                 // pre[v]    = preorder  number of v
	    private int[] post;                // post[v]   = postorder number of v
	    private Queue<Integer> preorder;   // vertices in preorder
	    private Queue<Integer> postorder;  // vertices in postorder
	    private int preCounter;            // counter or preorder numbering
	    private int postCounter;           // counter for postorder numbering
	public Topological(Digraph G) {
        pre    = new int[G.V()];
        post   = new int[G.V()];
        postorder = new LinkedList<Integer>();
        preorder  = new LinkedList<Integer>();
        marked    = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!marked[v]) dfs(G, v);

        //assert check();
    }
	 // run DFS in digraph G from vertex v and compute preorder/postorder
    private void dfs(Digraph G, int v) {
        marked[v] = true;
        pre[v] = preCounter++;
        preorder.offer(v);
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
        postorder.offer(v);
        post[v] = postCounter++;
    }
}
 class Digraph {
    private static final String NEWLINE = System.getProperty("line.separator");

    private final int V;           // number of vertices in this digraph
    private int E;                 // number of edges in this digraph
    private List<Integer>[] adj;    // adj[v] = adjacency list for vertex v
    private int[] indegree;        // indegree[v] = indegree of vertex v
    
    /**
     * Initializes an empty digraph with <em>V</em> vertices.
     *
     * @param  V the number of vertices
     * @throws IllegalArgumentException if {@code V < 0}
     */
    public Digraph(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
        this.V = V;
        this.E = 0;
        indegree = new int[V];
        adj = (List<Integer>[]) new List[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<Integer>();
        }
    }
    public int V() {
        return V;
    }
 // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }
    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }
 }