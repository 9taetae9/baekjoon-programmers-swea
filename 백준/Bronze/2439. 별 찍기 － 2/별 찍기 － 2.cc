#include <iostream>

int main(){
    using namespace std;
    int i,j,k,n;
    cin>>n;
    for(i=1; i<n+1; i++){
    	for(k=n; k>i; k--){
    		cout<<" ";
		}
        for(j=0; j<i; j++){
            cout<<"*";
        }
        cout<<"\n";
    }
    return 0;
}