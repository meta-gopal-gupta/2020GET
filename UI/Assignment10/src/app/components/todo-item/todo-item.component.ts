import { Component, OnInit, Input } from '@angular/core';
import { Todo } from 'src/app/models/Todo';
import { Status } from 'src/app/enums/status';
import { Priority } from 'src/app/enums/priority';

@Component({
  selector: 'app-todo-item',
  templateUrl: './todo-item.component.html',
  styleUrls: ['./todo-item.component.css']
})
export class TodoItemComponent implements OnInit {
  @Input() todo: Todo;

  constructor() { }

  ngOnInit(): void {

  }

  findPriority(): boolean[] {
    let isPriorityLow = false;
    let isPriorityMedium = false;
    let isPriorityHigh = false;
    
    if (this.todo.status === Status.NEW) {
      isPriorityLow = (this.todo.priority === Priority.LOW);
      isPriorityMedium = (this.todo.priority === Priority.MEDIUM);
      isPriorityHigh = (this.todo.priority === Priority.HIGH);
    }
    return [isPriorityLow, isPriorityMedium, isPriorityHigh];
  }

  /**
   * set the css classes to the task element.
   * @returns the object containing the css classes.
   */
  setClasses(): Object {
    
    let isPriorityLow: boolean;
    let isPriorityMedium: boolean;
    let isPriorityHigh: boolean;

    [isPriorityLow, isPriorityMedium, isPriorityHigh] = this.findPriority();

    const classes = {
      'text-light': true,
      'status-new': this.todo.status === Status.NEW,
      'status-in-progress': this.todo.status === Status.IN_PROGRESS,
      'status-completed': this.todo.status === Status.COMPLETED,
      'px-2': true,
      'py-1': true,
      'my-2': true,
      'tune-border': true,
      'priority-low': isPriorityLow,
      'priority-medium': isPriorityMedium,
      'priority-high': isPriorityHigh
    };
    return classes;
  }

}
