class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {

        List<Boolean> ans = new ArrayList<>();

        if (prerequisites.length == 0) {
            for (int i = 0; i < numCourses; i++) {
                ans.add(false);
            }

            return ans;
        }

        boolean[] visited = new boolean[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int startCourse = prerequisites[i][0];
            int endCourse = prerequisites[i][1];

            adjList.get(startCourse).add(endCourse);
            inDegree[endCourse]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        List<Set<Integer>> reachable = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            reachable.add(new HashSet<>());
        }

        while (!q.isEmpty()) {
            int curr = q.poll();
            visited[curr] = true;

            for (int nbr : adjList.get(curr)) {
                
                // In-direct reach
                reachable.get(nbr).addAll(reachable.get(curr)); 

                // Direct reach
                reachable.get(nbr).add(curr); 

                inDegree[nbr]--;
                if (inDegree[nbr] == 0) {
                    q.offer(nbr);
                }
            }
        }

        for (int[] query : queries) {
            int prereq = query[0];
            int course = query[1];

            ans.add(reachable.get(course).contains(prereq));
        }

        return ans;

    }
}