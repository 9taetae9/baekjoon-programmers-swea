#include <iostream>

using namespace std;

int main() {
	int N, M;
	cin >> N >> M; //N행 M열
	int nums[301][301];
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> nums[i][j];
		}
	}

	int K;
	cin >> K; //합을 구할 부분의 개수
	int i, j, x, y;//(1 ≤ i ≤ x ≤ N, 1 ≤ j ≤ y ≤ M)
	for (int p = 0; p < K; p++) {
		int sum = 0;
		cin >> i >> j >> x >> y;
		for (int o = i - 1; o < x; o++) {
			for (int r = j - 1; r < y; r++) {
				sum += nums[o][r];
			}
		}
		cout << sum << '\n';
	}
	return 0;
}