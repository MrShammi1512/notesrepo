import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateStudentComponent } from './create-student/create-student.component';

import { StudentListComponent } from './student-list/student-list.component';
import { UpdateStudentComponent } from './update-student/update-student.component';
import { ViewStudentComponent } from './view-student/view-student.component';

const routes: Routes = [
  {path:'students',component:StudentListComponent},
  {path:'create-student',component:CreateStudentComponent},
  {path:'update-student/:roll',component:UpdateStudentComponent},
  {path:'view-student/:roll',component:ViewStudentComponent},
  {path:'', redirectTo:'students', pathMatch:'full'}
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
