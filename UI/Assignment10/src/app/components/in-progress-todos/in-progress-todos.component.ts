import { Component, OnInit, Input } from '@angular/core';
import { Todo } from 'src/app/models/Todo';

@Component({
  selector: 'app-in-progress-todos',
  templateUrl: './in-progress-todos.component.html',
  styleUrls: ['./in-progress-todos.component.css']
})
export class InProgressTodosComponent implements OnInit {
  @Input() todos: Todo[];

  constructor() { }

  ngOnInit(): void {
    
  }

}
