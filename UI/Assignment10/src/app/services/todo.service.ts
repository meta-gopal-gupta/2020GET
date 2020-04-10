import { Injectable } from '@angular/core';
import { Todo } from '../models/Todo';
import { Status } from '../enums/status';
import { Priority } from '../enums/priority';

@Injectable({
  providedIn: 'root'
})
export class TodoService {
  todos: Todo[];
  currentId: number = 3;

  /**
   * creates some demo tasks.
   */
  constructor() { 
    this.todos = [
      {
        id: 1,
        title: 'First Todo',
        description: 'Demo Todo',
        status: Status.NEW,
        creationDate: new Date(),
        completionDate: new Date(),
        priority: Priority.MEDIUM
      },
      {
        id: 2,
        title: 'Second Todo',
        description: 'Demo Todo',
        status: Status.COMPLETED,
        creationDate: new Date(),
        completionDate: new Date(),
        priority: Priority.LOW
      },
      {
        id: 3,
        title: 'Third Todo',
        description: 'Demo Todo',
        status: Status.IN_PROGRESS,
        creationDate: new Date(),
        completionDate: new Date(),
        priority: Priority.HIGH
      }
    ];
  }

  /**
   *  Gives all the todos.
   *  @returns list of todos.
   */ 
  getTodos(): Todo[] {
    return this.todos;
  }

  /**
   *  Add Todo to the list.
   */
  addTodo(todo: Todo) {
    todo.id = ++this.currentId;
    this.todos.push(todo);
  }

}
