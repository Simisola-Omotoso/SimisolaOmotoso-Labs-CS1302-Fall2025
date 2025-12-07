package viewmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.comic_collection.model.Collection;
import edu.westga.cs1302.comic_collection.viewmodel.CollectionViewModel;

public class TestRemoveCollection {

	@Test
	void testOneRemoveCollection() {
		CollectionViewModel vm = new CollectionViewModel();
		vm.getNameProperty().set("Batman");
		vm.addCollection();
		vm.getNameProperty().set("Superman");
		vm.addCollection();
		vm.getNameProperty().set("Wonder Woman");
		vm.addCollection();
		Collection collection = vm.getCollectionsProperty().get(2);
		vm.getSelectedCollectionProperty().set(collection);
		vm.removeCollection();
		assertEquals(2, vm.getCollectionsProperty().size());
	}
	
	@Test
	void testTwoRemoveCollection() {
		CollectionViewModel vm = new CollectionViewModel();
		vm.getNameProperty().set("Batman");
		vm.addCollection();
		vm.getNameProperty().set("Superman");
		vm.addCollection();
		vm.getNameProperty().set("Wonder Woman");
		vm.addCollection();
		Collection collection = vm.getCollectionsProperty().get(2);
		Collection collection2 = vm.getCollectionsProperty().get(1);
		vm.getSelectedCollectionProperty().set(collection);
		vm.removeCollection();
		vm.getSelectedCollectionProperty().set(collection2);
		vm.removeCollection();
		assertEquals(1, vm.getCollectionsProperty().size());
	}
	
	@Test
	void testThreeRemoveCollection() {
		CollectionViewModel vm = new CollectionViewModel();
		vm.getNameProperty().set("Batman");
		vm.addCollection();
		vm.getNameProperty().set("Superman");
		vm.addCollection();
		vm.getNameProperty().set("Wonder Woman");
		vm.addCollection();
		Collection collection = vm.getCollectionsProperty().get(2);
		Collection collection2 = vm.getCollectionsProperty().get(1);
		Collection collection3 = vm.getCollectionsProperty().get(0);
		vm.getSelectedCollectionProperty().set(collection);
		vm.removeCollection();
		vm.getSelectedCollectionProperty().set(collection2);
		vm.removeCollection();
		vm.getSelectedCollectionProperty().set(collection3);
		vm.removeCollection();
		assertEquals(0, vm.getCollectionsProperty().size());
	}
}
