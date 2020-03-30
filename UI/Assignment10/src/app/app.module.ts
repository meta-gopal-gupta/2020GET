import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from "@angular/forms";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddTodoComponent } from './components/add-todo/add-todo.component';
import { NewTodosComponent } from './components/new-todos/new-todos.component';
import { InProgressTodosComponent } from './components/in-progress-todos/in-progress-todos.component';
import { CompletedTodosComponent } from './components/completed-todos/completed-todos.component';
import { TodoItemComponent } from './components/todo-item/todo-item.component';
import { TodosComponent } from './components/todos/todos.component';
import { AddTodoModalComponent } from './components/add-todo-modal/add-todo-modal.component';
import { EditTodoComponent } from './components/edit-todo/edit-todo.component';

@NgModule({
  declarations: [
    AppComponent,
    AddTodoComponent,
    NewTodosComponent,
    InProgressTodosComponent,
    CompletedTodosComponent,
    TodoItemComponent,
    TodosComponent,
    AddTodoModalComponent,
    EditTodoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
