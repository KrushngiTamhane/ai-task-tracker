import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterModule } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './dashboard.html',
  styleUrls: ['./dashboard.css']
})
export class Dashboard implements OnInit {

  tasks: any[] = [];

  constructor(
    private http: HttpClient,
    private router: Router
  ) {}

  ngOnInit(): void {

    this.loadTasks();
  }

  loadTasks() {

    this.http.get<any[]>(
      'http://localhost:8080/api/tasks'
    ).subscribe({

      next: (data) => {

        console.log(data);

        this.tasks = data;
      },

      error: (err) => {

        console.log(err);

        alert('Error loading tasks');
      }
    });
  }

  deleteTask(id: number) {

    const confirmDelete = confirm(
      'Are you sure you want to delete this task?'
    );

    if(confirmDelete) {

      this.http.delete(
        `http://localhost:8080/api/tasks/${id}`
      ).subscribe(() => {

        this.loadTasks();
      });
    }
  }

  logout() {

    localStorage.removeItem('token');

    this.router.navigate(['/']);
  }
}
