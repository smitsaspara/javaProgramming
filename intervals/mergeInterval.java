package intervals;

import java.util.LinkedList;
import java.util.List;

import static java.util.Comparator.comparingInt;

public class mergeInterval {

    public static class Interval {
    
        int start;
        int end;

        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }


    //inserting interval to current intervals
    List<Interval> insert(List<Interval> intervals, Interval newInterval){

        if (intervals == null || intervals.isEmpty()) {
            return intervals;
        }

        List<Interval> result = new LinkedList<>();
        
        int i = 0;
        
        while (i < intervals.size() && intervals.get(i).end < newInterval.start ) {
            result.add(intervals.get(i));
            i++;
        }

        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            Interval current = intervals.get(i);

            newInterval.start = Math.min(current.start , newInterval.start);
            newInterval.end  = Math.max(current.end, newInterval.end);

            i++;
        }

        result.add(newInterval);

        while (i < intervals.size()) {
            result.add(intervals.get(i));
            i++;
        }
        return result;
    }

    //merge intervals
    List<Interval> merge( List<Interval> intervals){

        if (intervals.size() < 2) {
            return intervals;
        }

        intervals.sort(comparingInt(interval -> interval.start));

        List<Interval> mergedIntervals = new LinkedList<>();

        Interval inter = intervals.get(0);

        int start = inter.start;

        int end = inter.end;

        for(int i = 1; i < intervals.size() ; i++){
            Interval current = intervals.get(i);
            if (current.start <= end ) {
                end = Math.max(end, current.end);
            }
            else{
                mergedIntervals.add(new Interval(start, end));
                start = current.start;
                end = current.end;
            }
        }

        mergedIntervals.add(new Interval(start, end));

        return mergedIntervals;
    }

    public static void main(String[] args) {

        mergeInterval mi = new mergeInterval();
        List<Interval> inter = new LinkedList<>();

        //inserting an interval in existing sorted list of intervals based on start
        // inter.add(new Interval(0, 1));
        // inter.add(new Interval(3, 5));
        // inter.add(new Interval(7, 8));
        // inter.add(new Interval(9, 10));

        // List<Interval> mergedInterval = mi.insert(inter, new Interval(2, 6));

        // for (Interval a : mergedInterval) {
        //     System.out.println(a.start + "," + a.end);
        // }
        
        //merged existing unsorted intervals 
        List<Interval> intervals1 = new LinkedList<>();
        intervals1.add(new Interval(6, 7));
        intervals1.add(new Interval(2, 4));
        intervals1.add(new Interval(5, 9));
        List<Interval> merge1 = mi.merge(intervals1);
        for (Interval a : merge1) {
             System.out.println(a.start + "," + a.end);
        }

    }

}
