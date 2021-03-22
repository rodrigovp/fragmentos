package org.rodnet.fragmentos;

import org.jsoup.select.Elements;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class LeitorDeDataDeArtigo {

    public static final LocalDate ler(Elements elementoHtmlComData){
        String[] elementoQuebrado = elementoHtmlComData.toString().split(",");
        String[] mesDia = elementoQuebrado[1].trim().split(" ");

        int ano = lerAno(elementoQuebrado[2]);
        int mes = lerMes(mesDia[0]);
        int dia = lerDia(mesDia[1]);

        return LocalDate.of(ano, mes, dia);
    }

    private static int lerDia(String diaString) {
        for(String paraRemover : List.of("th", "rd", "nd", "st")){
            diaString = diaString.replace(paraRemover, "");
        }
        return Integer.valueOf(diaString);
    }

    private static int lerMes(String mesString) {
        return Month.valueOf(mesString.toUpperCase()).getValue();
    }

    private static final int lerAno(String anoString) {
        anoString = anoString.replace("</small>", "").trim();
        return Integer.valueOf(anoString);
    }
}
