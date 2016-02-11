/*
	Single-Linked List 

	Its a very basic sequntial data-stucture , which stores elements similar to 
	an array but id dynamic in nature.

	Basic Operations Supported:

	* Add a Node
	* Remove a Node
	* Search a Node

	Time-Complexity:

	While linked-lists have additional storage overhead due to storing pointer reference,
	in addition to data ,they are very efficient in the peformace when it comes to remove an
	element or add a new element, which is not possible in an array without shifting the rest of the elements.

	Insertion :   O(n) 
	Remove    :   O(n)
	Search    :   O(n)
	
	Space Complexity
	Space      :   O(n)

*/

//Node Class 
function Node(data){ 
	this.data = data;
	this.next = null;
}

//Single-Linked List Class
function SLL(){ 
	this.head = null;
}

SLL.prototype = {

	add: function (data){

        //create a new node, place data in
        var node = new Node(value),
        	currNode = self.head;

        //special case: no items in the list yet
        if (this.head === null){
            this.head = node;
        } else {
            currNode = this.head;

            while(currNode.next){
                currNode = currNode.next;
            }

            currNode.next = node;
        }
    
    },

	remove : function(index){  //implementing remove function
			 

        //check for out-of-bounds values
        if (index > -1 && index < this.len){

            var currNode = this.head,
                		   prevNode,
                		   i = 0;

            //special case: removing first item
            if (index === 0){
                this.head = currNode.next;
            } else {

                //finding the right location
                while(i++ < index){
                    prevNode = currNode;
                    currNode = currNode.next;
                }
                //skip over the item to remove
                prevNode.next = currNode.next;
            }
         
            //return the value
            return currNode.data;            

        } else {
            return null;
        }

    },

    find :  function(value){  //implementing find function

    			var currNode = this.head;

				if(currNode){  //empty list
					return -1;
				}

				var pos = -1;
				
				while(currNode){		
					if(currNode.data == value)
						return pos;   // return the position
					pos++;
				}
				
				return -1; // return -1 if not found
	},

	insert : function(value){  //implementing insert  function
				var node = new Node(value);
				var currNode = self.head;

				if(!currNode){ //if the list is still empty
					this.head = node;
					this.len++;
					return node;
				}

				// we loop throught the end of the list ,and add the new node
				while(currNode.next){
					currNode = currNode.next;
				}
				currNode.next = node;
				this.len++;
				return node;
	}

};


//this is the client program to test the above linked-list functionality

function testClient(){

	SSL list = new SSL();
	list.insert(10);

}




