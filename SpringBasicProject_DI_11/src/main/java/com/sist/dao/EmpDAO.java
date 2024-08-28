package com.sist.dao;
import java.util.*;
import com.sist.vo.*;
import org.mybatis.spring.support.SqlSessionDaoSupport;
public class EmpDAO extends SqlSessionDaoSupport{
	public List<EmpVO> empListData(){
		return getSqlSession().selectList("empListData");
	}
}
