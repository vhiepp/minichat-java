package mini.chat.minichat.builder;

public class UserCreateBuilder {
    private String fullname;
    private String avartar;
    private String phone;
    private String password;
    private int gender;

    private UserCreateBuilder(Builder builder) {
        this.fullname = builder.fullname;
        this.avartar = builder.avartar;
        this.phone = builder.phone;
        this.password = builder.password;
        this.gender = builder.gender;
    }

    public static class Builder {
        private String fullname;
        private String avartar;
        private String phone;
        private String password;
        private int gender;

        public Builder setFullname(String fullname) {
            this.fullname = fullname;
            return this;
        }

        public Builder setAvartar(String avartar) {
            this.avartar = avartar;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setGender(int gender) {
            this.gender = gender;
            return this;
        }

        public UserCreateBuilder build() {
            return new UserCreateBuilder(this);
        }
    }

    // Getters for the fields
    public String getFullname() {
        return fullname;
    }

    public String getAvartar() {
        return avartar;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public int getGender() {
        return gender;
    }
}