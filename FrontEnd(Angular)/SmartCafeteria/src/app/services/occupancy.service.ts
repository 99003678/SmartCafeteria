import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OccupancyService {

  constructor(private _http : HttpClient) { 
  }

  public getCurrentOccupancy():Observable<object>{
    return this._http.get("http://localhost:8080/getCurrentOccupancy");
  }

  public getLastOccupancy():Observable<object>{
    return this._http.get("http://localhost:8080/lastvaluedining");
  }

  // public getServiceOccupancy():Observable<object>{
  //   return this._http.get("http://localhost:8080/pageservice");
  // }

  public getLastServiceOccupancy():Observable<object>{
    return this._http.get("http://localhost:8080/lastvalueservice");
  }


  public getCurrentAverageDining():Observable<object>{
    return this._http.get("http://localhost:8080/averagevaluesdining");
  }

  public getCurrentAverageService():Observable<object>{
    return this._http.get("http://localhost:8080/averagevaluesservice");
  }



  public getHistoricalDataDining():Observable<object>{
    return this._http.get("http://localhost:8080/historicaldatadining");
  }

  public getHistoricalDataService():Observable<object>{
    return this._http.get("http://localhost:8080/historicaldataservice");
  }



  public gethistlastdin():Observable<object>{
    return this._http.get("http://localhost:8080/historylasthourdining");
  }

  public gethistlastser():Observable<object>{
    return this._http.get("http://localhost:8080/historylasthourservice");
  }

  public forhistgraph():Observable<object>{
    return this._http.get("http://localhost:8080/forhistgraph");
  }

}
