import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {

        String dir = args[0];
        List<String> textLines = new ArrayList<>();
        String line = "";
        String message = "";
        boolean isClosed = false;
        Console cons = System.console();

        List<File> filesInFolder = Files.walk(Paths.get(dir))
                .filter(Files::isRegularFile)
                .map(Path::toFile)
                .collect(Collectors.toList());

        for (File r : filesInFolder) {
            // System.out.println(r.getName());
            FileReader fr = new FileReader(r);
            BufferedReader br = new BufferedReader(fr);

            while ((line = br.readLine()) != null) {
                textLines.add(line);

            }
        }
        // System.out.println(textLines);

        Map<String, Integer> wordCount = textLines.stream()
                .map(lines -> lines.replaceAll("\\p{Punct}", ""))
                .map(lines -> lines.toLowerCase().trim())
                .flatMap(lines -> Arrays.stream(lines.split("\\s+")))
                .collect(Collectors.toMap(word -> word, word -> 1, Integer::sum));

        List<String> wordList = new LinkedList<>();
        wordList = textLines.stream()
                .map(lines -> lines.replaceAll("\\p{Punct}", ""))
                .map(lines -> lines.toLowerCase().trim())
                .flatMap(lines -> Arrays.stream(lines.split("\\s+")))
                .toList();

        while (!isClosed) {
            message = cons.readLine("Please enter a word\n");

            // System.out.println(Index.indexOfAll(message, wordList));
            // get the index of the word that user enter
            List<Integer> wordIndex = Index.indexOfAll(message, wordList);
            // find the index of next word
            List<Integer> nextWordIndex = new ArrayList<>();

            for (int i : wordIndex) {
                int nextIndex = i + 1;
                nextWordIndex.add(nextIndex);
            }

            // Map that contains all word and their respective wordCount
            List<Map.Entry<String, Integer>> entryList = new ArrayList<>(wordCount.entrySet());

            Iterator<Integer> itr = nextWordIndex.iterator();

            List<String> wordBesideList = new ArrayList<>();
            // List<String> wordBesideListdistinct =
            // wordBesideList.stream().distinct().toList();
            Set<String> wordBesideSet = new HashSet<>();

            while (itr.hasNext()) {
                int i = itr.next();
                String w = wordList.get(i);
                // System.out.println(w);
                wordBesideList.add(w);
                wordBesideSet.add(w);
            }

            // find out how often the next word appear beside the word
            Map<String, Integer> wordBesideMap = wordBesideList.stream()
                    .collect(Collectors.toMap(word -> word, word -> 1, Integer::sum));

            List<Map.Entry<String, Integer>> entryBesideList = new ArrayList<>(wordBesideMap.entrySet());

            for (int i = 0; i < entryList.size(); i++) {
                Map.Entry<String, Integer> entry = entryList.get(i);
                for (String l : wordBesideSet) {
                    if (entry.getKey().contains(l)) {
                        for (int j = 0; j < entryBesideList.size(); j++) {
                            Map.Entry<String, Integer> entryBeside = entryBesideList.get(j);
                            if (entry.getKey().equals(entryBeside.getKey())) {
                                double d = entryBeside.getValue();
                                double c = entry.getValue();
                                double probability = d / c;

                                System.out.printf("%s %.2f\n", entry.getKey(), probability);
                            }
                        }
                    }
                }
            }
            if ("quit".equals(message.toLowerCase())) {
                System.out.println("closing programme...");
                isClosed = true;
            }

        }
    }
}
