import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { Todo } from 'src/app/models/Todo';
import { Status } from 'src/app/enums/status';
import { TodoService } from 'src/app/services/todo.service';
import { Priority } from 'src/app/enums/priority';

@Component({
  selector: 'app-add-todo-modal',
  templateUrl: './add-todo-modal.component.html',
  styleUrls: ['./add-todo-modal.component.css']
})
export class AddTodoModalComponent implements OnInit {
  title: string = "";
  description: string = "";
  status: string;
  priority: string = "low";
  @Output() addTodo: EventEmitter<any> = new EventEmitter();

  constructor() { }

  ngOnInit(): void {
  }

  /**
   * identifies the priority of task.
   * @returns priority of task.
   */
  identifyPriority(): Priority {
    let taskPriority: Priority;
    if (this.priority === "low") {
      taskPriority = Priority.LOW;
    } else if (this.priority === "medium") {
      taskPriority = Priority.MEDIUM;
    } else {
      taskPriority = Priority.HIGH;
    }
    return taskPriority;
  }

  /**
   * emit the todo to the parent element.
   */
  onSubmit() {

    // checks if value has been entered or not.
    if ((this.title !== "") && (this.description !== "")) {
      const taskPriority = this.identifyPriority();
      const todo = {
        title: this.title,
        description: this.description,
        status: Status.NEW,
        priority: taskPriority,
        creationDate: new Date(),
        completionDate: null
      };
      this.addTodo.emit(todo);
    }
  }

}
