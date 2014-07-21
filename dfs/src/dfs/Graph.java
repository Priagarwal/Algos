package dfs;

public class Graph{
	Vertex[] vertexList;
	int vertexCount;
	int maxVertices = 20;
	int adjMat[][];
	Stack stk;
	
	Graph(){
		this.vertexList = new Vertex[maxVertices];
		this.vertexCount = 0;
		this.adjMat = new int[maxVertices][maxVertices];
		this.stk = new Stack(maxVertices);
		for(int i = 0; i < maxVertices; i++) {
			for(int j = 0; j< maxVertices; j++) {
				adjMat[i][j] = 0;
			}
		}
	}
	
	public void addVertex(char v) {
		vertexList[vertexCount++] = new Vertex(v);
	}
	
	public void addEdge(int i, int j) {
		adjMat[i][j] = 1;
		adjMat[j][i] = 1;
	}
	
	public void displayVertex(int v){
		System.out.println(vertexList[v].lab);
	}
	
	/*
	public void dfs() {
		vertexList[0].isVisited = true;
		displayVertex(0);
		stk.push(0);
		
		while(!stk.isEmpty()) {
			int v = getAdjUnvisitedVertex(stk.getTop());
			if(v == -1) {
				stk.pop();
			} else {
				stk.push(v);
				vertexList[v].isVisited = true;
				displayVertex(v);
			}
		}
		
		for(int j=0; j<vertexCount; j++)          // reset flags
	         vertexList[j].isVisited = false;
	} 
	*/
	public void dfs()  // depth-first search
    {                                 // begin at vertex 0
    vertexList[0].isVisited = true;  // mark it
    displayVertex(0);                 // display it
    stk.push(0);                 // push it
    stk.printStack();
    while( !stk.isEmpty() )      // until stack empty,
       {
       // get an unvisited vertex adjacent to stack top
       int v = getAdjUnvisitedVertex( stk.getTop() );
       System.out.println("Now v is " + v);
       if(v == -1)       {             // if no such vertex,
          stk.pop();
          stk.printStack();
       } else {
          vertexList[v].isVisited = true;  // mark it
          displayVertex(v);                 // display it
          stk.push(v); 
          stk.printStack();// push it
       }
    }  // end while

    // stack is empty, so we're done
    for(int j=0; j<vertexCount; j++)          // reset flags
       vertexList[j].isVisited = false;
    }
	
	
	public int getAdjUnvisitedVertex(int v) {
		for(int j = 0; j < vertexCount; j++) {
			if(adjMat[v][j] == 1 && vertexList[j].isVisited == false) {
				System.out.println("Next unvisited vertex adjacent to " + v + " is " + j);
				return j;
			}
		}
		return -1;
	}
	
	/*public int getAdjUnvisitedVertex(int v)
    {
    for(int j=0; j<nVerts; j++)
       if(adjMat[v][j]==1 && vertexList[j].wasVisited==false)
          return j;
    return -1;
    } 
	*/
	public static void main(String args[]) {
		Graph theGraph = new Graph();
		theGraph.addVertex('A');
		theGraph.addVertex('B');
		theGraph.addVertex('C');
		theGraph.addVertex('D');
		theGraph.addVertex('E');
		theGraph.addVertex('F');
		theGraph.addVertex('G');
		theGraph.addEdge(0,1);
		theGraph.addEdge(0,2);
		theGraph.addEdge(0,3);
		theGraph.addEdge(1,4);
		theGraph.addEdge(4,5);
		theGraph.addEdge(5,6);
		theGraph.addEdge(2,6);
		/*
		for(int i = 0; i < theGraph.vertexCount; i++)
			System.out.println(theGraph.vertexList[i].lab);
			
		for(int i = 0; i < theGraph.vertexCount; i++) {
			for(int j = 0; j< theGraph.vertexCount; j++) {
				System.out.print(theGraph.adjMat[i][j] + "  ");
			}
			System.out.println("");
		}
		*/
		theGraph.dfs();
	}
	
	
}