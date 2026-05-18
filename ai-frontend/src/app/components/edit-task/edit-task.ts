import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-edit-task',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    RouterModule
  ],
  templateUrl: './edit-task.html',
  styleUrls: ['./edit-task.css']
})
export class EditTask implements OnInit {

  task: any = {
    id: '',
    title: '',
    description: '',
    status: ''
  };

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private http: HttpClient
  ) {}

  ngOnInit(): void {

    const id = this.route.snapshot.paramMap.get('id');

    this.http.get(
      `http://localhost:8080/api/tasks/${id}`
    ).subscribe((data: any) => {

      this.task = data;
    });
  }

  updateTask() {

    this.http.put(
      `http://localhost:8080/api/tasks/${this.task.id}`,
      this.task
    ).subscribe(() => {

      alert('Issue Updated');

      this.router.navigate(['/dashboard']);
    });
  }
}
