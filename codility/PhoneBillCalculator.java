import java.util.*;
import java.util.stream.Collectors;



public class App {

    public static void main(String[] args) {
        String INPUT = "00:01:07,400-234-090\n" +
                "00:05:01,701-080-080\n" +
                "00:05:00,400-234-090";
        System.out.print(solution(INPUT));
    }

    public static String solution(String s) {
        // write your code in Java SE 8

        return Integer.toString(new PhoneBillCalculator().calculatePhoneBill(s));
    }
}



class PhoneBillCalculator {


    private static final Comparator<List<CallEntry>> PHONE_CALL_LIST_COMPARATOR = (l1, l2) -> {
        int comparedValue = -1 * l1.stream().map(x -> x.seconds).reduce(0, (x, y) -> x + y)
                .compareTo(l2.stream().map(x -> x.seconds).reduce(0, (x, y) -> x + y));
        return comparedValue == 0
                ? l1.stream().findFirst().get().number.replace("-", "")
                .compareTo(l2.stream().findFirst().get().number.replace("-", ""))
                : comparedValue;
    };

    public int calculatePhoneBill(String csvString) {
        Map<String, List<CallEntry>> collect = Arrays.stream(csvString.split("\r?\n"))
                .map(x -> x.split(","))
                .map(Arrays::asList)
                .map(CallEntry::new) //Stream<CallEntry>
                .collect(Collectors.groupingBy(x -> x.number));

        System.out.println(collect);
        Map<String, Integer> totals = new HashMap<>();
        collect.forEach((s, phoneCalls) -> {
            totals.put(s, phoneCalls.stream().map(c-> c.totalSeconds).reduce(Integer::sum).orElse(0));
        });


        System.out.println(totals);
        return Arrays.stream(csvString.split("\r?\n"))
                .map(x -> x.split(","))
                .map(Arrays::asList)
                .map(CallEntry::new)
                .collect(Collectors.groupingBy(x -> x.number))
                .values()
                .stream()
                .sorted(PHONE_CALL_LIST_COMPARATOR)
                .skip(1)
                .flatMap(List::stream)
                .reduce(0, (curCost, call) -> curCost + call.costCalc() , (curCost, addCost) -> curCost + addCost);
    }

    private static class CallEntry {

        private static final Integer FIVEMINUTES = 300;
        private static final Integer COSTPSEC = 3;
        private static final Integer COSTPMIN = 150;


        String number;
        int hours;
        int minutes;
        int seconds;
        int totalSeconds;

        public String toString(){
            return number + " total: "  +Integer.toString(totalSeconds);
        }

        public int costCalc() {
            if(totalSeconds > FIVEMINUTES){
                return (seconds > 0 ? COSTPMIN : 0) + (minutes * COSTPMIN);
            }
            else{
                return seconds * COSTPSEC;
            }
        }

        CallEntry(List<String> values) {
            number = values.get(1);
            String[] arr = values.get(0).split(":");
            hours = Integer.valueOf(arr[0]);
            minutes = Integer.valueOf(arr[1]);
            seconds = Integer.valueOf(arr[2]);
            totalSeconds = (hours * 3600) + (minutes * 60) + (seconds);
        }
    }
}



//public class App {
//
//    public static void main(String[] args) {
//        int[] array = {3000, 100, 250, 1000};
//        System.out.print(solution(array));
//    }
//
//    public static int solution(int[] array) {
//        //int[] array = {100, 250, 1000, 3000};
//        int[] sorted = Arrays.copyOf(array, array.length);
//        Arrays.sort(sorted);
//        if(array.length < 2) return 0;
//        int total = sorted[0] + sorted[1];
//        if(array.length == 2) return total;
//        for(int i = 2; i < sorted.length; i++){
//            total = sorted[i] + (total*2);
//        }
//        return total;
//    }
//}
