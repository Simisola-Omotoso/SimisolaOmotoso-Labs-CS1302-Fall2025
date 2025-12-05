package edu.westga.cs1302.contact_manager.viewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.contact_manager.model.Contact;

public class TestFindContact {

	@Test
	void testNameFindContact() {
		MainWindowViewModel vm = new MainWindowViewModel();
		vm.getName().set("Simisola");
		vm.getPhoneNumber().set("1234567");
		vm.addContact();
		vm.getSearchCriteria().set("Simisola");
		assertEquals("Simisola, 1234567", vm.findContact());
	}
	
	@Test
	void testPhoneNumberFindContact() {
		MainWindowViewModel vm = new MainWindowViewModel();
		vm.getName().set("Simisola");
		vm.getPhoneNumber().set("1234567");
		vm.addContact();
		vm.getSearchCriteria().set("1234567");
		assertEquals("Simisola, 1234567", vm.findContact());
	}
	
	@Test
	void testNoContactFindContact() {
		MainWindowViewModel vm = new MainWindowViewModel();
		vm.getName().set("Simisola");
		vm.getPhoneNumber().set("1234567");
		vm.addContact();
		vm.getSearchCriteria().set("1234568");
		assertEquals("No contact found.", vm.findContact());
	}
	
	@Test
	void testIllegalArgumentFindContact() {
		MainWindowViewModel vm = new MainWindowViewModel();
		vm.getName().set("Simisola");
		vm.getPhoneNumber().set("1234567");
		vm.addContact();
		vm.getSearchCriteria().set(null);
		assertThrows(IllegalArgumentException.class, () -> {
			vm.findContact();
		});
	}
}
