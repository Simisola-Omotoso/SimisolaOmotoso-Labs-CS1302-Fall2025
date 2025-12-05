package edu.westga.cs1302.contact_manager.viewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.contact_manager.model.Contact;

public class TestAddContact {

	@Test
	void testOneAddContact() {
		MainWindowViewModel vm = new MainWindowViewModel();
		vm.getName().set("Simisola");
		vm.getPhoneNumber().set("1234567");
		vm.addContact();
		assertEquals(1, vm.getContacts().size());
	}
	
	@Test
	void testTwoAddContact() {
		MainWindowViewModel vm = new MainWindowViewModel();
		vm.getName().set("Simisola");
		vm.getPhoneNumber().set("1234567");
		vm.addContact();
		vm.getName().set("Simi");
		vm.getPhoneNumber().set("1234568");
		vm.addContact();
		assertEquals(2, vm.getContacts().size());
	}
	
	@Test
	void testDuplicateBothSidesAddContact() {
		MainWindowViewModel vm = new MainWindowViewModel();
		vm.getName().set("Simisola");
		vm.getPhoneNumber().set("1234567");
		vm.addContact();
		vm.getName().set("Simisola");
		vm.getPhoneNumber().set("1234567");
		assertThrows(IllegalArgumentException.class, () -> {
			vm.addContact();
		});
	}
}
