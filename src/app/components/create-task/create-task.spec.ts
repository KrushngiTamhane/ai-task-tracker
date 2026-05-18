import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { TaskService } from '../../services/task';
import { Task } from '../../models/task';

@Component({
  selector: 'app-create-task',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './create-task.html',
  styleUrl: './create-task.css',
})
export class CreateTask {
  task: Task = {
    title: '',
    description: '',
    status: 'Pending',
  };

  private taskService = inject(TaskService);
  private router = inject(Router);

  createTask(): void {
    this.taskService.createTask(this.task).subscribe(() => {
      this.router.navigate(['/']);
    });
  }
}
