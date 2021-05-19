import { Component, OnInit } from '@angular/core';
import { OccupancyService } from 'src/app/services/occupancy.service';
import {MatDialog} from "@angular/material/dialog";
import {MatDialogConfig} from "@angular/material/dialog";
import { HistorygraphComponent } from '../historygraph/historygraph.component';

@Component({
  selector: 'app-historicaloccupancy',
  templateUrl: './historicaloccupancy.component.html',
  styleUrls: ['./historicaloccupancy.component.css']
})
export class HistoricaloccupancyComponent implements OnInit {

  historicalDataDining=null;
  historicalDataService=null;

  historylasthourdiningdata=null;
  historylasthourservicedata=null;

  constructor(private occupancyService: OccupancyService,private dialog:MatDialog) {
    this.getHistoricalDataDiningDetails();
    this.getHistoricalDataServiceDetails();
    this.historylasthourdining();
    this.historylasthourservice();
   }

  ngOnInit(): void {
  }
  getHistoricalDataDiningDetails(){
    this.occupancyService.getHistoricalDataDining().subscribe(
      (resp)=>{
        console.log(resp);
        this.historicalDataDining=resp;
      },
      (err)=>{
        console.log(err);
      }
    );
  }


  getHistoricalDataServiceDetails(){
    this.occupancyService.getHistoricalDataService().subscribe(
      (resp)=>{
        console.log(resp);
        this.historicalDataService=resp;
      },
      (err)=>{
        console.log(err);
      }
    );
  }

  historylasthourdining(){
    this.occupancyService.gethistlastdin().subscribe(
      (resp)=>{
        console.log(resp);
        this.historylasthourdiningdata=resp;
      },
      (err)=>{
        console.log(err);
      }
    );
  }

  historylasthourservice(){
    this.occupancyService.gethistlastser().subscribe(
      (resp)=>{
        console.log(resp);
        this.historylasthourservicedata=resp;
      },
      (err)=>{
        console.log(err);
      }
    );
  }


  onCreate(){
    const dialogConfig=new MatDialogConfig();
    dialogConfig.autoFocus=true;
    dialogConfig.width="70%";
this.dialog.open(HistorygraphComponent,dialogConfig);

  }
}
