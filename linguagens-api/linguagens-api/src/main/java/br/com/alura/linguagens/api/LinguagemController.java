package br.com.alura.linguagens.api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LinguagemController {

    private List<Linguagem> linguagens =
        List.of(
            new Linguagem("Java", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/java/java_256x256.png", 1),
            new Linguagem("PHP", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/php/php_256x256.png", 2),
            new Linguagem("JS", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/javascript/javascript_256x256.png", 3),
            new Linguagem("cachorro", "https://raw.githubusercontent.com/FailedChampion/sander-cachorro-img0/main/63bace05-6a74-4307-88e1-e8875ee477f1.png?token=GHSAT0AAAAAACBKWLAY66D3GCXZWAEUNPQSZBXD5EQ", 4)

        );

    @GetMapping("/linguagens")
    public List<Linguagem> obterLinguagens() {
        return linguagens;
    }



}
