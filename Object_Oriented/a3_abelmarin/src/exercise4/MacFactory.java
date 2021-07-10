// Abel Marin
// Exercise 4
package exercise4;

public class MacFactory extends UserInterfaceAbstractFactory {
    public TextField createTextField() {
        return new MacTextField();
    }

    public PushButton createPushButton() {
        return new MacPushButton();
    }

    public ListBox createListBox() {
        return new MacListBox();
    }
}
