package com.koreait.dao;

import java.util.HashMap;

import com.koreait.vo.MemberVO;

public class Test {
   public static void main(String[] args) {
      MemberDAO dao = new MemberDAO();
      
//      MemberVO member = new MemberVO();
//      
//      member.setId("user002");
//      member.setName("한동석");
//      member.setPassword("1234");
//      member.setGender("남자");
//      member.setAddress("역삼");
//      member.setAddressDetail("2동");
//      member.setAddressEtc("100호");
//      member.setZipcode("12345");
//      
//      System.out.println(dao.join(member));
//      
//      System.out.println(dao.selectUser(1));
//      System.out.println(dao.checkId("hds1234"));
//      HashMap<String, String> datas = new HashMap<>();
//      datas.put("id", "hds1234");
//      datas.put("pw", "12344");
//      System.out.println(dao.login(datas));
      
//      System.out.println(dao.selectNum("yijoon12"));
//      System.out.println(dao.selectPw("yijoon12"));
      System.out.println(dao.selectId(23));
   }
}