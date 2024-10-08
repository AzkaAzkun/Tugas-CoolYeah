import java.util.HashMap;
import java.util.Random;

public class GenerateAnswer {
    private HashMap<String,String> response;
    private Random random;

    public GenerateAnswer(){
        response = new HashMap<>();
        random = new Random();
        setDefault();
    }

    private void setDefault(){
        response.put("halo","halo juga");
        response.put("siapa","aku temanmu namaku support system");
        response.put("main","ayo main aja yuk gimana?");
        response.put("ayo","gamau ah aku mager");
        response.put("bolos","aku gamau bolos nanti ndak bisa jadi dokter");
        response.put("sekarang","nanti aja deh sekarang aku malas");
        response.put("makan", "Sudah makan belum? Yuk makan bareng!");
        response.put("belajar", "Ayo kita belajar supaya bisa jadi pintar!");
        response.put("tidur", "Udah malam, ayo tidur dulu biar besok semangat.");
        response.put("kerja", "Jangan lupa kerja keras, tapi juga istirahat ya.");
        response.put("jalan", "Mau jalan-jalan ke mana nih?");
    }

    public String getResponse(String input){
        for (String key : response.keySet()) {
            if (input.toLowerCase().contains(key.toLowerCase())) {
                return response.get(key);
            }
        }
        return defultResponse();
    }

    private String defultResponse() {
        String[] defaultResponses = {
                "Gak jelas lu, Apaan sih.",
                "Apa tadi aku ndak kedengaran?",
                "Coba ulangin lagi dong aku kurang paham hehehe."
        };
        return defaultResponses[random.nextInt(defaultResponses.length)];
    }

}
