import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { HistoricaloccupancyComponent } from './components/historicaloccupancy/historicaloccupancy.component';
import { HomeComponent } from './components/home/home.component';
import { LiveoccupancyComponent } from './components/liveoccupancy/liveoccupancy.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';

// import { LogoutComponent } from './components/logout/logout.component';
// import { RegistrationComponent } from './components/registration/registration.component';
// import { UserComponent } from './components/user/user.component';


const routes: Routes = [
  {
    path:'',
    component:LoginComponent,
    pathMatch:'full',
  },

  {
path:"homepage",
component:HomeComponent,
pathMatch:"full",

  },
  {
  path:"dashboard",
component:DashboardComponent,
pathMatch:"full",

  },
  {
    path:"registration",
  component:RegisterComponent,
  pathMatch:"full"
    },

      {
        path:'liveoccupancy',
        component:LiveoccupancyComponent,
        pathMatch:'full',
      },
    
        {
          path:'historicaloccupancy',
          component:HistoricaloccupancyComponent,
          pathMatch:'full',
        },
    
 

];




@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
