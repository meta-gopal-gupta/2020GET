import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CompletedTodosComponent } from './completed-todos.component';

describe('CompletedTodosComponent', () => {
  let component: CompletedTodosComponent;
  let fixture: ComponentFixture<CompletedTodosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CompletedTodosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CompletedTodosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
