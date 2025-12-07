package viewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.comic_collection.viewmodel.CollectionViewModel;

public class TestAddCollection {

	@Test
	void testOneAddCollection() {
		CollectionViewModel vm = new CollectionViewModel();
		vm.getNameProperty().set("Batman");
		vm.addCollection();
		assertEquals(1, vm.getCollectionsProperty().size());
	}
	
	@Test
	void testTwoAddCollection() {
		CollectionViewModel vm = new CollectionViewModel();
		vm.getNameProperty().set("Batman");
		vm.addCollection();
		vm.getNameProperty().set("Superman");
		vm.addCollection();
		assertEquals(2, vm.getCollectionsProperty().size());
	}
	
	@Test
	void testThreeAddCollection() {
		CollectionViewModel vm = new CollectionViewModel();
		vm.getNameProperty().set("Batman");
		vm.addCollection();
		vm.getNameProperty().set("Superman");
		vm.addCollection();
		vm.getNameProperty().set("Wonder Woman");
		vm.addCollection();
		assertEquals(3, vm.getCollectionsProperty().size());
	}
	
	@Test
	void testEmptyAddCollection() {
		CollectionViewModel vm = new CollectionViewModel();
		vm.addCollection();
		assertEquals(1, vm.getCollectionsProperty().size());
	}
}

