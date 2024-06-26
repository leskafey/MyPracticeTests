package hh;


import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$x;

public class HhResumePage {
    private final SelenideElement gender = $x("//*[@id=\"a11y-main-content\"]/div[1]/p[1]/span[1]");
    private final SelenideElement age = $x("//*[@id=\"a11y-main-content\"]/div[1]/p[1]/span[2]/span");
    private final SelenideElement city = $x("//*[@id=\"a11y-main-content\"]/div[1]/div[6]/p[1]/span");
    private final SelenideElement liveString = $x("//*[@id=\"a11y-main-content\"]/div[1]/div[6]/p[1]");
    private final SelenideElement confirmedNumber = $x("//*[@id=\"a11y-main-content\"]/div[1]/div[7]/div/div[3]/div/svg");

    public static String GENDER = "Пол";
    public static String CITY = "Город";
    public static String AGE = "Возраст";
    public static String RELOCATE = "Готовность к переезду";
    public static String CONFIRMED_PHONE = "Пол";

    public HhResumePage(String url){
        Selenide.open(url);
    }

    public Map<String, Object> getAttributes(){
        return new HashMap<String, Object>(){{
            put(GENDER, getGender());
            put(CITY, getCityHard());
            put(AGE, getAge());
            put(RELOCATE, isReadyToRelocate());
            put(CONFIRMED_PHONE, isPhoneCofirmed());
        }};
    }

    public boolean isPhoneCofirmed() {
        return confirmedNumber.isDisplayed();
    }

    public boolean isReadyToRelocate(){
        return !liveString.getText().split(", ")[1].equals("не готов к переезду");
    }
    /** Простой способ получения
    public String getCityEasy(){
        return city.getText();
    } */
     public String getCityHard(){
         return liveString.getText().split(", ")[0];
     }

    public int getAge(){
        return Integer.parseInt(age.getText().replaceAll("[^0-9]", ""));
    }

/**  Пример полегче, но работает также

    public String getGenderEasy() {
        String genderValue = gender.getText();
        if (genderValue == "Мужчина"){
            return "М";
        }
        return "Ж";
    }
*/

// Тернарный оператор
    public String getGender(){
        return gender.getText().equals("Мужчина") ? "М" : "Ж";
    }
}
