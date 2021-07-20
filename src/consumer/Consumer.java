package consumer;

import consumer.resume.*;
import java.time.Instant;
import java.util.*;

public abstract class Consumer {
    private Resume resume;
    private List<Consumer> acquaintances;

    public Consumer(Resume resume, ArrayList<Consumer> acquaintances){
        this.resume = resume;
        this.acquaintances = acquaintances;
    }

    public Consumer() {
        this.acquaintances = new ArrayList<>();
    }

    public void add(Consumer consumer) {
        acquaintances.add(consumer);
    }

    public int getDegreeInFriendship(Consumer consumer) {
        // Am un set in care tin minte consumer-ii deja vizitati
        Set<Consumer> visited = new LinkedHashSet<>();
        // O coada pentru a face BFS-ul
        Queue<Consumer> queue = new LinkedList<>();
        // Vizitez consumer-ul de la care plec
        queue.add(this);
        visited.add(this);
        // Nivelul curent
        int counterLevel = 0;
        while (!queue.isEmpty()) {
            // O a doua coada pentru a delimita nivelele
            Queue<Consumer> nextLevel = new LinkedList<>();
            counterLevel++;
            // Cat timp prima coada este goala adaug prietenii nevizitati ai consumatorului curent
            while (!queue.isEmpty()) {
                Consumer current = queue.remove();
                for (Consumer at : current.acquaintances) {
                    if (!visited.contains(at)) {
                        nextLevel.add(at);
                        visited.add(at);
                        // Daca am ajuns la consumatorul dorit returnez nivelul BFS-ului la care am ajuns
                        if (at == consumer) {
                            return counterLevel;
                        }
                    }
                }
            }

            queue = nextLevel;
        }
        return Integer.MAX_VALUE;
    }

    public void remove(Consumer consumer) {
        acquaintances.remove(consumer);
    }

    public Integer getGraduationYear() {
        // Selectez Maximul dintre anii absolvirii de la toate facultatiile
        Integer graduationYear = 0;
        for (Education education : resume.educations) {
            if (education.getEndDate() != null && education.getEndDate().getYear() > graduationYear) {
                graduationYear = education.getEndDate().getYear();
            }
        }
        return graduationYear;
    }

    public Double meanGPA() {
        // Fac media dintre toate mediile Facultatiilor la care a participat/participa
        Double GPA = 0.0;
        for (Education education : resume.educations) {
            GPA += education.getGPA();
        }
        // 0 Daca nu are nici o facultate
        if (resume.educations.size() == 0) {
            return 0.0;
        } else {
            return GPA / resume.educations.size();
        }
    }

    public Integer getExperienceYears() {
        // Adaug anii de munca de la fiecare job
        Integer experienceYears = 0;
        for (Experience experience : resume.experiences) {
            Date start = experience.getStartDate();
            Date end = experience.getStartDate();
            // Daca lucreaza in prezent voi avea end-ul data de azi
            if (end == null) {
                end = Date.from(Instant.now());
            }
            // Calculez experienta in functie de luni
            int diffMonths = end.getMonth() - start.getMonth();
            int diffYear = end.getYear() - start.getYear();
            diffMonths += diffYear * 12;
            // Adaug anii completi plus inca unul daca are cel putin 3 luni din el.
            experienceYears += diffMonths / 12 + (diffMonths % 12 >= 3 ? 1 : 0);
        }
        return experienceYears;
    }

    public Resume getResume() {
        return resume;
    }

    public List<Consumer> getAcquaintances() {
        return acquaintances;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    public void setAcquaintances(List<Consumer> acquaintances) {
        this.acquaintances = acquaintances;
    }

    public static class Resume {
         public List<Education> educations;
         public List<Experience> experiences;
         public Information information;

        public Resume(ResumeBuilder resumeBuilder) {
            educations = resumeBuilder.educations;
            experiences = resumeBuilder.experiences;
            information = resumeBuilder.information;
        }

        // Pattern-ul de builder conform enuntului
        public static class ResumeBuilder {
            private final Information information;
            private List<Education> educations;
            private List<Experience> experiences;

            public ResumeBuilder() {
                information = new Information();
                educations = new ArrayList<>();
                experiences = new ArrayList<>();
            }

            public ResumeBuilder firstName(java.lang.String firstName) {
                information.setFirstName(firstName);
                return this;
            }

            public ResumeBuilder lastName(java.lang.String lastName) {
                information.setLastName(lastName);
                return this;
            }

            public ResumeBuilder email(java.lang.String email) {
                information.setEmail(email);
                return this;
            }

            public ResumeBuilder phone(java.lang.String phone) {
                information.setPhone(phone);
                return this;
            }

            public ResumeBuilder birthDate(Date birthDate) {
                information.setBirthDate(birthDate);
                return this;
            }
            public ResumeBuilder sex(java.lang.String sex) {
                information.setSex(String.valueOf(sex));
                return this;
            }

            public ResumeBuilder language(Language language) {
                information.addLanguage(language);
                return this;
            }

            public ResumeBuilder education(Education education) {
                educations.add(education);
                return this;
            }

            public ResumeBuilder experience(Experience experience) {
                experiences.add(experience);
                return this;
            }

            public Resume build() throws ResumeIncompleteException {
                // Arunc o exceptie daca informatia nu e completa sau daca nu am nici o educatie
                if (!information.completed() || educations.isEmpty()) {
                    throw new ResumeIncompleteException();
                }
                return new Consumer.Resume(this);
            }
        }

        @Override
        public String toString() {
            return information.getLastName() + " " + information.getFirstName()
                  + "\n" + "phone: " + information.getPhone() + "\nemail: " + information.getEmail() +
                    "\nBirthDate: " + information.getBirthDate() + "\n" + information.getSex() + "\n";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Resume)) return false;
            Resume resume = (Resume) o;
            return Objects.equals(educations, resume.educations) &&
                    Objects.equals(experiences, resume.experiences) &&
                    Objects.equals(information, resume.information);
        }

        @Override
        public int hashCode() {
            return Objects.hash(educations, experiences, information);
        }
    }

    public static class ResumeIncompleteException extends Exception { }

    @Override
    public String toString() {
        return  resume + "\n";

    }
}
