import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InProgressTodosComponent } from './in-progress-todos.component';

describe('InProgressTodosComponent', () => {
  let component: InProgressTodosComponent;
  let fixture: ComponentFixture<InProgressTodosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InProgressTodosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InProgressTodosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
