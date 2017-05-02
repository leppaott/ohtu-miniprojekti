package ohtu.views;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Sizeable;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("serial")
public class AddViewImpl extends VerticalLayout implements AddView {
	private Button previousButton;
	private ComboBox<String> referenceTypes;
	private ReferenceForm form;
	AddViewListener listener;

	public AddViewImpl() {
		setSizeUndefined();

		previousButton = new Button("Go Back", e -> UI.getCurrent().getNavigator().navigateTo(""));
		previousButton.setStyleName(ValoTheme.BUTTON_PRIMARY);
		previousButton.setHeightUndefined();
		previousButton.setId("previousButton");

		referenceTypes = new ComboBox<>("Select reference type");
		referenceTypes.setItems(refTypes());
		referenceTypes.setValue("article");
		referenceTypes.setEmptySelectionAllowed(false);
		form = new ReferenceForm("article");
		referenceTypes.addValueChangeListener(event -> {
			removeComponent(form);
			form = new ReferenceForm(referenceTypes.getValue());
			form.setListener(listener);
			addComponent(form);
		});

		addComponents(previousButton, referenceTypes, form);
	}

	public void setListener(AddViewListener listener) {

		// Saving listener to be updated when combobox value is changed
		this.listener = listener;
		form.setListener(listener);
	}

	@Override
	public void success() {
		Notification.show("Reference saved!");
		UI.getCurrent().getNavigator().navigateTo("");
		form.empty();
	}

	@Override
	public void failure() {
		Notification.show("Failed to save a reference");
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
	}

	private List<String> refTypes() {
		return Arrays.asList("article", "book", "booklet", "conference", "inbook", "incollection", "inproceedings",
				"manual", "mastersthesis", "misc", "phdthesis", "proceedings", "techreport", "unpublished");
	}
}
