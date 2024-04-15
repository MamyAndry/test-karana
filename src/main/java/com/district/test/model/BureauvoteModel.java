package com.district.test.model;

import com.district.test.entity.Bureauvote;
import com.karana.etu2060.framework.annotation.*;
import com.karana.etu2060.framework.annotation.property.*;
import com.dao.database.GenericDao;
import com.dao.database.Pageable;

@RequestMapping(path = "/bureauvote")
@Cors(allowedOrigin = "*")
public class BureauvoteModel {
	private Bureauvote entity = new Bureauvote();

	@Url(method = HttpMethod.POST)
	@Json
	public Object save(@RequestBody Bureauvote bureauvote){
	 	try{
			GenericDao.save(null, bureauvote);
			return "saved successfully";
		}catch(Exception e){
			return e.getMessage();
		}
	}
	@Url(method = HttpMethod.PUT)
	@Json
	public Object update(@RequestBody Bureauvote bureauvote){
	 	try{
			GenericDao.update(null, bureauvote);
			return "updated successfully";
		}catch(Exception e){
			return e.getMessage();
		}
	}
	@Url(method = HttpMethod.DELETE)
	@Json
	public Object delete(@RequestBody Bureauvote bureauvote){
	 	try{
			GenericDao.delete(null, bureauvote);
			return "deleted successfully";
		}catch(Exception e){
			return e.getMessage();
		}
	}

	@Url(method = HttpMethod.GET)
	@Json
	public Object findAll(@RequestBody Pageable pageable){
	 	try{
			return GenericDao.findAll(null, entity, pageable);
		}catch(Exception e){
			return e.getMessage();
		}
	}



}
