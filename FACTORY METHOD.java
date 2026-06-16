interface UIButton {
    void render();
}

class PrimaryButton implements UIButton {
    @Override
    public void render() {
        System.out.println("Rendering a solid blue Primary Button on the screen.");
    }
}

class GhostButton implements UIButton {
    @Override
    public void render() {
        System.out.println("Rendering a transparent Ghost Button with a colored outline.");
    }
}

class ButtonFactory {

    public UIButton createButton(String type) {
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("PRIMARY")) {
            return new PrimaryButton();
        } else if (type.equalsIgnoreCase("GHOST")) {
            return new GhostButton();
        }
        
        System.out.println("Unknown button style requested.");
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        

        ButtonFactory uiFactory = new ButtonFactory();
        System.out.println("Loading Login Page...");
        UIButton loginBtn = uiFactory.createButton("PRIMARY");
        loginBtn.render();

        System.out.println("\nLoading Settings Page...");
        UIButton cancelBtn = uiFactory.createButton("GHOST");
        cancelBtn.render();
    }
}