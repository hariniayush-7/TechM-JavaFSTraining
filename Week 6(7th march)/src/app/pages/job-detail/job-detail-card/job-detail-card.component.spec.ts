import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JobDetailCardComponent } from './job-detail-card.component';

describe('JobDetailCardComponent', () => {
  let component: JobDetailCardComponent;
  let fixture: ComponentFixture<JobDetailCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [JobDetailCardComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(JobDetailCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
