import java.util.*;
import java.util.stream.Collectors;
import java.math.*;

class BuySell {
    int buy,sell;
    int dayBuy,daySell;
  
    // constructor
    BuySell(int buy,int sell, int dayBuy, int daySell)
    {
        this.buy = buy;
        this.sell = sell;
        this.dayBuy = dayBuy;
        this.daySell = daySell;
    }
}

public class Main {

private static ArrayList<BuySell> allPossibleDeals(int[] arr) {
ArrayList<BuySell> buySells = new ArrayList<BuySell>();
for (int i = 0; i < arr.length - 2; ++i) {
int buy = arr[i];
for (int j = i + 2; j < arr.length; ++j) {
int sell = arr[j];
buySells.add(new BuySell(buy, sell,i,j));
}
}
return buySells;
}
    public static void main(String[] args) throws Exception {
        // Your code here!
        int arr[] = {7,8,9,2,5,4,8,5,6,25};
      ArrayList<BuySell> deals =  allPossibleDeals(arr);
      
      
Optional<BuySell> bestDeal = deals.stream().collect(
Collectors.maxBy(
(t1, t2) -> Integer.valueOf(t1.sell - t1.buy).compareTo(Integer.valueOf(t2.sell - t2.buy))
)
);
System.out.println(bestDeal.get().buy); // best price to but
System.out.println(bestDeal.get().sell); // best price to sell
System.out.println(bestDeal.get().dayBuy); // best day to buy
System.out.println(bestDeal.get().daySell); // best day to sell
System.exit(0);
    }
}
