import { Route } from '@angular/compiler/src/core';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/class/user';
import { RegistrationService } from 'src/app/services/registration.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

     user=new User();
     msg='';

  constructor(private _service: RegistrationService, private _router: Router) { }

  ngOnInit() {
  }

  loginForUser(){
this._service.loginUserFromRemote(this.user).subscribe(
  data=>
  {
    console.log("Data received");
    this._router.navigate(['/liveoccupancy']);

  },
  error=>
  {
    console.log("Exception Occured");
    this.msg="Invalid credentials";
  }

)
  }


}
