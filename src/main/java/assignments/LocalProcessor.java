package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    protected String processorVersion = "";
    private Long period = 10_000_000_000_000L;
    private List<String> stringArrayList = new LinkedList<>();
    private Scanner informationScanner;
    private String processorName;
    private Integer valueOfCheap;
    private StringBuilder stringBuilder;

    public LocalProcessor(String processorName, Long period, String processorVersion, Integer valueOfCheap,
                          Scanner informationscanner, LinkedList<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        if (informationScanner == null)
            throw new IllegalStateException();
        this.informationScanner = informationScanner;
        this.stringArrayList = stringArrayList;
    }
    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listIterator(LinkedList<String> stringList) {
        stringArrayList = new LinkedList<>(stringList);
        for ( String st : stringList) {
            System.out.println((st).hashCode());
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullnameProcessorgenerator(LinkedList<String> stringList) {
        for (int i = 0; i < stringArrayList.size(); i++) {
            processorName+=stringList.get(i)+' ';
        }
        return processorName;
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessOrName(File file) throws FileNotFoundException {
        stringBuilder = new StringBuilder();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                stringBuilder.append(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (stringBuilder != null)
            processorVersion = String.valueOf(stringBuilder);
    }
}

