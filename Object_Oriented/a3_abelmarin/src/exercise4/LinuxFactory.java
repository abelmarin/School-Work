// Abel Marin
// Exercise 4
package exercise4;

public class LinuxFactory extends UserInterfaceAbstractFactory {
    public TextField createTextField() {
        return new LinuxTextField();
    }

    public PushButton createPushButton() {
        return new LinuxPushButton();
    }

    public ListBox createListBox() {
        return new LinuxListBox();
    }
}
