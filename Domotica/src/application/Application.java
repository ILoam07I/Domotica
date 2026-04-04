
package application;

import application.mediator.UIApplicationMediator;

public class Application {

    public static void main(String[] args) {
        UIApplicationMediator uiMediator = new UIApplicationMediator();
        
        uiMediator.mediateInitialMenu();        
    }
    
}
