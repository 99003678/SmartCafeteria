package com.ltts.shadow.smartcafeteria.Services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import com.ltts.shadow.smartcafeteria.Dao.CurrentOccupancyDao;
import com.ltts.shadow.smartcafeteria.Models.CurrentOccupancy;

@Service
public class CurrentOccupancyService {
   @Autowired
   CurrentOccupancyDao currentOccupancyDao;
   
   @Autowired
	private SessionFactory sessionFactory;
   
   
   //for average count for service area every hour
	public ArrayList<Integer> makeList()
	{		
		List<CurrentOccupancy> ls =currentOccupancyDao.findAll();
		
	float sum=0, count=0,  count2=0;
	ArrayList<Integer> average = new ArrayList<Integer>();
	for(CurrentOccupancy a:ls) {
		
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
	
	//for average time in dining area every hour
	public ArrayList<Integer> makeListTime()
	{		
		List<CurrentOccupancy> ls =currentOccupancyDao.findAll();

		
	int sum=0, count=0,  count2=0;
	ArrayList<Integer> averagetime = new ArrayList<Integer>();
	for(CurrentOccupancy a:ls) {
		
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
	
	
	//for latest count in dining area   
   public List<CurrentOccupancy> getAlldata(Integer pageNo, Integer pageSize, String sortBy)
   {
       Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());

       Page<CurrentOccupancy> pagedResult = currentOccupancyDao.findAll(paging);
        
       if(pagedResult.hasContent()) {
           return pagedResult.getContent();
       } else {
           return new ArrayList<CurrentOccupancy>();
       }
   }
   
   //for historical average count for everyday
   public ArrayList<Integer> historicCount()
	{		
		List<CurrentOccupancy> ls =currentOccupancyDao.findAll();

		
	float sum=0, count=0,  count2=0;
	ArrayList<Integer> averagepday = new ArrayList<Integer>();
	for(CurrentOccupancy a:ls) {
		
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
   //for getting average day per day for dining area
   public ArrayList<Integer> historicTime()
	{		
		List<CurrentOccupancy> ls =currentOccupancyDao.findAll();

		
	int sum=0, count=0,  count2=0;
	ArrayList<Integer> averagetime = new ArrayList<Integer>();
	for(CurrentOccupancy a:ls) {
		
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
	
//	@SuppressWarnings("unchecked")
//   public List<CurrentOccupancy> rangeDate(Date startdate, Date enddate) {
//		Session session = this.sessionFactory.getCurrentSession();
//		List<CurrentOccupancy> results=session.createQuery(("SELECT count FROM CurrentOccupancy AS c WHERE (c.cdate BETWEEN :startdate AND :enddate) ")
//)
//		.setParameter("startdate", startdate)
//		.setParameter("enddate", enddate)
//		.list();
//		return results;
//
//}

//	int qk=a.getCdate().getDay();

}
