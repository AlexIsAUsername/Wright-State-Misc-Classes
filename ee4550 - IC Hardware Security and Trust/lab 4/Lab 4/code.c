#include <stdio.h>
#include <limits.h>

heap_overflow(){
    char* nums = malloc(2*sizeof(char));
    nums[0] = '0';
    nums[1] = '1';
    int* outside = &nums[1]+1;
    *outside = '2';
    printf("Before %d\n",*outside);
    nums[2] = '3';
    printf("After %d\n",*outside);
}

integer_overflow(){
    int num = INT_MAX;
    printf("Before %d\n", num);
    ++num;
    printf("After %d\n", num);
}

stack_overflow(){
    char nums[2] = {'0','1'};
    int* outside = &nums[1]+1;
    *outside = '2';
    printf("Before %d\n",*outside);
    nums[2] = '3';
    printf("After %d\n",*outside);
}

int main(int argc, char const *argv[])
{
    printf("Heap Overflow\n");
    heap_overflow();
    printf("\nInteger Overflow\n");
    integer_overflow();
    printf("\nStack Overflow\n");
    stack_overflow();
    }
