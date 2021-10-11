package org.jerometambo.jdk11;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StringFilesOptional {
    
    public static void main(String... args)
            throws IOException, URISyntaxException {
        string();
    
        files();
    
        optional();
     
    }
    
    private static void string() {
        System.out.println("String.repeat : " + "repeat-".repeat(3));
        System.out.println("String.isBlank(\" \") : " + " ".isBlank());
        String desLignesEncoreDesLignes = "abc\nbac\ncab\nbbc";
        
        final List<String> unPeuMoinsDeLignesLigneParLigne = desLignesEncoreDesLignes.lines()
                .filter(s -> s.contains("a"))
                .collect(Collectors.toList());
        System.out.println("String.lines()");
        System.out.println(desLignesEncoreDesLignes);
        System.out.println(unPeuMoinsDeLignesLigneParLigne);
        
        System.out.println("String.strip() & String.stripLeading() & String.stripTrailing()");
        String str = " JDK11 ";
        System.out.print("Con");
        System.out.print(str.strip());
        System.out.println("Citoyen");
        
        System.out.print("Con");
        System.out.print(str.stripLeading());
        System.out.println("Citoyen");
        
        System.out.print("Con");
        System.out.print(str.stripTrailing());
        System.out.println("Citoyen");
    }
    
    private static void files()
            throws URISyntaxException, IOException {
        URI uri = ClassLoader.getSystemResource("jdk13.txt").toURI();
        String path = Paths.get(uri).toString();
        List<String> jdk13 = Files.readString(Path.of(path), StandardCharsets.UTF_8).lines()
                .filter(s -> !s.contains("JDK13"))
                .collect(Collectors.toList());
        
        System.out.println("Files.readString");
        System.out.println(jdk13);
        Files.writeString(Path.of(path), "écris daddy", StandardCharsets.UTF_8);
        
        URI uri11 = ClassLoader.getSystemResource("jdk11.txt").toURI();
        URI uri12 = ClassLoader.getSystemResource("jdk12.txt").toURI();
        Path path11 = Paths.get(uri11);
        Path path12 = Paths.get(uri12);
        System.out.println("jdk11.txt & jdk12.txt same file :" + Files.isSameFile(path11, path12));
        System.out.println("jdk11.txt & jdk11.txt same file :" + Files.isSameFile(path11, path11));
    }
    
    private static void optional() {
        System.out.println("Finis d'écrire !opt.isPresent() : Optional.of(\"pasVide\").isEmpty() -> " + Optional.of("pasVide").isEmpty());
    }
    
}
