class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int out = w;
        
        PriorityQueue<Project> byCapital = new PriorityQueue<>(new CapitalComparator());
        PriorityQueue<Project> byProfit = new PriorityQueue<>(new ProfitComparator());
        
        for (int i = 0; i < profits.length; i++) {
            Project p = new Project(profits[i], capital[i]);
            byCapital.add(p);
        }
        
        int chosen = 0;
        
        while ((chosen < k) && ((byProfit.size() > 0) || ((byCapital.size() > 0) && (out >= byCapital.peek().capital)))) {
            // Add the projects that are feasible
            while (byCapital.size() > 0 && out >= byCapital.peek().capital) {
                byProfit.add(byCapital.poll());
            }
            
            // Choose the next project
            if (byProfit.size() > 0) {
                out += byProfit.poll().profit;
                chosen++;
            }
        }
        
        return out;
    }
    
    class Project {
        public int profit;
        public int capital;
        
        public Project(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
    }
    
    class ProfitComparator implements Comparator<Project> {
        @Override
        public int compare(Project p1, Project p2) {
            return Integer.compare(p2.profit, p1.profit);
        }
    }
    
    class CapitalComparator implements Comparator<Project> {
        @Override
        public int compare(Project p1, Project p2) {
            return Integer.compare(p1.capital, p2.capital);
        }
    }
}