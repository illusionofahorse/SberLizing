package utils;

import pages.*;

public class PageInitializer {

    public static CarMarketplacePage carmarcetplace;
    public static SberLizingDashboardPage sberLizingDashboard;
    public static GooglePage google;

    public static void initializePageObjects() {
        carmarcetplace = new CarMarketplacePage();
        sberLizingDashboard = new SberLizingDashboardPage();
        google = new GooglePage();

    }
}
