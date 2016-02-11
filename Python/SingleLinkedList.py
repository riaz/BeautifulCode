class Node:    
	def __init__(self,data):
		self.data = data;
		self.next = None;


class Linked:

    def printList(self):
        temp = self.first
        while temp:
            print temp.data
            temp = temp.next


	def __init__(self):
		self.first = None


    

if __name__ == '__main__':
    list = Linked()
    
    list.first = Node(10)
    second = Node(20)
    third = Node(30)
    list.first.next = second
    second.next = third

    print list.first.data
    print list.first.next.data
    print list.first.next.next.data
    
    list.printList()
