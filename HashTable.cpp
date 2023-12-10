#include <iostream>
#include <unordered_map>
using namespace std;

class node{
    public:
    int  val;
    node*next;
    node(int v, node* p=NULL){
        val = v;
        next = p;
    }
};


const int TSIZE=10;

node* HT[TSIZE];
// [TSIZE];

int myhash(int k) {
	return k%TSIZE;
}

void insert(int k) {
	int i = myhash(k); // i is the hash value of k
	// we try to put k as a new node into position i
	if (HT[i]==NULL) {
		HT[i] = new node(k);
	} else {
		node *q = HT[i];
		while (true) {
			if (k==q->val) return;
			else {
				if (q->next == NULL) break;
				else q = q->next;
			}
		}
		// q is the last item in linked list	
		q->next = new node(k);	
	}
}

void print_linkedlist(node* p) {
	while (p) {
		cout << p->val << "->";
		p = p->next;
	}
	cout << "NULL" << endl;
}

void print_ht() {
	int i;
	for (i=0;i<TSIZE;i++) {
		cout << i << ":";
		print_linkedlist(HT[i]);
	}
}

bool find(int k) {
	int i = myhash(k); // i is the hash value of k
	// we try to put k as a new node into position i
	if (HT[i]==NULL) {
		return false;
	} else {
		node *q = HT[i];
		while (q) {
			if (q->val == k) return true;
			else q=q->next;
		}
		return false;
	}
}

void remove(int k) {
	int i = myhash(k); // i is the hash value of k
	// we try to put k as a new node into position i
	if (HT[i]==NULL) {
		return;
	} else {
		node *p=NULL;
		node *q = HT[i];
		
		while (q) {
			if (q->val == k) { // we should remove q
				if (p==NULL) {
					HT[i] = q->next;
					delete q;
				} else {
					p->next = q->next;
					delete q;
				}
				break;
			} else {
				p = q;
				q = q->next;
			}
		}
	}			
}

void print_ll_numbers(node* p) {
	while (p) {
		cout << p->val << " ";
		p = p->next;
	}
}

void print_hashtable() {
	int i;
	for (i=0;i<TSIZE;i++) {
		print_ll_numbers(HT[i]);
	}
	cout << endl;
}


int main(){
int i;
for (i=0; i<TSIZE;i++) HT[i] = NULL;
insert(1056);
insert(23);
insert(76);
insert(33);
insert(89);
insert(76);

cout << find(333) << endl;



std::unordered_map<int, std::string> myHashTable;
std::unordered_map<std::string, std::string> stringHashTable;

myHashTable.reserve(10);   // sets capacity 


// example svalues with keys for hash table
myHashTable[100] = "Spongebob";    
myHashTable[123] = "Patrick";  
myHashTable[321] = "Sandy";  
myHashTable[555] = "Squidward";  
myHashTable[777] = "Gary";  



// myHashTable.erase(777);

 for (const auto& key : myHashTable) {
        std::cout << "Key: " << key.first 
        << " Value: " << key.second <<
        ", Hashcode: " << myHashTable.hash_function()(key.first) % 10 << std::endl;
    }


// example svalues with keys for hash table
stringHashTable["100"] = "Spongebob";    
stringHashTable["123"] = "Patrick";  
stringHashTable["321"] = "Sandy";  
stringHashTable["555"] = "Squidward";  
// stringHashTable["555"] = "Squidward", "Gary";  //  do this to avoid collision or unordered map will automatically set them to the same key 
stringHashTable["777"] = "Gary";  

 for (const auto& key : stringHashTable) {
        std::cout << "Key: " << key.first 
        << " Value: " << key.second <<
        ", Hashcode: " << stringHashTable.hash_function()(key.first) % 10  << std::endl;
    }// there is a collision , if increase the size i can avoid this , but if not I can make a bucket and turn it into a linked list, also automatically set with unordered maps. 



return 0;




}
