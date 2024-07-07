import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;
import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.groupingBy;

public class BitArray implements Clusterable<BitArray>{
	private ArrayList<Boolean> bits;
	private int length;

	//takes in a string of binary values and converts them into a bit Array
	public BitArray(String str){
		String[] split_list = str.split(",");
		this.bits = (ArrayList<Boolean>) Arrays.stream(split_list)
				.map(Boolean::valueOf).collect(Collectors.toList());
	}
	public BitArray(boolean[] bits) {
		this.bits =  (ArrayList<Boolean>)(IntStream.range(0,bits.length).mapToObj(x ->bits[x]).collect(Collectors.toList()));
	}
	public int getLength() {
		return this.bits.size();
	}

	//calculates the hamming distance between two bit arrays.
	@Override
	public double distance(BitArray other) {
		return IntStream.range(0, other.bits.size())
				.filter((i) -> other.bits.get(i) != (bits.get(i))).count();
	}

	public static Set<BitArray> readClusterableSet(String path) throws IOException {
		//a bitArray list of all the bitArrays
		List<BitArray> bitArrays = Files.lines(Paths.get(path)).map(BitArray::new).collect(Collectors.toList());
		//find the size of the longest bitArray in the List
		int max = bitArrays.stream().mapToInt(BitArray::getLength).max().orElse(-1);
		//return a set of all the bitarrays from the list of size max length
		return bitArrays.stream().filter(b -> b.getLength() == max).collect(Collectors.toSet());
	}

	@Override
	public String toString() {
		return bits.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BitArray bitArray = (BitArray) o;
		return bits.equals(bitArray.bits);
	}

	@Override
	public int hashCode() {
		return Objects.hash(bits);
	}
}
