import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


public class AgglomerativeClustering <T extends Clusterable<T>> implements Clustering<T>{
	double threshold;
	public AgglomerativeClustering(double threshold) {
		this.threshold = threshold;
	}

	//a Pair class that holds 2 generic sets and a distance value
	public class Pair implements Comparable<Pair>{
		Set<T> c1;
		Set<T> c2;
		double distance;

		public Pair(Set<T> c1, Set<T> c2, double distance){
			this.c1 = new HashSet<T>(c1);
			this.c2 = new HashSet<T>(c2);
			this.distance = distance;
		}

		public double getDistance(){
			return distance;
		}

		//a comparater function that compares two pair objects based on their distance value
		@Override
		public int compareTo(Pair other){
			if(this.getDistance() < other.getDistance()) return -1;
			else if(this.getDistance() > other.getDistance()) return 1;
			return 0;
		}

	}

	public Set<Set<T>> clusterSet(Set<T> elements) {
//     //make every element a set, so we have a set of sets
//     while (elements.size() != 1)
//     //find the two closest clusters, c1,c2 from clusters
//        //loops for every cluster to every other cluster
//        //representative for a cluster with many points is the closest point - need to loop through
//        //all points in a cluster
//     if (distance(c1, c2) > threshold) return clusters;
//     replace c1,c2 in clusters with the union of c1,c2
//     return clusters

		Set<Set<T>> clusters = elements.stream().map(Set::of).collect(Collectors.toSet()); //map every element to a new set and make that a set

		while (clusters.size() != 1){
			// find two closest clusters
			Pair closestClusters = clusters.stream()
					.flatMap(el1 -> clusters.stream()
							.map(el2 -> new Pair(el1, el2, distance((Set<T>)el1, (Set<T>)el2))))
					.min(myComparator).orElse(null);

			if(closestClusters.getDistance() > threshold) return clusters;
			//System.out.println(closestClusters.first.first, closestClusters.first.second);
			// 1. get elements from c1 and c2 - combine into new set
			// 2. remove c1 and c2 from new_set
			// 3. add the combined set to new_set

			clusters.remove(closestClusters.c1);
			clusters.remove(closestClusters.c2);
			closestClusters.c1.addAll(closestClusters.c2);
			clusters.add(closestClusters.c1);
		}

		return clusters;
	}
	//a comparator to use for min that compares two objects based on their distance
	Comparator<Pair> myComparator = (obj1, obj2) -> {
		if(obj1.getDistance() < obj2.getDistance()) return -1;
		else if(obj1.getDistance() > obj2.getDistance()) return 1;
		return 0;
	};

	//distance between 2 sets is the closest distance between any two points in either set
	public double distance(Set<T> c1, Set<T> c2){
		//return c1.stream().flatMap(point1 -> c2.stream().map(point2 -> check_distance(point1, point2))).min(Double::compare).orElse(Double.MAX_VALUE);
		boolean hasMaxValue = c1.stream()
				.flatMap(point1 -> c2.stream().map(point2 -> check_distance(point1, point2)))
				.anyMatch(distance -> distance == Double.MAX_VALUE);

		if (hasMaxValue) {
			return Double.MAX_VALUE;
		}

		return c1.stream()
				.flatMap(point1 -> c2.stream().map(point2 -> check_distance(point1, point2)))
				.min(Double::compare)
				.orElse(Double.MAX_VALUE);
	}



	public Double check_distance(T p1, T p2){
		if(p1.equals(p2)) return Double.MAX_VALUE;
		return p1.distance(p2);
	}

}
