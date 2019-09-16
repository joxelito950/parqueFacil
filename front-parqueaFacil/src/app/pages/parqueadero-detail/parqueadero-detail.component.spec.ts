import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ParqueaderoDetailComponent } from './parqueadero-detail.component';

describe('ParqueaderoDetailComponent', () => {
  let component: ParqueaderoDetailComponent;
  let fixture: ComponentFixture<ParqueaderoDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ParqueaderoDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ParqueaderoDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
