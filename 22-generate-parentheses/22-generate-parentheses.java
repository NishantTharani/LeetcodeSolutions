class Solution {
    public List<String> generateParenthesis(int n) {
        Queue<String> queue = new LinkedList<>();
        queue.add("()");
        
        for (int i = 1; i < n; i++) {
            int k = queue.size();
            
            for (int j = 0; j < k; j++) {
                String s = queue.poll();
                queue.add("()" + s);
                int a = 0;
                while (s.charAt(a) != ')') {
                    queue.add(s.substring(0, a+1) + "()" + s.substring(a+1, s.length()));
                    a++;
                }
            }
        }
        
        return new ArrayList<String>(queue);
    }
}


/*
Length 1: ()

Length 2: (()) ()()

Length 3: ((()))  (()())  (())()  ()(())  ()()()

Try building each length out of each previous length: but how to avoid duplicates?

One idea: add a () at the start + after each (, stop once we encounter a )
*/