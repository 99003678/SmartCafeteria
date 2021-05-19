import { Component, Inject, NgZone, PLATFORM_ID } from '@angular/core';
import { isPlatformBrowser } from '@angular/common';

// amCharts imports
import * as am4core from '@amcharts/amcharts4/core';
import * as am4charts from '@amcharts/amcharts4/charts';
import am4themes_animated from '@amcharts/amcharts4/themes/animated';
import { OccupancyService } from 'src/app/services/occupancy.service';

am4core.useTheme(am4themes_animated);


@Component({
  selector: 'app-liveoccupancy',
  templateUrl: './liveoccupancy.component.html',
  styleUrls: ['./liveoccupancy.component.css']
})


export class LiveoccupancyComponent {

  private chart : am4charts.XYChart;
  private data:object[]=null;
  responseData = null;
  responseDataa = null;
  lastOccupancyDetails=null;
  lastServiceOccupancyDetails=null;
  newResponse;

  constructor(private zone:NgZone, private liveService:OccupancyService){
    this.getCurrentOccupancy(); 
    this.getLastOccupancyDetails();
    this.getServiceOccupancy();
    this.getLastServiceOccupancyDetails();
  };
  
  //for live dining occupancy
  getCurrentOccupancy(){
    this.liveService.getCurrentAverageDining().subscribe(
      (resp)=>{
        console.log(resp);
        this.responseData=resp;
        // this.newResponse=JSON.stringify(this.responseData)

        // console.log(this.newResponse)
       
        //console.log(JSON.parse(this.newResponse))
 
      // let obj = JSON.parse(this.newResponse);
      // let objarr=Object.values(obj.count)
      // let objKeys = Object.keys(obj);

      // console.log(objKeys)

        this.ngAfterViewInit();

      },
      (err)=>{
        console.log(err);
      }
    );
  }

  //for last dining occupancy
  getLastOccupancyDetails(){
    this.liveService.getLastOccupancy().subscribe(
      (resp)=>{
        console.log(resp);
        this.lastOccupancyDetails=resp;
      },
      (err)=>{
        console.log(err);
      }
    );
  }


  //to implement charts
  ngAfterViewInit(){
this.zone.runOutsideAngular(()=> {
  let chart=am4core.create("line-chart",am4charts.XYChart);;
  let title=chart.titles.create();
  title.text="Occupancy Count by time";
  // chart.fill = am4core.color("black");
  chart.stroke = am4core.color("green");
  
 

  chart.data=this.responseData;
  

  let categoryAxis=chart.xAxes.push(new am4charts.CategoryAxis());
  categoryAxis.title.text="Time Intervals";
  categoryAxis.dataFields.category="times";
  

  let valueAxisY=chart.yAxes.push(new am4charts.ValueAxis())
valueAxisY.title.text="Occupancy Counts";
valueAxisY.renderer.minWidth=20;



let series=chart.series.push(new am4charts.LineSeries());
series.dataFields.categoryX="times";
series.dataFields.valueY="count";
series.name="Dining Occupancy Count";

let bullet=series.bullets.push(new am4charts.CircleBullet());
bullet.circle.strokeWidth=2;
bullet.circle.radius=4;
bullet.tooltipText="time : {categoryX} \n count: {valueY} {name}";


chart.legend=new am4charts.Legend();
this.chart=chart;

})
  }

  ngOnDestroy(){
this.zone.runOutsideAngular(()=>
{
  if (this.chart)
  {
    this.chart.dispose();
  }
})
  }


  //for live service occupancy
  getServiceOccupancy(){
    this.liveService.getCurrentAverageService().subscribe(
      (resp)=>{
        console.log(resp);
        this.responseDataa=resp;
        this.ngAfterViewInitt();
      },
      (err)=>{
        console.log(err);
      }
    );
  }
//for last service value
  getLastServiceOccupancyDetails(){
    this.liveService.getLastServiceOccupancy().subscribe(
      (resp)=>{
        console.log(resp);
        this.lastServiceOccupancyDetails=resp;
      },
      (err)=>{
        console.log(err);
      }
    );
  }

  //to implememnt service chart
  ngAfterViewInitt(){
    this.zone.runOutsideAngular(()=> {
      let chart=am4core.create("line-chartt",am4charts.XYChart);;
      let title=chart.titles.create();
      title.text="Service Occupancy Count by time";

      chart.stroke = am4core.color("green");
    
      

    
      chart.data=this.responseDataa;
    
      let categoryAxis=chart.xAxes.push(new am4charts.CategoryAxis());
      categoryAxis.title.text="Time Intervals";
      categoryAxis.dataFields.category="times";
      
    
      let valueAxisY=chart.yAxes.push(new am4charts.ValueAxis())
    valueAxisY.title.text="Service Occupancy Counts";
    valueAxisY.renderer.minWidth=20;
    
    
    
    let series=chart.series.push(new am4charts.LineSeries());
    series.dataFields.categoryX="times";
    series.dataFields.valueY="count";
    series.name="Service Occupancy Count";
    
    let bullet=series.bullets.push(new am4charts.CircleBullet());
    bullet.circle.strokeWidth=2;
    bullet.circle.radius=4;
    bullet.tooltipText="time : {categoryX} \n count: {valueY} {name}";
    
    
    chart.legend=new am4charts.Legend();
    this.chart=chart;
    
    })
      }
    
      ngOnDestroyy(){
    this.zone.runOutsideAngular(()=>
    {
      if (this.chart)
      {
        this.chart.dispose();
      }
    })
      }


}