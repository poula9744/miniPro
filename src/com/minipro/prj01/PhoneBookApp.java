package com.minipro.prj01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBookApp {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		//시작화면
		System.out.println("**********************************");
		System.out.println("*        전화번호 관리 프로그램       *");
		System.out.println("**********************************");
		
		
		//PhoneDB Reader 
		Reader fr = new FileReader("C:\\javaStudy\\PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);
		
		
		// 리스트 만들기
		ArrayList<Person> pList = new ArrayList<Person>();
		
		String[] personInfo = new String[3];
		String name = personInfo[0];
		String hp = personInfo[1];
		String company = personInfo[2];
		
		
		
		
		while(true) {
			System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료 ");
			System.out.println("----------------------------------");
		
			//시작화면: 번호 입력
			System.out.print(">메뉴번호:");
			int num = sc.nextInt();
			System.out.println();
			 
			if(num==1) {//1. 리스트
				
				System.out.println("<1.리스트>");
				
				// 반복
				while (true) {
					// 파일을 한줄 읽는다
					String str = br.readLine();

					
					// null이면 반복문을 나간다 (글자가 없으면) --> 순서 중요
					if (str == null) {
						break;
					}

					// ,로 분리한다
					personInfo = str.split(",");
					name = personInfo[0];
					hp = personInfo[1];
					company = personInfo[2];

					Person p = new Person(personInfo[0], personInfo[1], personInfo[2]);
					
					pList.add(p);
					
				}
				
				// 출력
				//1. 2. 3. 넣어
				for(int i=0; i<pList.size(); i++) {
					System.out.println((i+1) + "." + pList.get(i).getName() + "\t" + pList.get(i).getHp() + "\t" + pList.get(i).getCompany());
				}
		
			} else if(num == 2) { //2-1. 등록: 정보입력
				
				System.out.println("<2.등록>");
				
				
				sc.nextLine();
				System.out.print(">이름: ");
				personInfo[0] = sc.nextLine();
				
				System.out.print(">휴대전화: ");
				personInfo[1] = sc.nextLine();
				
				System.out.print(">회사전화: ");
				personInfo[2] = sc.nextLine();
				
				
		
			//2-2. 등록: 리스트 
				//PhoneDB Writer
				Writer wr = new FileWriter("C:\\javaStudy\\phoneDB.txt");
				BufferedWriter bw = new BufferedWriter(wr);
				
				Person person = new Person(personInfo[0], personInfo[1], personInfo[2]);
				pList.add(person);
				
				for(Person per : pList) {
					bw.write(person.getName() + "," + person.getHp() + "," + person.getCompany());
					bw.newLine();
				}
				
				System.out.println("[등록되었습니다.]");
		
				
			} else if(num == 3) {//3-1. 삭제: 삭제할 내용 선택
				
				System.out.println("<3. 삭제>");
				
				//PhoneDB Writer
				Writer wr = new FileWriter("C:\\javaStudy\\phoneDB.txt");
				BufferedWriter bw = new BufferedWriter(wr);
				
				System.out.print(">번호: ");
				int delete = sc.nextInt();
				pList.remove(delete-1);
				for(Person per : pList) {
					bw.write(per.getName() + "," + per.getHp() + "," + per.getCompany());
					bw.newLine();
				}
				
				System.out.println("[삭제되었습니다]");
		
			} else if(num == 4) { //4. 검색
				System.out.println("<4.검색>");
				
				String search = sc.nextLine();
//				for(int i=0; i<pList.size(); i++) {
//					if(pList.get(i).contains()){
//						System.out.println(pList.get(i));
//					}
//				}
				
			} else if(num == 5) {//5. 종료
				System.out.println("**********************************");
				System.out.println("*            감사합니다            *");
				System.out.println("**********************************");
				break;
		
			} else { //0. 없는 메뉴
				System.out.println("[다시 입력해 주세요.]");
			}
			
			//sc.close();
		}
		
		
		
	}

}
