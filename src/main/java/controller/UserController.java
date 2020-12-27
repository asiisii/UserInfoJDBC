package controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JOptionPane;

import model.User;
import service.UserService;
import service.UserServiceImpl;

public class UserController {
	
	public static void main(String[] args) {
		
		UserService userService = new UserServiceImpl();
		String decision = "";
		
		do {
			String choice = JOptionPane.showInputDialog("Enter choice: insert | update | delete | list | get");
			
			switch (choice) {
			case "insert":
				User user = getUser();
				int inserted = userService.saveUserInfo(user);
				if(inserted >=1 ) {
					JOptionPane.showMessageDialog(null,  "User info is saved successfully in db");
				}else {
					JOptionPane.showMessageDialog(null, "Error in db");
				}
				break;
			case "update":
				User updatedUser = getUser();
				int id = Integer.parseInt(JOptionPane.showInputDialog("Enter id: "));
				updatedUser.setId(id);
				int updated = userService.updateUserInfo(updatedUser);
				if(updated >= 1) {
					JOptionPane.showMessageDialog(null,  "User info is updated successfully in db");
				}else {
					JOptionPane.showMessageDialog(null, "Error in db");
				}
				break;
			case "delete":	
				id = Integer.parseInt(JOptionPane.showInputDialog("Enter id: "));
				int deleted = userService.deleteUserInfo(id);
				if(deleted >= 1) {
					JOptionPane.showMessageDialog(null,  "User info is deleted successfully in db");
				}else {
					JOptionPane.showMessageDialog(null, "Error in db");
				}
				break;
			case "list":	
				List<User> userList = userService.getAllUserInfo();
				for(User u: userList) {
					System.out.println("User id is: "+u.getId());
					System.out.println("User name is: "+u.getUsername());
					System.out.println("User password is: "+u.getPassword());
					System.out.println("User mobile number is: "+u.getMobileNo());
					System.out.println("User salary is: "+u.getSalary());
					System.out.println("Is user active?  "+u.isActive());
					System.out.println("+-------------------------------------------+");				
				}
				break;
			case "get":	
				id = Integer.parseInt(JOptionPane.showInputDialog("Enter id: "));
				User u = userService.getUserById(id);
					System.out.println("User id is: "+u.getId());
					System.out.println("User name is: "+u.getUsername());
					System.out.println("User password is: "+u.getPassword());
					System.out.println("User mobile number is: "+u.getMobileNo());
					System.out.println("User salary is: "+u.getSalary());
					System.out.println("Is user active?  "+u.isActive());
								
				break;
			default:
				JOptionPane.showMessageDialog(null, "Wrong Choice");
				break;
			}
			decision = JOptionPane.showInputDialog("Do you want to perform next operation? Enter yes | no");
		}while(decision.equalsIgnoreCase("yes"));
		JOptionPane.showMessageDialog(null, "The end");
	}
	
	public static User getUser() {
		User user = new User();
		String username = JOptionPane.showInputDialog("Enter username: ");
		String password = JOptionPane.showInputDialog("Enter password: ");
		long mobileNo = Long.parseLong(JOptionPane.showInputDialog("Enter mobile number: "));
		double salary = Double.parseDouble(JOptionPane.showInputDialog("Enter salary: "));
		boolean isActive = Boolean.parseBoolean(JOptionPane.showInputDialog("Enteris user active? :  "));
//		Date dob = new SimpleDateFormat("MM-dd-yyyy").parse(JOptionPane.showInputDialog("Enter dob: "));
		user.setUsername(username);
		user.setPassword(password);
		user.setMobileNo(mobileNo);
		user.setActive(isActive);
		user.setSalary(salary);
		return user;
	}
	
}
