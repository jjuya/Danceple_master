package ibatis;

import java.sql.SQLException;


import com.ibatis.sqlmap.client.SqlMapClient;

public class AccountTest {
	public static void main(String[] args) {

		while(true){	
			try {

			
				}
			
			}catch (SQLException e){
				System.out.println(e.getMessage());
			} 
			catch (Exception e) {
			
			}
		}
			
	}

	private static void insertAccount(Scanner sc) throws Exception{
		AccountVO accountVO= new AccountVO();
		System.out.println("* * *\n1.고객 입력* * *");
		System.out.println("finstName:"+sc.nextLine());
		accountVO.setFirstName(sc.nextLine());
		
		System.out.println("lastName: ");
		accountVO.setLastName(sc.nextLine());
		
		System.out.println("enailAddress : ");
		accountVO.setEmailAddress(sc.nextLine());
		SqlMapClient sqlMap= QueryHandler.getInstance();
		sqlMap.insert("insertAccount",accountVO);
	}


}
