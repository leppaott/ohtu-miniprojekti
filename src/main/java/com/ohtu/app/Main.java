package com.ohtu.app;

import javax.servlet.annotation.WebServlet;

import com.ohtu.views.AddView;
import com.ohtu.views.MainView;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
@Theme("valo")
public class Main extends UI {

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		getPage().setTitle("Main page - Title");

		Navigator navigator = new Navigator(this, this);
		navigator.addView("", new MainView(navigator));
		navigator.addView("addRefs", new AddView(navigator));
	}

	
	@WebServlet(urlPatterns = "/*", asyncSupported = true)
	@VaadinServletConfiguration(ui = Main.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {
	}
	
}