#include <bits/stdc++.h>
using namespace std;

struct GraphNode{
	int label;
	std::vector<GraphNode *> neighbors;
	GraphNode(int x) : label(x) {};
};


//根据题意，可以知道课程图不能成环，若成环，则不可能完成
class Solution {
public:
    bool canFinish(int numCourses,
		std::vector<std::pair<int, int> >& prerequisites) {
		std::vector<GraphNode*> graph;
		std::vector<int> degree;
		for (int i = 0; i < numCourses; i++){
			degree.push_back(0);
			graph.push_back(new GraphNode(i));
		}
		for (int i = 0; i < prerequisites.size(); i++){
			GraphNode *begin = graph[prerequisites[i].second];
			GraphNode *end = graph[prerequisites[i].first];
			begin->neighbors.push_back(end);
			degree[prerequisites[i].first]++;
		}		
		std::queue<GraphNode *> Q;
		for (int i = 0; i < numCourses; i++){
			if (degree[i] == 0){
				Q.push(graph[i]);
			}
		}
		while(!Q.empty()){
			GraphNode *node = Q.front();
			Q.pop();
			for (int i = 0; i < node->neighbors.size(); i++){
				degree[node->neighbors[i]->label]--;
				if (degree[node->neighbors[i]->label] == 0){
					Q.push(node->neighbors[i]);
				}
			}
		}		
		for (int i = 0; i < graph.size(); i++){
			delete graph[i];
		}		
		for (int i = 0; i < degree.size(); i++){
			if (degree[i]){
				return false;
			}
		}
		return true;
    }
};

class Solution {
private:
    vector<vector<int>> edges;
    vector<int> visited;
    bool valid = true;

public:
    void dfs(int u) {
        visited[u] = 1;
        for (int v: edges[u]) {
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            }
            else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        visited[u] = 2;
    }

    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        edges.resize(numCourses);
        visited.resize(numCourses);
        for (const auto& info: prerequisites) {
            edges[info[1]].push_back(info[0]);
        }
        for (int i = 0; i < numCourses && valid; ++i) {
            if (!visited[i]) {
                dfs(i);
            }
        }
        return valid;
    }
};