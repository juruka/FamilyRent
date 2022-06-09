package com.member.model;
import java.util.List;

public class MemberService {
	
	private MemberDAO dao;
	
	public MemberService() {
		dao = new MemberDAOImpl();
	}
	
	public boolean insert(MemberVO MemberVO) {
		return dao.insert(MemberVO);
	}
	
	public void update(MemberVO MemberVO) {
		dao.update(MemberVO);
	}
	
	public List<MemberVO> getAll(){
		return dao.getAll();
	}
	
	public boolean login(String account, String password) {
		return dao.login(account, password);
	}
	
	public MemberVO member(String account) {
		return dao.member(account);
	}
}
