#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

#define V 6

int minDist(int dist[], int final[])
{
    int min = INT_MAX, min_index;
    for (int v = 0; v < V; v++)
    {
        if (final[v] == 0 && dist[v] <= min)
        {
            min = dist[v];
            min_index = v;
        }
    }
    return min_index;
}

void dijkstra(int graph[V][V], int src)
{
    int final[V], dist[V], path[V];
    for (int i = 0; i < V; i++)
    {
        dist[i] = INT_MAX;
        final[i] = 0;
        path[i] = -1;
    }
    dist[src] = 0;
    for (int count = 0; count < V - 1; count++)
    {
        int u = minDist(dist, final);
        final[u] = 1;
        for (int v = 0; v < V; v++)
        {
            if (!final[v] && graph[u][v] && dist[u] != INT_MAX && dist[u] + graph[u][v] < dist[v])
            {
                dist[v] = dist[u] + graph[u][v];
                path[v] = u;
            }
        }
    }
    printf("Vertex\tDistance from Source\tPath\n");
    for (int i = 0; i < V; i++)
    {
        printf("%d\t%d\t\t", i, dist[i]);
        printPath(path, i);
        printf("\n");
    }
}

void printPath(int path[], int j)
{
    if (path[j] == -1)
    {
        printf("%d", j);
        return;
    }
    printPath(path, path[j]);
    printf(" -> %d", j);
}

int main(){
    int graph[V][V] = { { 0, 7, 9, 0, 0, 14 },
                        { 7, 0, 10, 15, 0, 0 },
                        { 9, 10, 0, 11, 0, 2 },
                        { 0, 15, 11, 0, 6, 0 },
                        { 0, 0, 0, 6, 0, 9 },
                        { 14, 0, 2, 0, 9, 0 } };
    dijkstra(graph, 0);
    return 0;
}