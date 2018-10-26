#include <iostream>
#include <algorithm>

using namespace std;

int main(int argc, char const *argv[])
{
    int N_number = 0;
    int A_value = 0;
    int B_value = 0;

    cout << "N: " << endl;
    cin >> N_number;

    cout << "A: " << endl;
    cin >> A_value;

    cout << "B: " << endl;
    cin >> B_value;

    

    return 0;
}

int find_common_divisor(int A_value, int B_value, int N_number){
    int common_divisor = 0;
    int temp_value = 0;
    int result = 0;

    if(A_value > B_value)
        std::swap(A_value, B_value);
    
    for(int i = 2; i <= 40000; i++){
        if(A_value % i == 0 && B_value % i == 0)
            common_divisor++;
    }

    return common_divisor;
}

int find 
