import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ParqueaderosListComponent } from './parqueaderos-list.component';

describe('ParqueaderosListComponent', () => {
  let component: ParqueaderosListComponent;
  let fixture: ComponentFixture<ParqueaderosListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ParqueaderosListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ParqueaderosListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
