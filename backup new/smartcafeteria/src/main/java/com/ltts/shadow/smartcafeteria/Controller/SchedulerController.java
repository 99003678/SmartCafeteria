package com.ltts.shadow.smartcafeteria.Controller;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ltts.shadow.smartcafeteria.Dao.CurrentOccupancyDao;
import com.ltts.shadow.smartcafeteria.Models.CurrentOccupancy;
import com.ltts.shadow.smartcafeteria.Models.CurrentOccupancyAverage;
import com.ltts.shadow.smartcafeteria.Models.ServiceOccupancy;
import com.ltts.shadow.smartcafeteria.Models.ServiceOccupancyAverage;
import com.ltts.shadow.smartcafeteria.Scheduler.CurrentOccupancyScheduler;
import com.ltts.shadow.smartcafeteria.Scheduler.ServiceOccupancyScheduler;
import com.ltts.shadow.smartcafeteria.Services.CurrentOccupancyService;
import com.ltts.shadow.smartcafeteria.Services.ServiceOccupancyService;

@CrossOrigin("http://localhost:4200")
@RestController
public class SchedulerController {
	
	

	@Autowired
	private CurrentOccupancyScheduler cos;
	
	@Autowired
	private CurrentOccupancyService currentOccupancyService;
	
	@Autowired
	private ServiceOccupancyScheduler sos;
	
	@Autowired
	private ServiceOccupancyService serviceOccupancyService;
	
	@Autowired
	private CurrentOccupancyDao cod;
	
	

	
	
	//for dining occupancy
	@GetMapping("/getCurrentOccupancy")
	public Iterable<CurrentOccupancy> getCurrentOccupancy()
	{
		return cos.getCurrentOccupancy();
	}
	
//	@GetMapping("/getAverage")
//	public List<CurrentOccupancyAverage> getAvg()
//	{
//		return cod.findAverage();
//	}
	
	//get average values of the current dining area
	@RequestMapping("/averagevaluesdining")
	public List<CurrentOccupancyAverage> makeList()
	{		
		List<Integer> lss =currentOccupancyService.makeList();
		List<Integer> lsss =currentOccupancyService.makeListTime();
		List<CurrentOccupancyAverage> lco=new ArrayList<CurrentOccupancyAverage>();

		

		for (int i=0; i<lsss.size(); i++)
		{ 
			lco.add(new CurrentOccupancyAverage(lss.get(i),lsss.get(i)));
			
		}

		 List<CurrentOccupancyAverage> firstNElementsList = lco.stream().limit(4).collect(Collectors.toList());
		 
			List<CurrentOccupancyAverage> tail = lco.subList(Math.max(lco.size() - 4, 0), lco.size());
			return tail;
	}
	
	
//get last value of current dining occupancy
	@RequestMapping("/lastvaluedining")
	public ResponseEntity<List<CurrentOccupancy>> getAllEmployment1( @RequestParam(defaultValue = "0") Integer pageNo, 
    @RequestParam(defaultValue = "1") Integer pageSize,
    @RequestParam(defaultValue = "id") String sortBy) {
	
		List<CurrentOccupancy> list = currentOccupancyService.getAlldata(pageNo, pageSize, sortBy);
		return new ResponseEntity<List<CurrentOccupancy>>(list, new HttpHeaders(), HttpStatus.OK); 
	}
	

	

//	@RequestMapping("/page")
//	public ResponseEntity<List<CurrentOccupancy>> getAllEmployment( @RequestParam(defaultValue = "0") Integer pageNo, 
//    @RequestParam(defaultValue = "4") Integer pageSize,
//    @RequestParam(defaultValue = "id") String sortBy) {
//	
//		List<CurrentOccupancy> list = currentOccupancyService.getAlldata(pageNo, pageSize, sortBy);
//		return new ResponseEntity<List<CurrentOccupancy>>(list, new HttpHeaders(), HttpStatus.OK); 
//	}
//	
//	@RequestMapping("/lastpage")
//	public ResponseEntity<List<CurrentOccupancy>> getAllEmployment1( @RequestParam(defaultValue = "0") Integer pageNo, 
//    @RequestParam(defaultValue = "1") Integer pageSize,
//    @RequestParam(defaultValue = "id") String sortBy) {
//	
//		List<CurrentOccupancy> list = currentOccupancyService.getAlldata(pageNo, pageSize, sortBy);
//		return new ResponseEntity<List<CurrentOccupancy>>(list, new HttpHeaders(), HttpStatus.OK); 
//	}
	
	
	
	
	
	//for service occupancy
	@GetMapping("/getServiceOccupancy")
	public Iterable<ServiceOccupancy> getServiceOccupancy()
	{
		return sos.getServiceOccupancy();
	}
	
	//for getting average values of data in service occupancy
	@RequestMapping("/averagevaluesservice")
	public List<ServiceOccupancyAverage> makeList1()
	{		
		List<Integer> lss =serviceOccupancyService.makeList();
		List<Integer> lsss =serviceOccupancyService.makeListTime();
		List<ServiceOccupancyAverage> lco=new ArrayList<ServiceOccupancyAverage>();

		
		//for(Integer b:lsss && Float a:lss) 
		for (int i=0; i<lsss.size(); i++)
		{
			//for(Float a:lss) {
 
		     
			lco.add(new ServiceOccupancyAverage(lss.get(i),lsss.get(i)));
			
		//}
		}


		List<ServiceOccupancyAverage> firstNElementsList = lco.stream().limit(4).collect(Collectors.toList());
		
		List<ServiceOccupancyAverage> tail = lco.subList(Math.max(lco.size() - 4, 0), lco.size());
		return tail;
	}
	
	//get last value of current service occupancy
		@RequestMapping("/lastvalueservice")
		public ResponseEntity<List<ServiceOccupancy>> getAllEmployment10( @RequestParam(defaultValue = "0") Integer pageNo, 
	    @RequestParam(defaultValue = "1") Integer pageSize,
	    @RequestParam(defaultValue = "id") String sortBy) {
		
			List<ServiceOccupancy> list = serviceOccupancyService.getAlldata(pageNo, pageSize, sortBy);
			return new ResponseEntity<List<ServiceOccupancy>>(list, new HttpHeaders(), HttpStatus.OK); 
		}

//	@RequestMapping("/pageservice")
//	public ResponseEntity<List<ServiceOccupancy>> getAllEmploymentt( @RequestParam(defaultValue = "0") Integer pageNo, 
//    @RequestParam(defaultValue = "4") Integer pageSize,
//    @RequestParam(defaultValue = "id") String sortBy) {
//	
//		List<ServiceOccupancy> list = serviceOccupancyService.getAlldata(pageNo, pageSize, sortBy);
//		return new ResponseEntity<List<ServiceOccupancy>>(list, new HttpHeaders(), HttpStatus.OK); 
//	}
//	
//	@RequestMapping("/lastpageservice")
//	public ResponseEntity<List<ServiceOccupancy>> getAllEmploymentt1( @RequestParam(defaultValue = "0") Integer pageNo, 
//    @RequestParam(defaultValue = "1") Integer pageSize,
//    @RequestParam(defaultValue = "id") String sortBy) {
//	
//		List<ServiceOccupancy> list = serviceOccupancyService.getAlldata(pageNo, pageSize, sortBy);
//		return new ResponseEntity<List<ServiceOccupancy>>(list, new HttpHeaders(), HttpStatus.OK); 
//	}

//		@GetMapping("/findPeopleCountForDateRange")
//	    public List<CurrentOccupancy> getfindPeopleCountForDateRange(
//	        @RequestParam("startdate") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date startdate,
//	        @RequestParam("enddate") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date enddate) {
//	      return currentOccupancyService.rangeDate(startdate, enddate);
//	    }
		
		
		
		
		//get historical date and count for dining area
		@RequestMapping("/historicaldatadining")
		public List<CurrentOccupancyAverage> getHistoricDataDining()
		{		
			List<Integer> lss =currentOccupancyService.historicCount();
			List<Integer> lsss =currentOccupancyService.historicTime();
			List<CurrentOccupancyAverage> lco=new ArrayList<CurrentOccupancyAverage>();

			
			
			for (int i=0; i<lsss.size(); i++)
			{ 
				lco.add(new CurrentOccupancyAverage(lss.get(i),lsss.get(i)));
				
			}

			return lco;
		}
		
		
		//get historical date and count for service area
		@RequestMapping("/historicaldataservice")
		public List<ServiceOccupancyAverage> getHistoricDataService()
		{		
			List<Integer> lss =serviceOccupancyService.historicCount();
			List<Integer> lsss =serviceOccupancyService.historicTime();
			List<ServiceOccupancyAverage> lco=new ArrayList<ServiceOccupancyAverage>();

			
			
			for (int i=0; i<lsss.size(); i++)
			{ 
				lco.add(new ServiceOccupancyAverage(lss.get(i),lsss.get(i)));
				
			}

			return lco;
		}

		//for historical last hour data dining
		@RequestMapping("/historylasthourdining")
		public List<CurrentOccupancyAverage> histlasthourdining()
		{		
			List<Integer> lss =currentOccupancyService.makeList();
			List<Integer> lsss =currentOccupancyService.makeListTime();
			List<CurrentOccupancyAverage> lco=new ArrayList<CurrentOccupancyAverage>();

			

			for (int i=0; i<lsss.size(); i++)
			{ 
				lco.add(new CurrentOccupancyAverage(lss.get(i),lsss.get(i)));
				
			}

			 List<CurrentOccupancyAverage> firstNElementsList = lco.stream().limit(1).collect(Collectors.toList());
			 
				List<CurrentOccupancyAverage> tail = lco.subList(Math.max(lco.size() - 1, 0), lco.size());
				return tail;
		}
		//for historical last hour data service
		@RequestMapping("/historylasthourservice")
		public List<ServiceOccupancyAverage> histlasthourservice()
		{		
			List<Integer> lss =serviceOccupancyService.makeList();
			List<Integer> lsss =serviceOccupancyService.makeListTime();
			List<ServiceOccupancyAverage> lco=new ArrayList<ServiceOccupancyAverage>();

			
			//for(Integer b:lsss && Float a:lss) 
			for (int i=0; i<lsss.size(); i++)
			{
				//for(Float a:lss) {
	 
			     
				lco.add(new ServiceOccupancyAverage(lss.get(i),lsss.get(i)));
				
			//}
			}


			List<ServiceOccupancyAverage> firstNElementsList = lco.stream().limit(1).collect(Collectors.toList());
			
			List<ServiceOccupancyAverage> tail = lco.subList(Math.max(lco.size() - 1, 0), lco.size());
			return tail;
		}
		
		
		//for historical graph
		@RequestMapping("/forhistgraph")
		public List<CurrentOccupancyAverage> histgraph()
		{		
			List<Integer> lss =currentOccupancyService.makeList();
			List<Integer> lsss =currentOccupancyService.makeListTime();
			List<CurrentOccupancyAverage> lco=new ArrayList<CurrentOccupancyAverage>();

			

			for (int i=0; i<lsss.size(); i++)
			{ 
				lco.add(new CurrentOccupancyAverage(lss.get(i),lsss.get(i)));
				
			}

			 List<CurrentOccupancyAverage> firstNElementsList = lco.stream().limit(24).collect(Collectors.toList());
			 
				List<CurrentOccupancyAverage> tail = lco.subList(Math.max(lco.size() - 24, 0), lco.size());
				return tail;
		}
}
