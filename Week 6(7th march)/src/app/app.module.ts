import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { JobListComponent } from './pages/job-list/job-list.component';
import { JobListCardComponent } from './pages/job-list/job-list-card/job-list-card.component';  
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router'; 
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from './pages/home/home.component';
import { AboutComponent } from './pages/about/about.component';
import { MenuBarComponent } from './common/menu-bar/menu-bar.component';
import { AuthGuard } from './services/auth.guard';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './common/login/login.component';
import { JobFilterPipe } from './pipes/job-filter.pipe';  
@NgModule({
  declarations: [
    AppComponent,
    MenuBarComponent, 
    JobListComponent,
    JobListCardComponent,
    HomeComponent,
    AboutComponent, 
    LoginComponent, 
    JobFilterPipe  
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule {}
