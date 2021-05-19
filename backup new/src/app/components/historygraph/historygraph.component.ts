import { NgZone } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { OccupancyService } from 'src/app/services/occupancy.service';
// amCharts imports
import * as am4core from '@amcharts/amcharts4/core';
import * as am4charts from '@amcharts/amcharts4/charts';
import am4themes_animated from '@amcharts/amcharts4/themes/animated';

am4core.useTheme(am4themes_animated);

@Component({
  selector: 'app-historygraph',
  templateUrl: './historygraph.component.html',
  styleUrls: ['./historygraph.component.css']
})
export class HistorygraphComponent implements OnInit {
 
  private chart : am4charts.XYChart;

  constructor(private zone:NgZone){}ngOnInit(): void {
    throw new Error('Method not implemented.');
  }
;
  
  ngAfterViewInit(){
this.zone.runOutsideAngular(()=> {
  let chart=am4core.create("line-chart",am4charts.XYChart);;
  let title=chart.titles.create();
  title.text="Occupancy Count by Time";

  let data=[
    {"time":"0", "count":20},
    {"time":"1", "count":41},
    {"time":"2","count":16},
    {"time":"3","count":10},
    {"time":"4","count":15},
    {"time":"5", "count":26},
    {"time":"6", "count":21},
    {"time":"7","count":2},
    {"time":"8","count":28},
    {"time":"9","count":31},
    {"time":"10", "count":45},
    {"time":"11", "count":21},
    {"time":"12","count":5},
    {"time":"13","count":32},
    {"time":"14","count":41},
    {"time":"15", "count":21},
    {"time":"16", "count":15},
    {"time":"17","count":11},
    {"time":"18","count":30},
    {"time":"19","count":27},
    {"time":"20", "count":33},
    {"time":"21", "count":10},
    {"time":"22","count":19},
    {"time":"23","count":43},
  
  ];
  chart.data=data;

  let categoryAxis=chart.xAxes.push(new am4charts.CategoryAxis());
  categoryAxis.title.text="Time Intervals";
  
  chart.stroke = am4core.color("green");
  categoryAxis.dataFields.category="time";

  let valueAxisY=chart.yAxes.push(new am4charts.ValueAxis())
valueAxisY.title.text="Occupancy Counts";
valueAxisY.renderer.minWidth=20;

let seriesNames=["count"];
for(let i=0;i<1;i++){

let series=chart.series.push(new am4charts.LineSeries());
series.dataFields.categoryX="time";
series.dataFields.valueY=seriesNames[i];
series.name=seriesNames[i];

let bullet=series.bullets.push(new am4charts.CircleBullet());
bullet.circle.strokeWidth=2;
bullet.circle.radius=4;
bullet.tooltipText="time : {categoryX} \n count: {valueY} {name}";

}
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


}
