package task27.dataClasses;

public class Parameters {
    private String textForSearch;
    private String recipients;
    private String topicLetter;
    private String textLetter;
    private String moveToSpamValidText;
    private String extractFromSpamValidText;
    private String sendLetterValidText;

    public String getTextForSearch() {
        return textForSearch;
    }

    public void setTextForSearch(String textForSearch) {
        this.textForSearch = textForSearch;
    }

    public String getRecipients() {
        return recipients;
    }

    public void setRecipients(String recipients) {
        this.recipients = recipients;
    }

    public String getTopicLetter() {
        return topicLetter;
    }

    public void setTopicLetter(String topicLetter) {
        this.topicLetter = topicLetter;
    }

    public String getTextLetter() {
        return textLetter;
    }

    public void setTextLetter(String textLetter) {
        this.textLetter = textLetter;
    }

    public String getMoveToSpamValidText() {
        return moveToSpamValidText;
    }

    public void setMoveToSpamValidText(String moveToSpamValidText) {
        this.moveToSpamValidText = moveToSpamValidText;
    }

    public String getExtractFromSpamValidText() {
        return extractFromSpamValidText;
    }

    public void setExtractFromSpamValidText(String extractFromSpamValidText) {
        this.extractFromSpamValidText = extractFromSpamValidText;
    }

    public String getSendLetterValidText() {
        return sendLetterValidText;
    }

    public void setSendLetterValidText(String sendLetterValidText) {
        this.sendLetterValidText = sendLetterValidText;
    }

    @Override
    public String toString() {
        return "Parameters:" +
                "\ntextForSearch = " + textForSearch +
                ",\nrecipients = " + recipients +
                ",\ntopicLetter = " + topicLetter +
                ",\ntextLetter = " + textLetter +
                ",\nmoveToSpamValidText = " + moveToSpamValidText +
                ",\nextractFromSpamValidText = " + extractFromSpamValidText +
                ",\nsendLetterValidText = " + sendLetterValidText;
    }
}