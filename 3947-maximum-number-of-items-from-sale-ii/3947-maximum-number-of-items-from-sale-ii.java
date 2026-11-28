class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] freq = new int[n + 1];
        int min = Integer.MAX_VALUE;
        
        // Count frequencies and find the absolute minimum price
        for (int[] item : items) {
            freq[item[0]]++;
            min = Math.min(min, item[1]);
        }
        
        int[] div = new int[n + 1];
        // Calculate how many valid multiples exist for each item ID
        for (int i = 1; i <= n; i++) {
            if (freq[i] == 0) continue;
            for (int j = i; j <= n; j += i) {
                div[i] += freq[j];
            }
            div[i] -= 1;
        }
        
        // Min-heap ordered by item price
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(x[1], y[1]));
        
        // Only add items to the queue if they have valid multiples to pair with
        for (int[] item : items) {
            if (div[item[0]] > 0) {
                pq.add(item);
            }
        }
        
        int copies = 0;
        while (budget >= min) {
            // If buying a pair is cheaper than buying two of the absolute minimum item
            if (!pq.isEmpty() && pq.peek()[1] < 2 * min) {
                int[] item = pq.poll();
                int price = item[1];
                int nc = div[item[0]];
                
                // Take as many pairs as we can afford or have available
                int k = Math.min(nc, budget / price);
                copies += k * 2;
                budget -= k * price;
            } else {
                // Otherwise, just buy the absolute cheapest item repeatedly
                copies += budget / min;
                budget = 0;
            }
        }
        
        return copies;
    }
}