package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;

@Repository("dao")
public class MusicDAO {
	//Spring안에 mybatis에서 자동 구현 => 자동으로 주소를 읽어온다
	@Autowired
	private MusicMapper mapper;
	/*
	 * 	@Select("SELECT mno,title,singer,album,idcrement,state "
			+"FROM genie_music ORDER BY mno ASC")
		public List<MusicVO> musicListData();
	 */
	public List<MusicVO> musicListData(){
		return mapper.musicListData();
	}
	
	/*
	 * 	@Select("SELECT mno,title,singer,album,idcrement,state "
			+"FROM genie_music "
			+"WHERE title=#{title}")
	public List<MusicVO> musicTitleFindData(String title);
	
	@Select("SELECT mno,title,singer,album,idcrement,state "
			+"FROM genie_music "
			+"WHERE singer=#{singer}")
	public List<MusicVO> musicSingerFindData(String singer);
	
	@Select("SELECT mno,title,singer,album,idcrement,state "
			+"FROM genie_music "
			+"WHERE album=#{album}")
	public List<MusicVO> musicAlbumFindData(String album);
	 */
	
	public List<MusicVO> musicTitleFindData(String title){
		return mapper.musicTitleFindData(title);
	}
	
	public List<MusicVO> musicSingerFindData(String singer){
		return mapper.musicSingerFindData(singer);
	}
	
	public List<MusicVO> musicAlbumFindData(String album){
		return mapper.musicAlbumFindData(album);
	}
	// 통합 검색 => 동적 쿼리
	/*
	 *   <foreach> : IN
	 *   <trim> : 제거/추가 => OR/AND
	 *   <if> : 조건문
	 *   <choose> => 다중 조건문
	 *   	<when>
	 *   </choose> 
	 *   ==========================
	 *   => <resultMap> : 조인
	 *   => <parameterMap> : 프로시저 
	 */
	public List<MusicVO> musicFindData(int type, String fd){
		return mapper.musicFindData(type, fd);
	}
}
