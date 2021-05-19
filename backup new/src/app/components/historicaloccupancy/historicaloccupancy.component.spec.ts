import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HistoricaloccupancyComponent } from './historicaloccupancy.component';

describe('HistoricaloccupancyComponent', () => {
  let component: HistoricaloccupancyComponent;
  let fixture: ComponentFixture<HistoricaloccupancyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HistoricaloccupancyComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HistoricaloccupancyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
