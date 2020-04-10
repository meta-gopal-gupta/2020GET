import { Component, OnInit, Input } from '@angular/core';
import { Todo } from 'src/app/models/Todo';

@Component({
  selector: 'app-new-todos',
  templateUrl: './new-todos.component.html',
  styleUrls: ['./new-todos.component.css']
})
export class NewTodosComponent implements OnInit {
  @Input() todos: Todo[];

  constructor() {  }

  ngOnInit(): void {
    
  }
}
