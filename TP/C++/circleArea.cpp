#include <iostream>
#include <iomanip>
#include <cmath>
 
using namespace std;
 
int main() {
 
    double pi = 3.14159, r;

    std::cin >> r;
    std::cout << std::setprecision(4) << std::fixed << "A=" << (pow(r, 2.0)*pi) << "\n";

    return 0;
}