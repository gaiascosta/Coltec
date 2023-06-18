#include <iostream>
#include <iomanip>
#include <string>
#include <cmath>
#define SUCESSO 0
 
using namespace std;
 
int main() 
{
    double salario, taxa;
    std::cin >> salario;

    if (salario <= 400.00)
    {
        taxa = 0.15;
    }
    else if (400.00 < salario && salario <= 800.00)
    {
        taxa = 0.12;
    }
    else if (800.00 < salario && salario <= 1200.00)
    {
        taxa = 0.10;
    }
    else if (1200.00 < salario && salario <= 2000.00)
    {
        taxa = 0.07;
    }
    else
    {
        taxa = 0.04;
    }
    
    std::cout << "Novo salario: " << fixed << setprecision(2) << (salario * taxa + salario) << "\n";
    std::cout << "Reajuste ganho: " << fixed << setprecision(2) << (salario * taxa) << "\n";
    std::cout << "Em percentual: " << fixed << setprecision(0) << (100 * taxa) << " %" << "\n";

    return SUCESSO;
}