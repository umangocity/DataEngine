package com.mangocity.de.mbr.datafactory.point;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.mangocity.ce.bean.EngineBean;
import com.mangocity.ce.exception.ExceptionAbstract;
import com.mangocity.ce.util.AssertUtils;
import com.mangocity.de.mbr.util.SqlUtil;

public class PointSchemeFactory {
	private static final Logger log = Logger.getLogger(PointSchemeFactory.class);
	
	public Map<String, List<Map<String, Object>>> queryAllPointSchemes(EngineBean pb) throws ExceptionAbstract{
		log.info("PointSchemeFactory queryAllPointSchemes begin()...");
		AssertUtils.assertNull(pb, "EngineBean can't be null.");
		Map<String, Object> headMap = pb.getHeadMap();
		log.info("headMap: " + headMap);
		Map<String, List<Map<String, Object>>> resMap = new HashMap<String, List<Map<String, Object>>>();
		List<Map<String,Object>> mbrMap  = SqlUtil.getInstance().selectList("queryAllPointSchemes", headMap);
		if(null == mbrMap || mbrMap.isEmpty()){
			return null;
		}
		List<Map<String, Object>> list = null;
		//处理数据，按照businessScenes 分组存储
		for(Map<String, Object> map : mbrMap){
			list = resMap.get(String.valueOf(map.get("businessScenes")));
			if(list == null){
				list = new ArrayList<Map<String,Object>>();
				resMap.put(String.valueOf(map.get("businessScenes")), list);
			}
			list.add(map);
		}
		log.info("PointSchemeFactory queryAllPointSchemes end()...");
		return resMap;
	}
	
	public String saveOrUpdateScheme(EngineBean pb) throws ExceptionAbstract {
		log.info("PointSchemeFactory saveOrUpdateScheme begin()...");
		AssertUtils.assertNull(pb, "EngineBean can't be null.");
		Map<String, Object> headMap = pb.getHeadMap();
		if(null == headMap.get("schemeId") || "".equals(headMap.get("schemeId"))){
			SqlUtil.getInstance().updateOne("insertScheme", headMap);
		}else{
			SqlUtil.getInstance().updateOne("updateScheme", headMap);
		}
		return "success";
	}
	
}
