import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewTodosComponent } from './new-todos.component';

describe('NewTodosComponent', () => {
  let component: NewTodosComponent;
  let fixture: ComponentFixture<NewTodosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewTodosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewTodosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
