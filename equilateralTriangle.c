#include<stdio.h>

void printSpaces(int numberOfRows, int counter){
	for(int j = 1; j <= numberOfRows - counter; j++){
		printf(" ");	
	}
}

void printStars(int numberOfRows, int counter){
	for(int j = 1; j <= (2 * counter) - 1; j++){
		printf("*");	
	}
}

int main(){
	int numberOfRows;
	printf("Input: ");
	scanf("%d", &numberOfRows);
	for(int i = 1; i <= numberOfRows; i++){
		printSpaces(numberOfRows, i);
		printStars(numberOfRows, i);
		printf("\n");
	}
}
