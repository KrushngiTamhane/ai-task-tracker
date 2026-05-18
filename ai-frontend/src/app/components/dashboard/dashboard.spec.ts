import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterLink } from '@angular/router';
import { TaskService } from '../../services/task';
import { Task } from '../../models/task';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.css',
})
export class Dashboard implements OnInit {
  tasks: Task[] = [];
  private taskService = inject(TaskService);
  private router = inject(Router);

  ngOnInit(): void {
    this.loadTasks();
  }

  loadTasks(): void {
    this.taskService.getTasks().subscribe((data) => {
      this.tasks = data;
    });
  }

  deleteTask(id: number | undefined): void {
    if (!id) return;

    this.taskService.deleteTask(id).subscribe(() => {
      this.loadTasks();
    });
  }

  editTask(id: number | undefined): void {
    if (!id) return;
    this.router.navigate(['/edit', id]);
  }
}
