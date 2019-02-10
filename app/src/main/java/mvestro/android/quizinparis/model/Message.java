package mvestro.android.quizinparis.model;


import java.util.Date;

public class Message {

    int id;
    String content;
    Date date;
    boolean received;

    private Friend source;
    private String message;

    public Message(Friend source, String message) {
        this.source = source;
        this.message = message;
    }

    public Friend getSource() {
        return source;
    }

    public String getMessage() {
        return message;
    }

    public boolean isMe()
    {
        return (1 == 1);
    }

}
