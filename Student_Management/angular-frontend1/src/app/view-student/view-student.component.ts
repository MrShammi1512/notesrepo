import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Student } from '../student';
import { StudentService } from '../student.service';

@Component({
  selector: 'app-view-student',
  templateUrl: './view-student.component.html',
  styleUrls: ['./view-student.component.css']
})
export class ViewStudentComponent implements OnInit {

  roll:number;
  student:Student;
  constructor(private studentService: StudentService,private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.roll=this.route.snapshot.params['roll'];
    this.studentService.getStudentByRoll(this.roll).subscribe(data=>{this.student=data});

  }
  

}
