package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given a list of airline tickets represented by pairs of departure and arrival
 * airports [from, to], reconstruct the itinerary in order. All of the tickets
 * belong to a man who departs from JFK. Thus, the itinerary must begin with
 * JFK.
 * 
 * Note:
 * 
 * If there are multiple valid itineraries, you should return the itinerary that
 * has the smallest lexical order when read as a single string. For example, the
 * itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"]. All
 * airports are represented by three capital letters (IATA code). You may assume
 * all tickets form at least one valid itinerary. One must use all the tickets
 * once and only once. Example 1:
 * 
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"] Example 2:
 * 
 * Input:
 * [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"] Explanation: Another possible
 * reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in
 * lexical order.
 * 
 * @author Chetan
 *
 */
public class ReconstructItenary {
	public List<String> findItinerary(List<List<String>> tickets) {
		Map<String, Queue<String>> flightMap = buildGraph(tickets);
		List<String> result = new ArrayList<>();

		dfs("JFK", result, flightMap);
		return result;
	}

	private void dfs(String origin, List<String> result, Map<String, Queue<String>> map) {
		if (map.containsKey(origin)) {
			Queue<String> destinations = map.get(origin);
			while (!destinations.isEmpty()) {
				String dest = destinations.poll();
				dfs(dest, result, map);
			}
		}
		result.add(0, origin);
	}

	/**
	 * Builds adjacency list of origin -> destinations
	 * 
	 * @param tickets
	 * @return
	 */
	private Map<String, Queue<String>> buildGraph(List<List<String>> tickets) {
		Map<String, Queue<String>> map = new HashMap<>();

		for (List<String> ticket : tickets) {
			String origin = ticket.get(0);
			String dest = ticket.get(1);

			Queue<String> destinations = map.get(origin);
			if (destinations == null) {
				// will be using priority queue as in the question, it should be lexicographically sorted.
				destinations = new PriorityQueue<>((a, b) -> a.compareTo(b));
				map.put(origin, destinations);
			}
			destinations.add(dest);
		}

		return map;
	}
	
	//[["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
	public static void main(String[] args) {
		List<List<String>> list = new ArrayList<>();
		List<String> l = new ArrayList<>();
		l.add("JFK");l.add("SFO");
		list.add(l);
		l = new ArrayList<>();
		l.add("JFK");l.add("ATL");
		list.add(l);
		l = new ArrayList<>();
		l.add("SFO");l.add("ATL");
		list.add(l);
		l = new ArrayList<>();
		l.add("ATL");l.add("JFK");
		list.add(l);
		l = new ArrayList<>();
		l.add("ATL");l.add("SFO");
		list.add(l);

		List<String> result = new ReconstructItenary().findItinerary(list);
		result.forEach(airport ->{
			System.out.println(airport);
		});
	}
}