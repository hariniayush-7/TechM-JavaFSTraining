import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { JobListComponent } from './pages/job-list/job-list.component';
import { AboutComponent } from './pages/about/about.component';
import { JobDetailComponent } from './pages/job-detail/job-detail.component';
import { AuthGuard } from './services/auth.guard';    // Import AuthGuard
import { LoginComponent } from './common/login/login.component'; 

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },  
  { path: 'home', component: HomeComponent },           
  { path: 'about', component: AboutComponent },           
  { path: 'jobs', component: JobListComponent }, 
  { path: 'login', component: LoginComponent },
  { 
    path: 'job-detail/:id', 
    component: JobDetailComponent, 
    canActivate: [AuthGuard]     // 🚨 Protect this route!
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
