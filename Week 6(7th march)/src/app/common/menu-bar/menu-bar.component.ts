import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-menu-bar',
  templateUrl: './menu-bar.component.html',
  styleUrls: ['./menu-bar.component.css']
})
export class MenuBarComponent implements OnInit {
  userName: string | null = null;

  constructor(private router: Router) {}

  ngOnInit(): void {
    const savedUser = localStorage.getItem('user');
    const isLoggedIn = localStorage.getItem('isLoggedIn');

    if (savedUser && isLoggedIn === 'true') {
      const user = JSON.parse(savedUser);
      this.userName = user.name;  // Get username if logged in
    }
  }

  logout() {
    localStorage.removeItem('isLoggedIn');
    this.userName = null;
    this.router.navigate(['/home']);  // Redirect to home on logout
  }
}
