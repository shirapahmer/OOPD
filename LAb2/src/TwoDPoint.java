import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class TwoDPoint implements Clusterable<TwoDPoint>{
	double x;
	double y;

	//Take in a point as a string, split it up and convert the string to double
	public TwoDPoint(String str){
		String[] split_list = str.split(",");
		this.x = Double.parseDouble(split_list[0]);
		this.y = Double.parseDouble(split_list[1]);

	}
	public TwoDPoint(double x, double y) {
		this.x = x;
		this.y = y;
	}

	//finds the euclidean distance between two points
	@Override
	public double distance(TwoDPoint other) {
		double ans = (this.x-other.x)*(this.x-other.x) + (this.y-other.y)*(this.y-other.y);
		return Math.sqrt(ans);
	}
	//this takes in a path to a file and returns a set of 2d points
	public static Set<TwoDPoint> readClusterableSet(String path) throws IOException{
			return Files.lines(Paths.get(path))
					.map(TwoDPoint::new).collect(Collectors.toSet());
	}

	@Override
	public String toString() {
		return x + "," + y;
	}

	@Override
	public boolean equals(Object other) {
		TwoDPoint otherP = (TwoDPoint) other;
		return (otherP.x == x && otherP.y == y);
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
}
