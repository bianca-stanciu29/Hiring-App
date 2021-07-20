package consumer.resume;

public class Language {
    private java.lang.String name;
    //private LanguageLevel languageLevel;
    private java.lang.String languageLevel;
    public Language(java.lang.String name, java.lang.String languageLevel) {
        this.name = name;
        this.languageLevel = languageLevel;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                "\n languageLevel='" + languageLevel + '\'';
    }
}
