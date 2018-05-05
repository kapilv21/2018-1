package GI;

import java.util.ArrayList;
import java.util.List;
public class A_MergeIntervals {
	public static void main(String[] args) {
		Interval it = new Interval(4, 13);
		insertInterval(createIntervalList(), it);
	}

	public static void insertInterval(List<Interval> intervals,
			Interval newInterval) {
		List<Interval> result = new ArrayList<>();
		for(Interval interval : intervals){
			if(newInterval.start > interval.end){
				result.add(interval);
			}else if(newInterval.end < interval.start){
				result.add(newInterval);
				newInterval = interval;
			}else{ // NOT SURE if ELSE will work for all
				newInterval = new Interval(Math.min(newInterval.start, interval.start), Math.max(newInterval.end, interval.end));
			}
			
			/*if(newInterval.start <= interval.start && newInterval.end >= interval.start){
				newInterval = new Interval(Math.min(newInterval.start, interval.start), Math.max(newInterval.end, interval.end));
				//result.add(newInterval);
			}else if(newInterval.start >= interval.start && newInterval.start <= interval.end){
				newInterval = new Interval(Math.min(newInterval.start, interval.start), Math.max(newInterval.end, interval.end));
			}*/
		}
		result.add(newInterval);
		System.out.println(" interval list ");
		for(Interval interval : result){
			System.out.println(" interval "+interval.start+"   "+interval.end);
		}

	}

	static private List<Interval> createIntervalList() {
		List<Interval> list = new ArrayList<Interval>();
		list.add(new Interval(1, 5));
		list.add(new Interval(7, 10));
		list.add(new Interval(15, 20));
		list.add(new Interval(25, 35));
		System.out.println("Initial interval List");
		return list;
	}

}

class Interval {
	int start;
	int end;

	public Interval() {
		start = 0;
		end = 0;
	}

	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}
