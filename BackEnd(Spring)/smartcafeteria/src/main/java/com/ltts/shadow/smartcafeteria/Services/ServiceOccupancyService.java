package com.ltts.shadow.smartcafeteria.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import com.ltts.shadow.smartcafeteria.Dao.ServiceOccupancyDao;
import com.ltts.shadow.smartcafeteria.Models.ServiceOccupancy;

@Service
public class ServiceOccupancyService {
   @Autowired
   ServiceOccupancyDao serviceOccupancyDao;

   
   
   //for average count for service area every hour
	public ArrayList<Integer> makeList()
	{		
		List<ServiceOccupancy> ls =serviceOccupancyDao.findAll();
		
	float sum=0, count=0,  count2=0;
	ArrayList<Integer> average = new ArrayList<Integer>();
	for(ServiceOccupancy a:ls) {
		
		sum=sum+a.getCount();
		count++;
		count2++;
		if(count2 != 0 && count2 % 12==0) {	
			sum= sum/count;
		    average.add((int) sum);
		    sum=0;
		    count=0;
			
		}
		
	}
	return average;
	
	}
	
	//for average time in service area every hour
	public ArrayList<Integer> makeListTime()
	{		
		List<ServiceOccupancy> ls =serviceOccupancyDao.findAll();

		
	int sum=0, count=0,  count2=0;
	ArrayList<Integer> averagetime = new ArrayList<Integer>();
	for(ServiceOccupancy a:ls) {
		
		int ak=a.getTimes().getHour();
		
		sum=sum+ak;
		count++;
		count2++;
		if(count2 != 0 && count2 % 12==0) {	
			sum= sum/count;
			averagetime.add(sum);
		    sum=0;
		    count=0;
			
		}
		
	}
	return averagetime;
	
	}

//for latest count in service area   
   public List<ServiceOccupancy> getAlldata(Integer pageNo, Integer pageSize, String sortBy)
   {
       Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());

       Page<ServiceOccupancy> pagedResult = serviceOccupancyDao.findAll(paging);
        
       if(pagedResult.hasContent()) {
           return pagedResult.getContent();
       } else {
           return new ArrayList<ServiceOccupancy>();
       }
   }
   
   
   //for historical average count for everyday 
   public ArrayList<Integer> historicCount()
 	{		
 		List<ServiceOccupancy> ls =serviceOccupancyDao.findAll();
// 		List<CurrentOccupancyAverage> lss =coad.findAll();
 		
 	float sum=0, count=0,  count2=0;
 	ArrayList<Integer> averagepday = new ArrayList<Integer>();
 	for(ServiceOccupancy a:ls) {
 		
 		sum=sum+a.getCount();
 		count++;
 		count2++;
 		if(count2 != 0 && count2 % 288==0) {	
 			sum= sum/count;
 			averagepday.add((int) sum);
 		    sum=0;
 		    count=0;
 			
 		}
 		
 	}
 	return averagepday;
 	
 	}
   
   
    //for getting average day per day for service area
    public ArrayList<Integer> historicTime()
 	{		
 		List<ServiceOccupancy> ls =serviceOccupancyDao.findAll();

 		
 	int sum=0, count=0,  count2=0;
 	ArrayList<Integer> averagetime = new ArrayList<Integer>();
 	for(ServiceOccupancy a:ls) {
 		
 		int ak=a.getCdate().getDate();

 		
 		sum=sum+ak;
 		count++;
 		count2++;
 		if(count2 != 0 && count2 % 288==0) {	
 			sum= sum/count;
 			averagetime.add(sum);
 		    sum=0;
 		    count=0;
 			
 		}
 		
 	}
 	return averagetime;
 	
 	}
}
	