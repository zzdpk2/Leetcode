#include <stdio.h>
#include <stdlib.h>

int sum_A(int A[], int low, int high);

int main(int argc, char const *argv[])
{

    int array[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    printf("sum: %d\n", sum_A(array, 0, 9));

    return 0;
}

int sum_A(int A[], int low, int high){
    int sum = 0;

    if(low == high)
        return A[low];

    // int mid = ((low + high) >> 1);
    int mid = (low + high) / 2;

    return ((sum_A(A, low, mid)) + (sum_A(A, mid + 1, high)));
}
