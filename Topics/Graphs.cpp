#include <iostream>
#include <map>
#include <set>
#include <unordered_map>
#include <queue>
using namespace std;


// Given a maze represented with a two dimensional array of nxn size,
// with (0,0) the entrance, and (n-1,n-1) the exit
// Return the length of the shortest path between (0,0) and (n-1,n-1)
// If path doesn't exist, return -1
// Example 1:
// 0 0 0
// 0 1 0
// 0 0 0
// Return 4. (It takes 4 steps to go from (0,0) to (2,2))
// Example 2:
// 0 1 1 0
// 0 0 1 0
// 1 0 0 1
// 0 0 1 0
// Return -1. (there is no path from (0,0) to (3,3))
// testing
int maze_dist(bool **maze, int n) {
  // Your code
  // checking if the entrance or exit is blocked
  if (maze[0][0] == 1 || maze[n - 1][n - 1] == 1) {
    return -1;
  }

  // Define possible movements: up,down, left, right
  int dx[] = {-1, 1, 0, 0};
  int dy[] = {0, 0, -1, 1};

  // queue for bfs
  queue<point> queuer;

  // starting from the entrance
  queuer.push({0, 0, 0});

  maze[0][0] = 1;

  while (!queuer.empty()) {
    point current = queuer.front();
    queuer.pop();

    // check if it reaches the exit
    if (current.x == n - 1 && current.y == n - 1) {
      return current.dist;
    }

    // explore all possible moves
    for (int i = 0; i < 4; i++) {
      int new_x = current.x + dx[i];
      int new_y = current.y + dy[i];

      // check if the new position is valid and  not visted
      if (new_x >= 0 && new_x < n && new_y >= 0 && new_y < n &&
          maze[new_x][new_y] == 0) {

        maze[new_x][new_y] = 1;

        queuer.push({new_x, new_y, current.dist + 1});
      }
    }
  }
  // else if there is no path return -1.
  return -1;
}


const int n = 5; 


bool maze[n][n] = {0,0,0,0,0,
                   0,1,1,1,1,
                   0,1,0,0,0,
                   0,1,1,0,0};


// checks to see if the movement is within the graph and legal
bool islegal(int x, int y)  {
if (x>=0 && y>= 0 && x<n && y<n && maze[x][y] == 0) return true;
else return false;
}





int main(){
    queue<pair<int,int>>  Queuer;
    set<pair<int,int>> Memory; // to remember where you've been.
    map<pair<int,int>, pair<int,int>>  from;
    // cout  << maze[1][3]  << '\n';
    Queuer.push(make_pair(0,0));
    while(true) {
        pair<int,int> current = Queuer.front();
        Queuer.pop();
        // cout << current.first << ".  " << current.second << '\n';
        int x,y;
        x = current.first;
        y = current.second;
        Memory.insert(make_pair(x,y));
        if (x==n-1 && y==n-1){
            cout << "found solution!" << '\n';
              int fx,fy,cx,cy;
              cx = n-1; cy = n-1;
            while (true){
              fx = from[make_pair(cx,cy)].first;
              fy = from[make_pair(cx,cy)].second;
            }
            break;
        }
    
       
        from[make_pair(x-1,y)] = make
        // check where we can reach immediately from location x and y. 
        // try left: (x-1,y)
        if (islegal(x-1,y) && Memory.find(make_pair(x-1,y)) == Memory.end()) Queuer.push(make_pair(x-1,y)) {
             Q.push(make_pair(x-1,y));
             from[make_pair(x-1,y)] = make_pair(x,y);
        }

        if (islegal(x+1,y) && Memory.find(make_pair(x+1,y)) == Memory.end()) Queuer.push(make_pair(x+1,y)){
             Q.push(make_pair(x+1,y));
             from[make_pair(x+1,y)] = make_pair(x,y);
        }
        if (islegal(x,y-1) && Memory.find(make_pair(x,y-1)) == Memory.end()) Queuer.push(make_pair(x,y-1)){
             Q.push(make_pair(x,y-1));
             from[make_pair(x,y-1)] = make_pair(x,y);
        }
        if (islegal(x,y+1) && Memory.find(make_pair(x,y+1)) == Memory.end()) Queuer.push(make_pair(x,y+1)){
             Q.push(make_pair(x,y+1));
             from[make_pair(x,y+1)] = make_pair(x,y);
        }
                            
    }
    return 0;

}