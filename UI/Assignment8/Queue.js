var queue = function() {
    this.array = [];
    this.enqueue = function(element) {
        this.array.push(element);
    }
    this.dequeue = function() {
        if (this.array.length == 0) {
            console.log("Queue is empty");
        } else {
            this.array.shift();
        }
    }
}


list = new queue();
list.enqueue(20);
list.enqueue(40);
list.array;
list.dequeue();
list.array;