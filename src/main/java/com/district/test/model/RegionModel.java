package com.district.test.model;

import com.district.test.entity.Region;
import com.karana.etu2060.framework.annotation.*;
import com.karana.etu2060.framework.annotation.property.*;

import java.util.HashMap;

import com.dao.database.GenericDao;
import com.dao.database.Pageable;

@RequestMapping(path = "/region")
@Cors(allowedOrigin = "*")
public class RegionModel {
	private Region entity = new Region();

	@Url(method = HttpMethod.POST)
	@Json
	public Object save(@RequestBody Region region){
	 	try{
			GenericDao.save(null, region);
			return "saved successfully";
		}catch(Exception e){
			return e.getMessage();
		}
	}
	@Url(method = HttpMethod.PUT)
	@Json
	public Object update(@RequestBody Region region){
	 	try{
			GenericDao.update(null, region);
			return "updated successfully";
		}catch(Exception e){
			return e.getMessage();
		}
	}
	@Url(method = HttpMethod.DELETE)
	@Json
	public Object delete(@RequestBody Region region){
	 	try{
			GenericDao.delete(null, region);
			return "deleted successfully";
		}catch(Exception e){
			return e.getMessage();
		}
	}

	@Url(method = HttpMethod.GET)
	@Json
	public Object findAll(){
	 	try{
			return GenericDao.findAll(null, entity);
		}catch(Exception e){
			return e.getMessage();
		}
	}

	@Url(method = HttpMethod.GET)
	@Json
	public Object findSome(@RequestParam(parameterName = "start") int start, @RequestParam(parameterName = "length") int length){
	 	try{
			Pageable pageable = new Pageable();
			pageable.setLength(length);
			pageable.setStart(start);
			HashMap<String, Object> res = new HashMap<>();
			res.put("count",GenericDao.getLineCount(null, entity));
			res.put("data", GenericDao.findAll(null, entity, pageable));
			return res;
		}catch(Exception e){
			return e.getMessage();
		}
	}
}