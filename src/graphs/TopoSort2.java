package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class TopoSort2 {
	
	public int[] findOrder(int numOfCourses, int[][] prerequisites) {
		int[] result = new int[numOfCourses];
		MyGraph graph = buildMyGraph(numOfCourses, prerequisites);
		Stack<Course> orders = order(graph.getNodes());
		int count = numOfCourses - 1;
		while(!orders.isEmpty()) {
			result[count--] = orders.pop().getName();
		}
		return result;
	}
	
	private MyGraph buildMyGraph(int numOfCourses, int[][] prerequisites) {
		MyGraph graph = new MyGraph();
		for(int i = 0; i < numOfCourses; i++) {
			graph.getOrCreateNode(i);
		}
		
		for(int[] i : prerequisites) {
			graph.addEdge(i[0], i[1]);
		}
		return graph;
	}
	
	public Stack<Course> order(List<Course> nodes){
		Stack<Course> stack = new Stack<>();
		for(Course node : nodes) {
			if(node.getState() == State.BLANK) {
				if(!dfs(node, stack)) {
					return null;
				}
			}
		}
		return stack;
	}
	
	private boolean dfs(Course node, Stack<Course> result) {
		if(node.getState() == State.PARTIAL) {
			return false;
		}
		
		if(node.getState() == State.BLANK) {
			node.setState(State.PARTIAL);
			List<Course> children = node.getChildren();
			for(Course child : children) {
				if(!dfs(child, result)) {
					return false;
				}
			}
			node.setState(State.COMPLETE);
			result.push(node);
		}
		return true;
	}
	
	public static void main(String[] args) {
		TopoSort2 obj = new TopoSort2();
		int[][] pre = {{0, 1}, {1, 0}};
		int[] result = obj.findOrder(2, pre);
		System.out.println(Arrays.toString(result));
	}
}

class MyGraph{
	private List<Course> nodes = new ArrayList<>();
	private Map<Integer, Course> map = new HashMap<>();
	
	public Course getOrCreateNode(int name) {
		Course node = map.get(name);
		if(node == null) {
			node = new Course(name);
			nodes.add(node);
			map.put(name, node);
		}
		return node;
	}
	
	public List<Course> getNodes(){
		return nodes;
	}
	
	public void addEdge(int start, int end) {
		Course stCourse = new Course(start);
		Course endCourse = new Course(end);
		stCourse.addNeighbour(endCourse);
	}
}

enum State{
	PARTIAL, COMPLETE, BLANK
}

class Course{
	private State state;
	private int name;
	private List<Course> children = new ArrayList<>();
	private Map<Integer, Course> map = new HashMap<>();
	
	public Course(int name) {
		this.name = name;
	}
	
	public void setState(State state) {
		this.state = state;
	}
	
	public State getState() {
		return state;
	}
	
	public int getName() {
		return name;
	}
	
	public List<Course> getChildren(){
		return children;
	}
	
	public void addNeighbour(Course course) {
		if(!map.containsKey(course.getName())) {
			children.add(course);
			map.put(course.getName(), course);
		}
	}
}
