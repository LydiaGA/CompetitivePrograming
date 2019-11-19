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

    char longerNumber[1000000];
    char shorterNumber[1000000];

    if(strlen(number1) > strlen(number1)){
	longerNumber = number1;
        shorterNumber = number2;
    }else{
	longerNumber = number2;
        shorterNumber = number1;
    }

    int i = 0;
    while(i < strlen(longerNumber)){

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

	if(i > strlen(shorterNumber)){
		summation[i] = longerNumber[strlen(number1) - i - 1];
        }
        i++;
    }

    for (int i = sizeof(summation) / sizeof(summation[0]); i > 0; i--){        
        printf("%d",summation[i-1]);
    }
	
    printf("\n");

    
}


