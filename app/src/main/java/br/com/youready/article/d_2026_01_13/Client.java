package br.com.youready.article.d_2026_01_13;

import lombok.Getter;

@Getter
class Client {
    private String name;
    private String contactInfo;

    public Client(String name, String contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
    }

    public void updateContactInfo(String newContactInfo) {
        this.contactInfo = newContactInfo;
    }
}
