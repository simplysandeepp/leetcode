class Solution {
    private int originalArray [] = null;
    private int shuffledArray [] = null;
    private Random random = null;
    
    public Solution(int[] nums) {
        this.originalArray = nums.clone();
        this.shuffledArray = nums;
        this.random = new Random();
    }
    
    public int[] reset() {
        return this.originalArray;    
    }
    
    public int getRandomIndex(int start , int end) {
        int randomNumber = this.random.nextInt(end - start + 1);
        return start + randomNumber;
    }
    
    public int[] shuffle() {
        int totalNumbers = this.shuffledArray.length;
        for(int index = 0; index < totalNumbers; index++) {
            int randomIndex = getRandomIndex(index , totalNumbers - 1);
            int temp = this.shuffledArray[randomIndex];
            this.shuffledArray[randomIndex] = this.shuffledArray[index];
            this.shuffledArray[index] = temp;

        }
        return this.shuffledArray;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */