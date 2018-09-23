package homeworks.HW.translator;

import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {

        LanguageService service = new LanguageService();
        FileService service1 = new FileService();

        service.printListOfLanguages();

        service.addNewPairLanguages("ukr_ru2");

        service.addNewPairOfWords("ru_ukr", "ыфт","Bazar"   );
        service.addNewPairOfWords("ukr_ru", "Nazar1","фыва"   );
        service.addNewPairOfWords("ukr_ru", "Nazar2","Bazar3"   );
        service.addNewPairOfWords("ukr_ru", "Nazar23","Bazar4"   );
        service.addNewPairOfWords("ukr_ru", "Nazdaasdr23","Bazasr4"   );

        service.translate("ukr_ru", "Nazar2");

        service.syncData();

    }
}
