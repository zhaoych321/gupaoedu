package com.game.mail;

//@Configuration
//@ConditionalOnProperty(prefix = "spring.mail", name = "host")
public class MailSenderPropertiesConfiguration {
    private final MailProperties properties;
    MailSenderPropertiesConfiguration(MailProperties properties) {
        this.properties = properties;
    }
//    @Bean
//    @ConditionalOnMissingBean
//    public JavaMailSenderImpl mailSender() {
//        JavaMailSenderImpl sender = new JavaMailSenderImpl();
//        applyProperties(sender);
//        return sender;
//    }
}
