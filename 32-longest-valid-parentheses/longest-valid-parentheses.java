class Solution {
    public int longestValidParentheses(String s) {
        Stack<Character> stack=new Stack<>();
        Stack<Integer> stack2=new Stack<>();
        StringBuilder sb=new StringBuilder(s);
        if(s.length()==0)return 0;
        int max=0,i=0;
        for(char ch:s.toCharArray()){
            if(stack.isEmpty()){
                if(ch==')'){
                    i++;
                    continue;
                }
                stack.push(ch);
                stack2.push(i);
            }
            else{
                if(stack.peek()=='(' && ch==')'){
                    stack.pop();
                    
                    sb.setCharAt(i,'+');
                    sb.setCharAt(stack2.peek(),'+');
                    stack2.pop();
                }
                else if(stack.peek()==')' && ch=='('){
                    stack.clear();
                    stack2.clear();
                    stack.push(ch);
                    stack2.push(i);
                }
                else{
                    stack.push(ch);
                    stack2.push(i);
                }
            }
            i++;
        }
        int c=0;
        for(int j=0;j<sb.length();j++){
            if(sb.charAt(j)=='+'){
                c++;
            }
            else{
                c=0;
            }
            max=Math.max(max,c);
        }
        max=Math.max(max,c);
        return max;
    }
}