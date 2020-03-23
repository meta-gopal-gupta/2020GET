var stack = function() {
    this.top = -1;
    this.array = [];
    this.pushItem = function(element) {
        this.array.push(element);
        this.top += 1;
    }
    this.popItem = function() {
        if (this.top == -1) {
            console.log("Stack is empty");
        } else {
            this.array.pop();
            this.top -= 1;
        }
    }
}


list = new stack();
list.pushItem(20);
list.pushItem(40);
list.array;
list.popItem();
list.array;