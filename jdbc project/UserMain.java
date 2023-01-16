package project1;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class UserMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		boolean repeat = true;
		do {
			System.out.println("*****WELCOME*****");
			System.out.println("Enter your choice");
			System.out.println("1.Insert Data");
			System.out.println("2.Update data");
			System.out.println("3.Delete Data");
			System.out.println("4.Fetch Data");
			System.out.println("5.Login to User");
			System.out.println("6.Exit");

			int choice = sc.nextInt();
			UserCrud usercrud = new UserCrud();
			User user = new User();

			switch (choice) {

			case 1: {

				System.out.println("Enter the id");
				int id = sc.nextInt();
				System.out.println("Enter the Name");
				String name = sc.next();
				System.out.println("Enter the Email");
				String email = sc.next();
				System.out.println("Enter the Password");
				String password = sc.next();
				System.out.println("Enter the Address");
				String address = sc.next();
				System.out.println("enter the fb password");
				String fbpass = sc.next();
				System.out.println("enter the insta password");
				String instapass = sc.next();

				System.out.println("enter the snap password");
				String snapass = sc.next();

				System.out.println("enter the twitter password");
				String tweetpass = sc.next();

				user.setId(id);
				user.setName(name);
				user.setEmail(email);
				user.setPassword(password);
				user.setAddress(address);
				user.setApp1(fbpass);
				user.setApp2(instapass);
				user.setApp3(snapass);
				user.setApp4(tweetpass);

				try {
					usercrud.signUp(user);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Invalid Entry");
				}

			}

				break;
			case 2: {
				System.out.println("enter the name");
				String name = sc.next();
				System.out.println("enter the id");
				int id = sc.nextInt();

				try {
					usercrud.updateUser(user);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Invalid Entry");
				}

			}

			case 3: {
				System.out.println("enter the id");
				int id = sc.nextInt();
				user.setId(id);
				try {
					usercrud.deleteUser(user);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Invalid Entry");
				}

			}
				break;
			case 4:// fetch
			{
				try {
					usercrud.fetchUser();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Invalid Entry");
				}

			}
				break;
			case 5: {
				System.out.println("enter the your email");
				String email = sc.next();
				System.out.println("enter the password");
				String password = sc.next();
				user.setEmail(email);
				user.setPassword(password);
				try {
					usercrud.loginUser(user);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Invalid Entry");
				}
				boolean result = usercrud.loginUser(user);
				if (result == true) {
					System.out.println("***** Sucessfully logged in*****");
					System.out.println("1.fb password");
					System.out.println("2.Insta password");
					System.out.println("3.Snap password");
					System.out.println("4.Twitter password");
					int key = sc.nextInt();

					switch (key) {
					case 1: {
						System.out.println("enter your email");
						String emaila1 = sc.next();
						user.setEmail(emaila1);

						usercrud.getFb(user);
						System.out.println("do you want to update your password");
						System.out.println("1.Yes");
						System.out.println("2.No");
						int fb = sc.nextInt();
						switch (fb) {
						case 1: {
							System.out.println("enter the password");
							String pass = sc.next();
							user.setApp1(pass);
							usercrud.updateFB(user);

						}

							break;
						case 2: {
							System.out.println("thank you");

						}

							break;
						default:
							break;
						}
					}
						break;
					case 2: {
						System.out.println("enter your email");
						String emaila1 = sc.next();
						user.setEmail(emaila1);

						usercrud.getInsta(user);
					}
						break;
					case 3: {
						System.out.println("enter your email");
						String emaila1 = sc.next();
						user.setEmail(emaila1);

						usercrud.getSnap(user);
					}
						break;
					case 4: {
						System.out.println("enter your email");
						String emaila1 = sc.next();
						user.setEmail(emaila1);

						usercrud.getTweet(user);
					}
						break;

					default:
						break;
					}

				} else {
					System.out.println("invalid password");
				}
				break;
			}
			case 6: {
				repeat = false;
				System.out.println("*****THANK YOU*****");
			}
				break;

			}

		} while (repeat);

	}
}
