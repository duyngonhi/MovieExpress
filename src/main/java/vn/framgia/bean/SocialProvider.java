package vn.framgia.bean;

public enum SocialProvider {
    FACEBOOK("facebook"), GOOGLE("google"), NONE("local");
    private String providerType;

    public String getProviderType() {
        return providerType;
    }

    SocialProvider(String providerType) {
        this.providerType = providerType;
    }

}
