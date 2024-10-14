package com.sist.service;
import java.util.*;
import com.sist.vo.*;

public interface ReserveService {
	public List<FoodVO> reserveFoodInfoData(Map map);
	public int reserveFoodTotalPage(Map map);
	public void reserveInsert(ReserverVO vo);
	public List<ReserverVO> reserveMypageListData(String id);
	public List<ReserverVO> reserveAdminListData();
	public void reserveOk(int rno);
	public ReserverVO reserveInfoData(int rno);
}
