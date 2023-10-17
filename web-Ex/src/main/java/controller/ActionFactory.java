package controller;

import controller.user.EditUserAction;
import controller.user.JoinAction;
import controller.user.LeaveAction;
import controller.user.LoginAction;
import controller.user.LogoutAction;
import controller.user.updateAction;

public class ActionFactory {
	
	private ActionFactory() {}
	private static ActionFactory instance = new ActionFactory();
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		if(command.equals("loginForm")) {
			action = new LoginAction();
		} else if(command.equals("editUserForm")) {
			action = new EditUserAction();
		} else if(command.equals("joinForm")) {
			action = new JoinAction();
		} else if(command.equals("leaveForm")) {
			action = new LeaveAction();
		} else if(command.equals("logoutForm")) {
			action = new LogoutAction();
		} else if(command.equals("loginForm")) {
			action = new LoginAction();
		} else if(command.equals("updateForm")) {
			action = new updateAction();
		} 
		
		return action;
	}
	
}
