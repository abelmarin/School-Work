// Abel Marin
// Exercise 4
package exercise4;

public class WindowsFactory extends UserInterfaceAbstractFactory {
    public TextField createTextField() {
        return new WindowsTextField();
    }

    public PushButton createPushButton() {
        return new WindowsPushButton();
    }

    public ListBox createListBox() {
        return new WindowsListBox();
    }
}
