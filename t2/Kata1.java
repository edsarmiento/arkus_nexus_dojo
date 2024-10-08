package t2;
import java.util.ArrayList;
import java.util.List;

public class Kata1 {
    public List<String> extractHashtags(String sentence) {
        String[] words = sentence.split(" ");
        List<String> validHashtags = new ArrayList<>();

        for (String word : words) {
            if (isValidHashtag(word)) {
                validHashtags.add(trimHashtag(word));
            }
        }

        return validHashtags;
    }

    private boolean isValidHashtag(String word) {
        String[] parts = word.split("#+");

        return parts.length > 1 && parts[parts.length - 1].matches("^[a-zA-Z]+$");
    }

    private String trimHashtag(String word) {
        return word.replaceFirst("^#+", "");
    }

    public static void main(String[] args) {
        Kata1 extractor = new Kata1();

        System.out.println(extractor.extractHashtags("This is a #test of the ##system"));
        System.out.println(extractor.extractHashtags("This is a #test #123 #!"));
        System.out.println(extractor.extractHashtags("in#line hashtag #normal"));
        System.out.println(extractor.extractHashtags("#alone ##twice ##one#two"));
        System.out.println(extractor.extractHashtags("This string has no hashtags"));
        System.out.println(extractor.extractHashtags(""));
        System.out.println(extractor.extractHashtags("#"));
        System.out.println(extractor.extractHashtags("###"));
        System.out.println(extractor.extractHashtags("This is ##123 ###!"));
    }
}