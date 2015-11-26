package main;

import view.*;
import repository.*;
import controller.*;

public class Main {

	public static void main(String[] args){
		IRepo repo = new Repo();
		IController ctrl = new Controller(repo);
		IMainMenu menu = new MainMenu(ctrl);
		menu.showMain();
	}
}
