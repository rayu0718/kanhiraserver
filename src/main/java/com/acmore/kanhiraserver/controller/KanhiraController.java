package com.acmore.kanhiraserver.controller;

import com.cm55.kanhira.KakasiDictReader;
import com.cm55.kanhira.Kanhira;
import com.cm55.kanhira.KanwaDict;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class KanhiraController {
    private Kanhira kakasi;

    public KanhiraController() {
        System.out.println('A' - 'a');
        System.out.println('Ａ' - 'ａ');
        try {
            KanwaDict dict = KakasiDictReader.load("dict/kakasidict");
            kakasi = new Kanhira(new KanwaDict[] {dict});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("api/convert")
    public String convert(@RequestParam("text") String text,
                          @RequestParam(name = "noSymbol", required = false, defaultValue = "false") boolean noSymbol,
                          @RequestParam(name = "oneLine", required = false, defaultValue = "false") boolean oneLine,
                          @RequestParam(name = "noSpace", required = false, defaultValue = "false") boolean noSpace,
                          @RequestParam(name = "lowerCase", required = false, defaultValue = "false") boolean lowerCase,
                          @RequestParam(name = "toHalfWidth", required = false, defaultValue = "false") boolean toHalfWidth) {
        String output, pattern = "[";
        output = kakasi.convert(text);

        if (noSymbol) pattern += "^\\dA-Za-zぁ-んァ-ヴ０-９]&\\[";
        if (oneLine) pattern += "\\n";
        if (noSpace) pattern += "\\s";
        pattern += "]";

        System.out.println(pattern);
        output = output.replaceAll(pattern, "");

        if (lowerCase) {
            StringBuilder sb = new StringBuilder();
            for (char c : output.toCharArray()) {
                sb.append(isUpperCaseAlphabet(c) ? (char) (c + 0x20) : c);
            }

            output = sb.toString();
        }

        if (toHalfWidth) {
            StringBuilder sb = new StringBuilder();
            for (char c : output.toCharArray()) {
                sb.append(isFullWidth(c) ? (char) (c - 0xFEE0) : c);
            }

            output = sb.toString();
        }

        return output;
    }

    private boolean isUpperCaseAlphabet(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'Ａ' && c <= 'Ｚ');
    }

    public boolean isFullWidth(char c) {
        return (c >= 'Ａ' && c <= 'Ｚ') || (c >= 'ａ' && c <= 'ｚ') || (c >= '０' && c <= '９');
    }
}
