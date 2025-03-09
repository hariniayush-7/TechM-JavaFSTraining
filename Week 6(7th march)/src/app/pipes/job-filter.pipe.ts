import { Pipe, PipeTransform } from '@angular/core';
import { Job } from '../model/job.model';

@Pipe({
  name: 'jobFilter'
})
export class JobFilterPipe implements PipeTransform {
  transform(jobs: Job[], titleFilter: string = '', salaryFilter: number = 0): Job[] {
    // Return empty if no filters are applied
    if (!titleFilter.trim() && salaryFilter <= 0) {
      return [];
    }

    // Filter based on title and salary
    return jobs.filter(job => 
      (titleFilter ? job.title.toLowerCase().includes(titleFilter.toLowerCase()) : true) &&
      (salaryFilter ? job.salary >= salaryFilter : true)
    );
  }
}
