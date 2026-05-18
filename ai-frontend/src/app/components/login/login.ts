import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './login.html',
  styleUrls: ['./login.css']
})
export class Login {

  loginData = {
    username: '',
    password: ''
  };
 constructor(
    private http: HttpClient,
    private router: Router
  ) {}
login() {

    this.http.post('http://localhost:8080/api/auth/login', this.loginData)
      .subscribe({
        next: (response: any) => {

          localStorage.setItem('token', response.token);

          alert('Login Successful');

          this.router.navigate(['/dashboard']);
        },
        error: () => {
          alert('Invalid Username or Password');
        }
      });
  }
}
