#include <iostream>

int main(){
	using namespace std;
	int i,n,sum=0;
	cin>>n;
	for(i=1; i<n+1; i++){
		sum+=i;
	}
	cout<<sum;
	return 0;
}