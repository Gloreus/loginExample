package scbt.rbs.arms.views;

import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.login.AbstractLogin;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginI18n;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import jakarta.validation.constraints.NotNull;
import lombok.SneakyThrows;
import lombok.extern.java.Log;

import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;

@Route(value = "login", autoLayout = true)
@AnonymousAllowed
@PageTitle("Вход в систему")
@Log
@Menu(title = "Авторизация", order = 0)
public class LoginView extends Main implements ComponentEventListener<AbstractLogin.LoginEvent> {
    private final LoginForm loginForm;

    public LoginView() {
        VerticalLayout layout = new VerticalLayout();
        layout.setAlignItems(FlexComponent.Alignment.CENTER);
        layout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        loginForm = new LoginForm();
        loginForm.setForgotPasswordButtonVisible(false);
        loginForm.setI18n(getI18n());
        loginForm.addLoginListener(this);
        loginForm.setAction("login");
        layout.add(loginForm);
        layout.setSizeFull();
        add(layout);
        setSizeFull();
    }

    private LoginI18n getI18n() {
        LoginI18n i18n = LoginI18n.createDefault();

        LoginI18n.Form i18nForm = i18n.getForm();
        i18nForm.setTitle("АРМ RBS");
        i18nForm.setUsername("Пользователь");
        i18nForm.setPassword("Пароль");
        i18nForm.setSubmit("Войти");
        i18nForm.setForgotPassword("Забыли пароль?");
        i18n.setForm(i18nForm);

        LoginI18n.ErrorMessage i18nErrorMessage = i18n.getErrorMessage();
        i18nErrorMessage.setTitle("Ошибка авторизации");
        i18nErrorMessage.setMessage(
                "Неправильный лагин или пароль.");
        i18n.setErrorMessage(i18nErrorMessage);

        LoginForm loginForm = new LoginForm();
        loginForm.setI18n(i18n);
        return i18n;
    }


    @SneakyThrows
    @Override
    public void onComponentEvent(@NotNull AbstractLogin.LoginEvent loginEvent) {
           // todo Слазить в базу проверить доступ
            if (loginEvent.getUsername().equals(loginEvent.getPassword())){
                Notification.show("Correct!",3000,  Notification.Position.BOTTOM_CENTER);

            } else{
                log.warning("password error");
                Notification.show("Error password!",3000,  Notification.Position.BOTTOM_CENTER);
                loginForm.setError(true);
            }
    }
}

