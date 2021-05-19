import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HistorygraphComponent } from './historygraph.component';

describe('HistorygraphComponent', () => {
  let component: HistorygraphComponent;
  let fixture: ComponentFixture<HistorygraphComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HistorygraphComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HistorygraphComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
