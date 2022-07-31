import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Animal> animals = getAnimal();
        //фильтраци по чём то ,в данном случае по класификации
        //Filter
        //List<Animal> predators = animals.stream()
        //.filter(animal -> animal.getClassification().equals(Classification.OMNIVORUS))
        // .collect(Collectors.toList());
        //predators.forEach(System.out::println);
        //сортировка по чему либо
        //Sort
        List<Animal> sorted = animals.stream()
                .sorted(Comparator.comparing(Animal::getAge).reversed())
                .collect(Collectors.toList());
        // sorted.forEach(System.out::println);
        //прохождение с каким либо условием ,все должны подходить под это условие, только тогда будет тру, а в данном случае будет фолс
        //All match
        boolean allMatch = animals.stream()
                .allMatch(animal -> animal.getAge() > 10);

        //System.out.println(allMatch);
        //прохождение с каким либо условием ,должен подходить хотя бы один, и будет тру , если вообще не будет то фолс
        //Any match
        boolean anyMatch = animals.stream()
                .anyMatch(animal -> animal.getAge() > 10);

        //System.out.println(anyMatch);
        //если есть то фолс если нет то тру
        //None match
        boolean noneMatch = animals.stream()
                .noneMatch(animal -> animal.getName().equals("Собака"));
        //System.out.println(noneMatch);
        // нахождение мксимального
        //max
        animals.stream()
                .max(Comparator.comparing(Animal::getAge));
        //.ifPresent((System.out::println));
        //нахождение минимального
        //min
        animals.stream()
                .min(Comparator.comparing(Animal::getAge))
                .ifPresent(System.out::println);
        //это разделение на группы
        //Group
        Map<Classification, List<Animal>> classficationListMap = animals.stream()
                .collect(Collectors.groupingBy(Animal::getClassification));

        classficationListMap.forEach((classification, animals1) -> {
            System.out.println(classification);
            animals1.forEach(System.out::println);
            System.out.println();
        });
    }
    private static List<Animal> getAnimal(){
        return List.of(
                new Animal("Рысь",2, Classification.PREDATOR),
                new Animal("Слон", 20, Classification.HERBIVORE),
                new Animal("Коза", 5,Classification.HERBIVORE),
                new Animal("Собака", 8, Classification.OMNIVORUS),
                new Animal("Динозавр", 257, Classification.PREDATOR)
        );
    }
}
