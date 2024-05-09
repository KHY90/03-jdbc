package com.ohgiraffers.section01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application03 {

    public static void main(String[] args) {

        Connection con = getConnection();
        // 쿼리문을 저장하고 실행하는 기능을 하는 용도의 인터페이스
        Statement stmt = null;

        // select 결과집합을 받아올 용도의 인터페이스 (쿼리에서 반환되는 결과를 저장하는 객체)
        ResultSet rset = null;
//                String name = "선동일";

        Scanner sc = new Scanner(System.in);
        System.out.println("회원 번호를 입력해주세요 : ");
        int empId = sc.nextInt();
        sc.close();

        try {
            // sql 에 말하는 방식을 만들어줌.
            // sql은 sql 문법을 이용해 말함.
            stmt = con.createStatement();

            rset = stmt.executeQuery("SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_ID = "+empId);
            while(rset.next()){
                System.out.println(rset.getString("EMP_ID") + ", " + rset.getString("EMP_NAME"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(con);
            close(rset);
            close(stmt);
        }


    }


}
