class Solution {
    public List<String> generateParenthesis(int n) {
        Queue<StringBuilder> queue = new LinkedList<>();
        queue.add(new StringBuilder("()"));
        
        for (int i = 1; i < n; i++) {
            int k = queue.size();
            
            for (int j = 0; j < k; j++) {
                StringBuilder sb = queue.poll();
                StringBuilder next = new StringBuilder(sb.toString());
                next.insert(0, "()");
                queue.add(next);
                int a = 0;
                while (sb.charAt(a) != ')') {
                    next = new StringBuilder(sb.toString());
                    next.insert(a+1, "()");
                    queue.add(next);
                    a++;
                }
            }
        }
        
        List<String> out = new ArrayList<String>();
        while (!queue.isEmpty()) {
            out.add(queue.poll().toString());
        }
        return out;
    }
}


/*
Length 1: ()

Length 2: (()) ()()

Length 3: ((()))  (()())  (())()  ()(())  ()()()

Try building each length out of each previous length: but how to avoid duplicates?

One idea: add a () at the start + after each (, stop once we encounter a )
*/