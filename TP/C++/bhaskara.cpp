#include <iostream>
#include <iomanip>
#include <cmath>
#define SUCESSO 0
 
using namespace std;
 
int main() {

    float a, b, c, delta;
    float r1, r2;

    std::cin >> a;
    std::cin >> b;
    std::cin >> c;

    delta = pow(b, 2.0) - (4 * a * c);

    if((delta < 0)||(a == 0)){
        std::cout << "Impossivel calcular\n";
    }
    else{
        r1 = ((b * -1) + sqrt(delta)) / (a * 2);
        r2 = ((b * -1) - sqrt(delta)) / (a * 2);

        std::cout << std::setprecision(5) << std::fixed << "R1 = " << r1 << "\n";
        std::cout << std::setprecision(5) << std::fixed << "R2 = " << r2 << "\n";
    }

    return SUCESSO;
}