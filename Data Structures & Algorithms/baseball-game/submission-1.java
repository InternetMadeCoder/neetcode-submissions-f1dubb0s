class Solution {
    public int calPoints(String[] operations) {
        int score = 0;
        Stack<Integer> stack = new Stack<>();

        for(String op : operations) {
            if(op.equals("D")) {
                score = 2 * stack.peek();
                stack.push(score);
            }
            else if(op.equals("C")) {
                stack.pop();
            } 
            else if(op.equals("+")) {
                int score1 = stack.pop();
                int newScore = stack.peek() + score1;
                stack.push(score1);
                stack.push(newScore);
            }
            else {
                stack.push(Integer.parseInt(op));
            }
        }

        int totalScore = 0;
        for(int num : stack) {
            totalScore += num;
        }
        return totalScore;
    }
}