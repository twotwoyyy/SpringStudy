package com.sist.commons;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.ControllerAdvice;
// 공통 예외처리 => 모든 Controller예외처리 
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class CommonsException {
  @ExceptionHandler(SQLException.class)
  public void sqlException(SQLException ex)
  {
	  System.out.println("===== 데이터베이스 에러 발생 =====");
	  ex.printStackTrace();
	  System.out.println("=============================");
  }
  @ExceptionHandler(IOException.class)
  public void ioException(IOException ex)
  {
	  System.out.println("===== 파일 입출력 에러 발생 =====");
	  ex.printStackTrace();
	  System.out.println("=============================");
  }
  @ExceptionHandler(RuntimeException.class)
  public void runException(RuntimeException ex)
  {
	  System.out.println("===== 실행시 에러 발생 =====");
	  ex.printStackTrace();
	  System.out.println("=============================");
  }
  @ExceptionHandler(Exception.class)
  public void exception(Exception ex)
  {
	  System.out.println("===== 기타 에러 발생 =====");
	  ex.printStackTrace();
	  System.out.println("=============================");
  }
}