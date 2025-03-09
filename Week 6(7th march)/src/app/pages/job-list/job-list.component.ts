import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { JobService } from '../../services/job.service';
import { Job } from '../../model/job.model';

@Component({
  selector: 'app-job-list',
  templateUrl: './job-list.component.html',
})
export class JobListComponent implements OnInit {
  jobs: Job[] = [];
  titleFilter: string = '';   // Define titleFilter here
  salaryFilter: number = 0;   // Define salaryFilter here
  constructor(private jobService: JobService, private router: Router) {}

  ngOnInit(): void {
    this.jobService.getJobs().subscribe((data) => {
      this.jobs = data;
    });
  }
  viewJobDetails(id: number): void {
    this.router.navigate(['/job-detail', id]);
  }
  
}