package DesignPattern.Behavior.Strategy;

import java.util.Base64;

public interface EncodingStrategy {
    String encode(String text);
}

class NormalStrategy implements EncodingStrategy {

    @Override
    public String encode(String text) {
        return text;
    }
}

class Base64Strategy implements EncodingStrategy {

    @Override
    public String encode(String text) {
        return Base64.getEncoder().encodeToString(text.getBytes());
    }
}

class AppendStrategy implements EncodingStrategy {

    @Override
    public String encode(String text) {
        return "ABCD " + text;
    }
}