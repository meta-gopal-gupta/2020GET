// Doubly Linked List Implementation.
var node = function(element) {
    this.item = element;
    this.next = null;
    this.prev = null;
}

var linkedList = function() {
    let head = null;
    this.size = 0;
    this.addItem = function(element) {
        var newNode = new node(element);
        if (head == null) {
            head = newNode;
            this.size += 1;
        } else {
            var traverseNode = head;
            while (traverseNode.next != null) {
                traverseNode = traverseNode.next;
            }
            newNode.prev = traverseNode;
            traverseNode.next = newNode;

        }
    }
    this.deleteItem = function(element) {
        var elementFound = false;
        var traverseNode = head;
        while (traverseNode != null) {
            if (traverseNode.item == element) {
                if (traverseNode.prev == null) {
                    head = traverseNode.next;
                } else if (traverseNode.next == null) {
                    traverseNode.prev.next = null;
                } else {
                    traverseNode.prev.next = traverseNode.next;
                    traverseNode.next.prev = traverseNode.prev;
                }
                elementFound = true;
                this.size -= 1;
                break;
            }
            traverseNode = traverseNode.next;
        }

        if (elementFound == true) {
            console.log("Element Deleted Successfully");
        } else {
            console.log("Element not found in the list");
        }
    }
    this.dispalyList = function() {
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
list.dispalyList();
list.deleteItem(20);
list.dispalyList();