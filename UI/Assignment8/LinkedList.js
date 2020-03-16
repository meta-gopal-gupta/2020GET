// Singly Linked List Implementation.
var node = function(element) {
    this.item = element;
    this.next = null;
}

var linkedList = function() {
    let head = null;
    this.size = 0;

    // Add items in the link list
    this.addItem = function(element) {
        let newNode = new node(element);
        if (head == null) {
            head = newNode;
            this.size += 1;
        } else {
            let traverseNode = head;
            while (traverseNode.next != null) {
                traverseNode = traverseNode.next;
            }
            traverseNode.next = newNode;
        }
    }

    // Delete Item from the link list 
    this.deleteItem = function(element) {
        var elementFound = false;
        var traverseNode = head;
        var previousNode = null;
        while (traverseNode != null) {
            if (traverseNode.item == element) {
                if (previousNode == null) {
                    head = traverseNode.next;
                } else {
                    previousNode.next = traverseNode.next;
                }
                elementFound = true;
                this.size -= 1;
                break;
            }
            previousNode = traverseNode;
            traverseNode = traverseNode.next;
        }
        if (elementFound == true) {
            console.log("Element Deleted Successfully");
        } else {
            console.log("Element not found in the list");
        }
    }

    // To traverse the List
    this.traverseList = function() {
        var traverseNode = head;
        while (traverseNode != null) {
            console.log(traverseNode.item);
            traverseNode = traverseNode.next;
        }
    }

}

list = new linkedList();
list.addItem(10);
list.addItem(20);
list.traverseList();
list.deleteItem(20);
list.traverseList();