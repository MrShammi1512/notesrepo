import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Student } from '../student';
import { StudentService } from '../student.service';

@Component({
  selector: 'app-update-student',
  templateUrl: './update-student.component.html',
  styleUrls: ['./update-student.component.css']
})
export class UpdateStudentComponent implements OnInit {

  roll:number;
  student:Student=new Student();

  constructor(private studentService :StudentService, private router:ActivatedRoute,private route:Router) { }

  ngOnInit(): void {
    this.roll=this.router.snapshot.params['roll'];
    this.studentService.getStudentByRoll(this.roll).subscribe(data=>{this.student=data;
    }, error=>console.log(error));
    
  }
  onSubmit()
  {
    this.updateStudent();
    console.log(this.student);
  }
  updateStudent()
  {
    this.studentService.updateStudent(this.roll,this.student).subscribe(data=>
      {this.goToStudentList()},
      error=>console.log(error));
      
  
  }
  goToStudentList()
  {
  this.route.navigate(['/students']);
  }

}
