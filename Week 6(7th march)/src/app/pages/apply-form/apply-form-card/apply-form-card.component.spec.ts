import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApplyFormCardComponent } from './apply-form-card.component';

describe('ApplyFormCardComponent', () => {
  let component: ApplyFormCardComponent;
  let fixture: ComponentFixture<ApplyFormCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ApplyFormCardComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ApplyFormCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
