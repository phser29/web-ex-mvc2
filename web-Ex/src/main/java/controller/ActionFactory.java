package controller;

import controller.board.DeleteAction;
import controller.board.GetAction;
import controller.board.InsertAction;
import controller.board.ListAllAction;
import controller.board.UpdateAction;
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
		
		//User command
		if(command.equals("loginForm")) {
			action = new LoginAction();
		} else if(command.equals("joinForm")) {
			action = new JoinAction();
		} else if(command.equals("leaveForm")) {
			action = new LeaveAction();
		} else if(command.equals("logoutForm")) {
			action = new LogoutAction();
		} else if(command.equals("loginForm")) {
			action = new LoginAction();
		} else if(command.equals("editUserForm")) {
			action = new EditUserAction();
		}
		
		//board command
		if(command.equals("insertAction")) {
			action = new InsertAction();
		} else if(command.equals("getAction")) {
			action = new GetAction();
		} else if(command.equals("updateAction")) {
			action = new UpdateAction();
		} else if(command.equals("deleteAction")) {
			action = new DeleteAction();
		} else if(command.equals("listAllAction")) {
			action = new ListAllAction();
		}
		
		return action;
	}
	
}
