package ru.regard.framework.managers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestPropManager {

    private final Properties properties = new Properties();

    private static TestPropManager instance = null;

    private TestPropManager() {
        loadApplicationProperties();
        loadCustomProperties();
    }

    public static TestPropManager getTestPropManager() {
        if (instance == null) {
            instance = new TestPropManager();
        }
        return instance;
    }

    /**
     * Метод подгружает содержимого файла application.properties в переменную {@link #properties}
     * Либо из файла переданного пользователем через настройку -DpropFile={nameFile}
     *
     * @see TestPropManager#TestPropManager()
     */
    private void loadApplicationProperties() {
        String nameFile = System.getProperty("propFile", "application");
        try {
            properties.load(new FileInputStream(
                    "src/main/resources/" + nameFile + ".properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод заменяет значение содержащиеся в ключах переменной {@link #properties}
     * Заменяет на те значения, что передал пользователь через maven '-D{name.key}={value.key}'
     * Замена будет происходить только в том случае если пользователь передаст совпадающий key из application.properties
     *
     * @see TestPropManager#TestPropManager()
     */
    private void loadCustomProperties() {
        properties.forEach((key, value) -> System.getProperties()
                .forEach((customUserKey, customUserValue) -> {
                    if (key.toString().equals(customUserKey.toString()) &&
                            !value.toString().equals(customUserValue.toString())) {
                        properties.setProperty(key.toString(), customUserValue.toString());
                    }
                }));
    }

    /**
     * Метод возвращает либо значение записанное в ключе в переменной {@link #properties},
     * либо defaultValue при отсутствие ключа в переменной {@link #properties}
     *
     * @param key          - ключ, значения которого хотите получить
     * @param defaultValue - значение по умолчанию которое хотите получить если отсутствует ключ в {@link #properties}
     * @return String - возвращает системное св-во либо переданное default значение
     */
    public String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    /**
     * Метод возвращает значения записанное в ключе в переменной {@link #properties}, если нет переменной вернет null
     *
     * @param key - ключ, значения которого хотите получить
     * @return String - строка со значением ключа
     */
    public String getProperty(String key) {
        return properties.getProperty(key);
    }

}