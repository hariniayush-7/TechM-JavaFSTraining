import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private loggedInUser: any = null;  // Store logged-in user info

  login(user: any) {
    this.loggedInUser = user;  // Save user info
    localStorage.setItem('user', JSON.stringify(user));  // Optional: Save to localStorage
  }

  logout() {
    this.loggedInUser = null;
    localStorage.removeItem('user');  // Optional: Clear localStorage
  }

  getUser() {
    if (!this.loggedInUser) {
      const savedUser = localStorage.getItem('user');
      this.loggedInUser = savedUser ? JSON.parse(savedUser) : null;
    }
    return this.loggedInUser;
  }

  isLoggedIn() {
    return this.getUser() !== null;
  }
}
