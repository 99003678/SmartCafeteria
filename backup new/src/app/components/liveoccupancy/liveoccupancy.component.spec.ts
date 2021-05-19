import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LiveoccupancyComponent } from './liveoccupancy.component';

describe('LiveoccupancyComponent', () => {
  let component: LiveoccupancyComponent;
  let fixture: ComponentFixture<LiveoccupancyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LiveoccupancyComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LiveoccupancyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
