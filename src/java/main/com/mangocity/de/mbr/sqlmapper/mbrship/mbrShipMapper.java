package com.mangocity.de.mbr.sqlmapper.mbrship;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface mbrShipMapper {
	/**
	 * 
	* @Title: mbrshipCategoryByCategoryCd 
	* @Description: TODO() 
	* @param  headMap
	* @return Map    返回类型
	 */
	public Map mbrshipCategoryByCategoryCd(Map headMap);
	
	/**
	 * 
	* @Title: mbrShipCreate 
	* @Description: TODO(插入mbrShip信息) 
	* @param  headMap  参数说明 
	* @return void    返回类型
	 */
	public void mbrShipCreate(Map headMap);
	
	/**
	* @Title: getMbrshipId 
	* @Description: (获得会籍id,序列生成) 
	* @param
	* @return Long    返回类型
	 */
	public Long getMbrshipId();
	
	/**
	* @Title: queryMbrShipByMbrshipCd 
	* @Description: (根据会籍cd查询会籍信息) 
	* @param
	* @return Map    返回类型
	 */
	public Map queryMbrShipByMbrshipCd(Map headMap);
	
	public List<Map> queryMbrShipListByMbrid(Map headMap);
	
	/**
	 * 根据旧的会籍编码查询会员Id
	 * @param headMap
	 * @return
	 */
	public Long queryMbrIdByOldMbrshipCd(Map headMap);
	
	/**
	 * 通过会籍编码和联名卡号查询
	 * @param headMap
	 * @return
	 */
	public Map<String, Object> queryMbrshipBymbrshipCategoryIdAndAliasNo(Map<String, Object> headMap);
	
	/**
	 * 通过shipCd查询会员信息
	 * @param headMap
	 * @return
	 */
	public Map<String, Object> queryMbrShipByShipCd(Map<String, Object> headMap);
	
}