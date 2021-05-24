import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from "@angular/material/button";
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { HomeComponent } from './components/home/home.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { LoginComponent } from './components/login/login.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import{MatFormFieldModule} from '@angular/material/form-field';
import{MatInputModule} from '@angular/material/input';
import {MatTableModule } from "@angular/material/table";
import{FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { RegisterComponent } from './components/register/register.component';
import { LiveoccupancyComponent } from './components/liveoccupancy/liveoccupancy.component';
import { HistoricaloccupancyComponent } from './components/historicaloccupancy/historicaloccupancy.component';
import * as Material from "@angular/material/dialog";
import {MatDialogModule} from '@angular/material/dialog';
import { HistorygraphComponent } from './components/historygraph/historygraph.component';


// import { UserComponent } from './components/user/user.component';
// import { LogoutComponent } from './components/logout/logout.component'




@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    HomeComponent,
    DashboardComponent,
    LoginComponent,
    RegisterComponent,
    LiveoccupancyComponent,
    HistoricaloccupancyComponent,
    HistorygraphComponent,
    
  


  ],
  imports: [

    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatToolbarModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    HttpClientModule,
    MatTableModule,
    Material.MatDialogModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
