package com.member.model;
import java.util.List;


public interface MemberDAO {
	
	
	
	//新增
	boolean insert( MemberVO MemberVO);
	//修改
	boolean update(MemberVO MemberVO);
	//修改圖片
	boolean imgupdate(MemberVO MemberVO);
	//預覽ALL
	List<MemberVO> getAll();
	//登入驗證
	boolean login(String account,String password);
	//取得會員基本資料
	MemberVO member(String account) ;
	
	
	
}
