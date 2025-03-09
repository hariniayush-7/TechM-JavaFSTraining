// src/app/pages/job-detail/job-detail.component.ts
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { JobService } from '../../services/job.service';
import { Job } from '../../model/job.model';

@Component({
  selector: 'app-job-detail',
  templateUrl: './job-detail.component.html',
  styleUrls: ['./job-detail.component.css']
})
export class JobDetailComponent implements OnInit {
  job: Job | undefined;

  constructor(
    private route: ActivatedRoute,
    private jobService: JobService,
    private router: Router
  ) {}

  ngOnInit(): void {
    const jobId = this.route.snapshot.paramMap.get('id');
    if (jobId) {
      this.jobService.getJobById(+jobId).subscribe((data) => {
        this.job = data;
      });
    }
  }

  applyForJob() {
    const isLoggedIn = localStorage.getItem('isLoggedIn') === 'true';
    if (!isLoggedIn) {
      alert('You need to login to apply for a job.');
    } else {
      alert('Application submitted successfully!');
    }
  }
  
}