import { Component, Input } from '@angular/core';
import { Job } from '../../../model/job.model';

@Component({
  selector: 'app-job-list-card',
  templateUrl: './job-list-card.component.html',
})
export class JobListCardComponent {
  @Input() job!: Job;
}
