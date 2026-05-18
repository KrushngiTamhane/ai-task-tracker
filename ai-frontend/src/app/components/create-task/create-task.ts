import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
@Component({
  selector: 'app-create-task',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './create-task.html',
  styleUrls: ['./create-task.css']
})
export class CreateTask {

  task = {
    title: '',
    description: '',
    status: 'OPEN'
  };

  constructor(private http: HttpClient,
     private router: Router) {}

  createTask() {

    this.http.post(
      'http://localhost:8080/api/tasks',
      this.task
    ).subscribe(() => {

      alert('Issue Created');
this.router.navigate(['/dashboard']);
      this.task = {
        title: '',
        description: '',
        status: 'OPEN'
      };
    });
  }

  generateAI() {

    const title = this.task.title;

    this.http.get(
      `http://localhost:8080/ai-suggestion?title=${title}`,
      { responseType: 'text' }
    ).subscribe((data) => {

      this.task.description = data;
    });
  }
}
