import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  isSignUpMode = true;  // Toggle between Sign-Up and Login
  user = { name: '', email: '', phone: '', institution: '', password: '' };

  constructor(private router: Router) {}

  toggleMode() {
    this.isSignUpMode = !this.isSignUpMode;
  }

  onSubmit() {
    if (this.isSignUpMode) {
      localStorage.setItem('user', JSON.stringify(this.user));
      alert('Sign-Up successful! Please log in.');
      this.isSignUpMode = false;  // Switch to login after sign-up
    } else {
      const savedUser = JSON.parse(localStorage.getItem('user') || '{}');
      if (
        savedUser.email === this.user.email &&
        savedUser.password === this.user.password
      ) {
        localStorage.setItem('isLoggedIn', 'true');
        alert('Login successful!');
        this.router.navigate(['/home']);  // Redirect to home
      } else {
        alert('Invalid credentials!');
      }
    }
  }
}
