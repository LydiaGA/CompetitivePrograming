#include <stdio.h>
#include <string.h>
void main(){   
 
    char number1[1000000];
    char number2[1000000];

    printf("Enter the first number:");
    scanf("%s", number1);
    printf("Enter the second number:");
    scanf("%s", number2);

    int summation[strlen(number1) + 1];
    int carry = 0;
    int valueOfZero = 48;

    int i = 0;
    while(i < strlen(number1)){

        char num1LastDigit = number1[strlen(number1) - i - 1];        
        char num2LastDigit = number2[strlen(number2) - i - 1];

        int digitSum;

        if(carry > 0){
             digitSum = num1LastDigit + num2LastDigit - 2 * valueOfZero + carry; 
        }
        else{
             digitSum = num1LastDigit + num2LastDigit - 2 * valueOfZero;
        }
        
        if(digitSum / 10 > 0){
            carry = digitSum / 10;
            summation[i] = digitSum % 10;
            if(i == strlen(number1) - 1){
		summation[i + 1] = carry;
            }
            
        }
        else{
            summation[i] = digitSum;
            
        }

        i++;
    }

    for (int i = sizeof(summation) / sizeof(summation[0]); i > 0; i--){        
        printf("%d",summation[i-1]);
    }
	
    printf("\n");

    
}


