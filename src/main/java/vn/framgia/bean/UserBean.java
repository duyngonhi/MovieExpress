package vn.framgia.bean;

public class UserBean {

    private String userId;
    private String fullName;
    private String email;
    private String password;
    private SocialProvider socialProvider;

    public UserBean() {
    }

    public UserBean(String userId, String fullName, String email, String password, SocialProvider socialProvider) {
        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.socialProvider = socialProvider;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SocialProvider getSocialProvider() {
        return socialProvider;
    }

    public void setSocialProvider(SocialProvider socialProvider) {
        this.socialProvider = socialProvider;
    }

    public static class Builder {
        private String userId;
        private String fullName;
        private String email;
        private String password;
        private SocialProvider socialProvider;

        public Builder addUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder addFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder addEmail(String email) {
        	this.email = email;
        	return this;
        }
        
        public Builder addPassword(String password) {
            this.password = password;
            return this;
        }


        public Builder addSocialProvider(SocialProvider socialProvider) {
            this.socialProvider = socialProvider;
            return this;
        }

        public UserBean build() {
            return new UserBean(userId, fullName, email, password, socialProvider);
        }
    }
}
