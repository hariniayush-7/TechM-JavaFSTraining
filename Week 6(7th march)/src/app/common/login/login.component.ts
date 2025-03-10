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
  errors = { name: '', email: '', phone: '', institution: '', password: '' };

  constructor(private router: Router) {}

  // Toggle between Sign-Up and Login modes
  toggleMode() {
    this.isSignUpMode = !this.isSignUpMode;
    this.errors = { name: '', email: '', phone: '', institution: '', password: '' };  // Reset errors
  }

  validateForm() {
    let isValid = true;
    // Name validation
    if (this.isSignUpMode && !this.user.name.trim()) {
      this.errors.name = 'Please enter your name.';
      isValid = false;
    } else {
      this.errors.name = '';
    }

    // Institution validation
    if (this.isSignUpMode && !this.user.institution.trim()) {
      this.errors.institution = 'Please enter your institution.';
      isValid = false;
    } else {
      this.errors.institution = '';
    }

    // Email validation
    if (!this.user.email.trim()) {
      this.errors.email = 'Please enter your email.';
      isValid = false;
    } else if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(this.user.email)) {
      this.errors.email = 'Please enter a valid email.';
      isValid = false;
    } else {
      this.errors.email = '';
    }

    // Phone validation
    if (this.isSignUpMode && !this.user.phone.trim()) {
      this.errors.phone = 'Please enter your phone number.';
      isValid = false;
    } else if (this.isSignUpMode && !/^\d+$/.test(this.user.phone)) {
      this.errors.phone = 'Phone number must contain only digits.';
      isValid = false;
    } else {
      this.errors.phone = '';
    }

    // Password validation
    if (!this.user.password.trim()) {
      this.errors.password = 'Please enter your password.';
      isValid = false;
    } else {
      this.errors.password = '';
    }

    return isValid;
  }

  onSubmit() {
    if (!this.validateForm()) {
      return;  // Stop if validation fails
    }

    if (this.isSignUpMode) {
      localStorage.setItem('user', JSON.stringify(this.user));
      alert('Sign-Up successful! Please log in.');
      this.isSignUpMode = false;  // Switch to login after sign-up
      this.user.password = '';  // Clear password field for login
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
