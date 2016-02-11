#include <stdio.h>
#include <stdlib.h>

struct node{
	struct node *next;
	int data;
};

void printList(struct node *head){
	while(head != NULL){
		printf("%d\n",head->data);
		head = head->next;
	}
}


int main(){
	struct node  *first,*second,*third;

	first = (struct node *)malloc(sizeof(struct node));

	first->data = 10;
	second = (struct node *)malloc(sizeof(struct node));

	second->data = 20;
	first->next = second;

	third = (struct node *)malloc(sizeof(struct node));

	third->data = 30;
	second->next = third;

	printf("%d\n",first->data); //10
	printf("%d\n",first->next->data); //20
	printf("%d\n",first->next->next->data); //30


	printList(first);
	return 0;
}