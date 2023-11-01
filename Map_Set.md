# Map and Set 

### very common and useful data structures 




````c++
#include <set>
#include <iostream>
#include <map>
using namespace std;

int main(){
    set<int> S;

tree_node* root=NULL;
cons int n = 100000;
int i;
// strand(time(NULL)) // using time to make true random numbers 
// rand () generates random numbers with integers 1-10.
t1 = time(NULL);
for (i=0; i<n ;i++){
    int k = rand();

    // cout << k << endl;  

    // root = insert(root,k);

    S.insert(k);
}
time_t t2 = time(NULL);
cout << "time spent " << t2-t1 << '\n';
// in_traversal(root); cout << endl;
cout << "hieght of tree " << height(root) << '\n';



// iterator using set function
// for each loop with auto funnction to detect variable type automatically. 
for (auto x:S)  {   
    cout << x << ", ";
}
cout <<'\n';



// iterator , iterates whole data structure.
//     set<int>::iterator it;
//     for(it=S.begin();it!=S.end()){
//         cout << *it << ", ";
//     }
// cout << endl;>>





}




````

# MAP

````c++
#include <set>
#include <iostream>
#include <map>
using namespace std;








int main(){
    map<string, double> GPA;
    // nodes in tree based on name 
    GPA("alice") = 3.5;      // insert 
    GPA("bob") = 2.8;     // insert 
    GPA("alice") = 3.7;      // updates alices

   // currently two nodes 

}
````