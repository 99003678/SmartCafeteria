import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/class/user';
import { RegistrationService } from 'src/app/services/registration.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  user=new User();
  msg='';

  constructor(private _service: RegistrationService, private _router: Router) { }

  ngOnInit(): void {
  }

  registerUser()
  {
    this._service.registerUserFromRemote(this.user).subscribe(
      data=>
      {
        console.log("Data received");
        alert("User Successfully Registered");
        this._router.navigate(['/']);
    
      },
      error=>
      {
        console.log("Exception Occured");
        this.msg="Invalid credentials";
    
    
      }
  
    )
}
}

