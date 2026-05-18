import { Routes } from '@angular/router';

import { Login } from './components/login/login';
import { Dashboard } from './components/dashboard/dashboard';
import { CreateTask } from './components/create-task/create-task';
import { EditTask } from './components/edit-task/edit-task';

export const routes: Routes = [

  {
    path: '',
    component: Login
  },

  {
    path: 'dashboard',
    component: Dashboard
  },

  {
    path: 'create',
    component: CreateTask
  },

  {
    path: 'edit/:id',
    component: EditTask
  }

];
