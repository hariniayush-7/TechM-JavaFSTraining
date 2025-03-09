import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Job } from '../model/job.model';

@Injectable({
  providedIn: 'root'
})
export class JobService {
  private apiUrl = 'http://localhost:4500/jobs';  // Your JSON Server URL

  constructor(private http: HttpClient) { }

  getJobs(): Observable<Job[]> {
    return this.http.get<Job[]>(this.apiUrl);
  }
  // src/app/services/job.service.ts
getJobById(id: number): Observable<Job> {
  return this.http.get<Job>(`${this.apiUrl}/${id}`);
}

}
