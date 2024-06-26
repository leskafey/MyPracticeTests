package hh;

import core.BaseSelenideTest;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;


public class HhTest extends BaseSelenideTest {

    private final static String URL = "https://hh.ru/resume/d45267efff0d5304350039ed1f477966396b51";

    @Test
    public void checkAttributesMap(){
        HhResumePage hhResumePage = new HhResumePage(URL);
        Map<String, Object> expectedAttributes = new HashMap<>();
        expectedAttributes.put(HhResumePage.GENDER, "М");
        expectedAttributes.put(HhResumePage.AGE, 24);
        expectedAttributes.put(HhResumePage.CITY, "Зеленоград");
        expectedAttributes.put(HhResumePage.CONFIRMED_PHONE, true);
        expectedAttributes.put(HhResumePage.RELOCATE, false);

        Map<String, Object> actualAttributes = hhResumePage.getAttributes();

        Assertions.assertEquals(expectedAttributes, actualAttributes);
    }

    @Test
    public void checkAttributesClass(){
        HhResumePage hhResumePage = new HhResumePage(URL);
        Resume expectedResume = new Resume ("М", "Зеленоград", 24, true,
                false);

        Resume actualResume = new Resume(hhResumePage.getGender(), hhResumePage.getCityHard(), hhResumePage.getAge(),
                hhResumePage.isPhoneCofirmed(), hhResumePage.isReadyToRelocate());
        // 1 способ сравнения классов, все и сразу
        Assertions.assertTrue(EqualsBuilder.reflectionEquals(expectedResume, actualResume));
        // 2 способ сравнения классов, по отдельным паременным в классе
        Assertions.assertEquals(expectedResume.getGender(), actualResume.getGender());
        Assertions.assertEquals(expectedResume.getCity(), actualResume.getCity());
        Assertions.assertEquals(expectedResume.getAge(), actualResume.getAge());
        Assertions.assertEquals(expectedResume.isPhoneConfirmed(), actualResume.isPhoneConfirmed());
        Assertions.assertEquals(expectedResume.isReadyToRelocate(), actualResume.isReadyToRelocate());

    }
}
