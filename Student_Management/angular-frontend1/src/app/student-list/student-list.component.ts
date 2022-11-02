import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Student } from '../student';
import { StudentService } from '../student.service';


@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {

  students : Student[];
  constructor(private studentService: StudentService, private router: Router ) { }

  ngOnInit(): void {
    // this.students =[{
    //   "roll":123,
    //   "first_name":"dasd",
    //   "last_name":"dfa",
    //   "age":21
    // }];
    this.studentDetails();
  }
  private studentDetails()
  {
    return this.studentService.getAllStudents().subscribe(data=>{this.students=data});
  }
  updateStudent(roll:number)
  {
    this.router.navigate(['update-student',roll]);
  }
  deleteStudent(roll:number)
  {
    this.studentService.deleteStudent(roll).subscribe(data=>{this.studentDetails()});
  }
  viewStudent(roll:number)
  {
    this.router.navigate(['view-student',roll]);
  }

}
